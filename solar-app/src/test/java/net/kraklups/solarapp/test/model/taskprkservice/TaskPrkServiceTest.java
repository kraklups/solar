package net.kraklups.solarapp.test.model.taskprkservice;

import static net.kraklups.solarapp.model.util.GlobalNames.SPRING_CONFIG_FILE;
import static net.kraklups.solarapp.test.util.GlobalNames.SPRING_CONFIG_TEST_FILE;
import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;

import net.kraklups.modelutil.exceptions.DuplicateInstanceException;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.park.Park;
import net.kraklups.solarapp.model.parkservice.ParkService;
import net.kraklups.solarapp.model.role.Role;
import net.kraklups.solarapp.model.taskprk.TaskPrk;
import net.kraklups.solarapp.model.taskprkservice.TaskPrkService;
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
		  

}
