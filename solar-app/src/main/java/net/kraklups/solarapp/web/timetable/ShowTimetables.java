package net.kraklups.solarapp.web.timetable;

import java.util.List;

import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.parkservice.ParkService;
import net.kraklups.solarapp.model.timetable.Timetable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application TimetableBlock page.
 */
@Controller
public class ShowTimetables {
	
	private final static int TIMETABLES_PER_PAGE = 50;

	private static final Logger logger = LoggerFactory.getLogger(ShowTimetables.class);
	
	private int startIndex = 0;
	
	@Autowired
	private ParkService parkService;	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/timetable/showTimetables", method = RequestMethod.GET)
	public String home(Model model) 
			throws InstanceNotFoundException {
		
		logger.info("Show Timetables page !");
		
		initModelListTimetables(model);
		
		return "timetable/showTimetables";
	}

	private void initModelListTimetables(Model model) throws InstanceNotFoundException {
		List <Timetable> timetableList = parkService.getTimetables(startIndex, TIMETABLES_PER_PAGE).getTimetables();
		model.addAttribute("timetableList",timetableList);
	}
}
