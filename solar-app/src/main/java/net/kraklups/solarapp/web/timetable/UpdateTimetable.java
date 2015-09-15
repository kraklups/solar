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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application TimetableBlock page.
 */
@Controller
public class UpdateTimetable {
	
	private final static int PARK_PER_PAGE = 50;

	private static final Logger logger = LoggerFactory.getLogger(UpdateTimetable.class);
	
	private int startIndex = 0;	
	
	@Autowired
	private UserService userService;	

	@Autowired
	private ParkService parkService;	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/timetable/updateTimetable/{timetableId}", method = RequestMethod.GET)
	public String updateTimetableGet(@PathVariable String timetableId, Model model) 
			throws InstanceNotFoundException {
		
		logger.info("Create Timetable page GET!");
		
		Timetable timetable = parkService.findTimetable(Long.valueOf(timetableId));
		
		initModelListPark(model);
		
		model.addAttribute("timetable", timetable);
				
		return "timetable/updateTimetable";
	}
	
	@RequestMapping(value = "/timetable/updateTimetable/{timetableId}", method = RequestMethod.POST)
	public String updateTimetablePost(@Valid @ModelAttribute("timetable") Timetable timetable, BindingResult result, Model model) 
			throws DuplicateInstanceException, InstanceNotFoundException {
				
		if(result.hasErrors()) {
			logger.info("Returning updateTimetable.jspx page");
			
			return "timetable/updateTimetable";
		} else {
			logger.info("UpdateTimetable done");
			
			model.addAttribute("timetable", timetable);

			logger.info("UserSession " + SecurityContextHolder.getContext().getAuthentication().getName());
			
			timetable.setUserProfile(userService.findUserProfileByLogin(SecurityContextHolder.getContext().getAuthentication().getName()));			
			
			Timetable merda = parkService.saveTimetable(timetable);
			
			logger.info("Update Timetable page POST!" + merda);
			
			return "redirect:/timetable/showTimetables";
		}
	}

	private void initModelListPark(Model model) throws InstanceNotFoundException {
		List <Park> parkList = parkService.getParks(startIndex, PARK_PER_PAGE).getParks();
		model.addAttribute("parkList",parkList);
	}	
	
}
