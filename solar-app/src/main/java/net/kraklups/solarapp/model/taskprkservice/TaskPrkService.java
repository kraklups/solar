package net.kraklups.solarapp.model.taskprkservice;

import java.util.Calendar;
import java.util.List;

import net.kraklups.modelutil.exceptions.DuplicateInstanceException;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.alarm.Alarm;
import net.kraklups.solarapp.model.eventtsk.EventTsk;
import net.kraklups.solarapp.model.report.Report;
import net.kraklups.solarapp.model.userprofile.UserProfile;

public interface TaskPrkService {
	
	public Alarm createAlarm(String alarmTag, Calendar triggerDate, EventTsk eventTsk) 
			throws DuplicateInstanceException;
	
	public void updateAlarm(Long alarmId, String alarmTag, Calendar triggerDate, EventTsk eventTsk) 
			throws InstanceNotFoundException;

	public void assignEventTskAlarm(Alarm alarm, EventTsk eventTsk) 
			throws InstanceNotFoundException;
	
	public void assignTriggerDateAlarm(Alarm alarm, Calendar triggerDate) 
			throws InstanceNotFoundException;
	
	public void assignAlarmTagAlarm(Alarm alarm, String alarmTag) 
			throws InstanceNotFoundException;
	
	public List<Alarm> getAlarmByAlarmTag(String alarmTag, int startIndex, int count) 
			throws InstanceNotFoundException;
	
	public List<Alarm> getAlarmByTriggerDate(Calendar triggerDate, int startIndex, int count) 
			throws InstanceNotFoundException;
	
	public List<Alarm> getAlarmByEventTsk(EventTsk eventTsk, int startIndex, int count) 
			throws InstanceNotFoundException;
	
	public Report createReport(String reportTitle, Calendar dateRequest, Calendar dateServed, 
			UserProfile loginRequest, String urlReport) throws DuplicateInstanceException;
	
	public void updateReport(Long reportId, String reportTitle, Calendar dateRequest, Calendar dateServed, 
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
	
	public List<Report> getReportByLoginRequest(UserProfile loginRequest, int startIndex, int count) 
			throws InstanceNotFoundException;
	
	public List<Report> getReportByDateRequest(Calendar dateRequest, int startIndex, int count)
			throws InstanceNotFoundException;
	
	
}
