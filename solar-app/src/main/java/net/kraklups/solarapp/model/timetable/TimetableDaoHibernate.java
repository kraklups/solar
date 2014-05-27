package net.kraklups.solarapp.model.timetable;

import net.kraklups.modelutil.dao.GenericDaoHibernate;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.timetable.Timetable;
import net.kraklups.solarapp.model.timetable.TimetableDao;

import org.springframework.stereotype.Repository;

@Repository("calendarDao")
public class TimetableDaoHibernate extends 
	GenericDaoHibernate<Timetable, Long> implements TimetableDao{

}
