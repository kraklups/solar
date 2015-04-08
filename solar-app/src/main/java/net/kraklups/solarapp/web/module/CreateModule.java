package net.kraklups.solarapp.web.module;

import javax.validation.Valid;

import net.kraklups.solarapp.model.module.Module;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	public String createModulePost(@Valid @ModelAttribute("module") Module module, BindingResult result) {
		
		logger.info("Create Module page POST!" + "module name: " + module.getModuleName() + " date: " + module.getDate());
		
		if(result.hasErrors()) {
			return "module/createModule";
		} else {
			return "Done";
		}

	}
	
}
