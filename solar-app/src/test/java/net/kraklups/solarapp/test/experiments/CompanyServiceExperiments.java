package net.kraklups.solarapp.test.experiments;

import static net.kraklups.solarapp.model.util.GlobalNames.SPRING_CONFIG_FILE;
import static net.kraklups.solarapp.test.util.GlobalNames.SPRING_CONFIG_TEST_FILE;

import net.kraklups.modelutil.exceptions.DuplicateInstanceException;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.company.Company;
import net.kraklups.solarapp.model.companyservice.CompanyService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CompanyServiceExperiments {
	
	public static void main(String[] args) {

		/* Get service object. */
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				new String[] { SPRING_CONFIG_FILE, SPRING_CONFIG_TEST_FILE });
		CompanyService companyService = ctx.getBean(CompanyService.class);

		try {
			// Register company.
			Company company = companyService.createCompany("testingcompany");
			System.out.println("company with companyId '"
					+ company.getCompanyId() + "' has been created");
			// Find company.
			company = companyService.findCompanyByName("testingcompany");
			System.out.println("company with companyId '"
					+ company.getCompanyId() + "' has been finded");
			System.out.println(company);
			
			// ... proceed in the same way for other entities / methods / use
			// cases
					
		} catch (InstanceNotFoundException
				| DuplicateInstanceException e) {
			e.printStackTrace();
		}
	}
}
