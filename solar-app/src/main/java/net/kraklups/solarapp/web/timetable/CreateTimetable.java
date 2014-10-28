package net.kraklups.solarapp.web.timetable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application Timetable page.
 */
@Controller
public class CreateTimetable {

	private static final Logger logger = LoggerFactory.getLogger(CreateTimetable.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/timetable/createTimetable", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("Create Timetable page !");
		
		return "timetable/createTimetable";
	}
	
}