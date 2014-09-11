package net.kraklups.solarapp.model.state;

import java.util.List;

import net.kraklups.modelutil.dao.GenericDaoHibernate;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.state.State;
import net.kraklups.solarapp.model.state.StateDao;

import org.springframework.stereotype.Repository;

@Repository("stateDao")
public class StateDaoHibernate extends 
	GenericDaoHibernate<State, Long> implements StateDao {

	@Override
	@SuppressWarnings("unchecked")
	public List<State> getStatesByUpkeepId(Long upkeepId, int startIndex,
			int count) throws InstanceNotFoundException {
		
		List<State> states = (List<State>)  getSession().createQuery(
	        	"SELECT a FROM State a WHERE a.upkeepId = :upkeepId " +
	        	"ORDER BY a.stateId").
	         	setParameter("upkeepId", upkeepId).
	           	setFirstResult(startIndex).
	           	setMaxResults(count).list();
		
		if (states == null) {
			throw new InstanceNotFoundException(upkeepId, State.class.getName());
		} else {
			return states;
		}			
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<State> getStatesByEventTskId(Long eventTskId, int startIndex,
			int count) throws InstanceNotFoundException {
		
		List<State> states = (List<State>)  getSession().createQuery(
	        	"SELECT a FROM State a WHERE a.eventTskId = :eventTskId " +
	        	"ORDER BY a.stateId").
	         	setParameter("eventTskId", eventTskId).
	           	setFirstResult(startIndex).
	           	setMaxResults(count).list();
		
		if (states == null) {
			throw new InstanceNotFoundException(eventTskId, State.class.getName());
		} else {
			return states;
		}					
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<State> getStatesByStateTypeId(Long stateTypeId, int startIndex,
			int count) throws InstanceNotFoundException {
		
		List<State> states = (List<State>)  getSession().createQuery(
	        	"SELECT a FROM State a WHERE a.stateTypeId = :stateTypeId " +
	        	"ORDER BY a.stateId").
	         	setParameter("stateTypeId", stateTypeId).
	           	setFirstResult(startIndex).
	           	setMaxResults(count).list();
		
		if (states == null) {
			throw new InstanceNotFoundException(stateTypeId, State.class.getName());
		} else {
			return states;
		}				
	}

	
	
}
