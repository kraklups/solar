package net.kraklups.solarapp.test.model.mngdb;

import java.util.Calendar;

import net.kraklups.modelutil.repository.DataValueMngDbRepository;
import net.kraklups.solarapp.model.mngdb.datavaluemngdb.DataValueMngDb;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mongodb-config-test.xml")
public class DataValueTest {

    @Autowired
    private DataValueMngDbRepository dataValueMngDbRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Before
    public void setUp() {
        mongoTemplate.dropCollection("dataValueMngDb");
    }

    @After
    public void tearDown() {
        mongoTemplate.dropCollection("dataValueMngDb");
    }
    
    @Test
    public void insert_and_find_dataValue_based_on_id() {

    	Calendar cal = Calendar.getInstance();
    	
    	DataValueMngDb dataValueMngDb = new DataValueMngDb();
        dataValueMngDb.setDataValueId("1");
        dataValueMngDb.setDataType("xXx");
        dataValueMngDb.setDataInput("666");
        dataValueMngDb.setTvi(cal);
        dataValueMngDb.setTvf(cal);
        dataValueMngDb.setTaskPrkId("1");
        dataValueMngDb.setElementPrkId("1");
        dataValueMngDb.setDataLoggerId("1");
        dataValueMngDb.setSensorId("1");        
        dataValueMngDbRepository.insert(dataValueMngDb);

        DataValueMngDb savedDataValue = dataValueMngDbRepository.findById(dataValueMngDb.getId());
        Assert.assertEquals(dataValueMngDb.getDataValueId(), savedDataValue.getDataValueId());
        Assert.assertEquals(dataValueMngDb.getDataType(), savedDataValue.getDataType());
        Assert.assertEquals(dataValueMngDb.getDataInput(), savedDataValue.getDataInput());
        Assert.assertEquals(dataValueMngDb.getTvi(), savedDataValue.getTvi());
        Assert.assertEquals(dataValueMngDb.getTvf(), savedDataValue.getTvf());
        Assert.assertEquals(dataValueMngDb.getTaskPrkId(), savedDataValue.getTaskPrkId());
        Assert.assertEquals(dataValueMngDb.getElementPrkId(), savedDataValue.getElementPrkId());
        Assert.assertEquals(dataValueMngDb.getDataLoggerId(), savedDataValue.getDataLoggerId());
        Assert.assertEquals(dataValueMngDb.getSensorId(), savedDataValue.getSensorId());
        
    }

    @Test
    public void find_all_dataValues() {

    	Calendar cal = Calendar.getInstance();
    	
        DataValueMngDb dataValueMngDb = new DataValueMngDb();
        dataValueMngDb.setDataValueId("1");
        dataValueMngDb.setDataType("xXx");
        dataValueMngDb.setDataInput("666");
        dataValueMngDb.setTvi(cal);
        dataValueMngDb.setTvf(cal);
        dataValueMngDb.setTaskPrkId("1");
        dataValueMngDb.setElementPrkId("1");
        dataValueMngDb.setDataLoggerId("1");
        dataValueMngDb.setSensorId("1");        

        dataValueMngDbRepository.insert(dataValueMngDb);

        Assert.assertEquals(1, dataValueMngDbRepository.findAll().size());

    }

}
