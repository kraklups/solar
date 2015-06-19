package net.kraklups.solarapp.web.company;

import java.util.List;

import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.company.Company;
import net.kraklups.solarapp.model.userservice.UserService;
import net.kraklups.solarapp.web.park.CreatePark;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application about page.
 */
@Controller
public class ShowCompanies {

	private final static int COMPANIES_PER_PAGE = 50;
	
	private static final Logger logger = LoggerFactory.getLogger(CreatePark.class);
	
	private int startIndex = 0;
	
	@Autowired
	private UserService userService;	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/company/showCompanies", method = RequestMethod.GET)
	public String home(Model model) 
			throws InstanceNotFoundException {
		
		logger.info("Create Company page !");
		
		initModelListCompanies(model);
		
		return "company/showCompanies";
	}

	private void initModelListCompanies(Model model) throws InstanceNotFoundException {
		List <Company> companyList = userService.getCompanies(startIndex, COMPANIES_PER_PAGE).getCompanies();
		model.addAttribute("companyList",companyList);
	}
	
}
