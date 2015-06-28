package net.kraklups.solarapp.web.formatters;

import java.text.ParseException;
import java.util.Locale;

import net.kraklups.solarapp.model.elementprk.ExtractionPoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class ExtractionPointFormatter implements Formatter<ExtractionPoint> {

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(ExtractionPointFormatter.class);
	
	@Override
	public String print(ExtractionPoint extractionPoint, Locale locale) {
		
//		logger.info("merde print: " + extractionPoint);
		
		return extractionPoint.getExtractionPointId().toString();
	}

	@Override
	public ExtractionPoint parse(String extractionPointId, Locale locale) throws ParseException {
		
//		logger.info("merde parse: " + extractionPointId);
		
		ExtractionPoint extractionPoint = new ExtractionPoint();
		extractionPoint.setExtractionPointId(Long.parseLong(extractionPointId));
		
		return extractionPoint;
	}
}
