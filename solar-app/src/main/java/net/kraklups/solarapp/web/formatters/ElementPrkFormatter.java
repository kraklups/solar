package net.kraklups.solarapp.web.formatters;

import java.text.ParseException;
import java.util.Locale;

import net.kraklups.solarapp.model.elementprk.ElementPrk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class ElementPrkFormatter implements Formatter<ElementPrk> {

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(ElementPrkFormatter.class);
	
	@Override
	public String print(ElementPrk elementPrk, Locale locale) {
		
//		logger.info("merde print: " + elementPrk);
		
		return elementPrk.getElementPrkId().toString();
	}

	@Override
	public ElementPrk parse(String elementPrkId, Locale locale) throws ParseException {
		
//		logger.info("merde parse: " + elementPrkId);
		
		ElementPrk elementPrk = new ElementPrk();
		elementPrk.setElementPrkId(Long.parseLong(elementPrkId));
		
		return elementPrk;
	}

}
