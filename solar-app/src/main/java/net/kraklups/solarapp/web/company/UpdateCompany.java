package net.kraklups.solarapp.web.company;

import javax.validation.Valid;

import net.kraklups.modelutil.exceptions.DuplicateInstanceException;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.company.Company;
import net.kraklups.solarapp.model.userservice.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application about page.
 */
@Controller
public class UpdateCompany {

	private static final Logger logger = LoggerFactory.getLogger(UpdateCompany.class);
	
	@Autowired
	private UserService userService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/company/updateCompany/{companyId}", method = RequestMethod.GET)
	public String createCompanyGet(@PathVariable String companyId, Model model) 
			throws InstanceNotFoundException {
		
		logger.info("Create Company page GET!");
		
		Company company = userService.findCompany(Long.valueOf(companyId));
		
		model.addAttribute("company", company);
				
		return "company/updateCompany";
	}
	
	@RequestMapping(value = "/company/updateCompany/{companyId}", method = RequestMethod.POST)
	public String updateCompanyPost(@Valid @ModelAttribute("company") Company company, BindingResult result, Model model) 
			throws DuplicateInstanceException {
				
		if(result.hasErrors()) {
			logger.info("Returning updateCompany.jspx page");
			
			return "company/updateCompany";
		} else {
			logger.info("UpdateCompany done");
			model.addAttribute("company", company);
			Company merda = userService.saveCompany(company);
			
			logger.info("Update Company page POST!" + merda);
			
			return "redirect:/company/showCompanies";
		}
	}	

}
