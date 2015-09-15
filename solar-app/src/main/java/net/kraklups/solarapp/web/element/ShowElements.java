package net.kraklups.solarapp.web.element;

import java.util.List;

import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.elementprk.ElementPrk;
import net.kraklups.solarapp.model.elementservice.ElementService;

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
public class ShowElements {
	
	private final static int ELEMENTPRK_PER_PAGE = 50;

	private static final Logger logger = LoggerFactory.getLogger(ShowElements.class);
	
	private int startIndex = 0;	

	@Autowired
	private ElementService elementService;		
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/element/showElements", method = RequestMethod.GET)
	public String home(Model model) 
			throws InstanceNotFoundException {
		
		logger.info("Show Elements page !");
		
		initModelListElementPrks(model);		
		
		return "element/showElements";
	}
	
	private void initModelListElementPrks(Model model) throws InstanceNotFoundException {
		List <ElementPrk> elementPrkList = elementService.getElementPrks(startIndex, ELEMENTPRK_PER_PAGE).getElementPrks();
		model.addAttribute("elementPrkList",elementPrkList);
	}	

}
