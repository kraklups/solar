package net.kraklups.solarapp.model.company;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.kraklups.modelutil.dao.GenericDaoHibernate;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.userprofile.UserProfile;

@Repository("companyDao")
public class CompanyDaoHibernate extends
		GenericDaoHibernate<Company, Long> implements CompanyDao {
	
	@SuppressWarnings("unchecked")	
	public List<UserProfile> getEmployees(Long companyId, int startIndex, int count) {
		
		return getSession().createQuery(
	        	"SELECT a FROM UserProfile a WHERE a.companyId = :companyId " +
	        	"ORDER BY a.UserProfileId").
	         	setParameter("companyId", companyId).
	           	setFirstResult(startIndex).
	           	setMaxResults(count).list();
	}

	@Override
	public Company findByName(String companyName) throws InstanceNotFoundException {

		Company company = (Company) getSession().createQuery(
				"SELECT u FROM Company u WHERE u.companyName = :companyName")
    			.setParameter("companyName", companyName)
    			.uniqueResult();
		
		if (company == null) {
			throw new InstanceNotFoundException(companyName,Company.class.getName());
		} else {
			return company;
		}
	}

}
