package net.kraklups.solarapp.test.experiments;

import org.hibernate.Transaction;

import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.taskprk.TaskPrk;
import net.kraklups.solarapp.model.taskprk.TaskPrkDao;
import net.kraklups.solarapp.model.taskprk.TaskPrkDaoHibernate;

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

			TaskPrk taskPrk = new TaskPrk();
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
