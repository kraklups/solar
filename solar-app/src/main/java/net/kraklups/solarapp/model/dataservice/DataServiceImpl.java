package net.kraklups.solarapp.model.dataservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.kraklups.modelutil.exceptions.DuplicateInstanceException;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.datalogger.DataLogger;
import net.kraklups.solarapp.model.datavalue.DataValue;
import net.kraklups.solarapp.model.datavalue.DataValueBlock;
import net.kraklups.solarapp.model.datavalue.DataValueDao;
import net.kraklups.solarapp.model.elementprk.ElementPrk;
import net.kraklups.solarapp.model.sensor.Sensor;
import net.kraklups.solarapp.model.taskprk.TaskPrk;

@Service("dataService")
@Transactional
public class DataServiceImpl implements DataService {

	@Autowired
	private DataValueDao dataValueDao;
	
	@Override
	public DataValue createDataValue(TaskPrk taskPrk, ElementPrk elementPrk,
			DataLogger dataLogger, Sensor sensor)
			throws DuplicateInstanceException {
		
		DataValue dataValue = new DataValue(taskPrk, elementPrk, dataLogger, sensor); 
		dataValueDao.save(dataValue);
		
		return dataValue;
	}

	@Override
	public DataValue updateDataValue(Long dataValueId, TaskPrk taskPrk,
			ElementPrk elementPrk, DataLogger dataLogger, Sensor sensor)
			throws InstanceNotFoundException {
		
		DataValue dataValue = (DataValue) dataValueDao.find(dataValueId);
		
		dataValue.setTaskPrk(taskPrk);
		dataValue.setElementPrk(elementPrk);
		dataValue.setDataLogger(dataLogger);
		dataValue.setSensor(sensor);
		
		return dataValue;
	}

	@Override
	public void assignTaskPrkDataValue(DataValue dataValue, TaskPrk taskPrk)
			throws InstanceNotFoundException {
		
		dataValue.setTaskPrk(taskPrk);
	}

	@Override
	public DataValueBlock getDataValueByTaskPrkId(Long taskPrkId,
			int startIndex, int count) throws InstanceNotFoundException {

		List<DataValue> dataValues = dataValueDao.getDataValuesByTaskPrkId(taskPrkId, startIndex, count +1);
		
		boolean existMoreDataValues = dataValues.size() == (count +1);
		
		return new DataValueBlock(dataValues, existMoreDataValues);
	}

	@Override
	public void assignElementPrkDataValue(DataValue dataValue,
			ElementPrk elementPrk) throws InstanceNotFoundException {

		dataValue.setElementPrk(elementPrk);
	}

	@Override
	public DataValueBlock getDataValueByElementPrkId(Long elementPrkId,
			int startIndex, int count) throws InstanceNotFoundException {

		List<DataValue> dataValues = dataValueDao.getDataValuesByElementPrkId(elementPrkId, startIndex, count +1);
		
		boolean existMoreDataValues = dataValues.size() == (count +1);
		
		return new DataValueBlock(dataValues, existMoreDataValues);
	}

	@Override
	public void assignDataLoggerDataValue(DataValue dataValue,
			DataLogger dataLogger) throws InstanceNotFoundException {
		
		dataValue.setDataLogger(dataLogger);
	}

	@Override
	public DataValueBlock getDataValueByDataLoggerId(Long dataLoggerId,
			int startIndex, int count) throws InstanceNotFoundException {
		
		List<DataValue> dataValues = dataValueDao.getDataValuesByDataLoggerId(dataLoggerId, startIndex, count +1);
		
		boolean existMoreDataValues = dataValues.size() == (count +1);
		
		return new DataValueBlock(dataValues, existMoreDataValues);		
	}

	@Override
	public void assignSensorDataValue(DataValue dataValue, Sensor sensor)
			throws InstanceNotFoundException {
		
		dataValue.setSensor(sensor);
	}

	@Override
	public DataValueBlock getDataValueBySensorId(Long sensorid, int startIndex,
			int count) throws InstanceNotFoundException {
		
		List<DataValue> dataValues = dataValueDao.getDataValuesBySensorId(sensorid, startIndex, count +1);
		
		boolean existMoreDataValues = dataValues.size() == (count +1);
		
		return new DataValueBlock(dataValues, existMoreDataValues);
	}

}
