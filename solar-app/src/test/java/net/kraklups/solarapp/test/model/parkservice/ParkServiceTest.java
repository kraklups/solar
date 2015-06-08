package net.kraklups.solarapp.test.model.parkservice;

import static net.kraklups.solarapp.model.util.GlobalNames.SPRING_CONFIG_FILE;
import static net.kraklups.solarapp.test.util.GlobalNames.SPRING_CONFIG_TEST_FILE;
import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;

import net.kraklups.modelutil.exceptions.DuplicateInstanceException;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.company.Company;
import net.kraklups.solarapp.model.park.Park;
import net.kraklups.solarapp.model.parkservice.ParkService;
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
	
}
