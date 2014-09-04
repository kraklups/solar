package net.kraklups.solarapp.model.sensor;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.kraklups.modelutil.dao.GenericDaoHibernate;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;

@Repository("sensorDao")
public class SensorDaoHibernate extends 
	GenericDaoHibernate<Sensor, Long> implements SensorDao {

	@Override
	@SuppressWarnings("unchecked")	
	public List<Sensor> getSensorsByElementPrkId(Long elementPrkId, int startIndex,
			int count) throws InstanceNotFoundException {		

		List<Sensor> sensors = getSession().createQuery(
            	"SELECT a FROM Sensor a WHERE a.elementPrkId = :elementPrkId " +
            	"ORDER BY a.sensorId").
             	setParameter("elementPrkId", elementPrkId).
               	setFirstResult(startIndex).
               	setMaxResults(count).list(); 
		

		if (sensors == null) {
			throw new InstanceNotFoundException(elementPrkId, Sensor.class.getName());
		} else {
			return sensors;
		}		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Sensor> getSensorsBySensorTag(String sensorTag, int startIndex,
			int count) throws InstanceNotFoundException {
		
		List<Sensor> sensors = getSession().createQuery(
            	"SELECT a FROM Sensor a WHERE a.sensorTag = :sensorTag " +
            	"ORDER BY a.sensorId").
             	setParameter("sensorTag", sensorTag).
               	setFirstResult(startIndex).
               	setMaxResults(count).list(); 
		

		if (sensors == null) {
			throw new InstanceNotFoundException(sensorTag, Sensor.class.getName());
		} else {
			return sensors;
		}			
	}

}
