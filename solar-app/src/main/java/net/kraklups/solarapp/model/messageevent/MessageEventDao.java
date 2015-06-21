package net.kraklups.solarapp.model.messageevent;

import java.util.List;

import net.kraklups.modelutil.dao.GenericDao;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;

public interface MessageEventDao extends GenericDao<MessageEvent, Long> {
	
    /**
     * Returns a MessageEvent using the eventTskId (
     *
     * @param eventTskId not the module identifier
     * @return list of MessageEvent
     */			
     
     public List<MessageEvent> getMessageEventsByEventTskId(Long eventTskId, int startIndex, int count) 
            throws InstanceNotFoundException; 	

 	public List<MessageEvent> getMessageEvents(int startIndex, int count)
			throws InstanceNotFoundException;     
     
}
