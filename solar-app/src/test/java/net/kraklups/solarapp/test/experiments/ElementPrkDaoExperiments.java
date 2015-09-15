package net.kraklups.solarapp.test.experiments;

import java.util.Calendar;
import java.util.Date;

import org.hibernate.Transaction;

import net.kraklups.modelutil.exceptions.InstanceNotFoundException;

import net.kraklups.solarapp.model.datalogger.DataLogger;
import net.kraklups.solarapp.model.elementprk.ElementPrk;
import net.kraklups.solarapp.model.elementprk.ElementPrkDao;
import net.kraklups.solarapp.model.elementprk.ElementPrkDaoHibernate;
import net.kraklups.solarapp.model.park.Park;
import net.kraklups.solarapp.model.userprofile.UserProfile;

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
			//String elementPrkName, String elementPrkTag, Date tvi, Date lastAccess, 
			//UserProfile userProfile, DataLogger dataLogger, Park park

			Calendar calendar = Calendar.getInstance();
			Date timestamp = new Date(calendar.getTime().getTime());
			UserProfile userProfile = new UserProfile();
			DataLogger dataLogger = new DataLogger();
			Park park = new Park();
			
			ElementPrk elementPrk = new ElementPrk("ferlerguelo","froselado",timestamp,timestamp,userProfile,dataLogger,park,null);
			
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
