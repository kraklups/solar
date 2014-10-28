package net.kraklups.solarapp.web.role;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String home(Model model) {
		logger.info("Create Role page !");
		
		return "role/createRole";
	}


}