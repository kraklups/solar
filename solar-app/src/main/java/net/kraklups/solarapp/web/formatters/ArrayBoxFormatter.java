package net.kraklups.solarapp.web.formatters;

import java.text.ParseException;
import java.util.Locale;

import net.kraklups.solarapp.model.elementprk.ArrayBox;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class ArrayBoxFormatter implements Formatter<ArrayBox> {

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(ArrayBoxFormatter.class);
	
	@Override
	public String print(ArrayBox arrayBox, Locale locale) {
	
		return arrayBox.getArrayBoxId().toString();
	}

	@Override
	public ArrayBox parse(String arrayBoxId, Locale locale) throws ParseException {
		
		ArrayBox arrayBox = new ArrayBox();
		arrayBox.setArrayBoxId(Long.parseLong(arrayBoxId));
		
		return arrayBox;
	}
}
