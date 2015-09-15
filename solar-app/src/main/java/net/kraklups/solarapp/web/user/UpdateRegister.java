package net.kraklups.solarapp.web.user;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application Register page.
 */
@Controller
public class UpdateRegister {
	
	private final static int COMPANIES_PER_PAGE = 50;
	
	private final static int ROLES_PER_PAGE = 50;

	private static final Logger logger = LoggerFactory.getLogger(UpdateRegister.class);
	
	private int startIndex = 0;
	
	@Autowired
	private UserService userService;	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/user/updateRegister/{userProfileId}", method = RequestMethod.GET)
	public String createUserProfileGet(@PathVariable String userProfileId, Model model) 
			throws InstanceNotFoundException {
		
		logger.info("Create UserProfile page GET!");
		
		UserProfile userProfile = userService.findUserProfile(Long.valueOf(userProfileId));
		
		model.addAttribute("userProfile", userProfile);
		
		initModelListCompany(model);
		
		initModelListRole(model);
				
		return "user/updateRegister";
	}
	
	@RequestMapping(value = "/user/updateRegister/{userProfileId}", method = RequestMethod.POST)
	public String updateUserProfilePost(@Valid @ModelAttribute("userProfile") UserProfile userProfile, BindingResult result, Model model) 
			throws DuplicateInstanceException, InstanceNotFoundException {
				
		if(result.hasErrors()) {
			logger.info("Returning updateUserProfile.jspx page");
			
			return "user/updateRegister";
		} else {
			logger.info("UpdateUserProfile done");
			model.addAttribute("userProfile", userProfile);
			UserProfile merda = userService.saveUserProfile(userProfile);
			
			logger.info("Update UserProfile page POST!" + merda);
			
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
