package net.kraklups.solarapp.web.formatters;

import java.text.ParseException;
import java.util.Locale;

import net.kraklups.solarapp.model.taskprk.Track;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class TrackFormatter implements Formatter<Track> {

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(TrackFormatter.class);
	
	@Override
	public String print(Track track, Locale locale) {
		
//		logger.info("merde print: " + track);
		
		return track.getTrackId().toString();
	}

	@Override
	public Track parse(String trackId, Locale locale) throws ParseException {
		
//		logger.info("merde parse: " + trackId);
		
		Track track = new Track();
		track.setTrackId(Long.parseLong(trackId));
		
		return track;
	}
}
