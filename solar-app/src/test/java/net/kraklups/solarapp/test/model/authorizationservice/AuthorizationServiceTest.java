package net.kraklups.solarapp.test.model.authorizationservice;

import static net.kraklups.solarapp.model.util.GlobalNames.SPRING_CONFIG_FILE;
import static net.kraklups.solarapp.test.util.GlobalNames.SPRING_CONFIG_TEST_FILE;
import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import net.kraklups.modelutil.exceptions.DuplicateInstanceException;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.authorizationservice.AuthorizationService;

import net.kraklups.solarapp.model.role.Role;
import net.kraklups.solarapp.model.module.Module;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author nexus7
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { SPRING_CONFIG_FILE, SPRING_CONFIG_TEST_FILE })
@Transactional
public class AuthorizationServiceTest {
	
	private final long NON_EXISTENT_ROLE_ID = -1;
	private final long NON_EXISTENT_MODULE_ID = -2;
	
	@Autowired 
	private AuthorizationService authorizationService;
	
	@Test
	public void testRegisterRoleAndFindRole() 
		throws DuplicateInstanceException, InstanceNotFoundException {
		
		/* Register role and find role */
		
		Long weight = new Long("1");
		Role role = authorizationService.registerRole("invitado", "tuxlex", weight);
		
		Role role2 = authorizationService.findRole(role.getRoleId());
		
		assertEquals(role, role2);		
	}
	
    @Test(expected = DuplicateInstanceException.class)
    public void testRegisterDuplicatedRole() throws DuplicateInstanceException,
        InstanceNotFoundException {
    	
    	Long weight = new Long("1");    	    
    	
    	authorizationService.registerRole("invitado", "tuxlex", weight);
    	
    	authorizationService.registerRole("invitado", "tuxlex", weight);
    }
    
	@Test
	public void testRegisterModuleAndFindModule() 
		throws DuplicateInstanceException, InstanceNotFoundException {
		
		/* Register role and find role */
		
		Module module = authorizationService.registerModule("invitado");
		
		Module module2 = authorizationService.findModule(module.getModuleId());
		
		assertEquals(module, module2);		
	}
	
    @Test(expected = DuplicateInstanceException.class)
    public void testRegisterDuplicatedModule() throws DuplicateInstanceException,
        InstanceNotFoundException {
    	  	
    	authorizationService.registerModule("invitado");
    	
    	authorizationService.registerModule("invitado");
    }
    
    
    
}
