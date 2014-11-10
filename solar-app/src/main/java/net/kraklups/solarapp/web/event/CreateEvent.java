package net.kraklups.solarapp.web.event;

import net.kraklups.solarapp.model.eventtsk.EventTsk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application about page.
 */
@Controller
public class CreateEvent {

	private static final Logger logger = LoggerFactory.getLogger(CreateEvent.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/event/createEvent", method = RequestMethod.GET)
	public String createEventGet(Model model) {
		
		logger.info("Create Event page GET!");
		
		model.addAttribute("eventTsk", new EventTsk());
				
		return "event/createEvent";
	}
	
	@RequestMapping(value = "/event/createEvent", method = RequestMethod.POST)
	public String createEventPost(@ModelAttribute EventTsk eventTsk) {
		
		logger.info("Create Event page POST!" + "event TagET: " + eventTsk.getTagET());
		
			
		return "event/createEvent";
	}	

}
