package net.kraklups.solarapp.model.taskprkservice;

import java.util.Date;
import java.util.List;

import net.kraklups.modelutil.exceptions.DuplicateInstanceException;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.alarm.Alarm;
import net.kraklups.solarapp.model.alarm.AlarmDTO;
import net.kraklups.solarapp.model.alarm.AlarmDao;
import net.kraklups.solarapp.model.eventtsk.EventTsk;
import net.kraklups.solarapp.model.eventtsk.EventTskDao;
import net.kraklups.solarapp.model.messageevent.MessageEvent;
import net.kraklups.solarapp.model.messageevent.MessageEventDao;
import net.kraklups.solarapp.model.park.Park;
import net.kraklups.solarapp.model.report.Report;
import net.kraklups.solarapp.model.report.ReportDao;
import net.kraklups.solarapp.model.role.Role;
import net.kraklups.solarapp.model.taskprk.Monitor;
import net.kraklups.solarapp.model.taskprk.Synchronize;
import net.kraklups.solarapp.model.taskprk.TaskPrk;
import net.kraklups.solarapp.model.taskprk.TaskPrkDao;
import net.kraklups.solarapp.model.taskprk.Track;
import net.kraklups.solarapp.model.taskprk.Upkeep;
import net.kraklups.solarapp.model.timetable.Timetable;
import net.kraklups.solarapp.model.userprofile.UserProfile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("taskService")
@Transactional
public class TaskPrkServiceImpl implements TaskPrkService {
	
	@SuppressWarnings("unused")
	private static final Logger LOGGER = LoggerFactory.getLogger(TaskPrkServiceImpl.class);

	@Autowired
	private TaskPrkDao taskPrkDao;
	
	@Autowired
	private ReportDao reportDao;
	
	@Autowired
	private AlarmDao alarmDao;
	
    @Autowired
    private EventTskDao eventTskDao;
    
    @Autowired
    private MessageEventDao messageEventDao;
	
	@Override
	public Upkeep createUpkeep(String taskName, Date creationDate,
			Park park, Role role, UserProfile userProfile)
			throws DuplicateInstanceException {
		
		Upkeep upkeep = new Upkeep(taskName, creationDate, park, role, userProfile);
		
		taskPrkDao.save(upkeep);
		
		return upkeep;
	}

	@Override
	public Upkeep updateUpkeep(Long upkeepId, String taskName,
			Date creationDate, Park park, Role role, UserProfile userProfile)
			throws InstanceNotFoundException {
		
		Upkeep upkeep = (Upkeep) taskPrkDao.find(upkeepId);
		
		upkeep.setTaskName(taskName);
		upkeep.setCreationDate(creationDate);
		upkeep.setPark(park);
		upkeep.setRole(role);
		upkeep.setUserProfile(userProfile);
		
		return upkeep;
	}

	@Override
	public Track createTrack(String taskName, Date creationDate, Park park,
			Role role, UserProfile userProfile, Date tvf, Report report)
			throws DuplicateInstanceException {
		
		Track track = new Track(taskName, creationDate, park, role, userProfile, tvf, report);
		
		taskPrkDao.save(track);
		
		return track;
	}

	@Override
	public Track updateTrack(Long trackId, String taskName,
			Date creationDate, Park park, Role role,
			UserProfile userProfile, Date tvf, Report report)
			throws InstanceNotFoundException {
		
		Track track = (Track) taskPrkDao.find(trackId);
		
		return track;
	}

	@Override
	public Monitor createMonitor(String taskName, Date creationDate,
			Park park, Role role, UserProfile userProfile)
			throws DuplicateInstanceException {
		
		Monitor monitor = new Monitor(taskName, creationDate, park, role, userProfile);
		
		taskPrkDao.save(monitor);
		
		return monitor;
	}

	@Override
	public Monitor updateMonitor(Long monitorId, String taskName,
			Date creationDate, Park park, Role role, UserProfile userProfile)
			throws InstanceNotFoundException {
		
		Monitor monitor = (Monitor) taskPrkDao.find(monitorId);
		
		monitor.setTaskName(taskName);
		monitor.setCreationDate(creationDate);
		monitor.setPark(park);
		monitor.setRole(role);
		monitor.setUserProfile(userProfile);
		
		return monitor;
	}

	@Override
	public Synchronize createSynchronize(String taskName,
			Date creationDate, Park park, Role role, UserProfile userProfile)
			throws DuplicateInstanceException {
		
		Synchronize synchronize = new Synchronize(taskName, creationDate, park, role, userProfile);
		
		taskPrkDao.save(synchronize);
		
		return synchronize;
	}

	@Override
	public Synchronize updateSynchronize(Long synchronizeId, String taskName,
			Date creationDate, Park park, Role role, UserProfile userProfile)
			throws InstanceNotFoundException {
		 
		Synchronize synchronize = (Synchronize) taskPrkDao.find(synchronizeId);
		
		synchronize.setTaskName(taskName);
		synchronize.setCreationDate(creationDate);
		synchronize.setPark(park);
		synchronize.setRole(role);
		synchronize.setUserProfile(userProfile);
		
		return synchronize;
	}

	@Override
	public Alarm createAlarm(String alarmTag, Date triggerDate,
			EventTsk eventTsk) throws DuplicateInstanceException {
		
		Alarm alarm = new Alarm(alarmTag, triggerDate, eventTsk);
		
		alarmDao.save(alarm);
		
		return alarm;
	}

	@Override
	public Alarm updateAlarm(Long alarmId, String alarmTag,
			Date triggerDate, EventTsk eventTsk)
			throws InstanceNotFoundException {
		
		Alarm alarm = alarmDao.find(alarmId);
		
		alarm.setAlarmTag(alarmTag);
		alarm.setTriggerDate(triggerDate);
		alarm.setEventTsk(eventTsk);
		
		return alarm;
	}

	@Override
	public void assignEventTskAlarm(Alarm alarm, EventTsk eventTsk)
			throws InstanceNotFoundException {

		alarm.setEventTsk(eventTsk);
	}

	@Override
	public void assignTriggerDateAlarm(Alarm alarm, Date triggerDate)
			throws InstanceNotFoundException {
		
		alarm.setTriggerDate(triggerDate);
	}

	@Override
	public void assignAlarmTagAlarm(Alarm alarm, String alarmTag)
			throws InstanceNotFoundException {
		
		alarm.setAlarmTag(alarmTag);
	}

	@Override
	public AlarmBlock getAlarmByAlarmTag(String alarmTag, int startIndex,
			int count) throws InstanceNotFoundException {
		
		List<Alarm> alarms = alarmDao.getAlarmsByAlarmTag(alarmTag, startIndex, count + 1);
		
		boolean existMoreAlarms = alarms.size() == (count + 1);
		
		return new AlarmBlock(alarms, existMoreAlarms);
	}

	@Override
	public AlarmBlock getAlarmByTriggerDate(Date triggerDate,
			int startIndex, int count) throws InstanceNotFoundException {

		List<Alarm> alarms = alarmDao.getAlarmsByTriggerDate(triggerDate, startIndex, count + 1);
		
		boolean existMoreAlarms = alarms.size() == (count + 1);
		
		return new AlarmBlock(alarms, existMoreAlarms);
	}

	@Override
	public AlarmBlock getAlarmByEventTskId(Long eventTskId, int startIndex,
			int count) throws InstanceNotFoundException {

		List<Alarm> alarms = alarmDao.getAlarmsByEventTskId(eventTskId, startIndex, count + 1);
		
		boolean existMoreAlarms = alarms.size() == (count + 1);
		
		return new AlarmBlock(alarms, existMoreAlarms);	
	}

	@Override
	public Report createReport(String reportTitle, Date dateRequest,
			Date dateServed, UserProfile userProfile, String urlReport)
			throws DuplicateInstanceException {
		
		Report report = new Report(reportTitle, dateRequest, dateServed, userProfile, urlReport);
		
		reportDao.save(report);
		
		return report;
	}

	@Override
	public Report updateReport(Long reportId, String reportTitle,
			Date dateRequest, Date dateServed,
			UserProfile userProfile, String urlReport)
			throws InstanceNotFoundException {
		
		Report report = reportDao.find(reportId);
		
		report.setReportTitle(reportTitle);
		report.setDateRequest(dateRequest);
		report.setDateServed(dateServed);
		report.setUserProfile(userProfile);
		report.setUrlReport(urlReport);
		
		return report;
	}

	@Override
	public void assignLoginRequestReport(Report report, UserProfile userProfile)
			throws InstanceNotFoundException {
		
		report.setUserProfile(userProfile);	
	}

	@Override
	public void assignReportTitleReport(Report report, String reportTitle)
			throws InstanceNotFoundException {

		report.setReportTitle(reportTitle);
	}

	@Override
	public void assignDateRequestReport(Report report, Date dateRequest)
			throws InstanceNotFoundException {
		
		report.setDateRequest(dateRequest);
	}

	@Override
	public void assignDateServedReport(Report report, Date dateServed)
			throws InstanceNotFoundException {
		
		report.setDateServed(dateServed);
	}

	@Override
	public void assignUrlReportReport(Report report, String urlReport)
			throws InstanceNotFoundException {
		
		report.setUrlReport(urlReport);
	}

	@Override
	public ReportBlock getReportByUserProfileId(Long userProfileId,
			int startIndex, int count) throws InstanceNotFoundException {
		
		List<Report> reports = reportDao.getReportsByUserProfileId(userProfileId, startIndex, count + 1); 
		
		boolean existMoreReports = reports.size() == (count +1);
		
		return new ReportBlock(reports, existMoreReports);
	}

	@Override
	public ReportBlock getReportByDateRequest(Date dateRequest,
			int startIndex, int count) throws InstanceNotFoundException {

		List<Report> reports = reportDao.getReportsByDateRequest(dateRequest, startIndex, count + 1); 
		
		boolean existMoreReports = reports.size() == (count +1);
		
		return new ReportBlock(reports, existMoreReports);

	}

	@Override
	public TaskPrkBlock getTaskPrkByParkId(Long parkId, int startIndex, int count)
			throws InstanceNotFoundException {
		
		List<TaskPrk> taskPrks = taskPrkDao.getTaskPrksByParkId(parkId, startIndex, count);
		
		boolean existMoreTaskPrks = taskPrks.size() == (count + 1);
		
		return new TaskPrkBlock(taskPrks, existMoreTaskPrks);
	}

	@Override
	public TaskPrkBlock getTaskPrkByUserProfileId(Long userProfileId,
			int startIndex, int count) throws InstanceNotFoundException {
		
		List<TaskPrk> taskPrks = taskPrkDao.getTaskPrksByUserProfileId(userProfileId, startIndex, count);
		
		boolean existMoreTaskPrks = taskPrks.size() == (count + 1);
		
		return new TaskPrkBlock(taskPrks, existMoreTaskPrks);		
	}

	@Override
	public TaskPrkBlock getTaskPrkByRolId(Long roleId, int startIndex, int count)
			throws InstanceNotFoundException {

		List<TaskPrk> taskPrks = taskPrkDao.getTaskPrksByRolId(roleId, startIndex, count);
		
		boolean existMoreTaskPrks = taskPrks.size() == (count + 1);
		
		return new TaskPrkBlock(taskPrks, existMoreTaskPrks);		
	}

	@Override
	public TaskPrkBlock getUpkeepByParkId(Long parkId, int startIndex, int count)
			throws InstanceNotFoundException {
		
		List<TaskPrk> taskPrks = taskPrkDao.getUpkeepsByParkId(parkId, startIndex, count);
		
		boolean existMoreTaskPrks = taskPrks.size() == (count + 1);
		
		return new TaskPrkBlock(taskPrks, existMoreTaskPrks);		
	}

	@Override
	public TaskPrkBlock getUpkeepByUserProfileId(Long userProfileId,
			int startIndex, int count) throws InstanceNotFoundException {
		
		List<TaskPrk> taskPrks = taskPrkDao.getUpkeepsByUserProfileId(userProfileId, startIndex, count);
		
		boolean existMoreTaskPrks = taskPrks.size() == (count + 1);
		
		return new TaskPrkBlock(taskPrks, existMoreTaskPrks);	
	}

	@Override
	public TaskPrkBlock getUpkeepByRolId(Long roleId, int startIndex, int count)
			throws InstanceNotFoundException {

		List<TaskPrk> taskPrks = taskPrkDao.getUpkeepsByRoleId(roleId, startIndex, count);
		
		boolean existMoreTaskPrks = taskPrks.size() == (count + 1);
		
		return new TaskPrkBlock(taskPrks, existMoreTaskPrks);	
	}

	@Override
	public TaskPrkBlock getMonitorByParkId(Long parkId, int startIndex, int count)
			throws InstanceNotFoundException {

		List<TaskPrk> taskPrks = taskPrkDao.getMonitorsByParkId(parkId, startIndex, count);
		
		boolean existMoreTaskPrks = taskPrks.size() == (count + 1);
		
		return new TaskPrkBlock(taskPrks, existMoreTaskPrks);
	}

	@Override
	public TaskPrkBlock getMonitorByUserProfileId(Long userProfileId,
			int startIndex, int count) throws InstanceNotFoundException {

		List<TaskPrk> taskPrks = taskPrkDao.getMonitorsByUserProfileId(userProfileId, startIndex, count);
		
		boolean existMoreTaskPrks = taskPrks.size() == (count + 1);
		
		return new TaskPrkBlock(taskPrks, existMoreTaskPrks);
	}

	@Override
	public TaskPrkBlock getMonitorByRolId(Long roleId, int startIndex, int count)
			throws InstanceNotFoundException {

		List<TaskPrk> taskPrks = taskPrkDao.getMonitorsByRoleId(roleId, startIndex, count);
		
		boolean existMoreTaskPrks = taskPrks.size() == (count + 1);
		
		return new TaskPrkBlock(taskPrks, existMoreTaskPrks);
	}

	@Override
	public TaskPrkBlock getTrackByParkId(Long parkId, int startIndex, int count)
			throws InstanceNotFoundException {

		List<TaskPrk> taskPrks = taskPrkDao.getTracksByParkId(parkId, startIndex, count);
		
		boolean existMoreTaskPrks = taskPrks.size() == (count + 1);
		
		return new TaskPrkBlock(taskPrks, existMoreTaskPrks);
	}

	@Override
	public TaskPrkBlock getTrackByUserProfileId(Long userProfileId,
			int startIndex, int count) throws InstanceNotFoundException {
		
		List<TaskPrk> taskPrks = taskPrkDao.getTracksByUserProfileId(userProfileId, startIndex, count);
		
		boolean existMoreTaskPrks = taskPrks.size() == (count + 1);
		
		return new TaskPrkBlock(taskPrks, existMoreTaskPrks);
	}

	@Override
	public TaskPrkBlock getTrackByRolId(Long roleId, int startIndex, int count)
			throws InstanceNotFoundException {
		
		List<TaskPrk> taskPrks = taskPrkDao.getTracksByRoleId(roleId, startIndex, count);
		
		boolean existMoreTaskPrks = taskPrks.size() == (count + 1);
		
		return new TaskPrkBlock(taskPrks, existMoreTaskPrks);
	}

	@Override
	public TaskPrkBlock getSynchronizeByParkId(Long parkId, int startIndex,
			int count) throws InstanceNotFoundException {

		List<TaskPrk> taskPrks = taskPrkDao.getSynchronizesByParkId(parkId, startIndex, count);
		
		boolean existMoreTaskPrks = taskPrks.size() == (count + 1);
		
		return new TaskPrkBlock(taskPrks, existMoreTaskPrks);

	}

	@Override
	public TaskPrkBlock getSynchronizeByUserProfileId(Long userProfileId,
			int startIndex, int count) throws InstanceNotFoundException {

		List<TaskPrk> taskPrks = taskPrkDao.getSynchronizesByUserProfileId(userProfileId, startIndex, count);
		
		boolean existMoreTaskPrks = taskPrks.size() == (count + 1);
		
		return new TaskPrkBlock(taskPrks, existMoreTaskPrks);		
	}

	@Override
	public TaskPrkBlock getSynchronizeByRolId(Long roleId, int startIndex, int count)
			throws InstanceNotFoundException {

		List<TaskPrk> taskPrks = taskPrkDao.getSynchronizesByRoleId(roleId, startIndex, count);
		
		boolean existMoreTaskPrks = taskPrks.size() == (count + 1);
		
		return new TaskPrkBlock(taskPrks, existMoreTaskPrks);
	}

	@Override
	public void assignRoleTaskPrk(TaskPrk taskPrk, Role role)
			throws InstanceNotFoundException {
		
		taskPrk.setRole(role);
	}

	@Override
	public void assignParkTaskPrk(TaskPrk taskPrk, Park park)
			throws InstanceNotFoundException {

		taskPrk.setPark(park);
	}

	@Override
	public void assignUserProfileTaskPrk(TaskPrk taskPrk,
			UserProfile userProfile) throws InstanceNotFoundException {
		
		taskPrk.setUserProfile(userProfile);
	}

	@Override
	public void assignTaskNameTaskPrk(TaskPrk taskPrk, String taskName)
			throws InstanceNotFoundException {
		
		taskPrk.setTaskName(taskName);
	}

	@Override
	public void assignCreationTimeTaskPrk(TaskPrk taskPrk, Date creationTime)
			throws InstanceNotFoundException {
		
		taskPrk.setCreationDate(creationTime);
	}

	@Override
	public TaskPrk cloneTaskPrk(TaskPrk taskPrk)
			throws InstanceNotFoundException {
		
		
		return null;
	}

	@Override
	public ReportBlock getReportByParkId(Long parkId, int startIndex, int count)
			throws InstanceNotFoundException {
		
		List<Report> reports = reportDao.getReportsByParkId(parkId, startIndex, count + 1); 
		
		boolean existMoreReports = reports.size() == (count +1);
		
		return new ReportBlock(reports, existMoreReports);
	}

	@Override
	public EventTsk createEventTsk(String tagET, String definitionET,
			Date tvi, Date tvf, TaskPrk taskPrk, Timetable timetable,
			Boolean triggerAlarm, Boolean triggerMessage) 
					throws DuplicateInstanceException {
		
		EventTsk eventTsk = new EventTsk(tagET, definitionET, tvi, tvf, taskPrk, 
				timetable, triggerAlarm, triggerMessage);
		
		eventTskDao.save(eventTsk);
		
		return eventTsk;
	}

	@Override
	public EventTsk updateEventTsk(Long eventTaskId, String tagET,
			String definitionET, Date tvi, Date tvf, TaskPrk taskPrk,
			Timetable timetable, Boolean triggerAlarm, Boolean triggerMessage) 
					throws InstanceNotFoundException {
		
		EventTsk eventTsk = eventTskDao.find(eventTaskId);
		
		eventTsk.setTagET(tagET);
		eventTsk.setDefinitionET(definitionET);
		eventTsk.setTvi(tvi);
		eventTsk.setTvf(tvf);
		eventTsk.setTaskPrk(taskPrk);
		eventTsk.setTimetable(timetable);
		eventTsk.setTriggerAlarm(triggerAlarm);
		eventTsk.setTriggerMessage(triggerMessage);
		
		return eventTsk;
	}

	@Override
	public void assignTviEventTsk(EventTsk eventTsk, Date tvi)
			throws InstanceNotFoundException {
		
		eventTsk.setTvi(tvi);
	}

	@Override
	public void assignTvfEventTsk(EventTsk eventTsk, Date tvf)
			throws InstanceNotFoundException {
		
		eventTsk.setTvf(tvf);
	}

	@Override
	public void assignTaskPrkEventTsk(EventTsk eventTsk, TaskPrk taskPrk)
			throws InstanceNotFoundException {
		
		eventTsk.setTaskPrk(taskPrk);
	}

	@Override
	public void assignTimetableEventTsk(EventTsk eventTsk, Timetable timetable)
			throws InstanceNotFoundException {
		
		eventTsk.setTimetable(timetable);
	}

	@Override
	public void assignTriggerAlarmEventTsk(EventTsk eventTsk, Boolean triggerAlarm)
			throws InstanceNotFoundException {
		
		eventTsk.setTriggerAlarm(triggerAlarm);
	}
	
	@Override
	public void assignTriggerMessageEventTsk(EventTsk eventTsk, Boolean triggerMessage)
			throws InstanceNotFoundException {
		
		eventTsk.setTriggerMessage(triggerMessage);
	}	
	
	@Override
	public MessageEventBlock getMessageEventByEventTskId(Long eventTskId, int startIndex, int count)
			throws InstanceNotFoundException {		
		
		List<MessageEvent> messageEvents = messageEventDao.getMessageEventsByEventTskId(eventTskId, startIndex, count + 1); 
		
		boolean existMoreMessageEvents = messageEvents.size() == (count +1);
		
		return new MessageEventBlock(messageEvents, existMoreMessageEvents);
	}

	@Override
	public MessageEvent createMessageEvent(String messageTxt, Date tvi, EventTsk eventTsk)
			throws DuplicateInstanceException {
		
		MessageEvent messageEvent = new MessageEvent(tvi, messageTxt, eventTsk);
		
		messageEventDao.save(messageEvent);
		
		return messageEvent;
	}

	@Override
	public MessageEvent updateMessageEvent(Long messageId, String messageTxt,
			Date tvi, EventTsk eventTsk) throws InstanceNotFoundException {
		
		MessageEvent messageEvent = messageEventDao.find(messageId);
		
		messageEvent.setTvi(tvi);
		messageEvent.setMessageEventText(messageTxt);
		messageEvent.setEventTsk(eventTsk);
		
		return messageEvent;
	}

	@Override
	public void assignTviMessageEvent(MessageEvent messageEvent, Date tvi)
			throws InstanceNotFoundException {
		
		messageEvent.setTvi(tvi);		
	}

	@Override
	public void assignMessageTxtMessageEvent(MessageEvent messageEvent,
			String messageTxt) throws InstanceNotFoundException {
		
		messageEvent.setMessageEventText(messageTxt);
	}

	@Override
	public void assignEventTskMessageEvent(MessageEvent messageEvent, EventTsk eventTsk)
			throws InstanceNotFoundException {
		
		messageEvent.setEventTsk(eventTsk);
	}

	@Override
	public Alarm alarmTriggered(AlarmDTO alarmDTO)
			throws DuplicateInstanceException, InstanceNotFoundException {
		
		Long eventTskId = Long.valueOf(alarmDTO.getEventTskId());
				
		Alarm alarm = new Alarm(alarmDTO.getAlarmTag(), alarmDTO.getTriggerDate(), eventTskDao.find(eventTskId));
		alarmDao.save(alarm);
		
		return alarm;
	}

	@Override
	public EventTskBlock getEventTskByTaskPrkId(Long parkId, int startIndex,
			int count) throws InstanceNotFoundException {

		List<EventTsk> eventTsks = eventTskDao.getEventTsksByTaskPrkId(parkId, startIndex, count + 1); 
		
		boolean existMoreEventTsks = eventTsks.size() == (count +1);
		
		return new EventTskBlock(eventTsks, existMoreEventTsks);	
	}

	@Override
	public EventTskBlock getEventTskByTimetableId(Long timetableId, int startIndex,
			int count) throws InstanceNotFoundException {
		
		List<EventTsk> eventTsks = eventTskDao.getEventTsksByTimetableId(timetableId, startIndex, count + 1); 
		
		boolean existMoreEventTsks = eventTsks.size() == (count +1);
		
		return new EventTskBlock(eventTsks, existMoreEventTsks);	
	}

	@Override
	public EventTskBlock getEventTsks(int startIndex, int count)
			throws InstanceNotFoundException {
		
		List<EventTsk> eventTsks = eventTskDao.getEventTsks(startIndex, count + 1);
		
		boolean existMoreEventTsks = eventTsks.size() == (count +1);
		
		return new EventTskBlock(eventTsks, existMoreEventTsks);	
	}

	@Override
	public Alarm saveAlarm(Alarm alarm) 
			throws DuplicateInstanceException {
	        	            
		alarmDao.save(alarm);
         
		return alarm;
	}
	
}
