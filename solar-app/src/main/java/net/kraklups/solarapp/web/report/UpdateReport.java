package net.kraklups.solarapp.web.report;

import java.util.List;

import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.report.Report;
import net.kraklups.solarapp.model.taskprkservice.TaskPrkService;
import net.kraklups.solarapp.model.userprofile.UserProfile;
import net.kraklups.solarapp.model.userservice.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application Report page.
 */
@Controller
public class UpdateReport {

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
	@RequestMapping(value = "/report/updateReport/{reportId}", method = RequestMethod.GET)
	public String createReportGet(@PathVariable String reportId, Model model) 
			throws InstanceNotFoundException {
		
		logger.info("Create Report page GET!");
		
		Report report = taskPrkService.getReportById(Long.valueOf(reportId));
		
		model.addAttribute("report", report);		
		initModelListUserProfile(model);
				
		return "report/updateReport";
	}
	
	private void initModelListUserProfile(Model model) throws InstanceNotFoundException {
		List <UserProfile> userProfileList = userService.getUserProfiles(startIndex, USERPROFILE_PER_PAGE).getUserProfiles();
		model.addAttribute(userProfileList);
	}		

	
}
