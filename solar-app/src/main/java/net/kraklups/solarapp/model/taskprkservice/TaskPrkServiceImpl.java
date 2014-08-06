package net.kraklups.solarapp.model.taskprkservice;

import java.util.Calendar;
import java.util.List;

import net.kraklups.modelutil.exceptions.DuplicateInstanceException;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.alarm.Alarm;
import net.kraklups.solarapp.model.eventtsk.EventTsk;
import net.kraklups.solarapp.model.park.Park;
import net.kraklups.solarapp.model.report.Report;
import net.kraklups.solarapp.model.role.Role;
import net.kraklups.solarapp.model.taskprk.Monitor;
import net.kraklups.solarapp.model.taskprk.Synchronize;
import net.kraklups.solarapp.model.taskprk.TaskPrk;
import net.kraklups.solarapp.model.taskprk.Track;
import net.kraklups.solarapp.model.taskprk.Upkeep;
import net.kraklups.solarapp.model.userprofile.UserProfile;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("taskService")
@Transactional
public class TaskPrkServiceImpl implements TaskPrkService {

	@Override
	public Alarm createAlarm(String alarmTag, Calendar triggerDate,
			EventTsk eventTsk) throws DuplicateInstanceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateAlarm(Long alarmId, String alarmTag,
			Calendar triggerDate, EventTsk eventTsk)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assignEventTskAlarm(Alarm alarm, EventTsk eventTsk)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assignTriggerDateAlarm(Alarm alarm, Calendar triggerDate)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assignAlarmTagAlarm(Alarm alarm, String alarmTag)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Alarm> getAlarmByAlarmTag(String alarmTag, int startIndex,
			int count) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Alarm> getAlarmByTriggerDate(Calendar triggerDate,
			int startIndex, int count) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Alarm> getAlarmByEventTsk(EventTsk eventTsk, int startIndex,
			int count) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Report createReport(String reportTitle, Calendar dateRequest,
			Calendar dateServed, UserProfile loginRequest, String urlReport)
			throws DuplicateInstanceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateReport(Long reportId, String reportTitle,
			Calendar dateRequest, Calendar dateServed,
			UserProfile loginRequest, String urlReport)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assignLoginRequestReport(Report report, UserProfile loginRequest)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assignReportTitleReport(Report report, String reportTitle)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assignDateRequestReport(Report report, Calendar dateRequest)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assignDateServedReport(Report report, Calendar dateServed)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assignUrlReportReport(Report report, String urlReport)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Report> getReportByLoginRequest(UserProfile loginRequest,
			int startIndex, int count) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Report> getReportByDateRequest(Calendar dateRequest,
			int startIndex, int count) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Upkeep createUpkeep(String taskName, Calendar creationDate,
			Park park, Role role, UserProfile userProfile)
			throws DuplicateInstanceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Upkeep updateUpkeep(Long upkeepId, String taskName,
			Calendar creationDate, Park park, Role role, UserProfile userProfile)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Track createTrack(String taskName, Calendar creationDate, Park park,
			Role role, UserProfile userProfile, Calendar tvf, Report report)
			throws DuplicateInstanceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Track updateTrack(Long trackId, String taskName,
			Calendar creationDate, Park park, Role role,
			UserProfile userProfile, Calendar tvf, Report report)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Monitor createMonitor(String taskName, Calendar creationDate,
			Park park, Role role, UserProfile userProfile)
			throws DuplicateInstanceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Monitor updateMonitor(Long monitorId, String taskName,
			Calendar creationDate, Park park, Role role, UserProfile userProfile)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Synchronize createSynchronize(String taskName,
			Calendar creationDate, Park park, Role role, UserProfile userProfile)
			throws DuplicateInstanceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Synchronize updateSynchronize(Long synchronizeId, String taskName,
			Calendar creationDate, Park park, Role role, UserProfile userProfile)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TaskPrk> getTaskPrkByPark(Park park, int startIndex, int count)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TaskPrk> getTaskPrkByLoginRequest(UserProfile loginRequest,
			int startIndex, int count) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TaskPrk> getTaskPrkByRol(Role role, int startIndex, int count)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Upkeep> getUpkeepByPark(Park park, int startIndex, int count)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Upkeep> getUpkeepByLoginRequest(UserProfile loginRequest,
			int startIndex, int count) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Upkeep> getUpkeepByRol(Role role, int startIndex, int count)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Monitor> getMonitorByPark(Park park, int startIndex, int count)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Monitor> getMonitorByLoginRequest(UserProfile loginRequest,
			int startIndex, int count) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Monitor> getMonitorByRol(Role role, int startIndex, int count)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Track> getTrackByPark(Park park, int startIndex, int count)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Track> getTrackByLoginRequest(UserProfile loginRequest,
			int startIndex, int count) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Track> getTrackByRol(Role role, int startIndex, int count)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Synchronize> getSynchronizeByPark(Park park, int startIndex,
			int count) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Synchronize> getSynchronizeByLoginRequest(
			UserProfile loginRequest, int startIndex, int count)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Synchronize> getSynchronizeByRol(Role role, int startIndex,
			int count) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void assignRoleTaskPrk(TaskPrk taskPrk, Role role)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assignParkTaskPrk(TaskPrk taskPrk, Park park)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assignUserProfileTaskPrk(TaskPrk taskPrk,
			UserProfile userProfile) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assignTaskNameTaskPrk(TaskPrk taskPrk, String taskName)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assignCreationTimeTaskPrk(TaskPrk taskPrk, Calendar creationTime)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TaskPrk cloneTaskPrk(TaskPrk taskPrk)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Report> getReportByPark(Park park, int startIndex, int count)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
