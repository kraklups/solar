package net.kraklups.solarapp.web.report;

import java.util.List;

import javax.validation.Valid;

import net.kraklups.modelutil.exceptions.DuplicateInstanceException;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.report.Report;
import net.kraklups.solarapp.model.taskprkservice.TaskPrkService;
import net.kraklups.solarapp.model.userprofile.UserProfile;
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
 * Handles requests for the application Report page.
 */
@Controller
public class CreateReport {
	
	private final static int USERPROFILE_PER_PAGE = 50;

	private static final Logger logger = LoggerFactory.getLogger(CreateReport.class);
	
	private int startIndex = 0;
	
	@Autowired
	private UserService userService;	
	
	@Autowired
	private TaskPrkService taskPrkService;	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/report/createReport", method = RequestMethod.GET)
	public String createReportGet(Model model) 
			throws InstanceNotFoundException {
		
		logger.info("Create Report page GET!");
		
		model.addAttribute("report", new Report());		
		initModelListUserProfile(model);
				
		return "report/createReport";
	}
	
	@RequestMapping(value = "/report/createReport", method = RequestMethod.POST)
	public String createReportPost(@Valid @ModelAttribute Report report, BindingResult result, Model model) 
			throws DuplicateInstanceException, InstanceNotFoundException {
				
		if(result.hasErrors()) {
			return "report/createReport";
		} else {
			logger.info("Create Report page !" + "reportId: " + report.getReportId());

			model.addAttribute("report", report);
			
			logger.info("UserSession " + SecurityContextHolder.getContext().getAuthentication().getName());
			
			report.setUserProfile(userService.findUserProfileByLogin(SecurityContextHolder.getContext().getAuthentication().getName()));			
			
			Report merda = taskPrkService.saveReport(report);
			
			logger.info("Create Report page POST! " + merda);			
			
			return "Done";
		}
	}	
	
	private void initModelListUserProfile(Model model) throws InstanceNotFoundException {
		List <UserProfile> userProfileList = userService.getUserProfiles(startIndex, USERPROFILE_PER_PAGE).getUserProfiles();
		model.addAttribute(userProfileList);
	}		
	
}
