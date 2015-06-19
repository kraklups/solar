package net.kraklups.solarapp.web.role;

import java.util.List;

import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.role.Role;
import net.kraklups.solarapp.model.userservice.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application Role page.
 */
@Controller
public class ShowRoles {

	private final static int ROLES_PER_PAGE = 50;
	
	private static final Logger logger = LoggerFactory.getLogger(ShowRoles.class);
	
	private int startIndex = 0;
	
	@Autowired
	private UserService userService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/role/showRoles", method = RequestMethod.GET)
	public String home(Model model) 
			throws InstanceNotFoundException {
		
		logger.info("Show Roles page !");
		
		initModelListRoles(model);
		
		return "role/showRoles";
	}

	private void initModelListRoles(Model model) throws InstanceNotFoundException {
		List <Role> roleList = userService.getRoles(startIndex, ROLES_PER_PAGE).getRoles();
		model.addAttribute("roleList",roleList);
	}

}
