package net.kraklups.solarapp.web.company;

import net.kraklups.solarapp.model.company.Company;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application about page.
 */
@Controller
public class UpdateCompany {

	private static final Logger logger = LoggerFactory.getLogger(UpdateCompany.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/company/updateCompany", method = RequestMethod.GET)
	public String updateCompanyGet(Model model) {
		logger.info("Update Company page !");
		
		return "company/updateCompany";
	}
	
	@RequestMapping(value = "/company/updateCompany", method = RequestMethod.POST)
	public String updateCompanyPost(@ModelAttribute Company company) {
		
		logger.info("Update Company page POST!" + "company name: " + company.getCompanyName() + " date: " + company.getDate());
		
		return "company/updateCompany";
	}	

}
