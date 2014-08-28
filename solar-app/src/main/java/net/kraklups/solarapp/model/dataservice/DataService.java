package net.kraklups.solarapp.model.dataservice;

import java.util.Calendar;
import java.util.List;

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

	public List<DataValue> getDataValueByTaskPrk(TaskPrk taskPrk, int startIndex, int count) 
			throws InstanceNotFoundException;

	public void assignElementPrkDataValue(DataValue dataValue, ElementPrk elementPrk) 
			throws InstanceNotFoundException;

	public List<DataValue> getDataValueByElementPrk(ElementPrk elementPrk, int startIndex, int count) 
			throws InstanceNotFoundException;

	public void assignDataLoggerDataValue(DataValue dataValue, DataLogger dataLogger) 
			throws InstanceNotFoundException;

	public List<DataValue> getDataValueByDataLogger(DataLogger dataLogger, int startIndex, int count) 
			throws InstanceNotFoundException;

	public void assignSensorDataValue(DataValue dataValue, Sensor sensor) 
			throws InstanceNotFoundException;

	public List<DataValue> getDataValueBySensor(Sensor sensor, int startIndex, int count) 
			throws InstanceNotFoundException;	
	
}
