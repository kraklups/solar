package net.kraklups.solarapp.web.sensor;

import net.kraklups.solarapp.model.sensor.Sensor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application Sensor page.
 */
@Controller
public class CreateSensor {

	private static final Logger logger = LoggerFactory.getLogger(CreateSensor.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/sensor/createSensor", method = RequestMethod.GET)
	public String createSensorGet(Model model) {
		
		logger.info("Create Sensor page GET!");
		
		model.addAttribute("sensor", new Sensor());
				
		return "sensor/createSensor";
	}
	
	@RequestMapping(value = "/sensor/createSensor", method = RequestMethod.POST)
	public String createSensorPost(@ModelAttribute Sensor sensor) {
		
		logger.info("Create Sensor page POST!" + "sensor name: " + sensor.getSensorTag());
		
			
		return "sensor/createSensor";
	}	
	
}
