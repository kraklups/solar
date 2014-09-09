package net.kraklups.solarapp.model.alarm;

import java.util.Calendar;
import java.util.List;

import net.kraklups.modelutil.dao.GenericDaoHibernate;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;

import org.springframework.stereotype.Repository;

@Repository("alarmDao")
public class AlarmDaoHibernate extends 
		GenericDaoHibernate<Alarm, Long> implements AlarmDao {

	@Override
	public List<Alarm> getAlarmsByAlarmTag(String alarmTag, int startIndex,
			int count) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Alarm> getAlarmsByTriggerDate(Calendar triggerDate,
			int startIndex, int count) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Alarm> getAlarmsByEventTskId(Long eventTskId, int startIndex,
			int count) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
