package net.kraklups.solarapp.model.sensor;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.kraklups.modelutil.dao.GenericDaoHibernate;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;

@Repository("sensorDao")
public class SensorDaoHibernate extends 
	GenericDaoHibernate<Sensor, Long> implements SensorDao {

	@Override
	public List<Sensor> getSensorsBySensorTag(String sensorTag, int startIndex,
			int count) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
