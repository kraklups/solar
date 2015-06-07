package net.kraklups.solarapp.test.experiments;

import org.hibernate.Transaction;

import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.timetable.Timetable;
import net.kraklups.solarapp.model.timetable.TimetableDao;
import net.kraklups.solarapp.model.timetable.TimetableDaoHibernate;

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

			Timetable timetable = new Timetable();
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
