package net.kraklups.solarapp.web.datalogger;

import org.apache.tapestry5.annotations.SessionState;

import net.kraklups.solarapp.web.services.AuthenticationPolicy;
import net.kraklups.solarapp.web.services.AuthenticationPolicyType;
import net.kraklups.solarapp.web.util.UserSession;

@AuthenticationPolicy(AuthenticationPolicyType.AUTHENTICATED_USERS)
public class CreateDatalogger {

    @SessionState(create=false)
    private UserSession userSession;

}
