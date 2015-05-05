package net.kraklups.solarapp.web.datalogger;

import java.util.List;

import javax.validation.Valid;

import net.kraklups.modelutil.exceptions.DuplicateInstanceException;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.datalogger.DataLogger;
import net.kraklups.solarapp.model.dataservice.DataService;

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
 * Handles requests for the application about page.
 */
@Controller
public class CreateDataLogger {

	private final static int DATALOGGER_PER_PAGE = 50;
	
	private static final Logger logger = LoggerFactory.getLogger(CreateDataLogger.class);
	
	private int startIndex = 0;

	@Autowired
	private DataService dataService;	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/dataLogger/createDataLogger", method = RequestMethod.GET)
	public String createDataLoggerGet(Model model) throws InstanceNotFoundException {
		
		logger.info("Create DataLogger page GET!");
		
		DataLogger dataLogger = new DataLogger();
		
		model.addAttribute("dataLogger", dataLogger);
		
		initModelList(model);
				
		return "dataLogger/createDataLogger";
	}
	
	@RequestMapping(value = "/dataLogger/createDataLogger", method = RequestMethod.POST)
	public String createDataLoggerPost(@ModelAttribute("dataLogger") DataLogger dataLogger, BindingResult result, Model model) 
			throws DuplicateInstanceException, InstanceNotFoundException {
				
		if(result.hasErrors()) {
			logger.info("Returning after error createDataLogger.jspx page");
			
			return "dataLogger/createDataLogger";
		} else {
			logger.info("Create DataLogger page! " + "datalogger: " + dataLogger);

			model.addAttribute("dataLogger", dataLogger);
			
			DataLogger merda = dataService.saveDataLogger(dataLogger);
			
			logger.info("Create DataLogger page POST! " + merda);
			
			return "Done";
		}
		
	}	

	private void initModelList(Model model) throws InstanceNotFoundException {
		List <DataLogger> dataLoggerList = dataService.getDataLoggers(startIndex, DATALOGGER_PER_PAGE).getDataLoggers();
		model.addAttribute(dataLoggerList);
	}	
	
}
