package net.kraklups.solarapp.web.user;

import java.util.List;

import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.userprofile.UserProfile;
import net.kraklups.solarapp.model.userservice.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application Register page.
 */
@Controller
public class ShowRegisters {
	
	private final static int USERPROFILES_PER_PAGE = 50;

	private static final Logger logger = LoggerFactory.getLogger(ShowRegisters.class);
	
	private int startIndex = 0;
	
	@Autowired
	private UserService userService;		
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/user/showRegisters", method = RequestMethod.GET)
	public String home(Model model) 
			throws InstanceNotFoundException {
		
		logger.info("Show Registers page !");
		
		initModelListUserProfiles(model);
		
		return "user/showRegisters";
	}	
	
	private void initModelListUserProfiles(Model model) throws InstanceNotFoundException {
		List <UserProfile> userProfileList = userService.getUserProfiles(startIndex, USERPROFILES_PER_PAGE).getUserProfiles();
		model.addAttribute("userProfileList",userProfileList);
	}	

}
