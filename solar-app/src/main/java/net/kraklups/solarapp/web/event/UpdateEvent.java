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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application about page.
 */
@Controller
public class UpdateEvent {
	
	private final static int TASKPRK_PER_PAGE = 50;
	
	private final static int TIMETABLE_PER_PAGE = 50;

	private static final Logger logger = LoggerFactory.getLogger(UpdateEvent.class);
	
	private int startIndex = 0;
	
	@Autowired
	private TaskPrkService taskPrkService;		
	
	@Autowired
	private ParkService parkService;			
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/event/updateEvent/{eventTskId}", method = RequestMethod.GET)
	public String updateEventTskGet(@PathVariable String eventTskId, Model model) 
			throws InstanceNotFoundException {
		
		logger.info("Create EventTsk page GET!");
		
		EventTsk eventTsk = taskPrkService.findEventTsk(Long.valueOf(eventTskId));
		
		model.addAttribute("eventTsk", eventTsk);
		
		initModelListTaskPrk(model);
		
		initModelListTimetable(model);
				
		return "event/updateEvent";
	}
	
	@RequestMapping(value = "/event/updateEvent/{eventTskId}", method = RequestMethod.POST)
	public String updateEventTskPost(@Valid @ModelAttribute("eventTsk") EventTsk eventTsk, BindingResult result, Model model) 
			throws DuplicateInstanceException, InstanceNotFoundException {
				
		if(result.hasErrors()) {
			logger.info("Returning updateEventTsk.jspx page");
			
			return "eventTsk/updateEventTsk";
		} else {
			logger.info("UpdateEventTsk done");
			
			model.addAttribute("eventTsk", eventTsk);
			
			EventTsk merda = taskPrkService.saveEventTsk(eventTsk);
			
			logger.info("Update EventTsk page POST!" + merda);
			
			return "redirect:/event/showEvents";
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
