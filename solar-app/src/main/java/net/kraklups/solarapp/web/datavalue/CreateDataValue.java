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
import net.kraklups.solarapp.model.taskprk.TaskPrk;
import net.kraklups.solarapp.model.taskprkservice.TaskPrkService;

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
 * Handles requests for the application DataValue page.
 */
@Controller
public class CreateDataValue {

	private final static int SENSOR_PER_PAGE = 50;
	
	private final static int TASKPRK_PER_PAGE = 50;
	
	private final static int DATALOGGER_PER_PAGE = 50;
	
	private final static int ELEMENTPRK_PER_PAGE = 50;
	
	private static final Logger logger = LoggerFactory.getLogger(CreateDataValue.class);
	
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
	@RequestMapping(value = "/dataValue/createDataValue", method = RequestMethod.GET)
	public String createDataValueGet(Model model) 
			throws InstanceNotFoundException {
		
		logger.info("Create DataValue page !");
		
		model.addAttribute("dataValue", new DataValue());
		
		initModelListDataLogger(model);
		
		initModelListSensor(model);
		
		initModelListTaskPrk(model);
		
		initModelListElementPrk(model);
		
		return "dataValue/createDataValue";
	}
	
	@RequestMapping(value = "/dataValue/createDataValue", method = RequestMethod.POST)
	public String createDataValuePost(@Valid @ModelAttribute("dataValue") DataValue dataValue, BindingResult result, Model model) 
			throws DuplicateInstanceException, InstanceNotFoundException {
				
		if(result.hasErrors()) {
			logger.info("Returning after error createDataValue.jspx page");
			
			return "dataValue/createDataValue";
		} else {
			logger.info("Create DataValue page! " + "dataValue: " + dataValue);

			model.addAttribute("dataValue", dataValue);
			
			DataValue merda = dataService.saveDataValue(dataValue);
			
			logger.info("Create DataValue page POST! " + merda);
			
			return "Done";

		}				
	}	
	
	private void initModelListSensor(Model model) throws InstanceNotFoundException {
		List <Sensor> sensorList = elementService.getSensors(startIndex, SENSOR_PER_PAGE).getSensors();
		model.addAttribute(sensorList);
	}
	
	private void initModelListTaskPrk(Model model) throws InstanceNotFoundException {
		List <TaskPrk> taskPrkList = taskPrkService.getTaskPrks(startIndex, TASKPRK_PER_PAGE).getTaskPrks();
		model.addAttribute(taskPrkList);
	}	

	private void initModelListDataLogger(Model model) throws InstanceNotFoundException {
		List <DataLogger> dataLoggerList = dataService.getDataLoggers(startIndex, DATALOGGER_PER_PAGE).getDataLoggers();
		model.addAttribute(dataLoggerList);
	}	
	
	private void initModelListElementPrk(Model model) throws InstanceNotFoundException {
		List <ElementPrk> elementPrkList = elementService.getElementPrks(startIndex, ELEMENTPRK_PER_PAGE).getElementPrks();
		model.addAttribute(elementPrkList);
	}	
}
