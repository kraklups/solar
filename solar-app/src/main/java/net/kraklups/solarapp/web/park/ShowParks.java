package net.kraklups.solarapp.web.park;

import net.kraklups.solarapp.web.services.AuthenticationPolicy;
import net.kraklups.solarapp.web.services.AuthenticationPolicyType;
import net.kraklups.solarapp.web.util.UserSession;

import org.apache.tapestry5.annotations.SessionState;

@AuthenticationPolicy(AuthenticationPolicyType.AUTHENTICATED_USERS)
public class ShowParks {

    @SessionState(create=false)
    private UserSession userSession;

}
