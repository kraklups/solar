package net.kraklups.solarapp.model.statetype;

import java.util.List;

import net.kraklups.modelutil.dao.GenericDaoHibernate;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;

import net.kraklups.solarapp.model.statetype.StateType;
import net.kraklups.solarapp.model.statetype.StateTypeDao;

import org.springframework.stereotype.Repository;

@Repository("stateTypeDao")
public class StateTypeDaoHibernate extends 
	GenericDaoHibernate<StateType, Long> implements StateTypeDao{

	@Override
	@SuppressWarnings("unchecked")	
	public List<StateType> getStateTypes(int startIndex, int count)
			throws InstanceNotFoundException {

		List<StateType> stateTypes = (List<StateType>)  getSession().createQuery(
	        	"SELECT a FROM StateType a  " +
	        	"ORDER BY a.stateTypeId").
	           	setFirstResult(startIndex).
	           	setMaxResults(count).list();
		
		if (stateTypes == null) {
			throw new InstanceNotFoundException(null, StateType.class.getName());
		} else {
			return stateTypes;
		}
	}
	
}
