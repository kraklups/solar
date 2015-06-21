package net.kraklups.solarapp.web.datavalue;

import java.util.List;

import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.dataservice.DataService;
import net.kraklups.solarapp.model.datavalue.DataValue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application Datavalue page.
 */
@Controller
public class ShowDataValues {
	
	private final static int DATAVALUE_PER_PAGE = 50;

	private static final Logger logger = LoggerFactory.getLogger(ShowDataValues.class);
	
	private int startIndex = 0;
	
	@Autowired
	private DataService dataService;	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/dataValue/showDataValues", method = RequestMethod.GET)
	public String home(Model model) 
			throws InstanceNotFoundException {
		
		logger.info("Show Datavalues page !");
		
		initModelListDataValues(model);
		
		return "dataValue/showDataValues";
	}
	
	private void initModelListDataValues(Model model) throws InstanceNotFoundException {
		List <DataValue> dataValueList = dataService.getDataValues(startIndex, DATAVALUE_PER_PAGE).getDataValues();
		model.addAttribute("dataValueList",dataValueList);
	}
}
