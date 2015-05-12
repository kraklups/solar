package net.kraklups.solarapp.model.userservice;

import java.util.Date;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.kraklups.solarapp.model.company.Company;
import net.kraklups.solarapp.model.company.CompanyDao;
import net.kraklups.solarapp.model.module.Module;
import net.kraklups.solarapp.model.module.ModuleDao;
import net.kraklups.solarapp.model.role.Role;
import net.kraklups.solarapp.model.role.RoleDao;
import net.kraklups.solarapp.model.rolemoduleaccess.RoleModuleAccess;
import net.kraklups.solarapp.model.rolemoduleaccess.RoleModuleAccessDao;
import net.kraklups.solarapp.model.rolemoduleaccess.RoleModuleAccess.Type;
import net.kraklups.solarapp.model.rolemoduleaccess.RoleModuleAccessId;
import net.kraklups.solarapp.model.userprofile.UserProfile;
import net.kraklups.solarapp.model.userprofile.UserProfileDao;
import net.kraklups.solarapp.model.userservice.util.PasswordEncrypter;
import net.kraklups.modelutil.exceptions.DuplicateInstanceException;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserProfileDao userProfileDao;
    
	@Autowired
	private CompanyDao companyDao;
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private ModuleDao moduleDao;
	
	@Autowired 
	private RoleModuleAccessDao roleModuleAccessDao;	

    public UserProfile registerUser(String loginName, String clearPassword,
            UserProfileDetails userProfileDetails)
            throws DuplicateInstanceException {

        try {
            userProfileDao.findByLoginName(loginName);
            throw new DuplicateInstanceException(loginName,
                    UserProfile.class.getName());
        } catch (InstanceNotFoundException e) {
            String encryptedPassword = PasswordEncrypter.crypt(clearPassword);

            UserProfile userProfile = new UserProfile(loginName,
                    encryptedPassword, userProfileDetails.getFirstName(),
                    userProfileDetails.getSurname1(), userProfileDetails.getSurname2(), userProfileDetails
                        .getEmail(), userProfileDetails.getDate(), userProfileDetails.getBlocked(), 
                        userProfileDetails.getErased(), userProfileDetails.getCompany(), userProfileDetails.getRole());

            userProfileDao.save(userProfile);
            return userProfile;
        }
    }

    @Transactional(readOnly = true)
    public UserProfile login(String loginName, String password,
            boolean passwordIsEncrypted) throws InstanceNotFoundException,
            IncorrectPasswordException {

        UserProfile userProfile = userProfileDao.findByLoginName(loginName);
        String storedPassword = userProfile.getEncryptedPassword();

        if (passwordIsEncrypted) {
            if (!password.equals(storedPassword)) {
                throw new IncorrectPasswordException(loginName);
            }
        } else {
            if (!PasswordEncrypter.isClearPasswordCorrect(password,
                    storedPassword)) {
                throw new IncorrectPasswordException(loginName);
            }
        }
        
        return userProfile;
    }

	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String loginName)
			throws UsernameNotFoundException, org.springframework.dao.DataAccessException {
		       
        UserProfile userProfile = null;
		        
        try {
        	userProfile = userProfileDao.findByLoginName(loginName);
        } catch (InstanceNotFoundException e) {
        	e.printStackTrace();
        	throw new UsernameNotFoundException("No user with loginName '" + loginName + "' found!");
        	
        }
        
        if (userProfile==null) throw new UsernameNotFoundException("No user with loginName '" + loginName + "' found!");
        
    	List<GrantedAuthority> authorities = 
                buildUserAuthority(userProfile.getRole());
    	
        return new User(userProfile.getLoginName(),userProfile.getEncryptedPassword(), 
        		userProfile.getEnabled(),userProfile.getAccountNonExpired(),
        		userProfile.getCredentialsNonExpired(),userProfile.getAccountNonLocked(),authorities);       
	}	    
    
	private List<GrantedAuthority> buildUserAuthority(Role role) {			
		
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		setAuths.add(new SimpleGrantedAuthority(role.getRoleName()));
 
		List<GrantedAuthority> result = new ArrayList<GrantedAuthority>(setAuths);
		
		return result;
	}	
	
    @Transactional(readOnly = true)
    public UserProfile findUserProfile(Long userProfileId)
            throws InstanceNotFoundException {

        return userProfileDao.find(userProfileId);
    }

    public void updateUserProfileDetails(Long userProfileId,
            UserProfileDetails userProfileDetails)
            throws InstanceNotFoundException {

        UserProfile userProfile = userProfileDao.find(userProfileId);
        userProfile.setFirstName(userProfileDetails.getFirstName());
        userProfile.setSurname1(userProfileDetails.getSurname1());
        userProfile.setSurname2(userProfileDetails.getSurname2());        
        userProfile.setEmail(userProfileDetails.getEmail());

    }

    public void changePassword(Long userProfileId, String oldClearPassword,
            String newClearPassword) throws IncorrectPasswordException,
            InstanceNotFoundException {

        UserProfile userProfile;
        userProfile = userProfileDao.find(userProfileId);

        String storedPassword = userProfile.getEncryptedPassword();

        if (!PasswordEncrypter.isClearPasswordCorrect(oldClearPassword,
                storedPassword)) {
            throw new IncorrectPasswordException(userProfile.getLoginName());
        }

        userProfile.setEncryptedPassword(PasswordEncrypter
                .crypt(newClearPassword));

    }

	@Override
	public void removeUser(Long userProfileId, boolean enabled)
			throws InstanceNotFoundException {

		UserProfile userProfile = userProfileDao.find(userProfileId);
		userProfile.setEnabled(enabled);			
	}

	@Override
	public void blockUser(Long userProfileId, boolean accountNonExpired)
			throws InstanceNotFoundException {

		UserProfile userProfile = userProfileDao.find(userProfileId);
		userProfile.setAccountNonExpired(accountNonExpired);
	}

	@Override
	public UserProfile findUserProfileByLogin(String loginName)
			throws InstanceNotFoundException {

		return userProfileDao.findByLoginName(loginName);		
	}

	@Override
	public String findUserLoginByProfileId(Long userProfileId)
			throws InstanceNotFoundException {
		
		return userProfileDao.find(userProfileId).getLoginName();
	}		
	
	@Override
	public void assignCompanyUserProfile(UserProfile userProfile,
			Company company) throws InstanceNotFoundException {
		
		userProfile.setCompany(company);
	}

	@Override
	public void assignRoleUserProfile(UserProfile userProfile, Role role)
			throws InstanceNotFoundException {
		
		userProfile.setRole(role);
	}

	@Override	
	public UserProfileBlock getEmployeeByFirstName(String firstName,
			int startIndex, int count) throws InstanceNotFoundException {
		
		List<UserProfile> userProfiles = userProfileDao.findByFirstName(firstName, startIndex, count + 1);
		
		boolean existMoreUserProfiles = userProfiles.size() == (count + 1);
		
		return new UserProfileBlock(userProfiles, existMoreUserProfiles);
	}

	@Override
	public UserProfileBlock getEmployeeBySurname1(String surname1, 
			int startIndex, int count) throws InstanceNotFoundException {

		List<UserProfile> userProfiles = userProfileDao.findBySurname1(surname1, startIndex, count + 1);
		
		boolean existMoreUserProfiles = userProfiles.size() == (count + 1);
		
		return new UserProfileBlock(userProfiles, existMoreUserProfiles);	
	}
	
	@Override
	public UserProfileBlock getEmployeeBySurname2(String surname2, 
			int startIndex, int count) throws InstanceNotFoundException {

		List<UserProfile> userProfiles = userProfileDao.findBySurname2(surname2, startIndex, count + 1);
		
		boolean existMoreUserProfiles = userProfiles.size() == (count + 1);
		
		return new UserProfileBlock(userProfiles, existMoreUserProfiles);	
	}	

	@Override
	public Company createCompany(String companyName, Date date)
			throws DuplicateInstanceException {

		try {
			companyDao.findByName(companyName);
			throw new DuplicateInstanceException(companyName, Company.class.getName());
		} catch (InstanceNotFoundException e) { 						
			Company company = new Company(companyName, date);			
			companyDao.save(company);			
			return company;
		}
	}

	@Override
	public Company saveCompany(Company company)
			throws DuplicateInstanceException {

		try {
			companyDao.findByName(company.getCompanyName());
			throw new DuplicateInstanceException(company.getCompanyName(), Company.class.getName());
		} catch (InstanceNotFoundException e) { 						
			companyDao.save(company);
			
			return company;
		}
	}
		
	@Override
	public void updateCompany(Long companyId, String companyName, Date date) 
			throws InstanceNotFoundException {
		
		Company company = companyDao.find(companyId);
		company.setCompanyName(companyName);
		company.setDate(date);
	}
	
	@Override
	public void removeCompany(Long companyId) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional(readOnly = true)
	public Company findCompany(Long companyId) throws InstanceNotFoundException {				
		return companyDao.find(companyId);
	}

	@Override
	@Transactional(readOnly = true)
	public Company findCompanyByName(String companyName) 
			throws InstanceNotFoundException {
		
		return companyDao.findByName(companyName);		
	}
	
	@Override
	public CompanyBlock getCompanies(int startIndex, int count)
			throws InstanceNotFoundException {

		List<Company> companies = companyDao.findCompanies(startIndex, count + 1);
		
		boolean existMoreCompanies = companies.size() == (count + 1);
		
		return new CompanyBlock(companies, existMoreCompanies);
		
	}	
	
	@Override
	public UserProfileBlock getEmployeesByCompanyId(Long companyId,
			int startIndex, int count) throws InstanceNotFoundException {

		List<UserProfile> userProfiles = userProfileDao.findByCompany(companyId, startIndex, count + 1);
		
		boolean existMoreUserProfiles = userProfiles.size() == (count + 1);
		
		return new UserProfileBlock(userProfiles, existMoreUserProfiles);			
	}	

	@Override
	public UserProfileBlock getEmployeeByRoleId(Long roleId,
			int startIndex, int count) throws InstanceNotFoundException {
		
		List<UserProfile> userProfiles = userProfileDao.findByCompany(roleId, startIndex, count + 1);
		
		boolean existMoreUserProfiles = userProfiles.size() == (count + 1);
		
		return new UserProfileBlock(userProfiles, existMoreUserProfiles);	
	}	
	
	@Override
	public Role registerRole(String roleName, UserProfile userProfile, Long weight) throws DuplicateInstanceException {
		
		try {
			roleDao.findByName(roleName);
			throw new DuplicateInstanceException(roleName, Role.class.getName()); 
		} catch (InstanceNotFoundException e) { 
			Calendar calendar = Calendar.getInstance();
			Date timestamp = new Date(calendar.getTime().getTime()); 			
			Role role = new Role(roleName, timestamp, userProfile, weight);
			roleDao.save(role);
			return role;
		}
	}

	@Override
	@Transactional(readOnly = true)	
	public Role findRole(Long roleId) throws InstanceNotFoundException {
		return roleDao.find(roleId);
	}

	@Override
	public void removeRole(Long roleId) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateRole(Long roleId, String roleName, Date date,
			UserProfile userProfile, Long weight) throws InstanceNotFoundException {

		Role role = roleDao.find(roleId);
		role.setRoleName(roleName);
		role.setDate(date);
		role.setUserProfile(userProfile);
		role.setWeight(weight);
	}

	@Override
	public Module registerModule(String moduleName) throws DuplicateInstanceException {

		try {
			moduleDao.findByName(moduleName);
			throw new DuplicateInstanceException(moduleName, Module.class.getName()); 
		} catch (InstanceNotFoundException e) { 
			Calendar calendar = Calendar.getInstance();
			Date timestamp = new Date(calendar.getTime().getTime()); 			
			Module module = new Module(moduleName, timestamp);
			moduleDao.save(module);
			return module;
		}
	}

	@Override
	@Transactional(readOnly = true)		
	public Module findModule(Long moduleId) throws InstanceNotFoundException {
		return moduleDao.find(moduleId);
	}

	@Override
	public void removeModule(Long moduleId) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateModule(Long moduleId, String moduleName, Date date)
			throws InstanceNotFoundException {

		Module module = moduleDao.find(moduleId);
		module.setModuleName(moduleName);
		module.setDate(date);
	}

	@Override
	public RoleModuleAccess registerRoleModuleAccess(Role role, Module module, Type type) throws DuplicateInstanceException {

		try {
			roleModuleAccessDao.findById(role.getRoleId(),module.getModuleId());
			throw new DuplicateInstanceException(role.getRoleName()+module.getModuleName(), RoleModuleAccess.class.getName()); 
		} catch (InstanceNotFoundException e) { 
			RoleModuleAccess roleModuleAccess = new RoleModuleAccess();
			roleModuleAccess.setModule(module);
			roleModuleAccess.setRole(role);
			roleModuleAccess.setType(type);
			roleModuleAccessDao.save(roleModuleAccess);
			return roleModuleAccess;
		}		
	}

	@Override
	public void updateRoleModuleAccess(RoleModuleAccessId roleModuleAccessId, Type type) throws InstanceNotFoundException {
		
	}

	@Override
	public RoleModuleAccess removeRoleModuleAccess() throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoleModuleAccess checkRoleModuleAccess()	throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role findRoleByName(String roleName) throws InstanceNotFoundException {
		
		return roleDao.findByName(roleName);
		
	}

	@Override
	public Module findModuleByName(String moduleName) throws InstanceNotFoundException {

		return moduleDao.findByName(moduleName);	
	}

	@Override
	public Module saveModule(Module module) throws DuplicateInstanceException {

		moduleDao.save(module);
        
		return module;
	}

	@Override
	public UserProfileBlock getUserProfiles(int startIndex, int count)
			throws InstanceNotFoundException {

		List<UserProfile> userProfiles = userProfileDao.getUserProfiles(startIndex, count + 1);
		
		boolean existMoreUserProfiles = userProfiles.size() == (count +1);
		
		return new UserProfileBlock(userProfiles, existMoreUserProfiles);
	}

	@Override
	public Role saveRole(Role role) throws DuplicateInstanceException {
		
		roleDao.save(role);
		
		return role;
	}

	@Override
	public RoleBlock getRoles(int startIndex, int count)
			throws InstanceNotFoundException {

		List<Role> roles = roleDao.getRoles(startIndex, count + 1);
		
		boolean existMoreRoles = roles.size() == (count +1);
		
		return new RoleBlock(roles, existMoreRoles);
	}

}
