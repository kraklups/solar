package net.kraklups.solarapp.web.module;

import java.util.List;

import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.module.Module;
import net.kraklups.solarapp.model.userservice.UserService;

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
public class ShowModules {
	
	private final static int MODULES_PER_PAGE = 50;
	
	private static final Logger logger = LoggerFactory.getLogger(ShowModules.class);
	
	private int startIndex = 0;
	
	@Autowired
	private UserService userService;	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/module/showModules", method = RequestMethod.GET)
	public String home(Model model) 
			throws InstanceNotFoundException {
		
		logger.info("Create Module page !");
		
		initModelListModules(model);
		
		return "module/showModules";
	}

	private void initModelListModules(Model model) throws InstanceNotFoundException {
		List <Module> moduleList = userService.getModules(startIndex, MODULES_PER_PAGE).getModules();
		model.addAttribute("moduleList",moduleList);
	}
}
