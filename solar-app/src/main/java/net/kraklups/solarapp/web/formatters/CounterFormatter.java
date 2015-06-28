package net.kraklups.solarapp.web.formatters;

import java.text.ParseException;
import java.util.Locale;

import net.kraklups.solarapp.model.elementprk.Counter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class CounterFormatter implements Formatter<Counter> {

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(CounterFormatter.class);
	
	@Override
	public String print(Counter counter, Locale locale) {

		return counter.getCounterId().toString();
	}

	@Override
	public Counter parse(String counterId, Locale locale) throws ParseException {
		
		Counter counter = new Counter();
		counter.setCounterId(Long.parseLong(counterId));
		
		return counter;
	}
}
