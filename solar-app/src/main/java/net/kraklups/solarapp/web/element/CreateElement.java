package net.kraklups.solarapp.web.element;

import java.util.List;

import javax.validation.Valid;

import net.kraklups.modelutil.exceptions.DuplicateInstanceException;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.datalogger.DataLogger;
import net.kraklups.solarapp.model.dataservice.DataService;
import net.kraklups.solarapp.model.elementprk.ElementPrk;
import net.kraklups.solarapp.model.elementprk.ElementPrkMock;
import net.kraklups.solarapp.model.elementprk.StringLine;
import net.kraklups.solarapp.model.elementservice.ElementService;
import net.kraklups.solarapp.model.park.Park;
import net.kraklups.solarapp.model.parkservice.ParkService;
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
 * Handles requests for the application Element page.
 */
@Controller
public class CreateElement {
	
	private final static int PARK_PER_PAGE = 50;
	
	private final static int STRINGLINE_PER_PAGE = 50;
	
	private final static int DATALOGGER_PER_PAGE = 50;

	private static final Logger logger = LoggerFactory.getLogger(CreateElement.class);
	
	private int startIndex = 0;	

	@Autowired
	private ElementService elementService;	
	
	@Autowired
	private UserService userService;	
	
	@Autowired
	private ParkService parkService;
	
	@Autowired
	private DataService dataService;	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/element/createElement", method = RequestMethod.GET)
	public String createElementGet(Model model) 
			throws InstanceNotFoundException {
		
		logger.info("Create Element page !");
		
		ElementPrkMock elementPrkMock = new ElementPrkMock();
		
		model.addAttribute("elementPrkMock", elementPrkMock);
		
		initModelListPark(model);
		
		initModelListDataLogger(model);
		
		initModelListStringLine(model);
		
		return "element/createElement";
	}

	@RequestMapping(value = "/element/createElementk", method = RequestMethod.POST)
	public String createElementPost(@Valid @ModelAttribute("elementPrk") ElementPrk elementPrk, BindingResult result, Model model) 
			throws DuplicateInstanceException, InstanceNotFoundException {
		
		if(result.hasErrors()) {
			logger.info("Returning after error createTask.jspx merde page");
			
			return "task/createTask";
		} else {
			logger.info("Create ElementPrk page! " + "elementPrk: " + elementPrk.getElementPrkId());

			model.addAttribute("elementPrk", elementPrk);
			
			logger.info("UserSession " + SecurityContextHolder.getContext().getAuthentication().getName());
			
			elementPrk.setUserProfile(userService.findUserProfileByLogin(SecurityContextHolder.getContext().getAuthentication().getName()));			
			
			ElementPrk merda = elementService.saveElementPrk(elementPrk);
			
			logger.info("Create ElementPrk page POST! " + merda);
			
			return "Done";
		}	
	}	
	
	private void initModelListPark(Model model) throws InstanceNotFoundException {
		List <Park> parkList = parkService.getParks(startIndex, PARK_PER_PAGE).getParks();
		model.addAttribute("parkList",parkList);
	}	
	
	private void initModelListDataLogger(Model model) throws InstanceNotFoundException {
		List <DataLogger> dataLoggerList = dataService.getDataLoggers(startIndex, DATALOGGER_PER_PAGE).getDataLoggers();
		model.addAttribute(dataLoggerList);
	}	
	
	private void initModelListStringLine(Model model) throws InstanceNotFoundException {
		List <StringLine> stringLineList = elementService.getStringLines(startIndex, STRINGLINE_PER_PAGE).getStringLines();
		model.addAttribute(stringLineList);
	}	
	
}
