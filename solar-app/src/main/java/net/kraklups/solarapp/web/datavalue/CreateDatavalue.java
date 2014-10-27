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
public class CreateDatavalue {

	private static final Logger logger = LoggerFactory.getLogger(CreateDatavalue.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/datavalue/createDatavalue", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("Create Datavalue page !");
		
		return "datavalue/createDatavalue";
	}
}
