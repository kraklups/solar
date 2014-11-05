package net.kraklups.solarapp.web.park;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;

import net.kraklups.modelutil.exceptions.DuplicateInstanceException;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.company.Company;
import net.kraklups.solarapp.model.park.Park;
import net.kraklups.solarapp.model.parkservice.ParkService;
import net.kraklups.solarapp.model.userprofile.UserProfile;
import net.kraklups.solarapp.model.userservice.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application Park page.
 */
@Controller
public class CreatePark {

	private static final Logger logger = LoggerFactory.getLogger(CreatePark.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/park/createPark", method = RequestMethod.GET)
	public String createParkGet(Model model) {
		
		logger.info("Create Park page GET!");
		
		model.addAttribute("park", new Park());
				
		return "park/createPark";
	}
	
	@RequestMapping(value = "/park/createPark", method = RequestMethod.POST)
	public String createParkPost(@ModelAttribute Park park) {
		
		logger.info("Create Park page POST!" + "park name: " + park.getParkName());
		
			
		return "park/createPark";
	}	
}

/*@AuthenticationPolicy(AuthenticationPolicyType.AUTHENTICATED_USERS)
@Import(stylesheet={"context:css/gis.css"},
		library={"context:js/OpenLayers.js", "context:js/gis_tools.js"})
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
        	
        	Park park = parkService.createPark(parkName, startupDateAsCalendar, productionDateAsCalendar, userProfile, company, (MultiPolygon) geom);
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