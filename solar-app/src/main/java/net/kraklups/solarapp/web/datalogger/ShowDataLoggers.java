package net.kraklups.solarapp.web.datalogger;

import java.util.List;

import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.datalogger.DataLogger;
import net.kraklups.solarapp.model.dataservice.DataService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application about page.
 */
@Controller
public class ShowDataLoggers {
	
	private final static int DATALOGGER_PER_PAGE = 50;

	private static final Logger logger = LoggerFactory.getLogger(ShowDataLoggers.class);
	
	private int startIndex = 0;
	
	@Autowired
	private DataService dataService;	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/dataLogger/showDataLoggers", method = RequestMethod.GET)
	public String home(Model model) 
			throws InstanceNotFoundException {
		
		logger.info("Create DataLogger page !");
		
		initModelListDataLoggers(model);
		
		return "dataLogger/showDataLoggers";
	}
	
	private void initModelListDataLoggers(Model model) throws InstanceNotFoundException {
		List <DataLogger> dataLoggerList = dataService.getDataLoggers(startIndex, DATALOGGER_PER_PAGE).getDataLoggers();
		model.addAttribute("dataLoggerList",dataLoggerList);
	}

}
