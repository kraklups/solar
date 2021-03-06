package net.kraklups.solarapp.test.experiments;

import java.util.Calendar;
import java.util.Date;

import org.hibernate.Transaction;

import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.eventtsk.EventTsk;
import net.kraklups.solarapp.model.eventtsk.EventTskDao;
import net.kraklups.solarapp.model.eventtsk.EventTskDaoHibernate;
import net.kraklups.solarapp.model.taskprk.TaskPrk;
import net.kraklups.solarapp.model.timetable.Timetable;

public class EventTskDaoExperiments {

	public static void main(String[] args) {
		
		EventTskDaoHibernate eventTskDaoHibernate = new EventTskDaoHibernate();
		eventTskDaoHibernate.setSessionFactory(HibernateUtil
				.getSessionFactory());
		EventTskDao eventTskDao = eventTskDaoHibernate;
		
		Transaction tx = HibernateUtil.getSessionFactory().getCurrentSession()
				.beginTransaction();
		
		try {
			
			// Register eventTsk
			//String tagET, String definitionET, Date tvi, Date tvf,  
			//TaskPrk taskPrk, Timetable timetable, Boolean triggerAlarm, Boolean triggerMessage
			
			Calendar calendar = Calendar.getInstance();
			Date timestamp = new Date(calendar.getTime().getTime());			

			TaskPrk taskPrk = new TaskPrk();
			
			Timetable timetable = new Timetable();
			
			EventTsk eventTsk = new EventTsk("eventofarleyo", "tagfarleyo", timestamp, timestamp, 
					taskPrk, timetable, false, false);
			
			eventTskDao.save(eventTsk);
			Long eventTskId = eventTsk.getEventTskId();
			System.out.println("EventTsk with eventTskId '" + eventTskId
					+ "' has been created");
			System.out.println(eventTsk);
			
			// Find eventTsk.
			eventTsk = eventTskDao.find(eventTskId);
			System.out.println("User with userId '" + eventTskId
					+ "' has been retrieved");
			System.out.println(eventTsk);							
			
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
