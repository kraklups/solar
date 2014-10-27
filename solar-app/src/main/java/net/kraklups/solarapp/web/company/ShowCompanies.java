package net.kraklups.solarapp.web.company;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application about page.
 */
@Controller
public class ShowCompanies {

	private static final Logger logger = LoggerFactory.getLogger(ShowCompanies.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/company/showCompanies", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("Create Company page !");
		
		return "company/showCompanies";
	}


}
