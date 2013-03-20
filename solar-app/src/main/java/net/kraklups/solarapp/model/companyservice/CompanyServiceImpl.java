package net.kraklups.solarapp.model.companyservice;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.kraklups.modelutil.exceptions.DuplicateInstanceException;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.company.Company;
import net.kraklups.solarapp.model.company.CompanyDao;
import net.kraklups.solarapp.model.userprofile.UserProfile;

@Service("companyService")
@Transactional
public class CompanyServiceImpl implements CompanyService{

	@Autowired
	private CompanyDao companyDao;
	
	@Override
	public Company createCompany(String companyName)
			throws DuplicateInstanceException {

		try {
			companyDao.findByName(companyName);
			throw new DuplicateInstanceException(companyName, Company.class.getName());
		} catch (InstanceNotFoundException e) { 			
			Calendar cal = Calendar.getInstance();			
			Company company = new Company(companyName, cal);			
			companyDao.save(company);			
			return company;
		}
	}

	@Override
	public void removeCompany(Long companyId) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional(readOnly = true)
	public Company findCompany(Long companyId) throws InstanceNotFoundException {				
		return companyDao.find(companyId);
	}

	@Override
	@Transactional(readOnly = true)
	public Company findCompanyByName(String companyName) throws InstanceNotFoundException {
		
		return companyDao.findByName(companyName);		
	}
	
	@Override
	public List<UserProfile> getEmployeesByCompanyId(Long companyId,
			int startIndex, int count) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
