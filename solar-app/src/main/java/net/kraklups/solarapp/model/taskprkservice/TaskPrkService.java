package net.kraklups.solarapp.model.taskprkservice;

import java.util.Calendar;

import net.kraklups.modelutil.exceptions.DuplicateInstanceException;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.alarm.Alarm;
import net.kraklups.solarapp.model.eventtsk.EventTsk;
import net.kraklups.solarapp.model.messageevent.MessageEvent;
import net.kraklups.solarapp.model.park.Park;
import net.kraklups.solarapp.model.report.Report;
import net.kraklups.solarapp.model.role.Role;
import net.kraklups.solarapp.model.taskprk.Monitor;
import net.kraklups.solarapp.model.taskprk.Synchronize;
import net.kraklups.solarapp.model.taskprk.TaskPrk;
import net.kraklups.solarapp.model.taskprk.Track;
import net.kraklups.solarapp.model.taskprk.Upkeep;
import net.kraklups.solarapp.model.timetable.Timetable;
import net.kraklups.solarapp.model.userprofile.UserProfile;

public interface TaskPrkService {
	
	public Upkeep createUpkeep(String taskName, Calendar creationDate,
			Park park, Role role, UserProfile userProfile) 
			throws DuplicateInstanceException;

	public Upkeep updateUpkeep(Long upkeepId, String taskName, Calendar creationDate,
			Park park, Role role, UserProfile userProfile) 
			throws InstanceNotFoundException;

	public Track createTrack(String taskName, Calendar creationDate,
			Park park, Role role, UserProfile userProfile, Calendar tvf, Report report) 
			throws DuplicateInstanceException;

	public Track updateTrack(Long trackId, String taskName, Calendar creationDate,
			Park park, Role role, UserProfile userProfile, Calendar tvf, Report report) 
			throws InstanceNotFoundException;

	public Monitor createMonitor(String taskName, Calendar creationDate,
			Park park, Role role, UserProfile userProfile) 
			throws DuplicateInstanceException;

	public Monitor updateMonitor(Long monitorId, String taskName, Calendar creationDate,
			Park park, Role role, UserProfile userProfile) 
			throws InstanceNotFoundException;

	public Synchronize createSynchronize(String taskName, Calendar creationDate,
			Park park, Role role, UserProfile userProfile) 
			throws DuplicateInstanceException;

	public Synchronize updateSynchronize(Long synchronizeId, String taskName, Calendar creationDate,
			Park park, Role role, UserProfile userProfile) 
			throws InstanceNotFoundException;	
	
	public Alarm createAlarm(String alarmTag, Calendar triggerDate, EventTsk eventTsk) 
			throws DuplicateInstanceException;
	
	public Alarm updateAlarm(Long alarmId, String alarmTag, Calendar triggerDate, EventTsk eventTsk) 
			throws InstanceNotFoundException;

	public void assignEventTskAlarm(Alarm alarm, EventTsk eventTsk) 
			throws InstanceNotFoundException;
	
	public void assignTriggerDateAlarm(Alarm alarm, Calendar triggerDate) 
			throws InstanceNotFoundException;
	
	public void assignAlarmTagAlarm(Alarm alarm, String alarmTag) 
			throws InstanceNotFoundException;
	
	public AlarmBlock getAlarmByAlarmTag(String alarmTag, int startIndex, int count) 
			throws InstanceNotFoundException;
	
	public AlarmBlock getAlarmByTriggerDate(Calendar triggerDate, int startIndex, int count) 
			throws InstanceNotFoundException;
	
	public AlarmBlock getAlarmByEventTskId(Long eventTskId, int startIndex, int count) 
			throws InstanceNotFoundException;
	
	public Report createReport(String reportTitle, Calendar dateRequest, Calendar dateServed, 
			UserProfile loginRequest, String urlReport) throws DuplicateInstanceException;
	
	public Report updateReport(Long reportId, String reportTitle, Calendar dateRequest, Calendar dateServed, 
			UserProfile loginRequest, String urlReport) throws InstanceNotFoundException;
	
	public void assignLoginRequestReport(Report report, UserProfile loginRequest) 
			throws InstanceNotFoundException;
	
	public void assignReportTitleReport(Report report, String reportTitle) 
			throws InstanceNotFoundException;
	
	public void assignDateRequestReport(Report report, Calendar dateRequest)
			throws InstanceNotFoundException;
	
	public void assignDateServedReport(Report report, Calendar dateServed)
			throws InstanceNotFoundException;	
	
	public void assignUrlReportReport(Report report, String urlReport)
				throws InstanceNotFoundException;
	
	public ReportBlock getReportByUserProfileId(Long userProfileId, int startIndex, int count) 
			throws InstanceNotFoundException;
	
	public ReportBlock getReportByDateRequest(Calendar dateRequest, int startIndex, int count)
			throws InstanceNotFoundException;
	
	public TaskPrkBlock getTaskPrkByParkId(Long parkId, int startIndex, int count)
			throws InstanceNotFoundException;
	
	public TaskPrkBlock getTaskPrkByUserProfileId(Long userProfileId, int startIndex, int count)
			throws InstanceNotFoundException;

	public TaskPrkBlock getTaskPrkByRolId(Long roleId, int startIndex, int count)
			throws InstanceNotFoundException;	
	
	public TaskPrkBlock getUpkeepByParkId(Long parkId, int startIndex, int count)
			throws InstanceNotFoundException;
	
	public TaskPrkBlock getUpkeepByUserProfileId(Long userProfileId, int startIndex, int count)
			throws InstanceNotFoundException;

	public TaskPrkBlock getUpkeepByRolId(Long roleId, int startIndex, int count)
			throws InstanceNotFoundException;
	
	public TaskPrkBlock getMonitorByParkId(Long parkId, int startIndex, int count)
			throws InstanceNotFoundException;
	
	public TaskPrkBlock getMonitorByUserProfileId(Long userProfileId, int startIndex, int count)
			throws InstanceNotFoundException;

	public TaskPrkBlock getMonitorByRolId(Long roleId, int startIndex, int count)
			throws InstanceNotFoundException;
	
	public TaskPrkBlock getTrackByParkId(Long parkId, int startIndex, int count)
			throws InstanceNotFoundException;
	
	public TaskPrkBlock getTrackByUserProfileId(Long userProfileId, int startIndex, int count)
			throws InstanceNotFoundException;

	public TaskPrkBlock getTrackByRolId(Long roleId, int startIndex, int count)
			throws InstanceNotFoundException;
	
	public TaskPrkBlock getSynchronizeByParkId(Long parkId, int startIndex, int count)
			throws InstanceNotFoundException;
	
	public TaskPrkBlock getSynchronizeByUserProfileId(Long userProfileId, int startIndex, int count)
			throws InstanceNotFoundException;

	public TaskPrkBlock getSynchronizeByRolId(Long roleId, int startIndex, int count)
			throws InstanceNotFoundException;	
	
	public void assignRoleTaskPrk(TaskPrk taskPrk, Role role) 
			throws InstanceNotFoundException;

	public void assignParkTaskPrk(TaskPrk taskPrk, Park park) 
			throws InstanceNotFoundException;

	public void assignUserProfileTaskPrk(TaskPrk taskPrk, UserProfile userProfile) 
			throws InstanceNotFoundException;	
	
	public void assignTaskNameTaskPrk(TaskPrk taskPrk, String taskName) 
			throws InstanceNotFoundException;
	
	public void assignCreationTimeTaskPrk(TaskPrk taskPrk, Calendar creationTime) 
			throws InstanceNotFoundException;
	
	public TaskPrk cloneTaskPrk(TaskPrk taskPrk) 
			throws InstanceNotFoundException;	
	
	public ReportBlock getReportByParkId(Long parkId, int startIndex, int count)
			throws InstanceNotFoundException;
	
    public EventTsk createEventTsk(String tagET, String definitionET, Calendar tvi, Calendar tvf, 
            TaskPrk taskPrk, Timetable timetable, Boolean triggerAlarm, Boolean triggerMessage)
            throws DuplicateInstanceException;

    public EventTsk updateEventTsk(Long eventTaskId, String tagET, String definitionET, Calendar tvi, Calendar tvf, 
            TaskPrk taskPrk, Timetable timetable, Boolean triggerAlarm, Boolean triggerMessage) 
            throws InstanceNotFoundException; 
    
    public void assignTviEventTsk(EventTsk eventTsk, Calendar tvi)
    		throws InstanceNotFoundException;

    public void assignTvfEventTsk(EventTsk eventTsk, Calendar tvf)
    		throws InstanceNotFoundException;

	public void assignTaskPrkEventTsk(EventTsk eventTsk, TaskPrk taskPrk)
			throws InstanceNotFoundException;

	public void assignTriggerAlarmEventTsk(EventTsk eventTsk, Boolean triggerAlarm)
			throws InstanceNotFoundException;
	
	public void assignTriggerMessageEventTsk(EventTsk eventTsk, Boolean triggerMessage)
			throws InstanceNotFoundException;

    public MessageEventBlock getMessageEventByEventTskId(Long eventTskId, int startIndex, int count)
			throws InstanceNotFoundException;  
       
    public MessageEvent createMessageEvent(String messageTxt, Calendar tvi, EventTsk eventTsk)
    		throws DuplicateInstanceException;
    
    public MessageEvent updateMessageEvent(Long messageId, String messageTxt, Calendar tvi, EventTsk eventTsk)
    		throws InstanceNotFoundException;
    
    public void assignTviMessageEvent(MessageEvent messageEvent, Calendar tvi)
    		throws InstanceNotFoundException;
    
    public void assignEventTskMessageEvent(MessageEvent messageEvent, EventTsk eventTsk)
    		throws InstanceNotFoundException;    
    
    public void assignMessageTxtMessageEvent(MessageEvent messageEvent, String messageTxt)
    		throws InstanceNotFoundException;    
    
    public void assignTimetableEventTsk(EventTsk eventTsk, Timetable timetable)
    		throws InstanceNotFoundException;    
}
