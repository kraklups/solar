package net.kraklups.solarapp.web.formatters;

import java.text.ParseException;
import java.util.Locale;

import net.kraklups.solarapp.model.taskprk.Upkeep;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class UpkeepFormatter implements Formatter<Upkeep> {

	private static final Logger logger = LoggerFactory.getLogger(UpkeepFormatter.class);
	
	@Override
	public String print(Upkeep upkeep, Locale locale) {
		
		logger.info("merde print: " + upkeep);
		
		return upkeep.getUpkeepId().toString();
	}

	@Override
	public Upkeep parse(String upkeepId, Locale locale) throws ParseException {
		
		logger.info("merde parse: " + upkeepId);
		
		Upkeep upkeep = new Upkeep();
		upkeep.setUpkeepId(Long.parseLong(upkeepId));
		
		return upkeep;
	}

}
