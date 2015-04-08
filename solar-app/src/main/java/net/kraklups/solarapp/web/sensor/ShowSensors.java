package net.kraklups.solarapp.web.sensor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application Sensor page.
 */
@Controller
public class ShowSensors {

	private static final Logger logger = LoggerFactory.getLogger(ShowSensors.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/sensor/showSensors", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("Show Sensors page !");
		
		return "sensor/showSensors";
	}

}
