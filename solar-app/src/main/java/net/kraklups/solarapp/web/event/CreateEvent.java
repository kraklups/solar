package net.kraklups.solarapp.web.event;

import java.util.List;

import javax.validation.Valid;

import net.kraklups.modelutil.exceptions.DuplicateInstanceException;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.eventtsk.EventTsk;
import net.kraklups.solarapp.model.parkservice.ParkService;
import net.kraklups.solarapp.model.taskprk.TaskPrk;
import net.kraklups.solarapp.model.taskprkservice.TaskPrkService;
import net.kraklups.solarapp.model.timetable.Timetable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application about page.
 */
@Controller
public class CreateEvent {

	private final static int TASKPRK_PER_PAGE = 50;
	
	private final static int TIMETABLE_PER_PAGE = 50;
	
	private static final Logger logger = LoggerFactory.getLogger(CreateEvent.class);
	
	private int startIndex = 0;
	
	@Autowired
	private TaskPrkService taskPrkService;		
	
	@Autowired
	private ParkService parkService;			
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/event/createEvent", method = RequestMethod.GET)
	public String createEventGet(Model model) 
			throws InstanceNotFoundException {
		
		logger.info("Create Event page GET!");
		
		model.addAttribute("eventTsk", new EventTsk());
		
		initModelListTaskPrk(model);
		
		initModelListTimetable(model);
				
		return "event/createEvent";
	}
	
	@RequestMapping(value = "/event/createEvent", method = RequestMethod.POST)
	public String createEventPost(@Valid @ModelAttribute("eventTsk") EventTsk eventTsk, BindingResult result, Model model) 
			throws DuplicateInstanceException, InstanceNotFoundException {
				
		if(result.hasErrors()) {
			logger.info("Returning after error createEvent.jspx page");
			
			return "event/createEvent";
		} else {
			logger.info("Create TimetableBlock page! " + "eventTsk: " + eventTsk);

			model.addAttribute("eventTsk", eventTsk);
			
			EventTsk merda = taskPrkService.saveEventTsk(eventTsk);
			
			logger.info("Create TimetableBlock page POST! " + merda);			
			
			return "redirect:/event/ShowEvents";
		}
			
	}	

	private void initModelListTaskPrk(Model model) throws InstanceNotFoundException {
		List <TaskPrk> taskPrkList = taskPrkService.getTaskPrks(startIndex, TASKPRK_PER_PAGE).getTaskPrks();
		model.addAttribute("taskPrkList",taskPrkList);
	}	
	
	private void initModelListTimetable(Model model) throws InstanceNotFoundException {
		List <Timetable> timetableList = parkService.getTimetables(startIndex, TIMETABLE_PER_PAGE).getTimetables();
		model.addAttribute("timetableList",timetableList);
	}	
	
}
