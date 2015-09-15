package net.kraklups.solarapp.web.formatters;

import java.text.ParseException;
import java.util.Locale;

import net.kraklups.solarapp.model.elementprk.MediumVoltage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class MediumVoltageFormatter implements Formatter<MediumVoltage> {

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(MediumVoltageFormatter.class);
	
	@Override
	public String print(MediumVoltage mediumVoltage, Locale locale) {
		
		//logger.info("merde print: " + mediumVoltage);
		
		return mediumVoltage.getMediumVoltageId().toString();
	}

	@Override
	public MediumVoltage parse(String mediumVoltageId, Locale locale) throws ParseException {
		
//		logger.info("merde parse: " + mediumVoltageId);
		
		MediumVoltage mediumVoltage = new MediumVoltage();
		mediumVoltage.setMediumVoltageId(Long.parseLong(mediumVoltageId));
		
		return mediumVoltage;
	}
}
