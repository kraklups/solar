package net.kraklups.solarapp.test.experiments;

import static net.kraklups.solarapp.model.util.GlobalNames.SPRING_CONFIG_FILE;
import static net.kraklups.solarapp.test.util.GlobalNames.SPRING_CONFIG_TEST_FILE;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.kraklups.solarapp.model.company.Company;
import net.kraklups.solarapp.model.userprofile.UserProfile;
import net.kraklups.solarapp.model.userservice.IncorrectPasswordException;
import net.kraklups.solarapp.model.userservice.UserProfileDetails;
import net.kraklups.solarapp.model.userservice.UserService;
import net.kraklups.modelutil.exceptions.DuplicateInstanceException;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;

public class UserServiceExperiments {

	public static void main(String[] args) {
		
		/* Get service object. */
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				new String[] { SPRING_CONFIG_FILE, SPRING_CONFIG_TEST_FILE });
		UserService userService = ctx.getBean(UserService.class);

		try {
			// Register user.
			Calendar cal = Calendar.getInstance();
	    	Long value = new Long("1");	    		
			UserProfile userProfile = userService.registerUser("serviceUser",
					"userPassword", new UserProfileDetails("adminName","adminSurname1",
			    			"adminSurname2","admin@kraklups.net",cal,false,false,null,null)); 
			System.out.println("User with userId '"
					+ userProfile.getUserProfileId() + "' has been created");
			System.out.println(userProfile);

			// Find user.
			userProfile = userService.login("serviceUser", "userPassword",
					false);
			System.out.println("User with userId '"
					+ userProfile.getUserProfileId() + "' has been retrieved");
			System.out.println(userProfile);

			Company company = userService.createCompany("testingcompany");
			System.out.println("company with companyId '"
					+ company.getCompanyId() + "' has been created");
			// Find company.
			company = userService.findCompanyByName("testingcompany");
			System.out.println("company with companyId '"
					+ company.getCompanyId() + "' has been finded");
			System.out.println(company);
			
			// ... proceed in the same way for other entities / methods / use
			// cases
			
			
			// ... proceed in the same way for other entities / methods / use
			// cases

		} catch (IncorrectPasswordException | InstanceNotFoundException
				| DuplicateInstanceException e) {
			e.printStackTrace();
		}

	}

}
