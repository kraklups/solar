package net.kraklups.solarapp.test.model.elementservice;

import static net.kraklups.solarapp.model.util.GlobalNames.SPRING_CONFIG_FILE;
import static net.kraklups.solarapp.test.util.GlobalNames.SPRING_CONFIG_TEST_FILE;
import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;

import net.kraklups.modelutil.exceptions.DuplicateInstanceException;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.datalogger.DataLogger;
import net.kraklups.solarapp.model.dataservice.DataService;
import net.kraklups.solarapp.model.elementprk.ElementPrk;
import net.kraklups.solarapp.model.elementservice.ElementService;
import net.kraklups.solarapp.model.park.Park;
import net.kraklups.solarapp.model.parkservice.ParkService;
import net.kraklups.solarapp.model.sensor.Sensor;
import net.kraklups.solarapp.model.userprofile.UserProfile;
import net.kraklups.solarapp.model.userservice.UserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { SPRING_CONFIG_FILE, SPRING_CONFIG_TEST_FILE })
@Transactional
public class ElementServiceTest {
    
    @Autowired
    private UserService userService;    
    
    @Autowired
    private DataService dataService;
    
    @Autowired
    private ParkService parkService;    

    @Autowired
    private ElementService elementService;
        
	@Test
	public void testCreateElementPrkAndFindElementPrk() 
		throws DuplicateInstanceException, InstanceNotFoundException, ParseException {
		
		/* Register element and find element */
		
		final int SRID = 4326;
		
		Long weight = new Long("1");
		
		Calendar calendar = Calendar.getInstance();
		Date timestamp = new Date(calendar.getTime().getTime());
		
		UserProfile userProfile = userService.findUserProfile(weight);
		DataLogger dataLogger = dataService.findDataLogger(weight);
		Park park = parkService.findPark(weight);
		
		String mapElement = "POINT (-71.060316 48.432044)";
		String cadena = "estraperlacio";
		
		WKTReader fromText = new WKTReader();
        Geometry geom = null;
        try {
            geom = fromText.read(mapElement);
            geom.setSRID(SRID);
        } catch (com.vividsolutions.jts.io.ParseException e) {
        	e.printStackTrace();
        	throw new ParseException("Merde de WKTReader: " + mapElement);			
		}		
        
		ElementPrk elementPrk = elementService.createElementPrk(cadena, cadena, timestamp, timestamp, userProfile, dataLogger, park, (Point) geom);       
		
		ElementPrk elementPrk2 = elementService.findElementPrk(elementPrk.getElementPrkId());
		
		assertEquals(elementPrk, elementPrk2);		
	}
	
	@Test
	public void testCreateSensorAndFindSensor() 
		throws DuplicateInstanceException, InstanceNotFoundException, ParseException {
		
		/* Register element and find element */
		//String sensorTag, String sensorType, ElementPrk elementPrk
		
		Long weight = new Long("1");
		String cadena = "estraperlacio";
		
		ElementPrk elementPrk = elementService.findElementPrk(weight);
		        
		Sensor sensor = elementService.createSensor(cadena, cadena, elementPrk);       
		
		Sensor sensor2 = elementService.findSensor(sensor.getSensorId());
		
		assertEquals(sensor, sensor2);		
	}    
	
	
}
