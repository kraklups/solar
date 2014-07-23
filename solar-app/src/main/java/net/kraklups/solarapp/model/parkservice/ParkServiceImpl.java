package net.kraklups.solarapp.model.parkservice;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import net.kraklups.solarapp.model.park.ParkDao;

@Service("parkService")
@Transactional
public class ParkServiceImpl implements ParkService {

    @Autowired
    private ParkDao parkDao;
      	
	@Override
	public Park createPark(String parkName, Calendar startupDate,
			Calendar productionDate, UserProfile userProfile, Company company,
			MultiPolygon mapPark) throws DuplicateInstanceException {
		
        try {
            parkDao.findByParkName(parkName);
            throw new DuplicateInstanceException(parkName,
                    Park.class.getName());
        } catch (InstanceNotFoundException e) {
        	
            Park park = new Park(parkName, startupDate, productionDate, userProfile, company, mapPark);

            parkDao.save(park);
         
            return park;
        }
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
	public void assignParkTimetable(Timetable timetable, Park park)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assignEventTskTimetable(Timetable timetable, EventTsk eventTsk)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assignLoginTimetable(Timetable timetable, String login)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assignTviTimetable(Timetable timetable, Calendar tvi)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assignTvfTimetable(Timetable timetable, Calendar tvf)
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
	public void assignTviEventTsk(EventTsk eventTsk, Calendar tvi)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assignTvfEventTsk(EventTsk eventTsk, Calendar tvf)
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
	public void assignTaskPrkEventTsk(EventTsk eventTsk, TaskPrk taskPrk)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assignMessageEventTsk(EventTsk eventTsk, MessageEvent messageEvent)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assignAlarmEventTsk(EventTsk eventTsk, Alarm alarm)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MessageEvent createMessageEvent(String messageTxt, Calendar tvi)
			throws DuplicateInstanceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateMessageEvent(Long messageId, String messageTxt,
			Calendar tvi) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assignTviMessageEvent(MessageEvent messageEvent, Calendar tvi)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assignMessageTxtMessageEvent(MessageEvent messageEvent,
			String messageTxt) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

}
