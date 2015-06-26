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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application Park page.
 */
@Controller
public class UpdatePark {
	
	private final static int COMPANIES_PER_PAGE = 50;

	private static final Logger logger = LoggerFactory.getLogger(UpdatePark.class);
	
	private int startIndex = 0;

	@Autowired
	private ParkService parkService;
		
	@Autowired
	private UserService userService;				
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/park/updatePark/{parkId}", method = RequestMethod.GET)
	public String updateParkGet(@PathVariable String parkId, Model model) 
			throws InstanceNotFoundException {
		
		logger.info("Create Park page GET!");
		
		Park park = parkService.findPark(Long.valueOf(parkId));
		
		model.addAttribute("park", park);
		initModelListCompany(model);
				
		return "park/updatePark";
	}
	
	@RequestMapping(value = "/park/updatePark/{parkId}", method = RequestMethod.POST)
	public String updateParkPost(@Valid @ModelAttribute("park") Park park, BindingResult result, Model model) 
			throws DuplicateInstanceException, InstanceNotFoundException {
				
		if(result.hasErrors()) {
			logger.info("Returning updatePark.jspx page");
			
			return "park/updatePark";
		} else {
			logger.info("UpdatePark done");
			
			model.addAttribute("park", park);

			logger.info("UserSession " + SecurityContextHolder.getContext().getAuthentication().getName());
			
			park.setUserProfile(userService.findUserProfileByLogin(SecurityContextHolder.getContext().getAuthentication().getName()));			
			
			Park merda = parkService.updatePark(park);
			
			logger.info("Update Park page POST!" + merda);
			
			return "redirect:/park/showParks";
		}
	}
	
	private void initModelListCompany(Model model) throws InstanceNotFoundException {
		List <Company> companyList = userService.getCompanies(startIndex, COMPANIES_PER_PAGE).getCompanies();
		model.addAttribute("companyList",companyList);
	}
	
}
