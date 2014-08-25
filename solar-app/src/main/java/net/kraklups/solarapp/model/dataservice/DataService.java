package net.kraklups.solarapp.model.dataservice;

import java.util.Calendar;
import java.util.List;

import net.kraklups.modelutil.exceptions.DuplicateInstanceException;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.datalogger.DataLogger;
import net.kraklups.solarapp.model.elementprk.ElementPrk;
import net.kraklups.solarapp.model.mngdb.datavaluemngdb.DataValueMngDb;
import net.kraklups.solarapp.model.sensor.Sensor;
import net.kraklups.solarapp.model.taskprk.TaskPrk;

public interface DataService {
	
	public DataValueMngDb createDataValue(String dataType, String dataInput,Calendar tvi, Calendar tvf, 
			TaskPrk taskPrk, ElementPrk elementPrk, DataLogger dataLogger, Sensor sensor)
					throws DuplicateInstanceException;

	
	
}
