package net.kraklups.solarapp.test.experiments;

import org.hibernate.Transaction;

import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.taskprk.TaskPrkDao;
import net.kraklups.solarapp.model.taskprk.TaskPrkDaoHibernate;
import net.kraklups.solarapp.model.taskprk.Upkeep;

public class UpkeepDaoExperiments {

	public static void main(String[] args) {
		
		TaskPrkDaoHibernate taskPrkDaoHibernate = new TaskPrkDaoHibernate();
		taskPrkDaoHibernate.setSessionFactory(HibernateUtil
				.getSessionFactory());
		TaskPrkDao taskPrkDao = taskPrkDaoHibernate;
		
		Transaction tx = HibernateUtil.getSessionFactory().getCurrentSession()
				.beginTransaction();
		
		try {
			
			// Register Upkeep			
			
			Upkeep upkeep = new Upkeep();
			
			taskPrkDao.save(upkeep);
			Long upkeepId = upkeep.getUpkeepId();
			System.out.println("Upkeep with upkeepId '" + upkeepId
					+ "' has been created");
			System.out.println(upkeep);
			
			// Find taskPrk.
			upkeep = (Upkeep) taskPrkDao.find(upkeepId);
			System.out.println("User with userId '" + upkeepId
					+ "' has been retrieved");
			System.out.println(upkeep);			
						
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
