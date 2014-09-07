package net.kraklups.solarapp.model.datavalue;

import java.util.List;

import net.kraklups.modelutil.dao.GenericDaoHibernate;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;

import org.springframework.stereotype.Repository;

@Repository("DataValueDao")
public class DataValueDaoHibernate extends 
		GenericDaoHibernate<DataValue, Long> implements DataValueDao {

	@Override
	@SuppressWarnings("unchecked")
	public List<DataValue> getDataValuesByTaskPrkId(Long taskPrkId,
			int startIndex, int count) throws InstanceNotFoundException {
		
		List<DataValue> dataValues = (List<DataValue>)  getSession().createQuery(
	        	"SELECT a FROM DataValue a WHERE a.taskPrkId = :taskPrkId " +
	        	"ORDER BY a.dataValueId").
	         	setParameter("taskPrkId", taskPrkId).
	           	setFirstResult(startIndex).
	           	setMaxResults(count).list();
		
		if (dataValues == null) {
			throw new InstanceNotFoundException(taskPrkId, DataValue.class.getName());
		} else {
			return dataValues;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<DataValue> getDataValuesByElementPrkId(Long elementPrkId,
			int startIndex, int count) throws InstanceNotFoundException {
		
		List<DataValue> dataValues = (List<DataValue>)  getSession().createQuery(
	        	"SELECT a FROM DataValue a WHERE a.elementPrkId = :elementPrkId " +
	        	"ORDER BY a.dataValueId").
	         	setParameter("elementPrkId", elementPrkId).
	           	setFirstResult(startIndex).
	           	setMaxResults(count).list();
		
		if (dataValues == null) {
			throw new InstanceNotFoundException(elementPrkId, DataValue.class.getName());
		} else {
			return dataValues;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<DataValue> getDataValuesByDataLoggerId(Long dataLoggerId,
			int startIndex, int count) throws InstanceNotFoundException {
		
		List<DataValue> dataValues = (List<DataValue>)  getSession().createQuery(
	        	"SELECT a FROM DataValue a WHERE a.dataLoggerId = :dataLoggerId " +
	        	"ORDER BY a.dataValueId").
	         	setParameter("dataLoggerId", dataLoggerId).
	           	setFirstResult(startIndex).
	           	setMaxResults(count).list();
		
		if (dataValues == null) {
			throw new InstanceNotFoundException(dataLoggerId, DataValue.class.getName());
		} else {
			return dataValues;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<DataValue> getDataValuesBySensorId(Long sensorId,
			int startIndex, int count) throws InstanceNotFoundException {
		
		List<DataValue> dataValues = (List<DataValue>)  getSession().createQuery(
	        	"SELECT a FROM DataValue a WHERE a.sensorId = :sensorId " +
	        	"ORDER BY a.dataValueId").
	         	setParameter("sensorId", sensorId).
	           	setFirstResult(startIndex).
	           	setMaxResults(count).list();
		
		if (dataValues == null) {
			throw new InstanceNotFoundException(sensorId, DataValue.class.getName());
		} else {
			return dataValues;
		}
	}


}
