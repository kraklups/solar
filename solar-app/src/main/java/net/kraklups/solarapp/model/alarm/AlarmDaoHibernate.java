package net.kraklups.solarapp.model.alarm;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import net.kraklups.modelutil.dao.GenericDaoHibernate;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;

import org.springframework.stereotype.Repository;

@Repository("alarmDao")
public class AlarmDaoHibernate extends 
		GenericDaoHibernate<Alarm, Long> implements AlarmDao {

	@Override
	@SuppressWarnings("unchecked")
	public List<Alarm> getAlarmsByAlarmTag(String alarmTag, int startIndex,
			int count) throws InstanceNotFoundException {
		
		List<Alarm> alarms = (List<Alarm>)  getSession().createQuery(
	        	"SELECT a FROM Alarm a WHERE a.alarmTag LIKE :alarmTag " +
	        	"ORDER BY a.alarmId").
	         	setParameter("alarmTag", alarmTag).
	           	setFirstResult(startIndex).
	           	setMaxResults(count).list();
		
		if (alarms == null) {
			throw new InstanceNotFoundException(alarmTag, Alarm.class.getName());
		} else {
			return alarms;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Alarm> getAlarmsByTriggerDate(Date triggerDate,
			int startIndex, int count) throws InstanceNotFoundException {
		
		List<Alarm> alarms = (List<Alarm>)  getSession().createQuery(
	        	"SELECT a FROM Alarm a WHERE a.triggerDate = :triggerDate " +
	        	"ORDER BY a.alarmId").
	         	setParameter("triggerDate", triggerDate).
	           	setFirstResult(startIndex).
	           	setMaxResults(count).list();
		
		if (alarms == null) {
			throw new InstanceNotFoundException(triggerDate, Alarm.class.getName());
		} else {
			return alarms;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Alarm> getAlarmsByEventTskId(Long eventTskId, int startIndex,
			int count) throws InstanceNotFoundException {
		
		List<Alarm> alarms = (List<Alarm>)  getSession().createQuery(
	        	"SELECT a FROM Alarm a WHERE a.eventTskId = :eventTskId " +
	        	"ORDER BY a.alarmId").
	         	setParameter("eventTskId", eventTskId).
	           	setFirstResult(startIndex).
	           	setMaxResults(count).list();
		
		if (alarms == null) {
			throw new InstanceNotFoundException(eventTskId, Alarm.class.getName());
		} else {
			return alarms;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Alarm> getAlarms(int startIndex, int count)
			throws InstanceNotFoundException {

		List<Alarm> alarms = (List<Alarm>)  getSession().createQuery(
	        	"SELECT a FROM Alarm a " +
	        	"ORDER BY a.alarmId").
	           	setFirstResult(startIndex).
	           	setMaxResults(count).list();
		
		if (alarms == null) {
			throw new InstanceNotFoundException(null, Alarm.class.getName());
		} else {
			return alarms;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Alarm> getAlarmsTriggered(int startIndex, int count)
			throws InstanceNotFoundException {
		
	
		Calendar calendar = Calendar.getInstance();		
		Date timestamp = new Date(calendar.getTime().getTime() - (5 * 1000L));
		
		List<Alarm> alarms = (List<Alarm>)  getSession().createQuery(
	        	"SELECT a FROM Alarm a WHERE a.triggerDate > :timestamp " +
	        	"ORDER BY a.alarmId").
	        	setParameter("timestamp", timestamp).
	           	setFirstResult(startIndex).
	           	setMaxResults(count).list();
		
		if (alarms == null) {
			return null;
		} else {
			return alarms;
		}	}

}
