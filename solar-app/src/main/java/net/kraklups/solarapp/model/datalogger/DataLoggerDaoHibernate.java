package net.kraklups.solarapp.model.datalogger;

import java.util.List;

import net.kraklups.modelutil.dao.GenericDaoHibernate;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;

import org.springframework.stereotype.Repository;

@Repository("dataLoggerDao")
public class DataLoggerDaoHibernate extends 
	GenericDaoHibernate<DataLogger, Long> implements DataLoggerDao {

	@Override
	@SuppressWarnings("unchecked")
	public List<DataLogger> getDataLoggersByDataLoggerId(Long dataLoggerId,
			int startIndex, int count) throws InstanceNotFoundException {
		
		List<DataLogger> dataLoggers = (List<DataLogger>)  getSession().createQuery(
	        	"SELECT a FROM DataLogger a WHERE a.dataLoggerFk = :dataLoggerId " +
	        	"ORDER BY a.dataLoggerId").
	         	setParameter("dataLoggerId", dataLoggerId).
	           	setFirstResult(startIndex).
	           	setMaxResults(count).list();
		
		if (dataLoggers == null) {
			throw new InstanceNotFoundException(dataLoggerId, DataLogger.class.getName());
		} else {
			return dataLoggers;
		}	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DataLogger> getDataLoggers(int startIndex, int count)
			throws InstanceNotFoundException {

		List<DataLogger> dataLoggers = (List<DataLogger>)  getSession().createQuery(
	        	"SELECT a FROM DataLogger a " +
	        	"ORDER BY a.dataLoggerId").
	           	setFirstResult(startIndex).
	           	setMaxResults(count).list();
		
		if (dataLoggers == null) {
			throw new InstanceNotFoundException(null, DataLogger.class.getName());
		} else {
			return dataLoggers;
		}		
	}

}
