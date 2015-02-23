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
	public String createParkGet(Model model) throws InstanceNotFoundException {
		
		logger.info("Create Park page GET!");
				
		Park park = new Park();
		
		model.addAttribute("park", park);		
		initModelList(model);
						
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
			
			//initModelList(model);
			
			return "park/createPark";
		} else {
			logger.info("CreateCompany done");
						
			model.addAttribute("park", park);
			Park merda = parkService.savePark(park);
			
			logger.info("Create Company page POST!" + merda);
			
			return "Done";
		}
	} 
	
	private void initModelList(Model model) throws InstanceNotFoundException {
		List <Company> companyList = userService.getCompanies(startIndex, COMPANIES_PER_PAGE).getCompanies();
		model.addAttribute(companyList);
	}
}

/*
public class CreatePark {

	@Property
	private Long parkId;
	
	@Property
	private String parkName;
	
	@Property
	private String startupDate;
	
	@Property
	private String productionDate;
	
	private Date startupDateAsDate;
	private Date productionDateAsDate;
		
	@Property
	private UserProfile userProfile;
	
	@Property
	private String companyName;	
	
	@Property
    private Company company;	
	
	@Property
	private String solarPark;		

    @SessionState(create=false)
    private UserSession userSession;
    
    @Inject
    private UserService userService;    

    @Inject
    private ParkService parkService;	
	
    @Component
    private Form createParkForm;   
    
    @Component(id = "parkName")
    private TextField parkNameField;    

    @Component(id = "companyName")
    private TextField companyNameField;    
        
	@Component(id="startupDate")
	private TextField startupDateField;
	
	@Component(id="productionDate")
	private TextField productionDateField;
	
	@Component(id="solarPark")
	private TextField solarParkField;
	
    @Inject
    private Messages messages;

	@Inject
	private Locale locale;  
		
	private static final int SRID = 4326;
    
   	void onValidateFromCreateParkForm() {
   		   		
        if (!createParkForm.isValid()) {
            return;
        }
        
		startupDateAsDate = validateDate(startupDateField, startupDate);
		productionDateAsDate = validateDate(productionDateField, productionDate);
		
		Calendar startupDateAsCalendar = Calendar.getInstance();
		Calendar productionDateAsCalendar = Calendar.getInstance();
		startupDateAsCalendar.setTime(startupDateAsDate);
		productionDateAsCalendar.setTime(productionDateAsDate);
			
		Geometry geom = wktToGeometry(solarPark);
		       
        try {
        	       	       	        	
        	try {
        		
				company = userService.findCompanyByName(companyName);    
        		
        	} catch (InstanceNotFoundException e) {
        		createParkForm.recordError(companyNameField, messages.format(
    					"error-companyNotFound", companyName));        		
        	}
        	
        	try {
        		
        		userProfile = userService.findUserProfile(userSession.getUserProfileId());
        		
        	} catch (InstanceNotFoundException e) {
        		
        	}
        	
        	Park park = parkService.createPark(parkName, startupDateAsCalendar, productionDateAsCalendar, userProfile, company, (MapPark) geom);
        //	parkId = park.getParkId();
            
        } catch (DuplicateInstanceException e) {
        	createParkForm.recordError(parkNameField, messages
                    .get("error-parkNameAlreadyExists"));
        }       
        
    }
    
    Object onSuccess() throws InstanceNotFoundException {

        return Index.class;

    }
 
    private Geometry wktToGeometry(String wktPoint) {
    	
        WKTReader fromText = new WKTReader();
        Geometry geom = null;
        try {
            geom = fromText.read(wktPoint);
            geom.setSRID(SRID);
        } catch (ParseException e) {
            throw new RuntimeException("Not a WKT string:" + wktPoint);
        }
        return geom;
    }    
    
	void onActivate() {
		startupDate = dateToString(Calendar.getInstance().getTime());
		productionDate = startupDate;
	}
	
	private Date validateDate(TextField textField, String dateAsString) {
		
		ParsePosition position = new ParsePosition(0);
		Date date = DateFormat.getDateInstance(DateFormat.SHORT, locale).
			parse(dateAsString, position);
		
		if (position.getIndex() != dateAsString.length()) {
			createParkForm.recordError(textField,
				messages.format("error-incorrectDateFormat", dateAsString));
		}

		return date;
		
	}
	
	private String dateToString(Date date) {
		return DateFormat.getDateInstance(DateFormat.SHORT, locale).
			format(date);
	}  
    

}
*/