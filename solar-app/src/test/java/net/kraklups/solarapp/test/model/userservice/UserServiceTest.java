package net.kraklups.solarapp.test.model.userservice;

import static net.kraklups.solarapp.model.util.GlobalNames.SPRING_CONFIG_FILE;
import static net.kraklups.solarapp.test.util.GlobalNames.SPRING_CONFIG_TEST_FILE;
import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import net.kraklups.solarapp.model.authorizationservice.AuthorizationService;
import net.kraklups.solarapp.model.companyservice.CompanyService;
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

    @Autowired
    private UserService userService;
    
    @Autowired
    private CompanyService companyService;
    
	@Autowired 
	private AuthorizationService authorizationService;    

    @Test
    public void testRegisterUserAndFindUserProfile()
        throws DuplicateInstanceException, InstanceNotFoundException {

        /* Register user and find profile. */
    	Calendar cal = Calendar.getInstance();
    	Long value = new Long("1");
    	UserProfileDetails userProfileDetails = new UserProfileDetails("adminName","adminSurname1",
    			"adminSurname2","admin@kraklups.net",cal,false,false,
    			companyService.findCompany(value),authorizationService.findRole(value));    	
    	
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
    	Calendar cal = Calendar.getInstance();
    	Long value = new Long("1");
    	UserProfileDetails userProfileDetails = new UserProfileDetails("adminName","adminSurname1",
    			"adminSurname2","admin@kraklups.net",cal,false,false,
    			companyService.findCompany(value),authorizationService.findRole(value));

        userService.registerUser(loginName, clearPassword, userProfileDetails);

        userService.registerUser(loginName, clearPassword, userProfileDetails);

    }    
    
    @Test(expected = InstanceNotFoundException.class)
    public void testFindNonExistentUser() throws InstanceNotFoundException {

        userService.findUserProfile(NON_EXISTENT_USER_PROFILE_ID);

    }    
    
}
