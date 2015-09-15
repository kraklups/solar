package net.kraklups.solarapp.model.messageevent;

import java.util.List;

import net.kraklups.modelutil.dao.GenericDaoHibernate;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;

import net.kraklups.solarapp.model.messageevent.MessageEvent;
import net.kraklups.solarapp.model.messageevent.MessageEventDao;

import org.springframework.stereotype.Repository;

@Repository("messageDao")
public class MessageEventDaoHibernate extends 
		GenericDaoHibernate<MessageEvent, Long> implements MessageEventDao{

	@Override
	@SuppressWarnings("unchecked")
	public List<MessageEvent> getMessageEventsByEventTskId(Long eventTskId,
			int startIndex, int count) throws InstanceNotFoundException {
		
		List<MessageEvent> messageEvents = (List<MessageEvent>)  getSession().createQuery(
	        	"SELECT a FROM MessageEvent a WHERE a.eventTskId = :eventTskId " +
	        	"ORDER BY a.messageEventId").
	         	setParameter("eventTskId", eventTskId).
	           	setFirstResult(startIndex).
	           	setMaxResults(count).list();
		
		if (messageEvents == null) {
			throw new InstanceNotFoundException(eventTskId, MessageEvent.class.getName());
		} else {
			return messageEvents;
		}		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<MessageEvent> getMessageEvents(int startIndex, int count)
			throws InstanceNotFoundException {

		List<MessageEvent> messageEvents = (List<MessageEvent>)  getSession().createQuery(
	        	"SELECT a FROM MessageEvent a  " +
	        	"ORDER BY a.messageEventId").
	           	setFirstResult(startIndex).
	           	setMaxResults(count).list();
		
		if (messageEvents == null) {
			throw new InstanceNotFoundException(null, MessageEvent.class.getName());
		} else {
			return messageEvents;
		}	
	}

}
