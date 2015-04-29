package net.kraklups.solarapp.model.eventtsk;

import java.util.List;

import net.kraklups.modelutil.dao.GenericDao;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;

public interface EventTskDao extends GenericDao<EventTsk, Long> {
	
	public List<EventTsk> getEventTsksByTimetableId(Long timetableId, int startIndex, int count)
			throws InstanceNotFoundException;
	
	public List<EventTsk> getEventTsksByTaskPrkId(Long taskPrkId, int startIndex, int count)
			throws InstanceNotFoundException;
	
	public List<EventTsk> getEventTsks(int startIndex, int count)
			throws InstanceNotFoundException;	
	
}
