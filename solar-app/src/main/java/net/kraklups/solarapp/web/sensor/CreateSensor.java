package net.kraklups.solarapp.web.sensor;

import java.util.List;

import javax.validation.Valid;

import net.kraklups.modelutil.exceptions.DuplicateInstanceException;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.elementprk.ElementPrk;
import net.kraklups.solarapp.model.elementservice.ElementService;
import net.kraklups.solarapp.model.sensor.Sensor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application Sensor page.
 */
@Controller
public class CreateSensor {

	private final static int ELEMENTPRK_PER_PAGE = 50;
	
	private static final Logger logger = LoggerFactory.getLogger(CreateSensor.class);
	
	private int startIndex = 0;
	
	@Autowired
	private ElementService elementService;	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/sensor/createSensor", method = RequestMethod.GET)
	public String createSensorGet(Model model) 
			throws InstanceNotFoundException {
		
		logger.info("Create Sensor page GET!");
		
		model.addAttribute("sensor", new Sensor());
		
		initModelListElementPrk(model);
				
		return "sensor/createSensor";
	}
	
	@RequestMapping(value = "/sensor/createSensor", method = RequestMethod.POST)
	public String createSensorPost(@Valid @ModelAttribute("sensor") Sensor sensor, BindingResult result, Model model) 
			throws DuplicateInstanceException, InstanceNotFoundException {
		
		if(result.hasErrors()) {
			logger.info("Returning after error createSensor.jspx page");
			
			initModelListElementPrk(model);

			return "sensor/createSensor";
		} else {
			logger.info("Create Sensor page! " + "sensor: " + sensor);

			model.addAttribute("sensor", sensor);
			
			Sensor merda = elementService.saveSensor(sensor);
			
			logger.info("Create Sensor page POST! " + merda);			
			
			return "redirect:/sensor/showSensors";
		}
	}	
	
	private void initModelListElementPrk(Model model) throws InstanceNotFoundException {
		List <ElementPrk> elementPrkList = elementService.getElementPrks(startIndex, ELEMENTPRK_PER_PAGE).getElementPrks();
		model.addAttribute("elementPrkList",elementPrkList);
	}		
	
}
