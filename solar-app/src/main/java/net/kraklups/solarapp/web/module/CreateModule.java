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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application about page.
 */
@Controller
public class CreateModule {

	private static final Logger logger = LoggerFactory.getLogger(CreateModule.class);
	
	@Autowired
	private UserService userService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/module/createModule", method = RequestMethod.GET)
	public String createModuleGet(Model model) {
		
		logger.info("Create Module page GET!");
		
		model.addAttribute("module", new Module());
				
		return "module/createModule";
	}
	
	@RequestMapping(value = "/module/createModule", method = RequestMethod.POST)
	public String createModulePost(@Valid @ModelAttribute("module") Module module, BindingResult result, Model model) 
			throws DuplicateInstanceException, InstanceNotFoundException {
		
		if(result.hasErrors()) {
			logger.info("Returning after error createModule.jspx page");
			
			return "module/createModule";
		} else {
			logger.info("Create Module page !" + "module: " + module);

			model.addAttribute("module", module);
			
			Module merda = userService.saveModule(module);
			
			logger.info("Create Module page POST! " + merda);			
						
			return "redirect:/module/showModules";
		}

	}
	
}
