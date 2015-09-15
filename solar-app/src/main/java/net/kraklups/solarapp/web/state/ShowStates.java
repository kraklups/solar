package net.kraklups.solarapp.web.state;

import java.util.List;

import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.parkservice.ParkService;
import net.kraklups.solarapp.model.state.State;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application State page.
 */
@Controller
public class ShowStates {

	private final static int ROLES_PER_PAGE = 50;
	
	private static final Logger logger = LoggerFactory.getLogger(ShowStates.class);
	
	private int startIndex = 0;

	@Autowired
	private ParkService parkService;	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/state/showStates", method = RequestMethod.GET)
	public String home(Model model) 
			throws InstanceNotFoundException {
		
		logger.info("Create State page !");
		
		initModelListState(model);
		
		return "state/showStates";
	}
	
	private void initModelListState(Model model) throws InstanceNotFoundException {
		List <State> stateList = parkService.getStates(startIndex, ROLES_PER_PAGE).getStates();
		model.addAttribute("stateList",stateList);	
	}

}
