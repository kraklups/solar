package net.kraklups.solarapp.model.companyservice;

import java.util.List;

import net.kraklups.solarapp.model.company.Company;
import net.kraklups.solarapp.model.userprofile.UserProfile;
import net.kraklups.modelutil.exceptions.DuplicateInstanceException;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;

public interface CompanyService {

	public Company createCompany(Company company) throws DuplicateInstanceException;
	
	public void removeCompany(Long companyId) throws InstanceNotFoundException;
	
	public Company findCompany(Long companyId) throws InstanceNotFoundException;
	
	public List<UserProfile> getEmployeesByCompanyId(Long companyId, int startIndex, int count) throws InstanceNotFoundException; 
}
