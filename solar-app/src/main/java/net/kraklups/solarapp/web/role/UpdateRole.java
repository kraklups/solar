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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application Role page.
 */
@Controller
public class UpdateRole {

	private static final Logger logger = LoggerFactory.getLogger(UpdateRole.class);
	
	@Autowired
	private UserService userService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/role/updateRole/{roleId}", method = RequestMethod.GET)
	public String createRoleGet(@PathVariable String roleId, Model model) 
			throws InstanceNotFoundException {
		
		logger.info("Create Role page GET!");
		
		Role role = userService.findRole(Long.valueOf(roleId));
		
		model.addAttribute("role", role);
				
		return "role/updateRole";
	}
	
	@RequestMapping(value = "/role/updateRole/{roleId}", method = RequestMethod.POST)
	public String updateRolePost(@Valid @ModelAttribute("role") Role role, BindingResult result, Model model) 
			throws DuplicateInstanceException, InstanceNotFoundException {
				
		if(result.hasErrors()) {
			logger.info("Returning updateRole.jspx page");
			
			return "role/updateRole";
		} else {
			logger.info("UpdateRole done");
			
			model.addAttribute("role", role);

			logger.info("UserSession " + SecurityContextHolder.getContext().getAuthentication().getName());
			
			role.setUserProfile(userService.findUserProfileByLogin(SecurityContextHolder.getContext().getAuthentication().getName()));			
			
			Role merda = userService.saveRole(role);
			
			logger.info("Update Role page POST!" + merda);
			
			return "redirect:/role/showRoles";
		}
	}



}
