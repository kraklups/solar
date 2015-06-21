package net.kraklups.solarapp.web.formatters;

import java.text.ParseException;
import java.util.Locale;

import net.kraklups.solarapp.model.taskprk.Synchronize;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.Formatter;

public class SynchronizeFormatter implements Formatter<Synchronize> {

	private static final Logger logger = LoggerFactory.getLogger(SynchronizeFormatter.class);
	
	@Override
	public String print(Synchronize synchronize, Locale locale) {
		
		logger.info("merde print: " + synchronize);
		
		return synchronize.getSynchronizeId().toString();
	}

	@Override
	public Synchronize parse(String synchronizeId, Locale locale) throws ParseException {
		
		logger.info("merde parse: " + synchronizeId);
		
		Synchronize synchronize = new Synchronize();
		synchronize.setSynchronizeId(Long.parseLong(synchronizeId));
		
		return synchronize;
	}
}
