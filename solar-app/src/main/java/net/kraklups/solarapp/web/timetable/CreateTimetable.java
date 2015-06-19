package net.kraklups.solarapp.web.timetable;

import javax.validation.Valid;

import net.kraklups.solarapp.model.timetable.Timetable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application TimetableBlock page.
 */
@Controller
public class CreateTimetable {

	private static final Logger logger = LoggerFactory.getLogger(CreateTimetable.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/timetable/createTimetable", method = RequestMethod.GET)
	public String createTimetableGet(Model model) {
		
		logger.info("Create TimetableBlock page GET!");
		
		model.addAttribute("timetable", new Timetable());
				
		return "timetable/createTimetable";
	}
	
	@RequestMapping(value = "/timetable/createTimetable", method = RequestMethod.POST)
	public String createTimetablePost(@Valid @ModelAttribute("timetable") Timetable timetable, BindingResult result) {
		
		logger.info("Create TimetableBlock page POST!" + "timetableTag: " + timetable.getTimetableTag());
					
		if(result.hasErrors()) {
			return "timetable/createTimetable";
		} else {
			return "redirect:/timetable/showTimetables";
		}
		
	}		
}
