package net.kraklups.solarapp.test.experiments;

import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.userprofile.UserProfile;
import net.kraklups.solarapp.model.userprofile.UserProfileDao;
import net.kraklups.solarapp.model.userprofile.UserProfileDaoHibernate;

import org.hibernate.Transaction;

public class UserProfileDaoExperiments {
	
	public static void main(String[] args) {

		UserProfileDaoHibernate userProfileDaoHibernate = new UserProfileDaoHibernate();
		userProfileDaoHibernate.setSessionFactory(HibernateUtil
				.getSessionFactory());
		UserProfileDao userProfileDao = userProfileDaoHibernate;

		Transaction tx = HibernateUtil.getSessionFactory().getCurrentSession()
				.beginTransaction();
		try {
			// Register user.
			UserProfile userProfile = new UserProfile();
			userProfileDao.save(userProfile);
			Long userId = userProfile.getUserProfileId();
			System.out.println("User with userId '" + userId
					+ "' has been created");
			System.out.println(userProfile);

			// Find user.
			userProfile = userProfileDao.find(userId);
			System.out.println("User with userId '" + userId
					+ "' has been retrieved");
			System.out.println(userProfile);
			
			// ... proceed in the same way for other entities / methods / use cases

			tx.commit();

		} catch (RuntimeException e) {
			e.printStackTrace();
			tx.rollback();
		} catch (InstanceNotFoundException e) {
			e.printStackTrace();
			tx.commit();
		} finally {
			HibernateUtil.getSessionFactory().getCurrentSession().close();
		}

		HibernateUtil.shutdown();

	}	

}
