package net.kraklups.solarapp.web.report;

import java.util.List;

import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.report.Report;
import net.kraklups.solarapp.model.taskprkservice.TaskPrkService;
import net.kraklups.solarapp.web.datavalue.CreateDataValue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application about page.
 */
@Controller
public class ShowReports {

	private final static int REPORT_PER_PAGE = 50;
	
	private static final Logger logger = LoggerFactory.getLogger(CreateDataValue.class);
	
	private int startIndex = 0;

	@Autowired
	private TaskPrkService taskPrkService;	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/report/showReports", method = RequestMethod.GET)
	public String home(Model model) 
			throws InstanceNotFoundException {
		
		logger.info("Show Reports page !");
		
		initModelListReport(model);
		
		return "report/showReports";
	}

	private void initModelListReport(Model model) throws InstanceNotFoundException {
		List <Report> ReportList = taskPrkService.getReports(startIndex, REPORT_PER_PAGE).getReports();
		model.addAttribute("ReportList",ReportList);
	}	
	
}