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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application about page.
 */
@Controller
public class UpdateDataLogger {
	
	private final static int DATALOGGER_PER_PAGE = 50;

	private static final Logger logger = LoggerFactory.getLogger(UpdateDataLogger.class);
	
	private int startIndex = 0;

	@Autowired
	private DataService dataService;	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/dataLogger/updateDataLogger/{dataLoggerId}", method = RequestMethod.GET)
	public String updateDataLoggerGet(@PathVariable String dataLoggerId, Model model) 
			throws InstanceNotFoundException {
		
		logger.info("Create DataLogger page GET!");
		
		DataLogger dataLogger = dataService.findDataLogger(Long.valueOf(dataLoggerId));
		
		model.addAttribute("dataLogger", dataLogger);
		
		initModelListDataLogger(model);
				
		return "dataLogger/updateDataLogger";
	}
	
	@RequestMapping(value = "/dataLogger/updateDataLogger/{dataLoggerId}", method = RequestMethod.POST)
	public String updateDataLoggerPost(@Valid @ModelAttribute("dataLogger") DataLogger dataLogger, BindingResult result, Model model) 
			throws DuplicateInstanceException, InstanceNotFoundException {
				
		if(result.hasErrors()) {
			logger.info("Returning updateDataLogger.jspx page");
			
			return "dataLogger/updateDataLogger";
		} else {
			logger.info("UpdateDataLogger done");
			
			model.addAttribute("dataLogger", dataLogger);
			
			DataLogger merda = dataService.saveDataLogger(dataLogger);
			
			logger.info("Update DataLogger page POST!" + merda);
			
			return "redirect:/dataLogger/showDataLoggers";
		}
	}
	
	private void initModelListDataLogger(Model model) throws InstanceNotFoundException {
		List <DataLogger> dataLoggerList = dataService.getDataLoggers(startIndex, DATALOGGER_PER_PAGE).getDataLoggers();
		model.addAttribute("dataLoggerList", dataLoggerList);
	}	
}
