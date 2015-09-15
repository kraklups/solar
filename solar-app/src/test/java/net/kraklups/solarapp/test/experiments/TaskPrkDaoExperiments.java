package net.kraklups.solarapp.test.experiments;

import java.util.Calendar;
import java.util.Date;

import org.hibernate.Transaction;

import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.park.Park;
import net.kraklups.solarapp.model.role.Role;
import net.kraklups.solarapp.model.taskprk.TaskPrk;
import net.kraklups.solarapp.model.taskprk.TaskPrkDao;
import net.kraklups.solarapp.model.taskprk.TaskPrkDaoHibernate;
import net.kraklups.solarapp.model.userprofile.UserProfile;

public class TaskPrkDaoExperiments {

	public static void main(String[] args) {
		
		TaskPrkDaoHibernate taskPrkDaoHibernate = new TaskPrkDaoHibernate();
		taskPrkDaoHibernate.setSessionFactory(HibernateUtil
				.getSessionFactory());
		TaskPrkDao taskPrkDao = taskPrkDaoHibernate;
		
		Transaction tx = HibernateUtil.getSessionFactory().getCurrentSession()
				.beginTransaction();
		
		try {
			
			// Register taskPrk
			//String taskName, Date creationDate, Park park, Role role, UserProfile userProfile
			
			Calendar calendar = Calendar.getInstance();
			Date timestamp = new Date(calendar.getTime().getTime());
			Park park = new Park();
			Role role = new Role();
			UserProfile userProfile = new UserProfile();
			
			TaskPrk taskPrk = new TaskPrk("trosmaville",timestamp, park, role, userProfile);
			
			taskPrkDao.save(taskPrk);
			Long taskPrkId = taskPrk.getTaskPrkId();
			System.out.println("TaskPrk with taskPrkId '" + taskPrkId
					+ "' has been created");
			System.out.println(taskPrk);
			
			// Find taskPrk.
			taskPrk = taskPrkDao.find(taskPrkId);
			System.out.println("User with userId '" + taskPrkId
					+ "' has been retrieved");
			System.out.println(taskPrk);			
						
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
