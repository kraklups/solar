package net.kraklups.solarapp.web.user;

import java.util.Calendar;

import net.kraklups.solarapp.model.userprofile.UserProfile;
import net.kraklups.solarapp.model.userservice.UserProfileDetails;
import net.kraklups.solarapp.model.userservice.UserService;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application Profile page.
 */
@Controller
public class UpdateProfile {

	private static final Logger logger = LoggerFactory.getLogger(UpdateProfile.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/user/updateProfile", method = RequestMethod.GET)
	public String updateProfileGet(Model model) {
		logger.info("Update Profile page !");
		
		return "user/updateProfile";
	}	

	@RequestMapping(value = "/user/updateProfile", method = RequestMethod.POST)
	public String updateProfilePost(@ModelAttribute UserProfile userProfile) {
		
		logger.info("Create DataValue page !" );
		
		return "user/updateProfile";
	}	
	
/*    @Property
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

    void onPrepareForRender() throws InstanceNotFoundException {

        UserProfile userProfile;

        userProfile = userService.findUserProfile(userSession
                .getUserProfileId());
        firstName = userProfile.getFirstName();
        surname1 = userProfile.getSurname1();
        surname2 = userProfile.getSurname2();        
        email = userProfile.getEmail();

    }

    Object onSuccess() throws InstanceNotFoundException {

        userService.updateUserProfileDetails(
                userSession.getUserProfileId(), new UserProfileDetails(firstName, surname1, surname2, email, Calendar.getInstance(), false, false, null, null));
        userSession.setFirstName(firstName);
        return Index.class;

    }*/

}