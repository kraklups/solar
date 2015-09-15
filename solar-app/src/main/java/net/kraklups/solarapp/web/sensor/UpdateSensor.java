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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application about page.
 */
@Controller
public class UpdateSensor {
	
	private final static int ELEMENTPRK_PER_PAGE = 50;

	private static final Logger logger = LoggerFactory.getLogger(UpdateSensor.class);
	
	private int startIndex = 0;
	
	@Autowired
	private ElementService elementService;		
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/sensor/updateSensor/{sensorId}", method = RequestMethod.GET)
	public String updateSensorGet(@PathVariable String sensorId, Model model) 
			throws InstanceNotFoundException {
		
		logger.info("Create Sensor page GET!");
		
		Sensor sensor = elementService.findSensor(Long.valueOf(sensorId));
		
		model.addAttribute("sensor", sensor);
		
		initModelListElementPrk(model);
				
		return "sensor/updateSensor";
	}
	
	@RequestMapping(value = "/sensor/updateSensor/{sensorId}", method = RequestMethod.POST)
	public String updateSensorPost(@Valid @ModelAttribute("sensor") Sensor sensor, BindingResult result, Model model) 
			throws DuplicateInstanceException, InstanceNotFoundException {
				
		if(result.hasErrors()) {
			logger.info("Returning updateSensor.jspx page");
			
			return "sensor/updateSensor";
		} else {
			logger.info("UpdateSensor done");
			
			model.addAttribute("sensor", sensor);
			
			Sensor merda = elementService.saveSensor(sensor);
			
			logger.info("Update Sensor page POST!" + merda);
			
			return "redirect:/sensor/showSensors";
		}
	}	
	
	private void initModelListElementPrk(Model model) throws InstanceNotFoundException {
		List <ElementPrk> elementPrkList = elementService.getElementPrks(startIndex, ELEMENTPRK_PER_PAGE).getElementPrks();
		model.addAttribute("elementPrkList",elementPrkList);
	}		

}
