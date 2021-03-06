package net.kraklups.solarapp.web.alarm;

import java.util.List;

import net.kraklups.modelutil.exceptions.InstanceNotFoundException;

import net.kraklups.solarapp.model.alarm.Alarm;
import net.kraklups.solarapp.model.taskprkservice.TaskPrkService;

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
public class ShowAlarms {

	private final static int ALARM_PER_PAGE = 50;
	
	private static final Logger logger = LoggerFactory.getLogger(ShowAlarms.class);
	
	private int startIndex = 0;
	
	@Autowired
	private TaskPrkService taskPrkService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/alarm/showAlarms", method = RequestMethod.GET)
	public String home(Model model) 
			throws InstanceNotFoundException {
		
		logger.info("Show Alarms page !");
		
		initModelListAlarm(model);
		
		return "alarm/showAlarms";
	}	
	
	@RequestMapping(value = "/alarm/showAlarmsTriggered", method = RequestMethod.GET)
	public String showAlarmsTriggered(Model model) 
			throws InstanceNotFoundException {
		
		logger.info("Show Alarms page !");
		
		initModelListAlarmTriggered(model);
		
		return "alarm/showAlarms";
	}		

	private void initModelListAlarm(Model model) throws InstanceNotFoundException {
		List <Alarm> alarmList = taskPrkService.getAlarms(startIndex, ALARM_PER_PAGE).getAlarms();
		model.addAttribute("alarmList",alarmList);
	}
	
	private void initModelListAlarmTriggered(Model model) throws InstanceNotFoundException {
		List <Alarm> alarmList = taskPrkService.getAlarmsTriggered(startIndex, ALARM_PER_PAGE).getAlarms();
		model.addAttribute("alarmList",alarmList);
	}	

}
