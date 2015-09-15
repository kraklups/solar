package net.kraklups.solarapp.web.datavalue;

import java.util.List;

import javax.validation.Valid;

import net.kraklups.modelutil.exceptions.DuplicateInstanceException;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.datalogger.DataLogger;
import net.kraklups.solarapp.model.dataservice.DataService;
import net.kraklups.solarapp.model.datavalue.DataValue;
import net.kraklups.solarapp.model.elementprk.ElementPrk;
import net.kraklups.solarapp.model.elementservice.ElementService;
import net.kraklups.solarapp.model.sensor.Sensor;
import net.kraklups.solarapp.model.taskprk.Synchronize;
import net.kraklups.solarapp.model.taskprkservice.TaskPrkService;

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
 * Handles requests for the application Datavalue page.
 */
@Controller
public class UpdateDataValue {
	
	private final static int SENSOR_PER_PAGE = 50;
	
	private final static int TASKPRK_PER_PAGE = 50;
	
	private final static int DATALOGGER_PER_PAGE = 50;
	
	private final static int ELEMENTPRK_PER_PAGE = 50;	

	private static final Logger logger = LoggerFactory.getLogger(UpdateDataValue.class);
	
	private int startIndex = 0;
	
	@Autowired
	private DataService dataService;
	
	@Autowired
	private ElementService elementService;
	
	@Autowired
	private TaskPrkService taskPrkService;		
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/dataValue/updateDataValue/{dataValueId}", method = RequestMethod.GET)
	public String updateDataValueGet(@PathVariable String dataValueId, Model model) 
			throws InstanceNotFoundException {
		
		logger.info("Create DataValue page GET!");
		
		DataValue dataValue = dataService.findDataValue(Long.valueOf(dataValueId));
		
		model.addAttribute("dataValue", dataValue);
		
		initModelListDataLogger(model);
		
		initModelListSensor(model);
		
		initModelListSynchronize(model);
		
		initModelListElementPrk(model);		
				
		return "dataValue/updateDataValue";
	}
	
	@RequestMapping(value = "/dataValue/updateDataValue/{dataValueId}", method = RequestMethod.POST)
	public String updateDataValuePost(@Valid @ModelAttribute("dataValue") DataValue dataValue, BindingResult result, Model model) 
			throws DuplicateInstanceException, InstanceNotFoundException {
				
		if(result.hasErrors()) {
			logger.info("Returning updateDataValue.jspx page");
			
			return "dataValue/updateDataValue";
		} else {
			logger.info("UpdateDataValue done");
			
			model.addAttribute("dataValue", dataValue);
			
			DataValue merda = dataService.saveDataValue(dataValue);
			
			logger.info("Update DataValue page POST!" + merda);
			
			return "redirect:/dataValue/showDataValues";
		}
	}
	
	private void initModelListSensor(Model model) throws InstanceNotFoundException {
		List <Sensor> sensorList = elementService.getSensors(startIndex, SENSOR_PER_PAGE).getSensors();
		model.addAttribute("sensorList",sensorList);
	}
	
	private void initModelListSynchronize(Model model) throws InstanceNotFoundException {
		List <Synchronize> synchronizeList = taskPrkService.getSynchronizes(startIndex, TASKPRK_PER_PAGE).getSynchronizes();
		model.addAttribute("synchronizeList",synchronizeList);
	}

	private void initModelListDataLogger(Model model) throws InstanceNotFoundException {
		List <DataLogger> dataLoggerList = dataService.getDataLoggers(startIndex, DATALOGGER_PER_PAGE).getDataLoggers();
		model.addAttribute("dataLoggerList",dataLoggerList);
	}	
	
	private void initModelListElementPrk(Model model) throws InstanceNotFoundException {
		List <ElementPrk> elementPrkList = elementService.getElementPrks(startIndex, ELEMENTPRK_PER_PAGE).getElementPrks();
		model.addAttribute("elementPrkList",elementPrkList);
	}		
}
