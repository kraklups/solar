package net.kraklups.solarapp.test.experiments;

import static net.kraklups.solarapp.model.util.GlobalNames.SPRING_CONFIG_FILE;
import static net.kraklups.solarapp.test.util.GlobalNames.SPRING_CONFIG_TEST_FILE;

import net.kraklups.modelutil.exceptions.DuplicateInstanceException;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.authorizationservice.AuthorizationService;
import net.kraklups.solarapp.model.role.Role;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AuthorizationServiceExperiments {
	
	public static void main(String[] args) {

		/* Get service object. */
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				new String[] { SPRING_CONFIG_FILE, SPRING_CONFIG_TEST_FILE });
		AuthorizationService authorizationService = ctx.getBean(AuthorizationService.class);


	}

}
