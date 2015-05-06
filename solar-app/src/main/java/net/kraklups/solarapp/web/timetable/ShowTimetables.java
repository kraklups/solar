package net.kraklups.solarapp.web.timetable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application TimetableBlock page.
 */
@Controller
public class ShowTimetables {

	private static final Logger logger = LoggerFactory.getLogger(ShowTimetables.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/timetable/showTimetables", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("Show Timetables page !");
		
		return "timetable/showTimetables";
	}

}
