package net.kraklups.solarapp.model.parkservice;

import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

@Service("parkService")
@Transactional
public class ParkServiceImpl implements ParkService {

	@Override
	public Park createPark(String parkName, Calendar startupDate,
			Calendar productionDate, String loginName, Company company,
			MultiPolygon mapPark) throws DuplicateInstanceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updatePark(Long parkId, String parkName, Calendar startupDate,
			Calendar productionDate, String loginName, Company company,
			MultiPolygon mapPark) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Park findParkByName(String parkName)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void assignLoginNamePark(Park park, String loginName)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assignCompanyPark(Park park, Company company)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assignGISPark(Park park, MultiPolygon mapPark)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Park> getParksByLoginName(String loginName, int startIndex,
			int count) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Park> getParksByCompany(Company company, int startIndex,
			int count) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Timetable createTimetable(String tag, UserProfile userProfile,
			Calendar tvi, Park park) throws DuplicateInstanceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateTimetable(Long timetableId, String tag,
			UserProfile userProfile, Calendar tvi, Park park)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assignParkTimetable(Park park, Timetable timetable)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assignEventTskTimetable(EventTsk eventTsk, Timetable timetable)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assignLoginTimetable(String login, Timetable timetable)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assignTviTimetable(Calendar tvi, Timetable timetable)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assignTvfTimetable(Calendar tvf, Timetable timetable)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Park getParkByTimetable(Timetable timetable)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EventTsk createEventTsk(String tagET, String definitionET,
			Calendar tvi, Calendar tvf, TaskPrk taskPrk, MessageEvent messageEvent,
			Alarm alarm) throws DuplicateInstanceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateTimetable(Long eventTaskId, String tagET,
			String definitionET, Calendar tvi, Calendar tvf, TaskPrk taskPrk,
			MessageEvent messageEvent, Alarm alarm) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assignTviEventTsk(Calendar tvi, EventTsk eventTsk)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assignTvfEventTsk(Calendar tvf, EventTsk eventTsk)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MessageEvent getMessageByEventTsk(EventTsk eventTsk)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Alarm getAlarmByEventTsk(EventTsk eventTsk)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TaskPrk getTaskPrkByEventTsk(EventTsk eventTsk)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void assignTaskPrkEventTsk(TaskPrk taskPrk, EventTsk eventTsk)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assignMessageEventTsk(MessageEvent messageEvent, EventTsk eventTsk)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assignAlarmEventTsk(Alarm alarm, EventTsk eventTsk)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MessageEvent createMessage(String messageTxt, Calendar tvi)
			throws DuplicateInstanceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateMessage(Long messageId, String messageTxt, Calendar tvi)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assignTviMessage(Calendar tvi, MessageEvent messageEvent)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assignMessageTextMessage(MessageEvent messageText, MessageEvent messageEvent)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}



}
