package net.kraklups.solarapp.test.model.parkservice;

import static net.kraklups.solarapp.model.util.GlobalNames.SPRING_CONFIG_FILE;
import static net.kraklups.solarapp.test.util.GlobalNames.SPRING_CONFIG_TEST_FILE;
import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;

import net.kraklups.modelutil.exceptions.DuplicateInstanceException;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.company.Company;
import net.kraklups.solarapp.model.eventtsk.EventTsk;
import net.kraklups.solarapp.model.park.Park;
import net.kraklups.solarapp.model.parkservice.ParkService;
import net.kraklups.solarapp.model.state.State;
import net.kraklups.solarapp.model.statetype.StateType;
import net.kraklups.solarapp.model.taskprk.Upkeep;
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
public class ParkServiceTest {

    @Autowired
    private ParkService parkService;
    
    @Autowired
    private UserService userService;   
    
    @Autowired
    private TaskPrkService taskPrkService;    
    
	@Test
	public void testCreateParkkAndFindPark() 
		throws DuplicateInstanceException, InstanceNotFoundException {
		
		//String parkName, Date startupDate, Date productionDate, UserProfile userProfile, 
		//Company company, MultiPolygon mapPark
		
		Long weight = new Long("1");
		
		Calendar calendar = Calendar.getInstance();
		Date timestamp = new Date(calendar.getTime().getTime());
		
		UserProfile userProfile = userService.findUserProfile(weight);
		Company company = userService.findCompany(weight);
		
		String cadena = "estraperlacio";
		
		Park park = parkService.createPark(cadena, timestamp, timestamp, userProfile, company, null);
		
		Park park2 = parkService.findPark(park.getParkId());
		
		assertEquals(park, park2);
		
	}

	@Test
	public void testCreateTimetableAndFindTimetable() 
		throws DuplicateInstanceException, InstanceNotFoundException {
		
		// String timetableTag, UserProfile userProfile, Date tvi, Park park
		
		Long weight = new Long("1");
		String cadena = "estraperlacio";
		
		Calendar calendar = Calendar.getInstance();
		Date timestamp = new Date(calendar.getTime().getTime());
		
		UserProfile userProfile = userService.findUserProfile(weight);
		Park park = parkService.findPark(weight);
		
		Timetable timetable = parkService.createTimetable(cadena, userProfile, timestamp, park);
		
		Timetable timetable2 = parkService.findTimetable(timetable.getTimetableId());
		
		assertEquals(timetable, timetable2);
			
	}
	
	@Test
	public void testCreateStateAndFindState() 
		throws DuplicateInstanceException, InstanceNotFoundException {
		
		//Date tvi, Date tvf, Park park, EventTsk eventTsk, Upkeep upkeep, StateType stateType
		
		Long weight = new Long("1");
		
		Long weight1 = new Long("3");
		
		Calendar calendar = Calendar.getInstance();
		Date timestamp = new Date(calendar.getTime().getTime());
		
		Park park = parkService.findPark(weight);
		EventTsk eventTsk = taskPrkService.findEventTsk(weight);
		Upkeep upkeep = taskPrkService.findUpkeep(weight1);
		StateType stateType = parkService.findStateType(weight);
		
		State state = parkService.createState(timestamp, timestamp, park, eventTsk, upkeep, stateType);
		
		State state2 = parkService.findState(state.getStateId());
		
		assertEquals(state, state2);		
					
	}	
	
	
}
