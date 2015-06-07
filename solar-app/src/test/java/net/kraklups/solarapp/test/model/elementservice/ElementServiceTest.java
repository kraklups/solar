package net.kraklups.solarapp.test.model.elementservice;

import static net.kraklups.solarapp.model.util.GlobalNames.SPRING_CONFIG_FILE;
import static net.kraklups.solarapp.test.util.GlobalNames.SPRING_CONFIG_TEST_FILE;

import net.kraklups.solarapp.model.elementservice.ElementService;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { SPRING_CONFIG_FILE, SPRING_CONFIG_TEST_FILE })
@Transactional
public class ElementServiceTest {

    @Autowired
    private ElementService elementService;
    
}
