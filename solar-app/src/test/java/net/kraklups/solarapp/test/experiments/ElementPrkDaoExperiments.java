package net.kraklups.solarapp.test.experiments;

import org.hibernate.Transaction;

import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.elementprk.ElementPrk;
import net.kraklups.solarapp.model.elementprk.ElementPrkDao;
import net.kraklups.solarapp.model.elementprk.ElementPrkDaoHibernate;

public class ElementPrkDaoExperiments {

	public static void main(String[] args) {
		
		ElementPrkDaoHibernate elementPrkDaoHibernate = new ElementPrkDaoHibernate();
		elementPrkDaoHibernate.setSessionFactory(HibernateUtil
				.getSessionFactory());
		ElementPrkDao elementPrkDao = elementPrkDaoHibernate;
		
		Transaction tx = HibernateUtil.getSessionFactory().getCurrentSession()
				.beginTransaction();
		
		try {
			
			// Register elementPrk

			ElementPrk elementPrk = new ElementPrk();
			elementPrkDao.save(elementPrk);
			Long elementPrkId = elementPrk.getElementPrkId();
			System.out.println("ElementPrk with elementPrkId '" + elementPrkId
					+ "' has been created");
			System.out.println(elementPrk);

			// Find elementPrk.
			elementPrk = elementPrkDao.find(elementPrkId);
			System.out.println("User with userId '" + elementPrkId
					+ "' has been retrieved");
			System.out.println(elementPrk);			
						
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
