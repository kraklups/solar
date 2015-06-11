package net.kraklups.solarapp.test.model.taskprkservice;

import static net.kraklups.solarapp.model.util.GlobalNames.SPRING_CONFIG_FILE;
import static net.kraklups.solarapp.test.util.GlobalNames.SPRING_CONFIG_TEST_FILE;
import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;

import net.kraklups.modelutil.exceptions.DuplicateInstanceException;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.alarm.Alarm;
import net.kraklups.solarapp.model.eventtsk.EventTsk;
import net.kraklups.solarapp.model.messageevent.MessageEvent;
import net.kraklups.solarapp.model.park.Park;
import net.kraklups.solarapp.model.parkservice.ParkService;
import net.kraklups.solarapp.model.report.Report;
import net.kraklups.solarapp.model.role.Role;
import net.kraklups.solarapp.model.taskprk.TaskPrk;
import net.kraklups.solarapp.model.taskprkservice.TaskPrkService;
import net.kraklups.solarapp.model.timetable.Timetable;
import net.kraklups.solarapp.model.userprofile.UserProfile;
import net.kraklups.solarapp.model.userservice.UserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { SPRING_CONFIG_FILE, SPRING_CONFIG_TEST_FILE })
@Transactional
public class TaskPrkServiceTest {

    @Autowired
    private TaskPrkService taskPrkService;
    
    @Autowired
    private UserService userService;    
        
    @Autowired
    private ParkService parkService;    
    
	@Test
	public void testCreateTaskPrkAndFindElementPrk() 
		throws DuplicateInstanceException, InstanceNotFoundException {
		
		// String taskName, Date creationDate, Park park, Role role, UserProfile userProfile
		
		Long weight = new Long("1");
		
		Calendar calendar = Calendar.getInstance();
		Date timestamp = new Date(calendar.getTime().getTime());
		
		UserProfile userProfile = userService.findUserProfile(weight);
		Park park = parkService.findPark(weight);
		Role role = userService.findRole(weight);
	
		TaskPrk taskPrk = taskPrkService.createTaskPrk("farleyo", timestamp, park, role, userProfile);
		
		TaskPrk taskPrk2 = taskPrkService.findTaskPrk(taskPrk.getTaskPrkId());
		
		assertEquals(taskPrk, taskPrk2);
			
	}
		  
	@Test
	public void testCreateAlarmAndFindAlarm() 
		throws DuplicateInstanceException, InstanceNotFoundException {
		
		// String alarmTag, Date triggerDate, EventTsk eventTsk
		
		Long weight = new Long("1");
		
		Calendar calendar = Calendar.getInstance();
		Date timestamp = new Date(calendar.getTime().getTime());
		
		String cadena = "estraperlacio";
		
		EventTsk eventTsk = taskPrkService.findEventTsk(weight);
		
		Alarm alarm = taskPrkService.createAlarm(cadena, timestamp, eventTsk, false);
		
		Alarm alarm2 = taskPrkService.findAlarm(alarm.getAlarmId());
		
		assertEquals(alarm, alarm2);		
		
			
	}
	
	@Test
	public void testCreateEventTskAndFindEventTsk() 
		throws DuplicateInstanceException, InstanceNotFoundException {
		
		// String tagET, String definitionET, Date tvi, Date tvf,  
		//TaskPrk taskPrk, Timetable timetable, Boolean triggerAlarm, Boolean triggerMessage

		
		Long weight = new Long("1");
		
		Calendar calendar = Calendar.getInstance();
		Date timestamp = new Date(calendar.getTime().getTime());
		
		String cadena = "estraperlacio";	
		
		TaskPrk taskPrk = taskPrkService.findTaskPrk(weight);
		Timetable timetable = parkService.findTimetable(weight);
			
		EventTsk eventTsk = taskPrkService.createEventTsk(cadena, cadena, timestamp, timestamp, taskPrk, timetable, false, false);
		
		EventTsk eventTsk2 = taskPrkService.findEventTsk(eventTsk.getEventTskId());
		
		assertEquals(eventTsk, eventTsk2);				
		
	}	

	@Test
	public void testCreateMessageAndFindMessage() 
		throws DuplicateInstanceException, InstanceNotFoundException {
		
		// Date tvi, String messageEventText, EventTsk eventTsk
		
		Long weight = new Long("1");
		
		Calendar calendar = Calendar.getInstance();
		Date timestamp = new Date(calendar.getTime().getTime());
		
		String cadena = "estraperlacio";
		
		EventTsk eventTsk = taskPrkService.findEventTsk(weight);
		
		MessageEvent messageEvent = taskPrkService.createMessageEvent(timestamp, cadena, eventTsk);
		
		MessageEvent messageEvent2 = taskPrkService.findMessageEvent(messageEvent.getMessageEventId());
		
		assertEquals(messageEvent, messageEvent2);		
		
	}
	
	@Test
	public void testCreateReportAndFindReport() 
		throws DuplicateInstanceException, InstanceNotFoundException {
		
		// String reportTitle, Date dateRequest, Date dateServed, UserProfile userProfile, 
		//String urlReport

		Long weight = new Long("1");
		
		Calendar calendar = Calendar.getInstance();
		Date timestamp = new Date(calendar.getTime().getTime());
		
		String cadena = "estraperlacio";	
		
		UserProfile userProfile = userService.findUserProfile(weight);
		
		Report report = taskPrkService.createReport(cadena, timestamp, timestamp, userProfile, cadena);
		
		Report report2 = taskPrkService.findReport(report.getReportId());
		
		assertEquals(report, report2);					
		
	}	
	

}
