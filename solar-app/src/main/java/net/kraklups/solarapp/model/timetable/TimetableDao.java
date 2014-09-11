package net.kraklups.solarapp.model.timetable;

import java.util.List;

import net.kraklups.modelutil.dao.GenericDao;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;

public interface TimetableDao extends GenericDao<Timetable, Long> {

	public List<Timetable> getTimetablesByUserProfileId(Long userProfileId, int startIndex, int count)
			throws InstanceNotFoundException;	
	
	public List<Timetable> getTimetablesByParkId(Long parkId, int startIndex, int count)
			throws InstanceNotFoundException;		
	
}
