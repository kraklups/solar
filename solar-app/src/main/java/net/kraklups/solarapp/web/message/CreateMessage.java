package net.kraklups.solarapp.web.message;

import net.kraklups.solarapp.model.messageevent.MessageEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application Message page.
 */
@Controller
public class CreateMessage {

	private static final Logger logger = LoggerFactory.getLogger(CreateMessage.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/message/createMessage", method = RequestMethod.GET)
	public String createMessageGet(Model model) {
		
		logger.info("Create Message page GET!");
		
		model.addAttribute("messageEvent", new MessageEvent());
				
		return "message/createMessage";
	}
	
	@RequestMapping(value = "/message/createMessage", method = RequestMethod.POST)
	public String createMessagePost(@ModelAttribute MessageEvent messageEvent) {
		
		logger.info("Create Message page POST!" + "messageEvent Id: " + messageEvent.getMessageEventId());
		
			
		return "message/createMessage";
	}	
	
}
