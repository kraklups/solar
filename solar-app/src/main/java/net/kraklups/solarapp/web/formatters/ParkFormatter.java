package net.kraklups.solarapp.web.formatters;

import java.text.ParseException;
import java.util.Locale;

import net.kraklups.solarapp.model.park.Park;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class ParkFormatter implements Formatter<Park>  {

	private static final Logger logger = LoggerFactory.getLogger(ParkFormatter.class);
	
	@Override
	public String print(Park park, Locale locale) {
		
		logger.info("merde print: " + park);
		
		return park.getParkId().toString();
	}

	@Override
	public Park parse(String parkId, Locale locale) throws ParseException {
		
		logger.info("merde parse: " + parkId);
		
		Park park = new Park();
		park.setParkId(Long.parseLong(parkId));
		
		return park;
	}
}
