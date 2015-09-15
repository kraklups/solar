package net.kraklups.solarapp.web.task;

import java.util.List;

import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.taskprk.TaskPrk;
import net.kraklups.solarapp.model.taskprkservice.TaskPrkService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application Task page.
 */
@Controller
public class ShowTasks {
	
	private final static int TASKPRK_PER_PAGE = 50;

	private static final Logger logger = LoggerFactory.getLogger(ShowTasks.class);
	
	private int startIndex = 0;
	
	@Autowired
	private TaskPrkService taskPrkService;		
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/task/showTasks", method = RequestMethod.GET)
	public String home(Model model) 
			throws InstanceNotFoundException {
		
		logger.info("Show Tasks page !");
		
		initModelListTaskPrks(model);
		
		return "task/showTasks";
	}
	
	private void initModelListTaskPrks(Model model) throws InstanceNotFoundException {
		List <TaskPrk> taskPrkList = taskPrkService.getTaskPrks(startIndex, TASKPRK_PER_PAGE).getTaskPrks();
		model.addAttribute("taskPrkList",taskPrkList);
	}

}
