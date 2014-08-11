package net.kraklups.solarapp.model.datalogger;

import java.util.List;

import net.kraklups.modelutil.dao.GenericDaoHibernate;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;

import org.springframework.stereotype.Repository;

@Repository("dataLoggerDao")
public class DataLoggerDaoHibernate extends 
	GenericDaoHibernate<DataLogger, Long> implements DataLoggerDao {

	@Override
	public List<DataLogger> getDataLoggerByDataLoggerTag(String dataLoggerTag,
			int startIndex, int count) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
