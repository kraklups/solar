package net.kraklups.solarapp.model.parkservice;

import java.util.Calendar;
import java.util.List;

import com.vividsolutions.jts.geom.MultiPolygon;

import net.kraklups.modelutil.exceptions.DuplicateInstanceException;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.alarm.Alarm;
import net.kraklups.solarapp.model.company.Company;
import net.kraklups.solarapp.model.eventtsk.EventTsk;
import net.kraklups.solarapp.model.messageevent.MessageEvent;
import net.kraklups.solarapp.model.park.Park;
import net.kraklups.solarapp.model.taskprk.TaskPrk;
import net.kraklups.solarapp.model.timetable.Timetable;
import net.kraklups.solarapp.model.userprofile.UserProfile;

public interface ParkService {

    public Park createPark(String parkName, Calendar startupDate, Calendar productionDate, String loginName, 
    		Company company, MultiPolygon mapPark) throws DuplicateInstanceException;

    public void updatePark(Long parkId, String parkName, Calendar startupDate, Calendar productionDate, String loginName, 
    		Company company, MultiPolygon mapPark) throws InstanceNotFoundException;

    public Park findParkByName(String parkName)
            throws InstanceNotFoundException;
	
    public void assignLoginNamePark(Park park, String loginName)
            throws InstanceNotFoundException;
    
    public void assignCompanyPark(Park park, Company company)
            throws InstanceNotFoundException;    
    
    public void assignGISPark(Park park, MultiPolygon mapPark)
            throws InstanceNotFoundException;    
    
    public List<Park> getParksByLoginName(String loginName, int startIndex, int count) 
            throws InstanceNotFoundException;    
    
    public List<Park> getParksByCompany(Company company, int startIndex, int count) 
            throws InstanceNotFoundException; 
    
    public Timetable createTimetable(String tag, UserProfile userProfile, Calendar tvi, Park park)
    		throws DuplicateInstanceException;
    
    public void updateTimetable(Long timetableId, String tag, UserProfile userProfile, Calendar tvi, Park park) 
    		throws InstanceNotFoundException; 
    
    public void assignParkTimetable(Timetable timetable, Park park)
    		throws InstanceNotFoundException;

    public void assignEventTskTimetable(Timetable timetable, EventTsk eventTsk)
    		throws InstanceNotFoundException;
    
    public void assignLoginTimetable(Timetable timetable, String login)
    		throws InstanceNotFoundException;  
    
    public void assignTviTimetable(Timetable timetable, Calendar tvi)
    		throws InstanceNotFoundException;
    
    public void assignTvfTimetable(Timetable timetable, Calendar tvf)
    		throws InstanceNotFoundException;
    
    public Park getParkByTimetable(Timetable timetable)
    		throws InstanceNotFoundException;  
    
    public EventTsk createEventTsk(String tagET, String definitionET, Calendar tvi, Calendar tvf, 
            TaskPrk taskPrk, MessageEvent messageEvent, Alarm alarm)
            throws DuplicateInstanceException;

    public void updateTimetable(Long eventTaskId, String tagET, String definitionET, Calendar tvi, Calendar tvf, 
            TaskPrk taskPrk, MessageEvent messageEvent, Alarm alarm) 
            throws InstanceNotFoundException; 
    
    public void assignTviEventTsk(EventTsk eventTsk, Calendar tvi)
    		throws InstanceNotFoundException;

    public void assignTvfEventTsk(EventTsk eventTsk, Calendar tvf)
    		throws InstanceNotFoundException;

    public MessageEvent getMessageByEventTsk(EventTsk eventTsk)
			throws InstanceNotFoundException;  
    
    public Alarm getAlarmByEventTsk(EventTsk eventTsk)
			throws InstanceNotFoundException;
    
    public TaskPrk getTaskPrkByEventTsk(EventTsk eventTsk)
			throws InstanceNotFoundException;    

	public void assignTaskPrkEventTsk(EventTsk eventTsk, TaskPrk taskPrk)
			throws InstanceNotFoundException;

	public void assignMessageEventTsk(EventTsk eventTsk, MessageEvent messageEvent)
			throws InstanceNotFoundException;

	public void assignAlarmEventTsk(EventTsk eventTsk, Alarm alarm)
			throws InstanceNotFoundException;
    
    public MessageEvent createMessageEvent(String messageTxt, Calendar tvi)
    		throws DuplicateInstanceException;
    
    public void updateMessageEvent(Long messageId, String messageTxt, Calendar tvi)
    		throws InstanceNotFoundException;
    
    public void assignTviMessageEvent(MessageEvent messageEvent, Calendar tvi)
    		throws InstanceNotFoundException;
    
    public void assignMessageTxtMessageEvent(MessageEvent messageEvent, String messageTxt)
    		throws InstanceNotFoundException;    
}
