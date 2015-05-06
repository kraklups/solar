package net.kraklups.solarapp.web.datavalue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application Datavalue page.
 */
@Controller
public class UpdateDataValue {

	private static final Logger logger = LoggerFactory.getLogger(UpdateDataValue.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/datavalue/updateDatavalue", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("Update Datavalue page !");
		
		return "updateDatavalue";
	}
}
