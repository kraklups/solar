package net.kraklups.solarapp.web.user;

import net.kraklups.solarapp.model.userprofile.UserProfile;
import net.kraklups.solarapp.model.userservice.IncorrectPasswordException;
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
 * Handles requests for the application Login page.
 */
@Controller
public class Login {

	private static final Logger logger = LoggerFactory.getLogger(Login.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/user/login", method = RequestMethod.GET)
	public String loginGet(Model model) {
		logger.info("Login page !");
		
		model.addAttribute("userProfile", new UserProfile());
		
		return "user/login";
	}	

	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	public String loginPost(@ModelAttribute UserProfile userProfile) {
		
		logger.info("Login page !" + "login: " + userProfile.getLoginName());
		
		return "user/login";
	}	
	
/*    @Property
    private String loginName;

    @Property
    private String password;

    @Property
    private boolean rememberMyPassword;

    @SessionState(create=false)
    private UserSession userSession;

    @Inject
    private Cookies cookies;

    @Component
    private Form loginForm;

    @Inject
    private Messages messages;

    @Inject
    private UserService userService;

    private UserProfile userProfile = null;


    void onValidateFromLoginForm() {

        if (!loginForm.isValid()) {
            return;
        }

        try {
            userProfile = userService.login(loginName, password, false);
        } catch (InstanceNotFoundException e) {
            loginForm.recordError(messages.get("error-authenticationFailed"));
        } catch (IncorrectPasswordException e) {
            loginForm.recordError(messages.get("error-authenticationFailed"));
        }

    }

    Object onSuccess() {

    	userSession = new UserSession();
        userSession.setUserProfileId(userProfile.getUserProfileId());
        userSession.setFirstName(userProfile.getFirstName());

        if (rememberMyPassword) {
            CookiesManager.leaveCookies(cookies, loginName, userProfile
                    .getEncryptedPassword());
        }
        return Index.class;

    }
*/
}
