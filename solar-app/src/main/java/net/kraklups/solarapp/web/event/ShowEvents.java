package net.kraklups.solarapp.web.event;

import java.util.List;

import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.eventtsk.EventTsk;
import net.kraklups.solarapp.model.taskprkservice.TaskPrkService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application about page.
 */
@Controller
public class ShowEvents {
	
	private final static int EVENTS_PER_PAGE = 50;

	private static final Logger logger = LoggerFactory.getLogger(ShowEvents.class);
	
	private int startIndex = 0;
	
	@Autowired
	private TaskPrkService taskPrkService;		
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/event/showEvents", method = RequestMethod.GET)
	public String home(Model model) 
			throws InstanceNotFoundException {
		
		logger.info("Show Events page !");
		
		initModelListEventTsks(model);
		
		return "event/showEvents";
	}
	
	private void initModelListEventTsks(Model model) throws InstanceNotFoundException {
		List <EventTsk> eventTskList = taskPrkService.getEventTsks(startIndex, EVENTS_PER_PAGE).getEventTsks();
		model.addAttribute("eventTskList",eventTskList);
	}	

}
