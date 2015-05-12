package net.kraklups.solarapp.web.task;

import java.util.List;

import javax.validation.Valid;

import net.kraklups.modelutil.exceptions.DuplicateInstanceException;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.park.Park;
import net.kraklups.solarapp.model.parkservice.ParkService;
import net.kraklups.solarapp.model.role.Role;
import net.kraklups.solarapp.model.taskprk.TaskPrk;
import net.kraklups.solarapp.model.taskprkservice.TaskPrkService;
import net.kraklups.solarapp.model.userservice.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application Task page.
 */
@Controller
public class CreateTask {
	
	private final static int PARK_PER_PAGE = 50;
	
	private final static int ROLE_PER_PAGE = 50;	
	
	private static final Logger logger = LoggerFactory.getLogger(CreateTask.class);
	
	private int startIndex = 0;	

	@Autowired
	private UserService userService;	
	
	@Autowired
	private ParkService parkService;
	
	@Autowired
	private TaskPrkService taskPrkService;	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/task/createTask", method = RequestMethod.GET)
	public String createTaskGet(Model model) 
			throws InstanceNotFoundException {
		
		logger.info("Create TaskPrk page !");
		
		TaskPrk taskPrk = new TaskPrk();
		
		model.addAttribute("taskPrk", taskPrk);
		
		initModelListPark(model);
		
		initModelListRole(model);		
		
		return "task/createTask";
	}
	
	@RequestMapping(value = "/task/createTask", method = RequestMethod.POST)
	public String createTaskPost(@Valid @ModelAttribute("taskPrk") TaskPrk taskPrk, BindingResult result, Model model) 
			throws DuplicateInstanceException, InstanceNotFoundException {
		
		if(result.hasErrors()) {
			logger.info("Returning after error createTask.jspx page");
			
			return "task/createTask";
		} else {
			logger.info("Create TaskPrk page! " + "taskPrk: " + taskPrk.getTaskPrkId());

			model.addAttribute("taskPrk", taskPrk);
			
			TaskPrk merda = taskPrkService.saveTaskPrk(taskPrk);
			
			logger.info("Create TaskPrk page POST! " + merda);
			
			return "Done";

		}	}

	private void initModelListPark(Model model) throws InstanceNotFoundException {
		List <Park> parkList = parkService.getParks(startIndex, PARK_PER_PAGE).getParks();
		model.addAttribute("parkList",parkList);
	}	
	
	private void initModelListRole(Model model) throws InstanceNotFoundException {
		List <Role> roleList = userService.getRoles(startIndex, ROLE_PER_PAGE).getRoles();
		model.addAttribute("roleList",roleList);
	}	
	
}
