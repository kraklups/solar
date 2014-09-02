package net.kraklups.solarapp.model.userprofile;

import java.util.List;

import net.kraklups.modelutil.dao.GenericDao;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;

public interface UserProfileDao extends GenericDao<UserProfile, Long>{

    /**
     * Returns an UserProfile by login name (not user identifier)
     *
     * @param loginName the user identifier
     * @return the UserProfile
     */
    public UserProfile findByLoginName(String loginName) throws InstanceNotFoundException;
    
    /**
     * Returns an login name (not user identifier) using user identifier
     *
     * @param userProfileId the user Id
     * @return the loginName of the user
     */    
    public String getUserLoginByProfileId(Long userProfileId) throws InstanceNotFoundException;
    
    /**
     * Returns a List of UserProfiles using firstName
     *
     * @param firstName of the userProfile
     * @return list of UserProfiles
     */   
    public List<UserProfile> findByFirstName(String firstName, int startIndex, int count);
    
    /**
     * Returns a List of UserProfiles using firstName
     *
     * @param firstName of the userProfile
     * @return list of UserProfiles
     */   
    public List<UserProfile> findBySurname1(String surname1, int startIndex, int count);

    /**
     * Returns a List of UserProfiles using firstName
     *
     * @param firstName of the userProfile
     * @return list of UserProfiles
     */   
    public List<UserProfile> findBySurname2(String surname2, int startIndex, int count);

    /**
     * Returns a List of UserProfiles using roleId
     *
     * @param roleId
     * @return list of UserProfiles
     */   
    public List<UserProfile> findByRole(Long roleId, int startIndex, int count);
    
    /**
     * Returns a List of UserProfiles using companyId
     *
     * @param companyId
     * @return list of UserProfiles
     */   
    public List<UserProfile> findByCompany(Long companyId, int startIndex, int count);

    
    
}
