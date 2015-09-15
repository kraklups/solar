package net.kraklups.solarapp.web.formatters;

import java.text.ParseException;
import java.util.Locale;

import net.kraklups.solarapp.model.eventtsk.EventTsk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class EventTskFormatter implements Formatter<EventTsk> {

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(EventTskFormatter.class);
	
	@Override
	public String print(EventTsk eventTsk, Locale locale) {
		
//		logger.info("merde print: " + eventTsk);
		
		return eventTsk.getEventTskId().toString();
	}

	@Override
	public EventTsk parse(String eventTskId, Locale locale) throws ParseException {
		
//		logger.info("merde parse: " + eventTskId);
		
		EventTsk eventTsk = new EventTsk();
		eventTsk.setEventTskId(Long.parseLong(eventTskId));
		
		return eventTsk;
	}

}
