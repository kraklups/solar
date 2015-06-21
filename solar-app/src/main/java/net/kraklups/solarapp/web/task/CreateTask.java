package net.kraklups.solarapp.web.task;

import java.util.List;

import javax.validation.Valid;

import net.kraklups.modelutil.exceptions.DuplicateInstanceException;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.park.Park;
import net.kraklups.solarapp.model.parkservice.ParkService;
import net.kraklups.solarapp.model.report.Report;
import net.kraklups.solarapp.model.role.Role;
import net.kraklups.solarapp.model.taskprk.Monitor;
import net.kraklups.solarapp.model.taskprk.Synchronize;
import net.kraklups.solarapp.model.taskprk.TaskPrk;
import net.kraklups.solarapp.model.taskprk.TaskPrkMock;
import net.kraklups.solarapp.model.taskprk.Track;
import net.kraklups.solarapp.model.taskprk.Upkeep;
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
		
		TaskPrkMock taskPrkMock = new TaskPrkMock();
		
		model.addAttribute("taskPrkMock", taskPrkMock);
		
		initModelListPark(model);
		
		initModelListRole(model);		
		
		initModelListReport(model);
		
		return "task/createTask";
	}
	
	@RequestMapping(value = "/task/createTask", method = RequestMethod.POST)
	public String createTaskPost(@Valid @ModelAttribute("taskPrk") TaskPrk taskPrk, BindingResult result, Model model) 
			throws DuplicateInstanceException, InstanceNotFoundException {
		
		if(result.hasErrors()) {
			logger.info("Returning after error createTask.jspx merde page");
			
			return "task/createTask";
		} else {
			logger.info("Create TaskPrk page! " + "taskPrk: " + taskPrk.getTaskPrkId());

			model.addAttribute("taskPrk", taskPrk);
			
			logger.info("UserSession " + SecurityContextHolder.getContext().getAuthentication().getName());
			
			taskPrk.setUserProfile(userService.findUserProfileByLogin(SecurityContextHolder.getContext().getAuthentication().getName()));			
			
			TaskPrk merda = taskPrkService.saveTaskPrk(taskPrk);
			
			logger.info("Create TaskPrk page POST! " + merda);
			
			return "redirect:/task/showTasks";
		}	
	}
	
	@RequestMapping(value = "/task/createMonitorTask", method = RequestMethod.POST)
	public String createMonitorPost(@Valid @ModelAttribute("monitor") Monitor monitor, BindingResult result, Model model) 
			throws DuplicateInstanceException, InstanceNotFoundException {
		
		if(result.hasErrors()) {
			logger.info("Returning after error createMonitorTask.jspx page");
						
			return "task/createTask";
		} else {
			logger.info("Create Monitor page! " + "monitor: " + monitor.getMonitorId());

			model.addAttribute("monitor", monitor);
			
			logger.info("UserSession " + SecurityContextHolder.getContext().getAuthentication().getName());
			
			monitor.setUserProfile(userService.findUserProfileByLogin(SecurityContextHolder.getContext().getAuthentication().getName()));			
			
			Monitor merda = taskPrkService.saveTaskPrk(monitor);
			
			logger.info("Create Monitor page POST! " + merda);
			
			return "redirect:/task/showTasks";
		}	
	}	
	
	@RequestMapping(value = "/task/createUpkeepTask", method = RequestMethod.POST)
	public String createUpkeepPost(@Valid @ModelAttribute("upkeep") Upkeep upkeep, BindingResult result, Model model) 
			throws DuplicateInstanceException, InstanceNotFoundException {
		
		if(result.hasErrors()) {
			logger.info("Returning after error createUpkeepTask.jspx page");
			
			logger.info(result.toString());
			
			model.addAttribute("taskPrkMock", upkeep);
			
			return "redirect:/task/createTask";
		} else {
			logger.info("Create Upkeep page! " + "upkeep: " + upkeep.getUpkeepId());

			model.addAttribute("upkeep", upkeep);
			
			logger.info("UserSession " + SecurityContextHolder.getContext().getAuthentication().getName());
			
			upkeep.setUserProfile(userService.findUserProfileByLogin(SecurityContextHolder.getContext().getAuthentication().getName()));			
			
			Upkeep merda = taskPrkService.saveTaskPrk(upkeep);
			
			logger.info("Create Upkeep page POST! " + merda);
			
			return "redirect:/task/showTasks";
		}	
	}	
	
	@RequestMapping(value = "/task/createSynchronizeTask", method = RequestMethod.POST)
	public String createSynchronizePost(@Valid @ModelAttribute("synchronize") Synchronize synchronize, BindingResult result, Model model) 
			throws DuplicateInstanceException, InstanceNotFoundException {
		
		if(result.hasErrors()) {
			logger.info("Returning after error createSynchronizeTask.jspx page");
			
			return "task/createTask";
		} else {
			logger.info("Create Synchronize page! " + "synchronize: " + synchronize.getSynchronizeId());

			model.addAttribute("synchronize", synchronize);
			
			logger.info("UserSession " + SecurityContextHolder.getContext().getAuthentication().getName());
			
			synchronize.setUserProfile(userService.findUserProfileByLogin(SecurityContextHolder.getContext().getAuthentication().getName()));			
			
			Synchronize merda = taskPrkService.saveTaskPrk(synchronize);
			
			logger.info("Create Synchronize page POST! " + merda);
			
			return "redirect:/task/showTasks";
		}	
	}	

	@RequestMapping(value = "/task/createTrackTask", method = RequestMethod.POST)
	public String createTrackPost(@Valid @ModelAttribute("track") Track track, BindingResult result, Model model) 
			throws DuplicateInstanceException, InstanceNotFoundException {
		
		if(result.hasErrors()) {
			logger.info("Returning after error createTrackTask.jspx page");
			
			return "task/createTask";
		} else {
			logger.info("Create Track page! " + "track: " + track.getTrackId());

			model.addAttribute("track", track);
			
			logger.info("UserSession " + SecurityContextHolder.getContext().getAuthentication().getName());
			
			track.setUserProfile(userService.findUserProfileByLogin(SecurityContextHolder.getContext().getAuthentication().getName()));			
			
			logger.info("Create Track page! " + "track: " + track);
			
			Track merda = taskPrkService.saveTaskPrk(track);
			
			logger.info("Create Track page POST! " + merda);
			
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
	
	private void initModelListReport(Model model) throws InstanceNotFoundException {
		List <Report> reportList = taskPrkService.getReports(startIndex, ROLE_PER_PAGE).getReports();
		model.addAttribute("reportList",reportList);
	}	
	
	
}
