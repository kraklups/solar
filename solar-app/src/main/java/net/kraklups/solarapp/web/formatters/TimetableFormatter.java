package net.kraklups.solarapp.web.formatters;

import java.text.ParseException;
import java.util.Locale;

import net.kraklups.solarapp.model.timetable.Timetable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class TimetableFormatter implements Formatter<Timetable> {

	private static final Logger logger = LoggerFactory.getLogger(TimetableFormatter.class);
	
	@Override
	public String print(Timetable timetable, Locale locale) {
		
		logger.info("merde print: " + timetable);
		
		return timetable.getTimetableId().toString();
	}

	@Override
	public Timetable parse(String timetableId, Locale locale) throws ParseException {
		
		logger.info("merde parse: " + timetableId);
		
		Timetable timetable = new Timetable();
		timetable.setTimetableId(Long.parseLong(timetableId));
		
		return timetable;
	}

}
