package net.kraklups.solarapp.web.sensor;

import java.util.List;

import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.elementservice.ElementService;
import net.kraklups.solarapp.model.sensor.Sensor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application Sensor page.
 */
@Controller
public class ShowSensors {
	
	private final static int SENSOR_PER_PAGE = 50;

	private static final Logger logger = LoggerFactory.getLogger(ShowSensors.class);
	
	private int startIndex = 0;
	
	@Autowired
	private ElementService elementService;		
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/sensor/showSensors", method = RequestMethod.GET)
	public String home(Model model) 
			throws InstanceNotFoundException {
		
		logger.info("Show Sensors page !");
		
		initModelListSensors(model);
		
		return "sensor/showSensors";
	}
	
	private void initModelListSensors(Model model) throws InstanceNotFoundException {
		List <Sensor> sensorList = elementService.getSensors(startIndex, SENSOR_PER_PAGE).getSensors();
		model.addAttribute("sensorList",sensorList);
	}	

}
