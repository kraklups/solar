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
public class CreateState {

	private static final Logger logger = LoggerFactory.getLogger(CreateState.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/state/createState", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("Create State page !");
		
		return "state/createState";
	}

}