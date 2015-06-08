package net.kraklups.solarapp.test.experiments;

import java.util.Calendar;
import java.util.Date;

import org.hibernate.Transaction;

import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.company.Company;
import net.kraklups.solarapp.model.park.Park;
import net.kraklups.solarapp.model.park.ParkDao;
import net.kraklups.solarapp.model.park.ParkDaoHibernate;
import net.kraklups.solarapp.model.userprofile.UserProfile;

public class ParkDaoExperiments {

	public static void main(String[] args) {
		
		ParkDaoHibernate parkDaoHibernate = new ParkDaoHibernate();
		parkDaoHibernate.setSessionFactory(HibernateUtil
				.getSessionFactory());
		ParkDao parkDao = parkDaoHibernate;
		
		Transaction tx = HibernateUtil.getSessionFactory().getCurrentSession()
				.beginTransaction();
		
		try {
			
			// Register park
			//String parkName, Date startupDate, Date productionDate, UserProfile userProfile, 
			//Company company, MultiPolygon mapPark

			Calendar calendar = Calendar.getInstance();
			Date timestamp = new Date(calendar.getTime().getTime());
			
			UserProfile userProfile = new UserProfile();
			Company company = new Company();
			
			Park park = new Park("farleyopark", timestamp, timestamp, userProfile, company, null);
			
			parkDao.save(park);
			Long parkId = park.getParkId();
			System.out.println("Park with parkId '" + parkId
					+ "' has been created");
			System.out.println(park);
			
			// Find park.
			park = parkDao.find(parkId);
			System.out.println("User with userId '" + parkId
					+ "' has been retrieved");
			System.out.println(park);			
			
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
