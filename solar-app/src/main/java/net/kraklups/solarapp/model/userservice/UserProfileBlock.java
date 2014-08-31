package net.kraklups.solarapp.model.userservice;

import java.util.List;

import net.kraklups.solarapp.model.userprofile.UserProfile;

public class UserProfileBlock {

    private List<UserProfile> userProfiles;
    private boolean existMoreUserProfiles;

    public UserProfileBlock(List<UserProfile> userProfiles, boolean existMoreUserProfiles) {
        
        this.userProfiles = userProfiles;
        this.existMoreUserProfiles = existMoreUserProfiles;

    }
    
    public List<UserProfile> getUserProfiles() {
        return userProfiles;
    }
    
    public boolean getExistMoreUserProfiles() {
        return existMoreUserProfiles;
    }

}
