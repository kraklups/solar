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
public class ShowRegisters {

	private static final Logger logger = LoggerFactory.getLogger(ShowRegisters.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/user/showRegisters", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("Show Registers page !");
		
		return "user/showRegisters";
	}	

}
