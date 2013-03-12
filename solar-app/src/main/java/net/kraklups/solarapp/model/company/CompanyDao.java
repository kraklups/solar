package net.kraklups.solarapp.model.company;

import java.util.List;

import net.kraklups.modelutil.dao.GenericDao;
import net.kraklups.solarapp.model.userprofile.UserProfile;

public interface CompanyDao extends GenericDao<Company, Long>{	
	
	public List<UserProfile> getEmployees(Long companyId, int startIndex, int count);

}
