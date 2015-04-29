package net.kraklups.solarapp.web.alarm;

import java.util.List;

import javax.validation.Valid;

import net.kraklups.modelutil.exceptions.DuplicateInstanceException;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.alarm.Alarm;
import net.kraklups.solarapp.model.eventtsk.EventTsk;
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
 * Handles requests for the application about page.
 */
@Controller
public class CreateAlarm {

	private final static int EVENTTSK_PER_PAGE = 50;
	
	private static final Logger logger = LoggerFactory.getLogger(CreateAlarm.class);
	
	private int startIndex = 0;

	@Autowired
	private TaskPrkService taskPrkService;
		
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/alarm/createAlarm", method = RequestMethod.GET)
	public String createAlarmGet(Model model) throws InstanceNotFoundException {
		
		logger.info("Create Alarm page !");
		
		Alarm alarm = new Alarm();
		
		model.addAttribute("alarm", alarm);
		initModelList(model);
		
		return "alarm/createAlarm";
	}
	
	@RequestMapping(value = "/alarm/createAlarm", method = RequestMethod.POST)
	public String createAlarmPost(@Valid @ModelAttribute("alarm") Alarm alarm, BindingResult result, Model model)
			throws DuplicateInstanceException, InstanceNotFoundException {
		
		if(result.hasErrors()) {
			logger.info("Returning after error createAlarm.jspx page");
			
			return "alarm/createAlarm";
		} else {
			
			logger.info("Create Alarm page !" + "alarm name: " + alarm.getAlarmId());

			model.addAttribute("alarm", alarm);
			
			Alarm merda = taskPrkService.saveAlarm(alarm);
			
			logger.info("Create Alarm page POST! " + merda);
			
			return "Done";
		}
				
	}

	private void initModelList(Model model) throws InstanceNotFoundException {
		List <EventTsk> evenTskList = taskPrkService.getEventTsks(startIndex, EVENTTSK_PER_PAGE).getEventTsks();
		model.addAttribute(evenTskList);
	}	
	
}
