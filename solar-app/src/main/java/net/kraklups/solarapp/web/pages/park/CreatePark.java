package net.kraklups.solarapp.web.pages.park;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.apache.tapestry5.annotations.AfterRender;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Environmental;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.corelib.components.TextField;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;

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
import net.kraklups.solarapp.web.pages.Index;
import net.kraklups.solarapp.web.services.AuthenticationPolicy;
import net.kraklups.solarapp.web.services.AuthenticationPolicyType;
import net.kraklups.solarapp.web.util.UserSession;

@AuthenticationPolicy(AuthenticationPolicyType.AUTHENTICATED_USERS)
@Import(stylesheet={"context:css/solar_gis.css", "context:css/gis.css", "context:css/ie6-style.css"},
	library={"context:js/OpenLayers.js", "context:js/gis_tools.js", "context:js/Firebug/firebug.js"})
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
	
    @Environmental
    private JavaScriptSupport javaScriptSupport;	
    
	private String wkt_temp;
    
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
			
//		wkt_temp= "MULTIPOLYGON(((-5.5439446866512 41.567382365465,-1.5888665616512 40.688476115465,-2.8193353116512 39.458007365465,-6.1591790616512 39.545897990465,-5.5439446866512 41.567382365465)),((-5.8076165616512 37.963866740465,-3.5224603116512 38.139647990465,-3.5224603116512 36.909179240465,-5.7197259366512 36.645507365465,-5.8076165616512 37.963866740465)))";

		wkt_temp ="MULTIPOLYGON (((10 10 0,20 10 0,20 20 0,20 10 0,10 10 0),(5 5 0,5 6 0,6 6 0,6 5 0,5 5 0)),((10 10 0,20 10 0,20 20 0,20 10 0,10 10 0),(5 5 0,5 6 0,6 6 0,6 5 0,5 5 0)))";
		
//		Geometry geom = wktToGeometry(solarPark);
		
		Geometry geom = wktToGeometry(wkt_temp);
		
//		Geometry geom = wktToGeometry();
		
//		MultiPolygon mapPark = new MultiPolygon(wkt_temp, null);		
       
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
