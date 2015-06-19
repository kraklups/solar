package net.kraklups.solarapp.model.userservice;

import java.util.Date;

import org.springframework.security.core.userdetails.UserDetailsService;

import net.kraklups.solarapp.model.company.Company;
import net.kraklups.solarapp.model.module.Module;
import net.kraklups.solarapp.model.role.Role;
import net.kraklups.solarapp.model.rolemoduleaccess.RoleModuleAccess;
import net.kraklups.solarapp.model.rolemoduleaccess.RoleModuleAccess.Type;
import net.kraklups.solarapp.model.rolemoduleaccess.RoleModuleAccessId;
import net.kraklups.solarapp.model.userprofile.UserProfile;
import net.kraklups.modelutil.exceptions.DuplicateInstanceException;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;

public interface UserService extends UserDetailsService {

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
    
    public void removeUser(Long userProfileId, boolean enabled) 
            throws InstanceNotFoundException;

    public void blockUser(Long userProfileId, boolean accountNonExpired)
    		throws InstanceNotFoundException;
    
    public UserProfile findUserProfileByLogin(String loginName)
    		throws InstanceNotFoundException;

    public String findUserLoginByProfileId(Long userProfileId)
    		throws InstanceNotFoundException;    
    
    public void assignCompanyUserProfile(UserProfile userProfile, Company company)
    		throws InstanceNotFoundException;
    
    public void assignRoleUserProfile(UserProfile userProfile, Role role)
    		throws InstanceNotFoundException;
    
    public UserProfileBlock getEmployeeByFirstName(String firstName, int startIndex, int count)
    		throws InstanceNotFoundException;
        
    public UserProfileBlock getEmployeeBySurname1(String surname1, int startIndex, int count)
    		throws InstanceNotFoundException;    
    
    public UserProfileBlock getEmployeeBySurname2(String surname2, int startIndex, int count)
    		throws InstanceNotFoundException;    
        
	public Company createCompany(String companyName, Date date) 
			throws DuplicateInstanceException;
	
	public Company saveCompany(Company company) 
			throws DuplicateInstanceException;	
	
	public void updateCompany(Long companyId, String companyName, Date date) 
			throws InstanceNotFoundException;
	
	public void removeCompany(Long companyId) 
			throws InstanceNotFoundException;
	
	public Company findCompany(Long companyId) 
			throws InstanceNotFoundException;
	
	public Company findCompanyByName(String companyName)
			throws InstanceNotFoundException;
	
	public CompanyBlock getCompanies(int startIndex, int count) 
			throws InstanceNotFoundException;  
		
	public UserProfileBlock getEmployeesByCompanyId(Long companyId, int startIndex, int count) 
			throws InstanceNotFoundException; 

	public UserProfileBlock getEmployeeByRoleId(Long roleId,
			int startIndex, int count) throws InstanceNotFoundException;	
	
	public Role registerRole(String roleName, UserProfile userProfile, Long weight) 
			throws DuplicateInstanceException;
	
	public Role findRole(Long roleId) throws InstanceNotFoundException;
	
	public Role findRoleByName(String roleName)	throws InstanceNotFoundException;	
	
	public void removeRole(Long roleId) throws InstanceNotFoundException;
	
	public void updateRole(Long roleId, String roleName, Date date, 
			UserProfile userProfile, Long weight) throws InstanceNotFoundException;

	public Module registerModule(String moduleName) throws DuplicateInstanceException;
	
	public Module findModule(Long moduleId) throws InstanceNotFoundException;
	
	public Module findModuleByName(String moduleName) throws InstanceNotFoundException;	
	
	public void removeModule(Long moduleId) throws InstanceNotFoundException;
	
	public void updateModule(Long moduleId, String moduleName, Date date) 
			throws InstanceNotFoundException;
	
	public RoleModuleAccess registerRoleModuleAccess(Role role, Module module, Type type) 
			throws DuplicateInstanceException;
	
	public void updateRoleModuleAccess(RoleModuleAccessId roleModuleAccessId, Type type) throws InstanceNotFoundException;
	
	public RoleModuleAccess removeRoleModuleAccess() throws InstanceNotFoundException;
	
	public RoleModuleAccess checkRoleModuleAccess() throws InstanceNotFoundException;	
	
    public Module saveModule(Module module)
    		throws DuplicateInstanceException;	
    
	public UserProfileBlock getUserProfiles(int startIndex, int count) 
			throws InstanceNotFoundException;    
	
    public Role saveRole(Role role)
    		throws DuplicateInstanceException;	
    
	public RoleBlock getRoles(int startIndex, int count) 
			throws InstanceNotFoundException;
	
	public ModuleBlock getModules(int startIndex, int count) 
			throws InstanceNotFoundException;    	
	
}
