package net.kraklups.solarapp.web.report;

import java.util.ArrayList;
import java.util.List;

import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.report.Report;
import net.kraklups.solarapp.model.taskprkservice.TaskPrkService;
import net.kraklups.solarapp.model.util.ValueObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application about page.
 */
@Controller
public class ShowReport {

	private final static int REPORT_PER_PAGE = 50;
	
	private static final Logger logger = LoggerFactory.getLogger(ShowReport.class);
	
	private int startIndex = 0;

	@Autowired
	private TaskPrkService taskPrkService;	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/report/showReport/{reportId}", method = RequestMethod.GET)
	public String showReportGet(@PathVariable String reportId, Model model) 
			throws InstanceNotFoundException {
		
		logger.info("Show Report page for MapReduce !");
		
		Report report = taskPrkService.getReportById(Long.valueOf(reportId));
		
		List<ValueObject> valObj = new ArrayList<ValueObject>();
		
		valObj = taskPrkService.mapReduceRest(Long.valueOf(reportId));
		
		System.out.println("isto é unha merda:" + valObj);
		
		return "report/showReport";
	}

	private void initModelListReport(Model model) throws InstanceNotFoundException {
		List <Report> ReportList = taskPrkService.getReports(startIndex, REPORT_PER_PAGE).getReports();
		model.addAttribute("ReportList",ReportList);
	}	
	
}