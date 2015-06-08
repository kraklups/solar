package net.kraklups.solarapp.test.experiments;

import java.util.Calendar;
import java.util.Date;

import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.park.Park;
import net.kraklups.solarapp.model.role.Role;
import net.kraklups.solarapp.model.taskprk.Synchronize;
import net.kraklups.solarapp.model.taskprk.TaskPrk;
import net.kraklups.solarapp.model.taskprk.TaskPrkDao;
import net.kraklups.solarapp.model.taskprk.TaskPrkDaoHibernate;
import net.kraklups.solarapp.model.userprofile.UserProfile;

import org.hibernate.Transaction;

public class SynchronizeDaoExperiments {

	public static void main(String[] args) {
		
		TaskPrkDaoHibernate taskPrkDaoHibernate = new TaskPrkDaoHibernate();
		taskPrkDaoHibernate.setSessionFactory(HibernateUtil
				.getSessionFactory());
		TaskPrkDao taskPrkDao = taskPrkDaoHibernate;
		
		Transaction tx = HibernateUtil.getSessionFactory().getCurrentSession()
				.beginTransaction();
		
		try {
			
			// Register Synchronize			
			
			Calendar calendar = Calendar.getInstance();
			Date timestamp = new Date(calendar.getTime().getTime());
			Park park = new Park();
			Role role = new Role();
			UserProfile userProfile = new UserProfile();			
			
			Synchronize synchronize = (Synchronize) new TaskPrk("trosmaville",timestamp, park, role, userProfile);
			
			taskPrkDao.save(synchronize);
			Long synchronizeId = synchronize.getSynchronizeId();
			System.out.println("Synchronize with synchronizeId '" + synchronizeId
					+ "' has been created");
			System.out.println(synchronize);
			
			// Find taskPrk.
			synchronize = (Synchronize) taskPrkDao.find(synchronizeId);
			System.out.println("User with userId '" + synchronizeId
					+ "' has been retrieved");
			System.out.println(synchronize);			
						
			// ... no more cases/entities/methods			
			
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
