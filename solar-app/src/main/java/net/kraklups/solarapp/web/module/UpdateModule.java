package net.kraklups.solarapp.web.module;

import javax.validation.Valid;

import net.kraklups.modelutil.exceptions.DuplicateInstanceException;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.module.Module;
import net.kraklups.solarapp.model.userservice.UserService;

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
 * Handles requests for the application about page.
 */
@Controller
public class UpdateModule {

	private static final Logger logger = LoggerFactory.getLogger(UpdateModule.class);
	
	@Autowired
	private UserService userService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/module/updateModule/{moduleId}", method = RequestMethod.GET)
	public String createModuleGet(@PathVariable String moduleId, Model model) 
			throws InstanceNotFoundException {
		
		logger.info("Create Module page GET!");
		
		Module module = userService.findModule(Long.valueOf(moduleId));
		
		model.addAttribute("module", module);
				
		return "module/updateModule";
	}
	
	@RequestMapping(value = "/module/updateModule/{moduleId}", method = RequestMethod.POST)
	public String updateModulePost(@Valid @ModelAttribute("module") Module module, BindingResult result, Model model) 
			throws DuplicateInstanceException, InstanceNotFoundException {
				
		if(result.hasErrors()) {
			logger.info("Returning updateModule.jspx page");
			
			return "module/updateModule";
		} else {
			logger.info("UpdateModule done");
			model.addAttribute("module", module);
			Module merda = userService.saveModule(module);
			
			logger.info("Update Module page POST!" + merda);
			
			return "redirect:/module/showModules";
		}
	}

}
