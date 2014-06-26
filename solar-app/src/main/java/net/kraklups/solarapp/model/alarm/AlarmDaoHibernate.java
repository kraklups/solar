package net.kraklups.solarapp.model.alarm;

import net.kraklups.modelutil.dao.GenericDaoHibernate;

import org.springframework.stereotype.Repository;

@Repository("alarmDao")
public class AlarmDaoHibernate extends 
		GenericDaoHibernate<Alarm, Long> implements AlarmDao {

}
