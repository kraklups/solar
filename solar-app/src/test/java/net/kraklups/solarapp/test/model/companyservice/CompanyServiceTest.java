package net.kraklups.solarapp.test.model.companyservice;

import static net.kraklups.solarapp.model.util.GlobalNames.SPRING_CONFIG_FILE;
import static net.kraklups.solarapp.test.util.GlobalNames.SPRING_CONFIG_TEST_FILE;
import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import net.kraklups.modelutil.exceptions.DuplicateInstanceException;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.company.Company;
import net.kraklups.solarapp.model.companyservice.CompanyService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author nexus7
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { SPRING_CONFIG_FILE, SPRING_CONFIG_TEST_FILE })
@Transactional
public class CompanyServiceTest {
	
	private final long NON_EXISTENT_COMPANY_ID = -1;
	
	@Autowired 
	private CompanyService companyService;
	
	@Test
	public void testRegisterCompanyAndFindCompany() 
		throws DuplicateInstanceException, InstanceNotFoundException {
		
		/* Register company and find company */
		Company company = companyService.createCompany("Kraklups");
		
		Company company2 = companyService.findCompany(company.getCompanyId());
		assertEquals(company, company2);		
	}
	
    @Test(expected = InstanceNotFoundException.class)
    public void testFindNonExistentUser() throws InstanceNotFoundException {
	
    	companyService.findCompany(NON_EXISTENT_COMPANY_ID);
    	
    }
    
    @Test(expected = DuplicateInstanceException.class)
    public void testRegisterDuplicatedCompany() throws DuplicateInstanceException,
        InstanceNotFoundException {
    	
    	String companyName = "Kraklups";
    	
    	companyService.createCompany(companyName);
    	
    	companyService.createCompany(companyName);
    }

    
}
