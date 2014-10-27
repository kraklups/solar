package net.kraklups.solarapp.web.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application Task page.
 */
@Controller
public class CreateTask {

	private static final Logger logger = LoggerFactory.getLogger(CreateTask.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/task/createTask", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("Create Task page !");
		
		return "task/createTask";
	}
	
}
