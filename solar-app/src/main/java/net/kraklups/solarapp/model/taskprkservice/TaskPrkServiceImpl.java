package net.kraklups.solarapp.model.taskprkservice;

import java.util.Calendar;
import java.util.List;

import net.kraklups.modelutil.exceptions.DuplicateInstanceException;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.alarm.Alarm;
import net.kraklups.solarapp.model.eventtsk.EventTsk;
import net.kraklups.solarapp.model.report.Report;
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

}
