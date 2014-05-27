package net.kraklups.solarapp.model.statetype;

import net.kraklups.modelutil.dao.GenericDaoHibernate;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.statetype.StateType;
import net.kraklups.solarapp.model.statetype.StateTypeDao;

import org.springframework.stereotype.Repository;

@Repository("stateTypeDao")
public class StateTypeDaoHibernate extends 
	GenericDaoHibernate<StateType, Long> implements StateTypeDao{

	
	
}
