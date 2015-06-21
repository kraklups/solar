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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application Task page.
 */
@Controller
public class UpdateTask {

	private final static int PARK_PER_PAGE = 50;
	
	private final static int ROLE_PER_PAGE = 50;	
	
	private static final Logger logger = LoggerFactory.getLogger(UpdateTask.class);
	
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
	@RequestMapping(value = "/task/updateTask/{taskPrkId}", method = RequestMethod.GET)
	public String updateTaskPrkGet(@PathVariable String taskPrkId, Model model) 
			throws InstanceNotFoundException {
		
		logger.info("Create TaskPrk page GET!");
		
		TaskPrk taskPrk = taskPrkService.findTaskPrk(Long.valueOf(taskPrkId));
		
		model.addAttribute("taskPrk", taskPrk);
		
		initModelListPark(model);
		
		initModelListRole(model);				
				
		return "task/updateTask";
	}
	
	@RequestMapping(value = "/task/updateTask/{taskPrkId}", method = RequestMethod.POST)
	public String updateTaskPrkPost(@Valid @ModelAttribute("taskPrk") TaskPrk taskPrk, BindingResult result, Model model) 
			throws DuplicateInstanceException, InstanceNotFoundException {
				
		if(result.hasErrors()) {
			logger.info("Returning updateTaskPrk.jspx page");
			
			return "taskPrk/updateTaskPrk";
		} else {
			logger.info("UpdateTaskPrk done");
			
			model.addAttribute("taskPrk", taskPrk);
			
			logger.info("UserSession " + SecurityContextHolder.getContext().getAuthentication().getName());
			
			taskPrk.setUserProfile(userService.findUserProfileByLogin(SecurityContextHolder.getContext().getAuthentication().getName()));			
			
			TaskPrk merda = taskPrkService.saveTaskPrk(taskPrk);
			
			logger.info("Update TaskPrk page POST!" + merda);
			
			return "redirect:/task/showTasks";
		}
	}	
	private void initModelListPark(Model model) throws InstanceNotFoundException {
		List <Park> parkList = parkService.getParks(startIndex, PARK_PER_PAGE).getParks();
		model.addAttribute("parkList",parkList);
	}	
	
	private void initModelListRole(Model model) throws InstanceNotFoundException {
		List <Role> roleList = userService.getRoles(startIndex, ROLE_PER_PAGE).getRoles();
		model.addAttribute("roleList",roleList);
	}			
	
}
