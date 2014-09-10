package net.kraklups.solarapp.model.park;

import java.util.List;

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
	
    /**
     * Returns a Park using the loginName (not park identifier)
     *
     * @param loginName not the module identifier
     * @return the Park
     */			
	public List<Park> getParksByLoginName(String loginName, int startIndex, int count) 
			throws InstanceNotFoundException;

    /**
     * Returns a Park using the companyId (not park identifier)
     *
     * @param companyId not the module identifier
     * @return the Park
     */			
	public List<Park> getParksByCompanyId(Long companyId, int startIndex, int count) 
			throws InstanceNotFoundException;
	
}
