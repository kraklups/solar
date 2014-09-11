package net.kraklups.solarapp.model.timetable;

import java.util.List;

import net.kraklups.modelutil.dao.GenericDaoHibernate;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;

import net.kraklups.solarapp.model.timetable.Timetable;
import net.kraklups.solarapp.model.timetable.TimetableDao;

import org.springframework.stereotype.Repository;

@Repository("calendarDao")
public class TimetableDaoHibernate extends 
	GenericDaoHibernate<Timetable, Long> implements TimetableDao{

	@Override
	@SuppressWarnings("unchecked")
	public List<Timetable> getTimetablesByUserProfileId(Long userProfileId,
			int startIndex, int count) throws InstanceNotFoundException {

		List<Timetable> timetables = (List<Timetable>)  getSession().createQuery(
	        	"SELECT a FROM Timetable a WHERE a.userProfileId = :userProfileId " +
	        	"ORDER BY a.timetableId").
	         	setParameter("userProfileId", userProfileId).
	           	setFirstResult(startIndex).
	           	setMaxResults(count).list();
		
		if (timetables == null) {
			throw new InstanceNotFoundException(userProfileId, Timetable.class.getName());
		} else {
			return timetables;
		}		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Timetable> getTimetablesByParkId(Long parkId, int startIndex,
			int count) throws InstanceNotFoundException {
		
		List<Timetable> timetables = (List<Timetable>)  getSession().createQuery(
	        	"SELECT a FROM Timetable a WHERE a.parkId = :parkId " +
	        	"ORDER BY a.timetableId").
	         	setParameter("parkId", parkId).
	           	setFirstResult(startIndex).
	           	setMaxResults(count).list();
		
		if (timetables == null) {
			throw new InstanceNotFoundException(parkId, Timetable.class.getName());
		} else {
			return timetables;
		}		
	}

}
