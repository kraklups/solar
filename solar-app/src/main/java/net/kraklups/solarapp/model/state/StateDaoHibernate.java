package net.kraklups.solarapp.model.state;

import net.kraklups.modelutil.dao.GenericDaoHibernate;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.state.State;
import net.kraklups.solarapp.model.state.StateDao;

import org.springframework.stereotype.Repository;

@Repository("stateDao")
public class StateDaoHibernate extends 
	GenericDaoHibernate<State, Long> implements StateDao {

}
