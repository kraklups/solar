package net.kraklups.solarapp.web.state;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application State page.
 */
@Controller
public class ShowStates {

	private static final Logger logger = LoggerFactory.getLogger(ShowStates.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/state/showStates", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("Create State page !");
		
		return "state/showStates";
	}

}
