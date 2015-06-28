package net.kraklups.solarapp.web.timetable;

import java.util.List;

import javax.validation.Valid;

import net.kraklups.modelutil.exceptions.DuplicateInstanceException;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.park.Park;
import net.kraklups.solarapp.model.parkservice.ParkService;
import net.kraklups.solarapp.model.timetable.Timetable;
import net.kraklups.solarapp.model.userservice.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Handles requests for the application TimetableBlock page.
 */
@Controller
@SessionAttributes("timetable")
public class CreateTimetable {
	
	private final static int PARK_PER_PAGE = 50;

	private static final Logger logger = LoggerFactory.getLogger(CreateTimetable.class);
	
	private int startIndex = 0;	
	
	@Autowired
	private ParkService parkService;	
	
	@Autowired
	private UserService userService;				
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/timetable/createTimetable", method = RequestMethod.GET)
	public String createTimetableGet(Model model) 
			throws InstanceNotFoundException {
		
		logger.info("Create TimetableBlock page GET!");
		
		model.addAttribute("timetable", new Timetable());
		
		initModelListPark(model);
				
		return "timetable/createTimetable";
	}
	
	@RequestMapping(value = "/timetable/createTimetable", method = RequestMethod.POST)
	public String createTimetablePost(@Valid @ModelAttribute("timetable") Timetable timetable, BindingResult result, Model model) 
 			throws DuplicateInstanceException, InstanceNotFoundException {		
		
		logger.info("Create TimetableBlock page POST!" + "timetableTag: " + timetable.getTimetableTag());
					
		if(result.hasErrors()) {
			
			initModelListPark(model);
			
			return "timetable/createTimetable";
		} else {
			logger.info("Create Timetable page POST!");
			
			model.addAttribute("timetable", timetable);
			
			logger.info("UserSession " + SecurityContextHolder.getContext().getAuthentication().getName());
			
			timetable.setUserProfile(userService.findUserProfileByLogin(SecurityContextHolder.getContext().getAuthentication().getName()));
			Timetable merda = parkService.saveTimetable(timetable);
			
			logger.info("Create Timetable page POST! " + merda);			
			
			return "redirect:/timetable/showTimetables";
		}	
	}	
	
	private void initModelListPark(Model model) throws InstanceNotFoundException {
		List <Park> parkList = parkService.getParks(startIndex, PARK_PER_PAGE).getParks();
		model.addAttribute("parkList",parkList);
	}
}
