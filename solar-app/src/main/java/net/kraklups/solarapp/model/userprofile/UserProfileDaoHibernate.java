package net.kraklups.solarapp.model.userprofile;

import org.springframework.stereotype.Repository;

import net.kraklups.modelutil.dao.GenericDaoHibernate;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;

@Repository("userProfileDao")
public class UserProfileDaoHibernate extends
		GenericDaoHibernate<UserProfile, Long> implements UserProfileDao {

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

}