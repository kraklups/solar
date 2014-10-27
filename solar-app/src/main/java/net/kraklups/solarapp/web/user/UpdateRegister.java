package net.kraklups.solarapp.web.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application Register page.
 */
@Controller
public class UpdateRegister {

	private static final Logger logger = LoggerFactory.getLogger(UpdateRegister.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/user/updateRegister", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("Update Register page !");
		
		return "user/updateRegister";
	}	

}
