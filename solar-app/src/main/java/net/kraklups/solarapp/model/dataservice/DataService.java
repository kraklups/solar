package net.kraklups.solarapp.model.dataservice;

import net.kraklups.modelutil.exceptions.DuplicateInstanceException;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.datalogger.DataLogger;
import net.kraklups.solarapp.model.datavalue.DataValue;
import net.kraklups.solarapp.model.elementprk.ElementPrk;
import net.kraklups.solarapp.model.sensor.Sensor;
import net.kraklups.solarapp.model.taskprk.TaskPrk;

public interface DataService {
	
	public DataValue createDataValue(TaskPrk taskPrk, ElementPrk elementPrk, DataLogger dataLogger, Sensor sensor) 
			throws DuplicateInstanceException;

	public DataValue updateDataValue(Long dataValueId, TaskPrk taskPrk, ElementPrk elementPrk, DataLogger dataLogger, Sensor sensor) 
			throws InstanceNotFoundException;

	public void assignTaskPrkDataValue(DataValue dataValue, TaskPrk taskPrk) 
			throws InstanceNotFoundException;

	public DataValueBlock getDataValueByTaskPrkId(Long taskPrkId, int startIndex, int count) 
			throws InstanceNotFoundException;

	public void assignElementPrkDataValue(DataValue dataValue, ElementPrk elementPrk) 
			throws InstanceNotFoundException;

	public DataValueBlock getDataValueByElementPrkId(Long elementPrkId, int startIndex, int count) 
			throws InstanceNotFoundException;

	public void assignDataLoggerDataValue(DataValue dataValue, DataLogger dataLogger) 
			throws InstanceNotFoundException;

	public DataValueBlock getDataValueByDataLoggerId(Long dataLoggerId, int startIndex, int count) 
			throws InstanceNotFoundException;

	public void assignSensorDataValue(DataValue dataValue, Sensor sensor) 
			throws InstanceNotFoundException;

	public DataValueBlock getDataValueBySensorId(Long sensorId, int startIndex, int count) 
			throws InstanceNotFoundException;	
	
	public DataLogger createDataLogger(String dataLoggerTag, String dataLoggerType, DataLogger dataLogger) 
			throws DuplicateInstanceException;

	public DataLogger updateDataLogger(Long dataLoggerId, String dataLoggerTag, String dataLoggerType, DataLogger dataLogger) 
			throws InstanceNotFoundException;	
	
	public DataLoggerBlock getDataLoggerByDataLoggerId(Long dataLoggerId, int startIndex, int count) 
			throws InstanceNotFoundException;
		
	public DataLoggerBlock getDataLoggers(int startIndex, int count) 
			throws InstanceNotFoundException;
	
    public DataLogger saveDataLogger(DataLogger dataLogger)
    		throws DuplicateInstanceException;	
	
}
