package net.kraklups.solarapp.web.state;

import java.util.List;

import javax.validation.Valid;

import net.kraklups.modelutil.exceptions.DuplicateInstanceException;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.eventtsk.EventTsk;
import net.kraklups.solarapp.model.park.Park;
import net.kraklups.solarapp.model.parkservice.ParkService;
import net.kraklups.solarapp.model.state.State;
import net.kraklups.solarapp.model.statetype.StateType;
import net.kraklups.solarapp.model.taskprk.Upkeep;
import net.kraklups.solarapp.model.taskprkservice.TaskPrkService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application State page.
 */
@Controller
public class UpdateState {
	
	private final static int EVENTTSK_PER_PAGE = 50;
	
	private final static int PARK_PER_PAGE = 50;
	
	private final static int UPKEEP_PER_PAGE = 50;
	
	private final static int STATETYPE_PER_PAGE = 50;	

	private static final Logger logger = LoggerFactory.getLogger(UpdateState.class);
	
	private int startIndex = 0;

	@Autowired
	private ParkService parkService;	
	
	@Autowired
	private TaskPrkService taskPrkService;	
		
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/state/updateState/{stateId}", method = RequestMethod.GET)
	public String createStateGet(@PathVariable String stateId, Model model) 
			throws InstanceNotFoundException {
		
		logger.info("Create State page GET!");
		
		State state = parkService.findState(Long.valueOf(stateId));
		
		model.addAttribute("state", state);
		
		initModelListPark(model);		
		
		initModelListEventTsk(model);
			
		initModelListUpkeep(model);
		
		initModelListStateType(model);		
				
		return "state/updateState";
	}
	
	@RequestMapping(value = "/state/updateState/{stateId}", method = RequestMethod.POST)
	public String updateStatePost(@Valid @ModelAttribute("state") State state, BindingResult result, Model model) 
			throws DuplicateInstanceException, InstanceNotFoundException {
				
		if(result.hasErrors()) {
			logger.info("Returning updateState.jspx page");
			
			return "state/updateState";
		} else {
			logger.info("UpdateState done");
			
			model.addAttribute("state", state);
			
			State merda = parkService.saveState(state);
			
			logger.info("Update State page POST!" + merda);
			
			return "redirect:/state/showStates";
		}
	}
	
	private void initModelListEventTsk(Model model) throws InstanceNotFoundException {
		List <EventTsk> eventTskList = taskPrkService.getEventTsks(startIndex, EVENTTSK_PER_PAGE).getEventTsks();
		model.addAttribute("eventTskList", eventTskList);
	}
	
	private void initModelListPark(Model model) throws InstanceNotFoundException {
		List <Park> parkList = parkService.getParks(startIndex, PARK_PER_PAGE).getParks();
		model.addAttribute("parkList", parkList);
	}
	
	private void initModelListUpkeep(Model model) throws InstanceNotFoundException {
		
		List <Upkeep> upkeepList = taskPrkService.getUpkeeps(startIndex, UPKEEP_PER_PAGE).getUpkeeps();
		model.addAttribute("upkeepList",upkeepList);
	}
	
	private void initModelListStateType(Model model) throws InstanceNotFoundException {
		List <StateType> stateTypeList = parkService.getStateTypes(startIndex, STATETYPE_PER_PAGE).getStateTypes();
		model.addAttribute("stateTypeList", stateTypeList);
	}	
	
}
