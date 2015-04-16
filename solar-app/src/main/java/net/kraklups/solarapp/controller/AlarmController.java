package net.kraklups.solarapp.controller;

import java.util.List;

import javax.validation.Valid;

import net.kraklups.modelutil.exceptions.AlarmNotFoundException;
import net.kraklups.modelutil.exceptions.DuplicateInstanceException;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.alarm.Alarm;
import net.kraklups.solarapp.model.taskprkservice.AlarmBlock;
import net.kraklups.solarapp.model.taskprkservice.TaskPrkService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/setalarm")
final class AlarmController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AlarmController.class);
	
	private int startIndex = 0;
	private final static int ALARMS_PER_PAGE = 20;
	private AlarmBlock alarmBlock;
	private String alarmTag;

	@Autowired
	private final TaskPrkService taskPrk;
	
	@Autowired
	public AlarmController(TaskPrkService taskPrk) {
		this.taskPrk = taskPrk;
	}	
	
	@RequestMapping(method = RequestMethod.POST)
	public Alarm create(@RequestBody @Valid Alarm alarm) throws DuplicateInstanceException {
		
		LOGGER.error("Handling error with message: {}", alarm);
		
		return taskPrk.createAlarm(alarm.getAlarmTag(), alarm.getTriggerDate(), alarm.getEventTsk());
	}

	@RequestMapping(method = RequestMethod.GET)
    public List<Alarm> findAll(@RequestBody @Valid String alarmTag) throws InstanceNotFoundException {
		this.alarmTag = alarmTag;
		
        alarmBlock = taskPrk.getAlarmByAlarmTag(alarmTag, startIndex, ALARMS_PER_PAGE);
        
        return alarmBlock.getAlarms();
    }		
	
	@ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleDataValueNotFound(AlarmNotFoundException ex) {
		LOGGER.error("Handling error with message: {}", ex.getMessage());
    }
	
}
