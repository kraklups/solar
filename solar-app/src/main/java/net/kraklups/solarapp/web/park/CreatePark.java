package net.kraklups.solarapp.web.park;

import java.util.List;

import javax.validation.Valid;

import net.kraklups.modelutil.exceptions.DuplicateInstanceException;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.company.Company;
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
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Handles requests for the application Park page.
 */
@Controller
@SessionAttributes("park")
public class CreatePark {

	private final static int COMPANIES_PER_PAGE = 50;
	
	private static final Logger logger = LoggerFactory.getLogger(CreatePark.class);
	
	private int startIndex = 0;

	@Autowired
	private ParkService parkService;
		
	@Autowired
	private UserService userService;			
		
	@RequestMapping(value = "/park/createPark", method = RequestMethod.GET)
	public String createParkGet(Model model) 
			throws InstanceNotFoundException {
		
		logger.info("Create Park page GET!");
				
		Park park = new Park();
		
		model.addAttribute("park", park);	
		
		initModelListCompany(model);
		
		return "park/createPark";
	}

	@RequestMapping(value = "/park/createPark", method = RequestMethod.PUT)
	public String createParkPut() {
		return null;
	}
	
	@RequestMapping(value = "/park/createPark", method = RequestMethod.POST)
	public String createParkPost(@Valid @ModelAttribute("park") Park park, BindingResult result, Model model) 
 			throws DuplicateInstanceException, InstanceNotFoundException {		
								
		if(result.hasErrors()) {
			logger.info("Returning after error createPark.jspx page");
			
			initModelListCompany(model);
			
			return "park/createPark";
		} else {
			
			logger.info("Create Park page POST!");
			
			model.addAttribute("park", park);
			
			logger.info("UserSession " + SecurityContextHolder.getContext().getAuthentication().getName());
			
			park.setUserProfile(userService.findUserProfileByLogin(SecurityContextHolder.getContext().getAuthentication().getName()));
			Park merda = parkService.savePark(park);
			
			logger.info("Create Park page POST! " + merda);
			
			return "redirect:/park/showParks";
		}
	} 
	
	private void initModelListCompany(Model model) throws InstanceNotFoundException {
		List <Company> companyList = userService.getCompanies(startIndex, COMPANIES_PER_PAGE).getCompanies();
		model.addAttribute("companyList",companyList);
	}
}

