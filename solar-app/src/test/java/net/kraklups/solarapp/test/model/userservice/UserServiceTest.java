package net.kraklups.solarapp.test.model.userservice;

import static net.kraklups.solarapp.model.util.GlobalNames.SPRING_CONFIG_FILE;
import static net.kraklups.solarapp.test.util.GlobalNames.SPRING_CONFIG_TEST_FILE;
import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.Calendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import net.kraklups.solarapp.model.company.Company;
import net.kraklups.solarapp.model.module.Module;
import net.kraklups.solarapp.model.role.Role;
import net.kraklups.solarapp.model.userprofile.UserProfile;
import net.kraklups.solarapp.model.userservice.IncorrectPasswordException;
import net.kraklups.solarapp.model.userservice.UserProfileDetails;
import net.kraklups.solarapp.model.userservice.UserService;
import net.kraklups.modelutil.exceptions.DuplicateInstanceException;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;

/**
 * @author nexus7
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { SPRING_CONFIG_FILE, SPRING_CONFIG_TEST_FILE })
@Transactional
public class UserServiceTest {
	
	private final long NON_EXISTENT_USER_PROFILE_ID = -1;
	private final long NON_EXISTENT_ROLE_ID = -1;
	private final long NON_EXISTENT_MODULE_ID = -2;
	private final long NON_EXISTENT_COMPANY_ID = -1;	
	

    @Autowired
    private UserService userService;
    
    @Test
    public void testRegisterUserAndFindUserProfile()
        throws DuplicateInstanceException, InstanceNotFoundException {

        /* Register user and find profile. */
		Calendar calendar = Calendar.getInstance();
		Date timestamp = new Date(calendar.getTime().getTime());
    	Long value = new Long("1");
    	UserProfileDetails userProfileDetails = new UserProfileDetails("adminName","adminSurname1",
    			"adminSurname2","admin@kraklups.net",timestamp,false,false,
    			userService.findCompany(value),userService.findRole(value));    	
    	
        UserProfile userProfile = userService.registerUser(
            "user", "userPassword", userProfileDetails);

        UserProfile userProfile2 = userService.findUserProfile(
            userProfile.getUserProfileId());

        /* Check data. */
        assertEquals(userProfile, userProfile2);

    }	

    @Test(expected = DuplicateInstanceException.class)
    public void testRegisterDuplicatedUser() throws DuplicateInstanceException,
        InstanceNotFoundException {

        String loginName = "user";
        String clearPassword = "userPassword";
		Calendar calendar = Calendar.getInstance();
		Date timestamp = new Date(calendar.getTime().getTime());
    	Long value = new Long("1");
    	UserProfileDetails userProfileDetails = new UserProfileDetails("adminName","adminSurname1",
    			"adminSurname2","admin@kraklups.net",timestamp,false,false,
    			userService.findCompany(value),userService.findRole(value));

        userService.registerUser(loginName, clearPassword, userProfileDetails);

        userService.registerUser(loginName, clearPassword, userProfileDetails);

    }    
    
    @Test(expected = InstanceNotFoundException.class)
    public void testFindNonExistentUser() throws InstanceNotFoundException {

        userService.findUserProfile(NON_EXISTENT_USER_PROFILE_ID);

    }    

	@Test
	public void testRegisterRoleAndFindRole() 
		throws DuplicateInstanceException, InstanceNotFoundException {
		
		/* Register role and find role */
		
		Long weight = new Long("1");
		
		UserProfile userProfile = userService.findUserProfile(weight);	
		
		Role role = userService.registerRole("invitado", userProfile, weight);
		
		Role role2 = userService.findRole(role.getRoleId());
		
		assertEquals(role, role2);		
	}
	
    @Test(expected = DuplicateInstanceException.class)
    public void testRegisterDuplicatedRole() throws DuplicateInstanceException,
        InstanceNotFoundException {
    	
    	Long weight = new Long("1"); 
    	
    	UserProfile userProfile = userService.findUserProfile(weight);
    	
    	userService.registerRole("invitado", userProfile, weight);
    	
    	userService.registerRole("invitado", userProfile, weight);
    }
    
	@Test
	public void testRegisterModuleAndFindModule() 
		throws DuplicateInstanceException, InstanceNotFoundException {
		
		/* Register role and find role */
		
		Module module = userService.registerModule("invitado");
		
		Module module2 = userService.findModule(module.getModuleId());
		
		assertEquals(module, module2);		
	}
	
    @Test(expected = DuplicateInstanceException.class)
    public void testRegisterDuplicatedModule() throws DuplicateInstanceException,
        InstanceNotFoundException {
    	  	
    	userService.registerModule("invitado");
    	
    	userService.registerModule("invitado");
    }    

	@Test
	public void testRegisterCompanyAndFindCompany() 
		throws DuplicateInstanceException, InstanceNotFoundException {
		
		/* Register company and find company */
		Calendar calendar = Calendar.getInstance();
		Date timestamp = new Date(calendar.getTime().getTime());
		Company company = userService.createCompany("Kraklups", timestamp);
		
		Company company2 = userService.findCompany(company.getCompanyId());
		assertEquals(company, company2);		
	}
	
    @Test(expected = InstanceNotFoundException.class)
    public void testFindNonExistentCompany() throws InstanceNotFoundException {
	
    	userService.findCompany(NON_EXISTENT_COMPANY_ID);
    	
    }
    
    @Test(expected = DuplicateInstanceException.class)
    public void testRegisterDuplicatedCompany() throws DuplicateInstanceException,
        InstanceNotFoundException {
    	
    	String companyName = "Kraklups";
		Calendar calendar = Calendar.getInstance();
		Date timestamp = new Date(calendar.getTime().getTime());
    	
    	userService.createCompany(companyName, timestamp);
    	
    	userService.createCompany(companyName, timestamp);
    }    
    
}
