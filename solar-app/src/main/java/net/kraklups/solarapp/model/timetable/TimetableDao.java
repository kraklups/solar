package net.kraklups.solarapp.model.timetable;

import net.kraklups.modelutil.dao.GenericDao;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;


public interface TimetableDao extends GenericDao<Timetable, Long> {
    /**
     * Returns a Calendar using the calendar id 
     *
     * @param calendarId
     * @return the Calendar
     */			
	
}
