package net.kraklups.solarapp.web.formatters;

import java.text.ParseException;
import java.util.Locale;

import net.kraklups.solarapp.model.elementprk.StringLine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class StringLineFormatter implements Formatter<StringLine> {

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(StringLineFormatter.class);
	
	@Override
	public String print(StringLine stringLine, Locale locale) {
		
//		logger.info("merde print: " + stringLine);
		
		return stringLine.getStringLineId().toString();
	}

	@Override
	public StringLine parse(String stringLineId, Locale locale) throws ParseException {
		
//		logger.info("merde parse: " + stringLineId);
		
		StringLine stringLine = new StringLine();
		stringLine.setStringLineId(Long.parseLong(stringLineId));
		
		return stringLine;
	}
}
