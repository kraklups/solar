package net.kraklups.solarapp.web.datalogger;

import javax.validation.Valid;

import net.kraklups.solarapp.model.datalogger.DataLogger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private static final Logger logger = LoggerFactory.getLogger(CreateDataLogger.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/dataLogger/createDataLogger", method = RequestMethod.GET)
	public String createDataLoggerGet(Model model) {
		
		logger.info("Create DataLogger page GET!");
		
		model.addAttribute("dataLogger", new DataLogger());
				
		return "dataLogger/createDataLogger";
	}
	
	@RequestMapping(value = "/dataLogger/createDataLogger", method = RequestMethod.POST)
	public String createDataLoggerPost(@Valid @ModelAttribute("dataLogger") DataLogger dataLogger, BindingResult result) {
		
		logger.info("Create DataLogger page POST!" + "dataLogger Tag: " + dataLogger.getDataLoggerTag());
				
		if(result.hasErrors()) {
			return "dataLogger/createDataLogger";
		} else {
			return "Done";
		}
		
	}	

}
