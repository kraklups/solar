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
	public List<DataLogger> getDataLoggerByDataLoggerId(Long dataLoggerId,
			int startIndex, int count) throws InstanceNotFoundException {
		
		List<DataLogger> dataLoggers = (List<DataLogger>)  getSession().createQuery(
	        	"SELECT a FROM DataLogger a WHERE a.dataLoggerFk = :dataLoggerId " +
	        	"ORDER BY a.parkId").
	         	setParameter("dataLoggerId", dataLoggerId).
	           	setFirstResult(startIndex).
	           	setMaxResults(count).list();
		
		if (dataLoggers == null) {
			throw new InstanceNotFoundException(dataLoggerId, DataLogger.class.getName());
		} else {
			return dataLoggers;
		}	
	}
}
