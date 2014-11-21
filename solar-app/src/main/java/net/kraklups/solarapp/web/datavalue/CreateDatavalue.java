package net.kraklups.solarapp.web.datavalue;

import javax.validation.Valid;

import net.kraklups.solarapp.model.datavalue.DataValue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application DataValue page.
 */
@Controller
public class CreateDatavalue {

	private static final Logger logger = LoggerFactory.getLogger(CreateDatavalue.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/dataValue/createDataValue", method = RequestMethod.GET)
	public String createDataValueGet(Model model) {
		
		logger.info("Create DataValue page !");
		
		model.addAttribute("dataValue", new DataValue());
		
		return "dataValue/createDataValue";
	}
	
	@RequestMapping(value = "/dataValue/createDataValue", method = RequestMethod.POST)
	public String createDataValuePost(@Valid @ModelAttribute("dataValue") DataValue dataValue, BindingResult result) {
		
		logger.info("Create DataValue page !" + "dataValue name: " + dataValue.getDataValueId());

		if(result.hasErrors()) {
			return "dataValue/createDataValue";
		} else {
			return "Done";
		}		
		
	}	
	
}
