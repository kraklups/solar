package net.kraklups.solarapp.model.companyservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.kraklups.modelutil.exceptions.DuplicateInstanceException;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.company.Company;
import net.kraklups.solarapp.model.userprofile.UserProfile;

@Service("companyService")
@Transactional
public class CompanyServiceImpl implements CompanyService{

	@Override
	public Company createCompany(Company company)
			throws DuplicateInstanceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeCompany(Long companyId) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Company findCompany(Long companyId) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserProfile> getEmployeeByCompanyId(Long companyId,
			int startIndex, int count) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
