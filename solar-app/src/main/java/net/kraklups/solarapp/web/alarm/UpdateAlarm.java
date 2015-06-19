package net.kraklups.solarapp.web.alarm;

import java.util.List;

import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.alarm.Alarm;
import net.kraklups.solarapp.model.eventtsk.EventTsk;
import net.kraklups.solarapp.model.taskprkservice.TaskPrkService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application about page.
 */
@Controller
public class UpdateAlarm {

	private final static int EVENTTSK_PER_PAGE = 50;
	
	private static final Logger logger = LoggerFactory.getLogger(UpdateAlarm.class);
	
	private int startIndex = 0;

	@Autowired
	private TaskPrkService taskPrkService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/alarm/updateAlarm/{alarmId}", method = RequestMethod.GET)
	public String home(@PathVariable String alarmId, Model model) 
			throws InstanceNotFoundException {

		logger.info("Create Alarm page !");
				
		Alarm alarm = taskPrkService.getAlarmById(Long.valueOf(alarmId));
		
		model.addAttribute("alarm", alarm);		
		initModelEventTskList(model);		
		
		return "alarm/updateAlarm";
	}

	@RequestMapping(value = "/alarm/updateAlarmCheked/{alarmId}", method = RequestMethod.GET)
	public String updateAlarmChecked(@PathVariable String alarmId, Model model) 
			throws InstanceNotFoundException {

		logger.info("Update Alarm Checked !");
		
		taskPrkService.getAlarmChecked(Long.valueOf(alarmId));
		
		return "redirect:/alarm/showAlarms";
	}	
	

	private void initModelEventTskList(Model model) throws InstanceNotFoundException {
		List <EventTsk> eventTskList = taskPrkService.getEventTsks(startIndex, EVENTTSK_PER_PAGE).getEventTsks();
		model.addAttribute("eventTskList", eventTskList);
	}		
	
}
