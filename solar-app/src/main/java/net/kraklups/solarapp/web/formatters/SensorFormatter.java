package net.kraklups.solarapp.web.formatters;

import java.text.ParseException;
import java.util.Locale;

import net.kraklups.solarapp.model.sensor.Sensor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class SensorFormatter implements Formatter<Sensor> {

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(SensorFormatter.class);
	
	@Override
	public String print(Sensor sensor, Locale locale) {
		
//		logger.info("merde print: " + sensor);
		
		return sensor.getSensorId().toString();
	}

	@Override
	public Sensor parse(String sensorId, Locale locale) throws ParseException {
		
		//logger.info("merde parse: " + sensorId);
		
		Sensor sensor = new Sensor();
		sensor.setSensorId(Long.parseLong(sensorId));
		
		return sensor;
	}


}
