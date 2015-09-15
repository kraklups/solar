package net.kraklups.solarapp.web.report;

import java.text.ParseException;
import java.util.Iterator;
import java.util.List;

import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
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

	private static final Logger logger = LoggerFactory.getLogger(ShowReport.class);
	
	@Autowired
	private TaskPrkService taskPrkService;	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws ParseException 
	 */
	@RequestMapping(value = "/report/showReport/{reportId}", method = RequestMethod.GET)
	public String showReportGet(@PathVariable String reportId, Model model) 
			throws InstanceNotFoundException, ParseException {
		
		logger.info("Show Report page for MapReduce !");
		
//		Report report = taskPrkService.getReportById(Long.valueOf(reportId));	
		
		List<ValueObject> valObj  = taskPrkService.mapReduceRest(Long.valueOf(reportId));
		
		Iterator<ValueObject> itr = valObj.iterator();
		while(itr.hasNext()){
			ValueObject xxx = itr.next();
			xxx.setId(xxx.getId().substring(0,10));
		}
		
//		System.out.println("isto é unha merda:" + valObj);
		
		model.addAttribute("MorrisData", valObj);
		
		return "report/showReport";
	}
	
}