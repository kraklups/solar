package net.kraklups.solarapp.test.model.dataservice;

import static net.kraklups.solarapp.model.util.GlobalNames.SPRING_CONFIG_FILE;
import static net.kraklups.solarapp.test.util.GlobalNames.SPRING_CONFIG_TEST_FILE;
import static org.junit.Assert.assertEquals;

import net.kraklups.modelutil.exceptions.DuplicateInstanceException;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.datalogger.DataLogger;
import net.kraklups.solarapp.model.dataservice.DataService;
import net.kraklups.solarapp.model.datavalue.DataValue;
import net.kraklups.solarapp.model.elementprk.ElementPrk;
import net.kraklups.solarapp.model.elementservice.ElementService;
import net.kraklups.solarapp.model.sensor.Sensor;
import net.kraklups.solarapp.model.taskprk.Synchronize;
import net.kraklups.solarapp.model.taskprkservice.TaskPrkService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { SPRING_CONFIG_FILE, SPRING_CONFIG_TEST_FILE })
@Transactional
public class DataServiceTest {

    @Autowired
    private DataService dataService;
    
    @Autowired
    private ElementService elementService;
    
    @Autowired
    private TaskPrkService taskPrkService;    
    
	@Test
	public void testRegisterDataValueAndFindDataValue() 
		throws DuplicateInstanceException, InstanceNotFoundException {
		
		//Synchronize synchronize, ElementPrk elementPrk, 
		//DataLogger dataLogger, Sensor sensor
		
		Long weight = new Long("1");
		Long weight1 = new Long("1");
		
		DataLogger dataLogger = dataService.findDataLogger(weight);
		Synchronize synchronize = (Synchronize) taskPrkService.findTaskPrk(weight1);
		Sensor sensor = elementService.findSensor(weight);
		ElementPrk elementPrk = elementService.findElementPrk(weight);
		
		DataValue dataValue = dataService.createDataValue(synchronize, elementPrk, dataLogger, sensor);
		
		DataValue dataValue2 = dataService.findDataValue(dataValue.getDataValueId());
		
		assertEquals(dataValue, dataValue2);
	}

	@Test
	public void testRegisterDataLoggerAndFindDataLogger() 
		throws DuplicateInstanceException, InstanceNotFoundException {
		
		//String dataLoggerTag, String dataLoggerType, DataLogger dataLoggerManager
		
		Long weight = new Long("1");
		
		DataLogger dataLogger1 = dataService.findDataLogger(weight);
		
		DataLogger dataLogger = dataService.createDataLogger("percebecojo", "percebefeliz", dataLogger1);
		
		DataLogger dataLogger2 = dataService.findDataLogger(dataLogger.getDataLoggerId());
		
		assertEquals(dataLogger, dataLogger2);
	}	
	
}
