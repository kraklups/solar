package net.kraklups.solarapp.model.company;

import java.util.List;

import net.kraklups.modelutil.dao.GenericDao;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.userprofile.UserProfile;

public interface CompanyDao extends GenericDao<Company, Long>{	
		
    /**
     * Returns a list of the employees which belong to a company
     *
     * @param companyId and index & count
     * @return List of the Employees
     */	
	public List<UserProfile> getEmployees(Long companyId, int startIndex, int count);
	
    /**
     * Returns a Company using the company name (not company identifier)
     *
     * @param companyName not the company identifier
     * @return the Company
     */	
	public Company findByName(String companyName) throws InstanceNotFoundException; 

}
