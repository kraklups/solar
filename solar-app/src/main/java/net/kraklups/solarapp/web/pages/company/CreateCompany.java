package net.kraklups.solarapp.web.pages.company;

import org.apache.tapestry5.annotations.SessionState;

import net.kraklups.solarapp.web.services.AuthenticationPolicy;
import net.kraklups.solarapp.web.services.AuthenticationPolicyType;
import net.kraklups.solarapp.web.util.UserSession;

@AuthenticationPolicy(AuthenticationPolicyType.AUTHENTICATED_USERS)
public class CreateCompany {

    @SessionState(create=false)
    private UserSession userSession;


}
