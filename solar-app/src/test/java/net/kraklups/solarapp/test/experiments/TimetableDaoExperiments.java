package net.kraklups.solarapp.test.experiments;

import java.util.Calendar;
import java.util.Date;

import org.hibernate.Transaction;

import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.park.Park;
import net.kraklups.solarapp.model.timetable.Timetable;
import net.kraklups.solarapp.model.timetable.TimetableDao;
import net.kraklups.solarapp.model.timetable.TimetableDaoHibernate;
import net.kraklups.solarapp.model.userprofile.UserProfile;

public class TimetableDaoExperiments {

	public static void main(String[] args) {
		
		TimetableDaoHibernate timetableDaoHibernate = new TimetableDaoHibernate();
		timetableDaoHibernate.setSessionFactory(HibernateUtil
				.getSessionFactory());
		TimetableDao timetableDao = timetableDaoHibernate;
		
		Transaction tx = HibernateUtil.getSessionFactory().getCurrentSession()
				.beginTransaction();
		
		try {
			
			// Register timetable
			// String timetableTag, UserProfile userProfile, Date tvi, Park park

			Calendar calendar = Calendar.getInstance();
			Date timestamp = new Date(calendar.getTime().getTime());
			UserProfile userProfile = new UserProfile();
			Park park = new Park();
			
			Timetable timetable = new Timetable("farleyo27", userProfile, timestamp, park);
			
			timetableDao.save(timetable);
			Long timetableId = timetable.getTimetableId();
			System.out.println("Timetable with timetableId '" + timetableId
					+ "' has been created");
			System.out.println(timetable);

			// Find timetable.
			timetable = timetableDao.find(timetableId);
			System.out.println("User with userId '" + timetableId
					+ "' has been retrieved");
			System.out.println(timetable);			
						
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
