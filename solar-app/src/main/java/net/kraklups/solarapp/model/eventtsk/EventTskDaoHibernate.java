package net.kraklups.solarapp.model.eventtsk;

import java.util.List;

import net.kraklups.modelutil.dao.GenericDaoHibernate;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;

import net.kraklups.solarapp.model.eventtsk.EventTsk;
import net.kraklups.solarapp.model.eventtsk.EventTskDao;

import org.springframework.stereotype.Repository;

@Repository("eventTskDao")
public class EventTskDaoHibernate extends 
	GenericDaoHibernate<EventTsk, Long> implements EventTskDao {

	@Override
	@SuppressWarnings("unchecked")
	public List<EventTsk> getEventTsksByTimetableId(Long timetableId,
			int startIndex, int count) throws InstanceNotFoundException {
		
		List<EventTsk> eventTsks = (List<EventTsk>)  getSession().createQuery(
	        	"SELECT a FROM EventTsk a WHERE a.timetableId = :timetableId " +
	        	"ORDER BY a.eventTskId").
	         	setParameter("timetableId", timetableId).
	           	setFirstResult(startIndex).
	           	setMaxResults(count).list();
		
		if (eventTsks == null) {
			throw new InstanceNotFoundException(timetableId, EventTsk.class.getName());
		} else {
			return eventTsks;
		}		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<EventTsk> getEventTsksByTaskPrkId(Long taskPrkId,
			int startIndex, int count) throws InstanceNotFoundException {

		List<EventTsk> eventTsks = (List<EventTsk>)  getSession().createQuery(
	        	"SELECT a FROM EventTsk a WHERE a.taskPrkId = :taskPrkId " +
	        	"ORDER BY a.eventTskId").
	         	setParameter("taskPrkId", taskPrkId).
	           	setFirstResult(startIndex).
	           	setMaxResults(count).list();
		
		if (eventTsks == null) {
			throw new InstanceNotFoundException(taskPrkId, EventTsk.class.getName());
		} else {
			return eventTsks;
		}		

	}

}
