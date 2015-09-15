package net.kraklups.solarapp.model.statetype;

import java.util.List;

import net.kraklups.modelutil.dao.GenericDao;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;

public interface StateTypeDao extends GenericDao<StateType, Long> {
    
	public List<StateType> getStateTypes(int startIndex, int count)
			throws InstanceNotFoundException;
	
}
