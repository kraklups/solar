package net.kraklups.solarapp.web.formatters;

import java.text.ParseException;
import java.util.Locale;

import net.kraklups.solarapp.model.elementprk.ElectricalSubstation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class ElectricalSubstationFormatter implements Formatter<ElectricalSubstation> {

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(ElectricalSubstationFormatter.class);
	
	@Override
	public String print(ElectricalSubstation electricalSubstation, Locale locale) {
		
//		logger.info("merde print: " + electricalSubstation);
		
		return electricalSubstation.getElectricalSubstationId().toString();
	}

	@Override
	public ElectricalSubstation parse(String electricalSubstationId, Locale locale) throws ParseException {
		
//		logger.info("merde parse: " + electricalSubstationId);
		
		ElectricalSubstation electricalSubstation = new ElectricalSubstation();
		electricalSubstation.setElectricalSubstationId(Long.parseLong(electricalSubstationId));
		
		return electricalSubstation;
	}
}
