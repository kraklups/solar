package net.kraklups.solarapp.web.element;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application Element page.
 */
@Controller
public class CreateElement {

	private static final Logger logger = LoggerFactory.getLogger(CreateElement.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/element/createElement", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("Create Element page !");
		
		return "element/createElement";
	}

}
