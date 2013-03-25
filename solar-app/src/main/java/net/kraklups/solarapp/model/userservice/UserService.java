package net.kraklups.solarapp.model.userservice;

import java.util.List;

import net.kraklups.solarapp.model.company.Company;
import net.kraklups.solarapp.model.role.Role;
import net.kraklups.solarapp.model.userprofile.UserProfile;
import net.kraklups.modelutil.exceptions.DuplicateInstanceException;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;

public interface UserService {

    public UserProfile registerUser(String loginName, String clearPassword,
            UserProfileDetails userProfileDetails)
            throws DuplicateInstanceException;

    public UserProfile login(String loginName, String password,
            boolean passwordIsEncrypted) 
            throws InstanceNotFoundException, IncorrectPasswordException;

    public UserProfile findUserProfile(Long userProfileId)
            throws InstanceNotFoundException;

    public void updateUserProfileDetails(Long userProfileId,
            UserProfileDetails userProfileDetails)
            throws InstanceNotFoundException;

    public void changePassword(Long userProfileId, String oldClearPassword,
            String newClearPassword) 
            throws IncorrectPasswordException, InstanceNotFoundException;
    
    public void removeUser(Long userProfileId, boolean erased) 
            throws InstanceNotFoundException;

    public void blockUser(Long userProfileId, boolean blocked)
    		throws InstanceNotFoundException;
    
    public UserProfile findUserProfileByLogin(String loginName)
    		throws InstanceNotFoundException;
    
    public void assignCompanyUserProfile(UserProfile userProfile, Company company)
    		throws InstanceNotFoundException;
    
    public void assignRoleUserProfile(UserProfile userProfile, Role role)
    		throws InstanceNotFoundException;
    
    public List<UserProfile> getEmployeeByFirstName(String firstName, int startIndex, int count)
    		throws InstanceNotFoundException;
    
    public List<UserProfile> getEmployeeByLogin(String loginName, int startIndex, int count)
    		throws InstanceNotFoundException;    
    
    public List<UserProfile> getEmployeeBySurname(String surname1, String surname2, 
    		int startIndex, int count)
    		throws InstanceNotFoundException;    
    
    public List<UserProfile> getEmployeeByRole(Role role, int startIndex, int count)
    		throws InstanceNotFoundException;
    
    public List<UserProfile> getEmployeeByCompany(Company company, int startIndex, int count)
    		throws InstanceNotFoundException;    
    
        
}
