package net.kraklups.solarapp.web.controller;

import java.util.ArrayList;
import java.util.List;

import net.kraklups.modelutil.exceptions.AlarmNotFoundException;
import net.kraklups.modelutil.exceptions.DuplicateInstanceException;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.alarm.Alarm;
import net.kraklups.solarapp.model.alarm.AlarmDTO;
import net.kraklups.solarapp.model.taskprkservice.TaskPrkService;
import net.kraklups.solarapp.web.datavalue.CreateDataValue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
@RequestMapping("/rest")
final class AlarmController {

	private final static int ALARM_PER_PAGE = 50;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CreateDataValue.class);
	
	private int startIndex = 0;

	@Autowired
	private final TaskPrkService taskPrkService;
	
	@Autowired
	public AlarmController(TaskPrkService taskPrkService) {
		this.taskPrkService = taskPrkService;
	}	
	
	@RequestMapping(value = "/notifyalarm", method = RequestMethod.POST, headers="Accept=application/json")
	public @ResponseBody Alarm create(@RequestBody AlarmDTO alarmDTO) throws DuplicateInstanceException, InstanceNotFoundException {
		
		LOGGER.warn("Handling EventTsk & NotifyAlarm: {}", alarmDTO.getEventTskId());
		
		return taskPrkService.alarmTriggered(alarmDTO);
	}		

	@RequestMapping(value = "/alarmTriggered/{alarmId}", method = RequestMethod.GET, headers="Accept=application/json", produces = "application/json")
    public @ResponseBody List<Alarm> alarmsTriggered(@PathVariable String alarmId) 
    		throws InstanceNotFoundException {
		
		Alarm alarm = taskPrkService.findAlarm(Long.valueOf(alarmId));
			
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode node = mapper.createObjectNode();
		
		node.put("alarmId", alarm.getAlarmId());
		node.put("URL", alarm.getAlarmTag());
		
		LOGGER.warn("Handling AlarmTriggered: {}", alarm.getAlarmId());
		
		List <Alarm> alarmList = taskPrkService.getAlarms(startIndex, ALARM_PER_PAGE).getAlarms();
		
		return alarmList;
	}
	
	@ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleDataValueNotFound(AlarmNotFoundException ex) {
		LOGGER.error("Handling error with message: {}", ex.getMessage());
    }
		
}
