package net.kraklups.solarapp.web.alarm;

import net.kraklups.solarapp.model.alarm.Alarm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application about page.
 */
@Controller
public class CreateAlarm {

	private static final Logger logger = LoggerFactory.getLogger(CreateAlarm.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/alarm/createAlarm", method = RequestMethod.GET)
	public String createAlarmGet(Model model) {
		
		logger.info("Create Alarm page !");
		
		model.addAttribute("alarm", new Alarm());
		
		return "alarm/createAlarm";
	}
	
	@RequestMapping(value = "/alarm/createAlarm", method = RequestMethod.POST)
	public String createAlarmPost(@ModelAttribute Alarm alarm) {
		
		logger.info("Create Alarm page !" + "alarm name: " + alarm.getAlarmId());
		
		return "alarm/createAlarm";
	}
    
}
