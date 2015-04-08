package net.kraklups.solarapp.web.park;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application Park page.
 */
@Controller
public class UpdatePark {

	private static final Logger logger = LoggerFactory.getLogger(UpdatePark.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/park/updatePark", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("Update Park page !");
		
		return "park/updatePark";
	}

}
