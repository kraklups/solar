package net.kraklups.solarapp.web.formatters;

import java.text.ParseException;
import java.util.Locale;

import net.kraklups.solarapp.model.datalogger.DataLogger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class DataLoggerFormatter implements Formatter<DataLogger> {

	private static final Logger logger = LoggerFactory.getLogger(DataLoggerFormatter.class);
	
	@Override
	public String print(DataLogger dataLogger, Locale locale) {
		
		logger.info("merde print: " + dataLogger);
		
		return dataLogger.getDataLoggerId().toString();
	}

	@Override
	public DataLogger parse(String dataLoggerId, Locale locale) throws ParseException {
		
		logger.info("merde parse: " + dataLoggerId);
		
		DataLogger dataLogger = new DataLogger();
		dataLogger.setDataLoggerId(Long.parseLong(dataLoggerId));
		
		return dataLogger;
	}

}
