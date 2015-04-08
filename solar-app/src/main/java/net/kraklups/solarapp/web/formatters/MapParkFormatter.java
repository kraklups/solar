package net.kraklups.solarapp.web.formatters;

import java.text.ParseException;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.io.WKTReader;
import com.vividsolutions.jts.io.WKTWriter;

@Component
public class MapParkFormatter implements Formatter<MultiPolygon> {

	private static final Logger logger = LoggerFactory.getLogger(MapParkFormatter.class);
	
	private static final int SRID = 4326;
	
	@Override
	public String print(MultiPolygon mapPark, Locale locale) {			
		
		WKTWriter toText = new WKTWriter();
		String wkt = toText.write(mapPark);
		
		logger.info("merde print: " + SRID + "|" + wkt);
		
		return wkt;
	}

	@Override
	public MultiPolygon parse(String mapPark, Locale locale) throws ParseException {
		
		logger.info("merde parse: " + mapPark);
		
		WKTReader fromText = new WKTReader();
        Geometry geom = null;
        try {
            geom = fromText.read(mapPark);
            geom.setSRID(SRID);
        } catch (com.vividsolutions.jts.io.ParseException e) {
        	e.printStackTrace();
        	throw new ParseException("Merde de WKTReader: " + mapPark, SRID);			
		}
        return (MultiPolygon) geom;
	}

}
