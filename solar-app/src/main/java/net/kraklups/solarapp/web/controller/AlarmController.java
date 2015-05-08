package net.kraklups.solarapp.web.controller;

import net.kraklups.modelutil.exceptions.AlarmNotFoundException;
import net.kraklups.modelutil.exceptions.DuplicateInstanceException;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.alarm.Alarm;
import net.kraklups.solarapp.model.alarm.AlarmDTO;
import net.kraklups.solarapp.model.taskprkservice.TaskPrkService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
final class AlarmController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AlarmController.class);

	@Autowired
	private final TaskPrkService taskPrk;
	
	@Autowired
	public AlarmController(TaskPrkService taskPrk) {
		this.taskPrk = taskPrk;
	}	
	
	@RequestMapping(value = "/notifyalarm", method = RequestMethod.POST, headers="Accept=application/json")
	public @ResponseBody Alarm create(@RequestBody AlarmDTO alarmDTO) throws DuplicateInstanceException, InstanceNotFoundException {
		
		LOGGER.warn("Handling EventTsk & NotifyAlarm: {}", alarmDTO.getEventTskId());
		
		return taskPrk.alarmTriggered(alarmDTO);
	}		
	
	@ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleDataValueNotFound(AlarmNotFoundException ex) {
		LOGGER.error("Handling error with message: {}", ex.getMessage());
    }
	
}