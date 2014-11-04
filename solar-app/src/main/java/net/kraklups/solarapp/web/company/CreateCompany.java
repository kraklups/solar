package net.kraklups.solarapp.web.company;

import net.kraklups.modelutil.exceptions.DuplicateInstanceException;
import net.kraklups.solarapp.model.company.Company;
import net.kraklups.solarapp.model.userservice.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application about page.
 */
@Controller
public class CreateCompany {

	@Autowired
	private UserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(CreateCompany.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/company/createCompany", method = RequestMethod.GET)
	public String createCompanyGet(Model model) {
		
		logger.info("Create Company page GET!");
		
		model.addAttribute("company", new Company());
				
		return "company/createCompany";
	}
	
	@RequestMapping(value = "/company/createCompany", method = RequestMethod.POST)
	public String createCompanyPost(@ModelAttribute Company company) {
		
		logger.info("Create Company page POST!" + "company name: " + company.getCompanyName() + " date: " + company.getDate());
		
			
		return "company/createCompany";
	}	

}
