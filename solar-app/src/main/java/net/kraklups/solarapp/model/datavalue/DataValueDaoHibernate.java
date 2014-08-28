package net.kraklups.solarapp.model.datavalue;

import net.kraklups.modelutil.dao.GenericDaoHibernate;

import org.springframework.stereotype.Repository;

@Repository("DataValueDao")
public class DataValueDaoHibernate extends 
		GenericDaoHibernate<DataValue, Long> implements DataValueDao {


}
