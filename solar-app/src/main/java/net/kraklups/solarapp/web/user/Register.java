package net.kraklups.solarapp.web.user;

import java.util.Calendar;

import net.kraklups.solarapp.model.company.Company;
import net.kraklups.solarapp.model.role.Role;
import net.kraklups.solarapp.model.userprofile.UserProfile;
import net.kraklups.solarapp.model.userservice.UserProfileDetails;
import net.kraklups.solarapp.model.userservice.UserService;
import net.kraklups.modelutil.exceptions.DuplicateInstanceException;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application Register page.
 */
@Controller
public class Register {
	 
	private static final Logger logger = LoggerFactory.getLogger(Register.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/user/register", method = RequestMethod.GET)
	public String registerGet(Model model) {
		logger.info("Register page !");
		
		model.addAttribute("userProfile", new UserProfile());
		
		return "user/register";
	}	

	@RequestMapping(value = "/user/register", method = RequestMethod.POST)
	public String registerPost(@ModelAttribute UserProfile userProfile) {
		
		logger.info("Register page !" );
		
		return "user/register";
	}	
	
/*    @Property
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
*/
}
