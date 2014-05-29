package net.kraklups.solarapp.model.parkservice;

import java.util.Calendar;
import java.util.List;

import com.vividsolutions.jts.geom.MultiPolygon;

import net.kraklups.modelutil.exceptions.DuplicateInstanceException;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.alarm.Alarm;
import net.kraklups.solarapp.model.eventtsk.EventTsk;
import net.kraklups.solarapp.model.message.Message;
import net.kraklups.solarapp.model.park.Park;
import net.kraklups.solarapp.model.taskprk.TaskPrk;
import net.kraklups.solarapp.model.timetable.Timetable;
import net.kraklups.solarapp.model.userprofile.UserProfile;

public interface ParkService {

    public Park createPark(String parkName, Calendar startupDate, Calendar productionDate, String loginName, 
    		String company, MultiPolygon mapPark) throws DuplicateInstanceException;

    public void updatePark(Long parkId, String parkName, Calendar startupDate, Calendar productionDate, String loginName, 
    		String company, MultiPolygon mapPark) throws InstanceNotFoundException;

    public Park findParkByName(String parkName)
            throws InstanceNotFoundException;
	
    public void assignLoginNamePark(Park park, String loginName)
            throws InstanceNotFoundException;
    
    public void assignCompanyPark(Park park, String company)
            throws InstanceNotFoundException;    
    
    public void assignGISPark(Park park, MultiPolygon mapPark)
            throws InstanceNotFoundException;    
    
    public List<Park> getParksByLoginName(String loginName, int startIndex, int count) 
            throws InstanceNotFoundException;    
    
    public List<Park> getParksByCompany(String company, int startIndex, int count) 
            throws InstanceNotFoundException; 
    
    public Timetable createTimetable(String tag, UserProfile userProfile, Calendar tvi, Park park)
    		throws DuplicateInstanceException;
    
    public void updateTimetable(Long timetableId, String tag, UserProfile userProfile, Calendar tvi, Park park) 
    		throws InstanceNotFoundException; 
    
    public void assignParkTimetable(Park park, Timetable timetable)
    		throws InstanceNotFoundException;

    public void assignEventTskTimetable(EventTsk eventTsk, Timetable timetable)
    		throws InstanceNotFoundException;
    
    public void assignLoginTimetable(String login, Timetable timetable)
    		throws InstanceNotFoundException;  
    
    public void assignTviTimetable(Calendar tvi, Timetable timetable)
    		throws InstanceNotFoundException;
    
    public void assignTvfTimetable(Calendar tvf, Timetable timetable)
    		throws InstanceNotFoundException;
    
    public Park getParkByTimetable(Timetable timetable)
    		throws InstanceNotFoundException;  
    
    public EventTsk createEventTsk(String tagET, String definitionET, Calendar tvi, Calendar tvf, 
            TaskPrk taskPrk, Message message, Alarm alarm)
            throws DuplicateInstanceException;

    public void updateTimetable(Long eventTaskId, String tagET, String definitionET, Calendar tvi, Calendar tvf, 
            TaskPrk taskPrk, Message message, Alarm alarm) 
            throws InstanceNotFoundException; 
    
    public void assignTviEventTsk(Calendar tvi, EventTsk eventTsk)
    		throws InstanceNotFoundException;

    public void assignTvfEventTsk(Calendar tvf, EventTsk eventTsk)
    		throws InstanceNotFoundException;

    public Message getMessageByEventTsk(EventTsk eventTsk)
			throws InstanceNotFoundException;  
    
    public Alarm getAlarmByEventTsk(EventTsk eventTsk)
			throws InstanceNotFoundException;
    
    public TaskPrk getTaskPrkByEventTsk(EventTsk eventTsk)
			throws InstanceNotFoundException;    

	public void assignTaskPrkEventTsk(TaskPrk taskPrk, EventTsk eventTsk)
			throws InstanceNotFoundException;

	public void assignMessageEventTsk(Message message, EventTsk eventTsk)
			throws InstanceNotFoundException;

	public void assignAlarmEventTsk(Alarm alarm, EventTsk eventTsk)
			throws InstanceNotFoundException;
    
    public Message createMessage(String messageTxt, Calendar tvi)
    		throws DuplicateInstanceException;
    
    public void updateMessage(Long messageId, String messageTxt, Calendar tvi)
    		throws InstanceNotFoundException;
    
    public void assignTviMessage(Calendar tvi, Message message)
    		throws InstanceNotFoundException;
    
    public void assignMessageTextMessage(Message messageText, Message message)
    		throws InstanceNotFoundException;    
}
