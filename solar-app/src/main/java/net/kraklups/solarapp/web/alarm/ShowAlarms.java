package net.kraklups.solarapp.web.alarm;

import java.util.List;

import net.kraklups.modelutil.exceptions.InstanceNotFoundException;

import net.kraklups.solarapp.model.alarm.Alarm;
import net.kraklups.solarapp.model.taskprkservice.TaskPrkService;
import net.kraklups.solarapp.web.datavalue.CreateDataValue;

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
	
	private static final Logger logger = LoggerFactory.getLogger(CreateDataValue.class);
	
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

	private void initModelListAlarm(Model model) throws InstanceNotFoundException {
		List <Alarm> AlarmList = taskPrkService.getAlarms(startIndex, ALARM_PER_PAGE).getAlarms();
		model.addAttribute("AlarmList",AlarmList);
	}

}
