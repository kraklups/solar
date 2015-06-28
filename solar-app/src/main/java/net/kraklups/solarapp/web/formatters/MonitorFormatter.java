package net.kraklups.solarapp.web.formatters;

import java.text.ParseException;
import java.util.Locale;

import net.kraklups.solarapp.model.taskprk.Monitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class MonitorFormatter implements Formatter<Monitor> {

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(MonitorFormatter.class);
	
	@Override
	public String print(Monitor monitor, Locale locale) {
		
//		logger.info("merde print: " + monitor);
		
		return monitor.getMonitorId().toString();
	}

	@Override
	public Monitor parse(String monitorId, Locale locale) throws ParseException {
		
//		logger.info("merde parse: " + monitorId);
		
		Monitor monitor = new Monitor();
		monitor.setMonitorId(Long.parseLong(monitorId));
		
		return monitor;
	}
}