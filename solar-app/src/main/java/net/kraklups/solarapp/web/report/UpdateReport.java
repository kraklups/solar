package net.kraklups.solarapp.web.report;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application Report page.
 */
@Controller
public class UpdateReport {

	private static final Logger logger = LoggerFactory.getLogger(UpdateReport.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/report/updateReport", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("Update Report page !");
		
		return "report/updateReport";
	}
}
