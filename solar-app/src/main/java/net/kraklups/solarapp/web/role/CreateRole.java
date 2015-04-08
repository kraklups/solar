package net.kraklups.solarapp.web.role;

import javax.validation.Valid;

import net.kraklups.solarapp.model.role.Role;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/role/createRole", method = RequestMethod.GET)
	public String createRoleGet(Model model) {
		
		logger.info("Create Role page GET!");
		
		model.addAttribute("role", new Role());
				
		return "role/createRole";
	}
	
	@RequestMapping(value = "/role/createRole", method = RequestMethod.POST)
	public String createRolePost(@Valid @ModelAttribute("role") Role role, BindingResult result) {
		
		logger.info("Create Role page POST!" + "role name: " + role.getRoleName());
		
		if(result.hasErrors()) {
			return "role/createRole";
		} else {
			return "Done";
		}
		
	}

}
