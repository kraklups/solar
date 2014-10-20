package net.kraklups.solarapp.web.components;

import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.Cookies;

import net.kraklups.solarapp.web.pages.Index;
import net.kraklups.solarapp.web.services.AuthenticationPolicy;
import net.kraklups.solarapp.web.services.AuthenticationPolicyType;
import net.kraklups.solarapp.web.util.CookiesManager;
import net.kraklups.solarapp.web.util.UserSession;

@Import(stylesheet={"context:css/sb-admin.css", "context:css/bootstrap.min.css", "context:font-awesome/css/font-awesome.css"},
		library={"context:js/bootstrap.min.js", "context:js/jquery-1.11.0.js", "context:js/Firebug/firebug.js"})
public class Layout {
		
    @Property
    @Parameter(required = false, defaultPrefix = "message")
    private String menuExplanation;

    @Property
    @Parameter(required = true, defaultPrefix = "message")
    private String pageTitle;

    @Property
    @SessionState(create=false)
    private UserSession userSession;

    @Inject
    private Cookies cookies;
   
    @AuthenticationPolicy(AuthenticationPolicyType.AUTHENTICATED_USERS)
   	Object onActionFromLogout() {
        userSession = null;
        CookiesManager.removeCookies(cookies);
        return Index.class;
	}    
    

}