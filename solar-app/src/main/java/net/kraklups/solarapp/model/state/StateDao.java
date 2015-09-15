package net.kraklups.solarapp.model.state;

import java.util.List;

import net.kraklups.modelutil.dao.GenericDao;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;

public interface StateDao extends GenericDao<State, Long> {

	public List<State> getStatesByUpkeepId(Long upkeepId, int startIndex, int count)
			throws InstanceNotFoundException;	
	
	public List<State> getStatesByEventTskId(Long eventTskId, int startIndex, int count)
			throws InstanceNotFoundException;	
	
	public List<State> getStatesByStateTypeId(Long stateTypeId, int startIndex, int count)
			throws InstanceNotFoundException;
	
    public List<State> getStates(int startIndex, int count)
			throws InstanceNotFoundException;	
	
}
