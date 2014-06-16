package net.kraklups.solarapp.web.pages.park;

import java.util.Calendar;

import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.corelib.components.TextField;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.annotations.Type;

import com.vividsolutions.jts.geom.MultiPolygon;

import net.kraklups.modelutil.exceptions.DuplicateInstanceException;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.company.Company;
import net.kraklups.solarapp.model.park.Park;
import net.kraklups.solarapp.model.parkservice.ParkService;
import net.kraklups.solarapp.model.userservice.UserService;
import net.kraklups.solarapp.web.pages.Index;
import net.kraklups.solarapp.web.services.AuthenticationPolicy;
import net.kraklups.solarapp.web.services.AuthenticationPolicyType;
import net.kraklups.solarapp.web.util.UserSession;

@AuthenticationPolicy(AuthenticationPolicyType.AUTHENTICATED_USERS)
public class CreatePark {

	@Property
	private Long parkId;
	
	@Property
	private String parkName;
	
	@Property
	private Calendar startupDate;
	
	@Property
	private Calendar productionDate;
	
	@Property
	private String loginName;
	
	@Property
	private String companyName;	
	
	@Property
	@Type(type="org.hibernate.spatial.GeometryType")	
	private MultiPolygon mapPark;

    @SessionState(create=false)
    private UserSession userSession;

    @Inject
    private ParkService parkService;	
	
    @Component
    private Form registrationForm;   
    
    @Component(id = "parkName")
    private TextField parkNameField;    
    
    @Inject
    private Messages messages;

    private Company company;
    
    
    void onValidateFromRegistrationForm() {
    	
        UserService userService = null;

        if (!registrationForm.isValid()) {
            return;
        }
        
        try {
        	       	
        	try {
				company = userService.findCompanyByName(parkName);
        	} catch (InstanceNotFoundException e) {
        		
        	}        	    
        	
        	Park park = parkService.createPark(parkName, startupDate, productionDate, loginName, company, mapPark);
            
        } catch (DuplicateInstanceException e) {
            registrationForm.recordError(parkNameField, messages
                    .get("error-parkNameAlreadyExists"));
        }        
        
    }
    
    Object onSuccess() throws InstanceNotFoundException {

        return Index.class;

    }
    
}
