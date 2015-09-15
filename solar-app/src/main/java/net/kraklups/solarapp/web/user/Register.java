package net.kraklups.solarapp.web.user;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import net.kraklups.modelutil.exceptions.DuplicateInstanceException;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.company.Company;
import net.kraklups.solarapp.model.role.Role;
import net.kraklups.solarapp.model.userprofile.UserProfile;
import net.kraklups.solarapp.model.userservice.UserService;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application Register page.
 */
@Controller
public class Register {
	 
	private final static int COMPANIES_PER_PAGE = 50;
	
	private final static int ROLES_PER_PAGE = 50;
	
	private static final Logger logger = LoggerFactory.getLogger(Register.class);
	
	private int startIndex = 0;
	
	@Autowired
	private UserService userService;	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/user/register", method = RequestMethod.GET)
	public String registerGet(Model model) throws InstanceNotFoundException {
		
		logger.info("Register page !");
		
		model.addAttribute("userProfile", new UserProfile());
		
		initModelListCompany(model);
		
		initModelListRole(model);
		
		return "user/register";
	}	

	@RequestMapping(value = "/user/register", method = RequestMethod.POST)
	public String registerPost(@Valid @ModelAttribute("userProfile") UserProfile userProfile, BindingResult result, Model model) 
			throws DuplicateInstanceException, InstanceNotFoundException {
		
		if(result.hasErrors()) {
			logger.info("Returning after error createUserProfile.jspx page");
			
			initModelListCompany(model);
			
			initModelListRole(model);			
			
			return "user/register";
		} else {
			
			logger.info("Create UserProfile page POST!");
			
			model.addAttribute("userProfile", userProfile);
			
			Calendar calendar = Calendar.getInstance();
			Date timestamp = new Date(calendar.getTime().getTime());
			
			userProfile = userService.assignDateUserProfile(userProfile, timestamp);
			
			UserProfile merda = userService.saveUserProfile(userProfile);
			
			logger.info("Create UserProfile page POST! " + merda);
			
			return "redirect:/user/showRegisters";
		}
	}	
	
	private void initModelListCompany(Model model) throws InstanceNotFoundException {
		List <Company> companyList = userService.getCompanies(startIndex, COMPANIES_PER_PAGE).getCompanies();
		model.addAttribute("companyList",companyList);
	}
	
	private void initModelListRole(Model model) throws InstanceNotFoundException {
		List <Role> roleList = userService.getRoles(startIndex, ROLES_PER_PAGE).getRoles();
		model.addAttribute("roleList",roleList);
	}	
	
}
