package net.kraklups.solarapp.web.role;

import javax.validation.Valid;

import net.kraklups.modelutil.exceptions.DuplicateInstanceException;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.role.Role;
import net.kraklups.solarapp.model.userservice.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application Role page.
 */
@Controller
public class CreateRole {
	
	private static final Logger logger = LoggerFactory.getLogger(CreateRole.class);
	
	@Autowired
	private UserService userService;	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/role/createRole", method = RequestMethod.GET)
	public String createRoleGet(Model model) 
			throws InstanceNotFoundException {
		
		logger.info("Create Role page GET!");
		
		model.addAttribute("role", new Role());
				
		return "role/createRole";
	}
	
	@RequestMapping(value = "/role/createRole", method = RequestMethod.POST)
	public String createRolePost(@Valid @ModelAttribute("role") Role role, BindingResult result, Model model) 
			throws DuplicateInstanceException, InstanceNotFoundException {
				
		if(result.hasErrors()) {
			logger.info("Returning after error createRole.jspx page");
			
			return "role/createRole";
		} else {
			logger.info("Create Role page !" + "roleId: " + role.getRoleId());

			model.addAttribute("role", role);
			
			logger.info("UserSession " + SecurityContextHolder.getContext().getAuthentication().getName());
			
			role.setUserProfile(userService.findUserProfileByLogin(SecurityContextHolder.getContext().getAuthentication().getName()));			
						
			Role merda = userService.saveRole(role);
			
			logger.info("Create Role page POST! " + merda);			
			
			return "redirect:/role/showRoles";
		}
	}	
	
}
