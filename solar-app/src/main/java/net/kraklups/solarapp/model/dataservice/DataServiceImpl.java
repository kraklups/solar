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

	@Override
	public DataValue createDataValue(TaskPrk taskPrk, ElementPrk elementPrk,
			DataLogger dataLogger, Sensor sensor)
			throws DuplicateInstanceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataValue updateDataValue(Long dataValueId, TaskPrk taskPrk,
			ElementPrk elementPrk, DataLogger dataLogger, Sensor sensor)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void assignTaskPrkDataValue(DataValue dataValue, TaskPrk taskPrk)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<DataValue> getDataValueByTaskPrk(TaskPrk taskPrk,
			int startIndex, int count) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void assignElementPrkDataValue(DataValue dataValue,
			ElementPrk elementPrk) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<DataValue> getDataValueByElementPrk(ElementPrk elementPrk,
			int startIndex, int count) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void assignDataLoggerDataValue(DataValue dataValue,
			DataLogger dataLogger) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<DataValue> getDataValueByDataLogger(DataLogger dataLogger,
			int startIndex, int count) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void assignSensorDataValue(DataValue dataValue, Sensor sensor)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<DataValue> getDataValueBySensor(Sensor sensor, int startIndex,
			int count) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}



	


}
