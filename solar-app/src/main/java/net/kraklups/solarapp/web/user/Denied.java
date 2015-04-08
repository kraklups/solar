package net.kraklups.solarapp.web.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application Login page.
 */
@Controller
public class Denied {

	private static final Logger logger = LoggerFactory.getLogger(Denied.class);
		
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/user/denied", method = RequestMethod.GET)
	public String DeniedGet() {
		logger.info("Denied GET page !");
		
		return "user/denied";
	}	
	
	@RequestMapping(value = "/user/denied", method = RequestMethod.POST)
	public String DeniedPost() {
		logger.info("Denied POST page !");
		
		return "user/denied";
	}
		
}
