package net.kraklups.solarapp.model.park;

import net.kraklups.modelutil.dao.GenericDao;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;

public interface ParkDao extends GenericDao<Park, Long> {
    /**
     * Returns a Park using the park name (not park identifier)
     *
     * @param parkName not the module identifier
     * @return the Park
     */			
	public Park findByParkName(String parkName) throws InstanceNotFoundException;
}
