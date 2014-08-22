package net.kraklups.solarapp.model.dataservice;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.kraklups.modelutil.exceptions.DuplicateInstanceException;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.datalogger.DataLogger;
import net.kraklups.solarapp.model.datavalue.DataValue;
import net.kraklups.solarapp.model.elementprk.ElementPrk;
import net.kraklups.solarapp.model.sensor.Sensor;
import net.kraklups.solarapp.model.taskprk.TaskPrk;

@Service("dataService")
@Transactional
public class DataServiceImpl implements DataService {

    @Autowired
    private TaskPrk taskPrk;

    @Autowired
    private ElementPrk elementPrk;
    
    @Autowired
    private DataLogger dataLogger;
    
    @Autowired
    private Sensor sensor;
	
	@Override
	public DataValue createDataValue(String dataType, String dataInput,
			Calendar tvi, Calendar tvf, TaskPrk taskPrk, ElementPrk elementPrk,
			DataLogger dataLogger, Sensor sensor)
			throws DuplicateInstanceException {

		DataValue dataValue = new DataValue(dataType, dataInput, tvi, tvf, 
				taskPrk, elementPrk, dataLogger, sensor);
		
		return dataValue;
	}

}
