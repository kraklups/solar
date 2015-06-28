package net.kraklups.solarapp.web.formatters;

import java.text.ParseException;
import java.util.Locale;

import net.kraklups.solarapp.model.taskprk.TaskPrk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class TaskPrkFormatter implements Formatter<TaskPrk> {

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(TaskPrkFormatter.class);
	
	@Override
	public String print(TaskPrk taskPrk, Locale locale) {
		
		//logger.info("merde print: " + taskPrk);
		
		return taskPrk.getTaskPrkId().toString();
	}

	@Override
	public TaskPrk parse(String taskPrkId, Locale locale) throws ParseException {
		
//		logger.info("merde parse: " + taskPrkId);
		
		TaskPrk taskPrk = new TaskPrk();
		taskPrk.setTaskPrkId(Long.parseLong(taskPrkId));
		
		return taskPrk;
	}

}
