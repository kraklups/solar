package net.kraklups.solarapp.model.userprofile;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.kraklups.modelutil.dao.GenericDaoHibernate;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;

@Repository("userProfileDao")
public class UserProfileDaoHibernate extends
		GenericDaoHibernate<UserProfile, Long> implements UserProfileDao {

	@Override
	public UserProfile findByLoginName(String loginName) 
			throws InstanceNotFoundException {

    	UserProfile userProfile = (UserProfile) getSession().createQuery(
    			"SELECT u FROM UserProfile u WHERE u.loginName = :loginName")
    			.setParameter("loginName", loginName)
    			.uniqueResult();
    	if (userProfile == null) {
   			throw new InstanceNotFoundException(loginName, UserProfile.class.getName());
    	} else {
    		return userProfile;
    	}
	}

	@Override	
	public String getUserLoginByProfileId(Long userProfileId)
			throws InstanceNotFoundException {
		
    	String loginName = (String) getSession().createQuery(
    			"SELECT loginName FROM UserProfile u WHERE u.userProfileId = :userProfileId")
    			.setParameter("userProfileId", userProfileId)
    			.uniqueResult();
    	if (loginName == null) {
   			throw new InstanceNotFoundException(loginName, UserProfile.class.getName());
    	} else {
    		return loginName;
    	}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<UserProfile> findByFirstName(String firstName, int startIndex, int count) 
			throws InstanceNotFoundException {
		
		List <UserProfile> userProfiles = getSession().createQuery(
            	"SELECT a FROM UserProfile a WHERE a.firstName = :firstName " +
            	"ORDER BY a.userProfileId").
             	setParameter("firstName", firstName).
               	setFirstResult(startIndex).
               	setMaxResults(count).list();
		
		if (userProfiles == null) {
			throw new InstanceNotFoundException(firstName, UserProfile.class.getName());
		} else {
			return userProfiles;
		}	        
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<UserProfile> findBySurname1(String surname1, int startIndex, int count) 
			throws InstanceNotFoundException {
		
		List <UserProfile> userProfiles =  getSession().createQuery(
            	"SELECT a FROM UserProfile a WHERE a.surname1 = :surname1 " +
            	"ORDER BY a.userProfileId").
             	setParameter("surname1", surname1).
               	setFirstResult(startIndex).
               	setMaxResults(count).list();
		
		if (userProfiles == null) {
			throw new InstanceNotFoundException(surname1, UserProfile.class.getName());
		} else {
			return userProfiles;
		}	 		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<UserProfile> findBySurname2(String surname2, int startIndex, int count) 
			throws InstanceNotFoundException {
		
		List <UserProfile> userProfiles = getSession().createQuery(
            	"SELECT a FROM UserProfile a WHERE a.surname2 = :surname2 " +
            	"ORDER BY a.userProfileId").
             	setParameter("surname2", surname2).
               	setFirstResult(startIndex).
               	setMaxResults(count).list();
		
		if (userProfiles == null) {
			throw new InstanceNotFoundException(surname2, UserProfile.class.getName());
		} else {
			return userProfiles;
		}	 		
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<UserProfile> findByRole(Long roleId, int startIndex, int count) 
			throws InstanceNotFoundException {
		
		List <UserProfile> userProfiles = getSession().createQuery(
            	"SELECT a FROM UserProfile a WHERE a.roleId = :roleId " +
            	"ORDER BY a.userProfileId").
             	setParameter("roleId", roleId).
               	setFirstResult(startIndex).
               	setMaxResults(count).list();
		
		if (userProfiles == null) {
			throw new InstanceNotFoundException(roleId, UserProfile.class.getName());
		} else {
			return userProfiles;
		}	 				
	}	
	
	@Override
	@SuppressWarnings("unchecked")
	public List<UserProfile> findByCompany(Long companyId, int startIndex, int count) 
			throws InstanceNotFoundException {
		
		List <UserProfile> userProfiles = getSession().createQuery(
            	"SELECT a FROM UserProfile a WHERE a.companyId = :companyId " +
            	"ORDER BY a.userProfileId").
             	setParameter("companyId", companyId).
               	setFirstResult(startIndex).
               	setMaxResults(count).list();
		
		if (userProfiles == null) {
			throw new InstanceNotFoundException(companyId, UserProfile.class.getName());
		} else {
			return userProfiles;
		}			
	}

	@Override
	@SuppressWarnings("unchecked")	
	public List<UserProfile> getUserProfiles(int startIndex, int count)
			throws InstanceNotFoundException {

		List<UserProfile> userProfiles = (List<UserProfile>)  getSession().createQuery(
	        	"SELECT a FROM UserProfile a  " +
	        	"ORDER BY a.userProfileId").
	           	setFirstResult(startIndex).
	           	setMaxResults(count).list();
		
		if (userProfiles == null) {
			throw new InstanceNotFoundException(null, UserProfile.class.getName());
		} else {
			return userProfiles;
		}
	}		
	
}