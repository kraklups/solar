package net.kraklups.solarapp.web.formatters;

import java.text.ParseException;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.io.WKTReader;
import com.vividsolutions.jts.io.WKTWriter;

@Component
public class MapElementFormatter implements Formatter<Point>{

	private static final Logger logger = LoggerFactory.getLogger(MapElementFormatter.class);
	
	private static final int SRID = 4326;
	
	@Override
	public String print(Point mapElement, Locale locale) {			
		
		WKTWriter toText = new WKTWriter();
		String wkt = toText.write(mapElement);
		
		logger.info("merde print: " + SRID + "|" + wkt);
		
		return wkt;
	}

	@Override
	public Point parse(String mapElement, Locale locale) throws ParseException {
		
		logger.info("merde parse: " + mapElement);
		
		WKTReader fromText = new WKTReader();
        Geometry geom = null;
        try {
            geom = fromText.read(mapElement);
            geom.setSRID(SRID);
        } catch (com.vividsolutions.jts.io.ParseException e) {
        	e.printStackTrace();
        	throw new ParseException("Merde de WKTReader: " + mapElement, SRID);			
		}
        return (Point) geom;
	}
}
