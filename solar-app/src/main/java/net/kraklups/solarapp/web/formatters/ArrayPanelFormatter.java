package net.kraklups.solarapp.web.formatters;

import java.text.ParseException;
import java.util.Locale;

import net.kraklups.solarapp.model.elementprk.ArrayPanel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class ArrayPanelFormatter implements Formatter<ArrayPanel>{

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(ArrayPanelFormatter.class);
	
	@Override
	public String print(ArrayPanel arrayPanel, Locale locale) {
		
		return arrayPanel.getArrayPanelId().toString();
	}

	@Override
	public ArrayPanel parse(String arrayPanelId, Locale locale) throws ParseException {
		
		ArrayPanel arrayPanel = new ArrayPanel();
		arrayPanel.setArrayPanelId(Long.parseLong(arrayPanelId));
		
		return arrayPanel;
	}
}
