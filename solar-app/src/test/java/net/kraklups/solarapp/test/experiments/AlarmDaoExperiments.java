package net.kraklups.solarapp.test.experiments;

import java.util.Calendar;
import java.util.Date;

import org.hibernate.Transaction;

import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.alarm.Alarm;
import net.kraklups.solarapp.model.alarm.AlarmDao;
import net.kraklups.solarapp.model.alarm.AlarmDaoHibernate;
import net.kraklups.solarapp.model.eventtsk.EventTsk;

public class AlarmDaoExperiments {

	public static void main(String[] args) {
		
		AlarmDaoHibernate alarmDaoHibernate = new AlarmDaoHibernate();
		alarmDaoHibernate.setSessionFactory(HibernateUtil
				.getSessionFactory());
		AlarmDao alarmDao = alarmDaoHibernate;
		
		Transaction tx = HibernateUtil.getSessionFactory().getCurrentSession()
				.beginTransaction();
		
		try {
			
			// Register alarm
			//String alarmTag, Date triggerDate, EventTsk eventTsk
			
			Calendar calendar = Calendar.getInstance();
			Date timestamp = new Date(calendar.getTime().getTime());

			EventTsk eventTsk = new EventTsk();
			
			Alarm alarm = new Alarm("farleyero", timestamp, eventTsk);
			alarmDao.save(alarm);
			Long alarmId = alarm.getAlarmId();
			System.out.println("Alarm with alarmId '" + alarmId
					+ "' has been created");
			System.out.println(alarm);
			
			// Find alarm.
			alarm = alarmDao.find(alarmId);
			System.out.println("User with userId '" + alarmId
					+ "' has been retrieved");
			System.out.println(alarm);			
						
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
