package net.kraklups.solarapp.web.pages.user;

import java.util.Calendar;

import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.corelib.components.PasswordField;
import org.apache.tapestry5.corelib.components.TextField;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;

import net.kraklups.solarapp.model.company.Company;
import net.kraklups.solarapp.model.role.Role;
import net.kraklups.solarapp.model.userprofile.UserProfile;
import net.kraklups.solarapp.model.userservice.UserProfileDetails;
import net.kraklups.solarapp.model.userservice.UserService;
import net.kraklups.solarapp.web.pages.Index;
import net.kraklups.solarapp.web.services.AuthenticationPolicy;
import net.kraklups.solarapp.web.services.AuthenticationPolicyType;
import net.kraklups.solarapp.web.util.UserSession;
import net.kraklups.modelutil.exceptions.DuplicateInstanceException;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;

@AuthenticationPolicy(AuthenticationPolicyType.NON_AUTHENTICATED_USERS)
public class Register {
	 	
    @Property
    private String loginName;

    @Property
    private String password;

    @Property
    private String retypePassword;

    @Property
    private String firstName;

    @Property
    private String surname1;

    @Property
    private String surname2;    

    @Property
    private String email;    
       
    @Property
    private String companyName;
    
    @Property
    private String roleName;
    
    @SessionState(create=false)
    private UserSession userSession;

    @Inject
    private UserService userService;
    
    @Component
    private Form registrationForm;

    @Component(id = "loginName")
    private TextField loginNameField;

    @Component(id = "password")
    private PasswordField passwordField;

    @Inject
    private Messages messages;

    private Long userProfileId;
    
    private Role role;
    
    private Company company;

    void onValidateFromRegistrationForm() {

        if (!registrationForm.isValid()) {
            return;
        }

        if (!password.equals(retypePassword)) {
            registrationForm.recordError(passwordField, messages
                    .get("error-passwordsDontMatch"));
        } else {

            try {
            	
            	Long value = new Long("1");
            	
            	try {
            		company = userService.findCompany(value);
            	} catch (InstanceNotFoundException e) {
            		
            	}
            	
            	try {
            		role = userService.findRole(value);
            	} catch (InstanceNotFoundException e) {
            		
            	}
        
            	
                UserProfile userProfile = userService.registerUser(loginName, password, 
                		new UserProfileDetails(firstName, surname1, surname2, email, Calendar.getInstance(), false, false, company, role));
                userProfileId = userProfile.getUserProfileId();
                
            } catch (DuplicateInstanceException e) {
                registrationForm.recordError(loginNameField, messages
                        .get("error-loginNameAlreadyExists"));
            }

        }

    }

    Object onSuccess() {

        userSession = new UserSession();
        userSession.setUserProfileId(userProfileId);
        userSession.setFirstName(firstName);
        return Index.class;

    }

}
