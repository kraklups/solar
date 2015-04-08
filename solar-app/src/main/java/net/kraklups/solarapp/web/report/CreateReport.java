package net.kraklups.solarapp.web.report;

import javax.validation.Valid;

import net.kraklups.solarapp.model.report.Report;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private static final Logger logger = LoggerFactory.getLogger(CreateReport.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/report/createReport", method = RequestMethod.GET)
	public String createReportGet(Model model) {
		
		logger.info("Create Report page GET!");
		
		model.addAttribute("report", new Report());
				
		return "report/createReport";
	}
	
	@RequestMapping(value = "/report/createReport", method = RequestMethod.POST)
	public String createReportPost(@Valid @ModelAttribute Report report, BindingResult result) {
		
		logger.info("Create Report page POST!" + "report id: " + report.getReportId());
		
		if(result.hasErrors()) {
			return "report/createReport";
		} else {
			return "Done";
		}

	}	
	
}
