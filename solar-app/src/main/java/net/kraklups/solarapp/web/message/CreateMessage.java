package net.kraklups.solarapp.web.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String home(Model model) {
		logger.info("Create Message page !");
		
		return "message/createMessage";
	}	
}
