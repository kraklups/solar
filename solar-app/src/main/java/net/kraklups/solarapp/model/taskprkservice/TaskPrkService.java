package net.kraklups.solarapp.model.taskprkservice;

import java.util.Date;

import net.kraklups.modelutil.exceptions.DuplicateInstanceException;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.alarm.Alarm;
import net.kraklups.solarapp.model.alarm.AlarmDTO;
import net.kraklups.solarapp.model.eventtsk.EventTsk;
import net.kraklups.solarapp.model.eventtsk.EventTskDTO;
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
	
	public Upkeep createUpkeep(String taskName, Date creationDate,
			Park park, Role role, UserProfile userProfile) 
			throws DuplicateInstanceException;

	public Upkeep updateUpkeep(Long upkeepId, String taskName, Date creationDate,
			Park park, Role role, UserProfile userProfile) 
			throws InstanceNotFoundException;

	public Track createTrack(String taskName, Date creationDate,
			Park park, Role role, UserProfile userProfile, Date tvf, Report report) 
			throws DuplicateInstanceException;

	public Track updateTrack(Long trackId, String taskName, Date creationDate,
			Park park, Role role, UserProfile userProfile, Date tvf, Report report) 
			throws InstanceNotFoundException;

	public Monitor createMonitor(String taskName, Date creationDate,
			Park park, Role role, UserProfile userProfile) 
			throws DuplicateInstanceException;

	public Monitor updateMonitor(Long monitorId, String taskName, Date creationDate,
			Park park, Role role, UserProfile userProfile) 
			throws InstanceNotFoundException;

	public Synchronize createSynchronize(String taskName, Date creationDate,
			Park park, Role role, UserProfile userProfile) 
			throws DuplicateInstanceException;

	public Synchronize updateSynchronize(Long synchronizeId, String taskName, Date creationDate,
			Park park, Role role, UserProfile userProfile) 
			throws InstanceNotFoundException;	
	
	public Alarm alarmTriggered(AlarmDTO alarmDTO) 
			throws DuplicateInstanceException, InstanceNotFoundException;
	
	public Alarm createAlarm(String alarmTag, Date triggerDate, EventTsk eventTsk) 
			throws DuplicateInstanceException;
	
	public Alarm updateAlarm(Long alarmId, String alarmTag, Date triggerDate, EventTsk eventTsk) 
			throws InstanceNotFoundException;

	public void assignEventTskAlarm(Alarm alarm, EventTsk eventTsk) 
			throws InstanceNotFoundException;
	
	public void assignTriggerDateAlarm(Alarm alarm, Date triggerDate) 
			throws InstanceNotFoundException;
	
	public void assignAlarmTagAlarm(Alarm alarm, String alarmTag) 
			throws InstanceNotFoundException;
	
	public AlarmBlock getAlarmByAlarmTag(String alarmTag, int startIndex, int count) 
			throws InstanceNotFoundException;
	
	public AlarmBlock getAlarmByTriggerDate(Date triggerDate, int startIndex, int count) 
			throws InstanceNotFoundException;
	
	public AlarmBlock getAlarmByEventTskId(Long eventTskId, int startIndex, int count) 
			throws InstanceNotFoundException;
	
	public Report createReport(String reportTitle, Date dateRequest, Date dateServed, 
			UserProfile loginRequest, String urlReport) throws DuplicateInstanceException;
	
	public Report updateReport(Long reportId, String reportTitle, Date dateRequest, Date dateServed, 
			UserProfile loginRequest, String urlReport) throws InstanceNotFoundException;
	
	public void assignLoginRequestReport(Report report, UserProfile loginRequest) 
			throws InstanceNotFoundException;
	
	public void assignReportTitleReport(Report report, String reportTitle) 
			throws InstanceNotFoundException;
	
	public void assignDateRequestReport(Report report, Date dateRequest)
			throws InstanceNotFoundException;
	
	public void assignDateServedReport(Report report, Date dateServed)
			throws InstanceNotFoundException;	
	
	public void assignUrlReportReport(Report report, String urlReport)
				throws InstanceNotFoundException;
	
	public ReportBlock getReportByUserProfileId(Long userProfileId, int startIndex, int count) 
			throws InstanceNotFoundException;
	
	public ReportBlock getReportByDateRequest(Date dateRequest, int startIndex, int count)
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
	
	public void assignCreationTimeTaskPrk(TaskPrk taskPrk, Date creationTime) 
			throws InstanceNotFoundException;
	
	public TaskPrk cloneTaskPrk(TaskPrk taskPrk) 
			throws InstanceNotFoundException;	
	
	public ReportBlock getReportByParkId(Long parkId, int startIndex, int count)
			throws InstanceNotFoundException;
	
    public EventTsk createEventTsk(String tagET, String definitionET, Date tvi, Date tvf, 
            TaskPrk taskPrk, Timetable timetable, Boolean triggerAlarm, Boolean triggerMessage)
            throws DuplicateInstanceException;

    public EventTsk updateEventTsk(Long eventTaskId, String tagET, String definitionET, Date tvi, Date tvf, 
            TaskPrk taskPrk, Timetable timetable, Boolean triggerAlarm, Boolean triggerMessage) 
            throws InstanceNotFoundException; 
    
	public EventTskBlock getEventTskByTaskPrkId(Long parkId, int startIndex, int count)
			throws InstanceNotFoundException;    
    
	public EventTskBlock getEventTskByTimetableId(Long parkId, int startIndex, int count)
			throws InstanceNotFoundException;	
	
	public EventTskBlock getEventTsks(int startIndex, int count)
			throws InstanceNotFoundException;	
	
    public void assignTviEventTsk(EventTsk eventTsk, Date tvi)
    		throws InstanceNotFoundException;

    public void assignTvfEventTsk(EventTsk eventTsk, Date tvf)
    		throws InstanceNotFoundException;

	public void assignTaskPrkEventTsk(EventTsk eventTsk, TaskPrk taskPrk)
			throws InstanceNotFoundException;

	public void assignTriggerAlarmEventTsk(EventTsk eventTsk, Boolean triggerAlarm)
			throws InstanceNotFoundException;
	
	public void assignTriggerMessageEventTsk(EventTsk eventTsk, Boolean triggerMessage)
			throws InstanceNotFoundException;

    public MessageEventBlock getMessageEventByEventTskId(Long eventTskId, int startIndex, int count)
			throws InstanceNotFoundException;  
       
    public MessageEvent createMessageEvent(String messageTxt, Date tvi, EventTsk eventTsk)
    		throws DuplicateInstanceException;
    
    public MessageEvent updateMessageEvent(Long messageId, String messageTxt, Date tvi, EventTsk eventTsk)
    		throws InstanceNotFoundException;
    
    public void assignTviMessageEvent(MessageEvent messageEvent, Date tvi)
    		throws InstanceNotFoundException;
    
    public void assignEventTskMessageEvent(MessageEvent messageEvent, EventTsk eventTsk)
    		throws InstanceNotFoundException;    
    
    public void assignMessageTxtMessageEvent(MessageEvent messageEvent, String messageTxt)
    		throws InstanceNotFoundException;    
    
    public void assignTimetableEventTsk(EventTsk eventTsk, Timetable timetable)
    		throws InstanceNotFoundException;
    
    public Alarm saveAlarm(Alarm alarm)
    		throws DuplicateInstanceException;
    
	public TaskPrkBlock getTaskPrks(int startIndex, int count) 
			throws InstanceNotFoundException;   
	
	public UpkeepBlock getUpkeeps(int startIndex, int count) 
			throws InstanceNotFoundException;	
	
    public EventTsk saveEventTsk(EventTsk eventTsk)
    		throws DuplicateInstanceException;
    
    public MessageEvent saveMessageEvent(MessageEvent messageEvent)
    		throws DuplicateInstanceException;	    
    
    public Report saveReport(Report report)
    		throws DuplicateInstanceException;    
    
    public TaskPrk saveTaskPrk(TaskPrk taskPrk)
    		throws DuplicateInstanceException;
    
    public Monitor saveTaskPrk(Monitor monitor)
    		throws DuplicateInstanceException;

    public Upkeep saveTaskPrk(Upkeep upkeep)
    		throws DuplicateInstanceException;

    public Synchronize saveTaskPrk(Synchronize synchronize)
    		throws DuplicateInstanceException;

    public Track saveTaskPrk(Track track)
    		throws DuplicateInstanceException;
    
	public ReportBlock getReports(int startIndex, int count) 
			throws InstanceNotFoundException;
	
	public void RegisterEventTsk(EventTskDTO evetntTskDTO)
			throws Exception;
    
	public AlarmBlock getAlarms(int startIndex, int count) 
			throws InstanceNotFoundException;	
	
	public Alarm getAlarmById(Long alarmId) 
			throws InstanceNotFoundException;
	
	public Report getReportById(Long reportId) 
			throws InstanceNotFoundException;	
	
}
