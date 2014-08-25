package net.kraklups.solarapp.model.mngdb.datavaluemngdb;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;

import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.modelutil.repository.DataValueMngDbRepository;

@Repository
@ContextConfiguration("classpath:spring-mongodb-config.xml")
public class DataValueMngDbRepositoryImpl implements DataValueMngDbRepository {

	@Autowired 
	MongoTemplate mongoTemplate;
	
	Class<DataValueMngDb> entityClass = DataValueMngDb.class;
	
	Collection<DataValueMngDb> dataValueMngDb = new ArrayList<DataValueMngDb>();
	
	@Override
	public List<DataValueMngDb> getDataValueMngDbByDataValueId(Long dataValueId,
			int startIndex, int count) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createDataValueMngDb(String dataValueId, String dataType, String dataInput,
			Calendar tvi, Calendar tvf, String taskPrkId, String elementPrkId,
			String dataLoggerId, String sensorId) {

		try {
			dataValueMngDb.add(new DataValueMngDb(dataValueId, dataType, dataInput, tvi, tvf, taskPrkId, elementPrkId,
					dataLoggerId, sensorId));
			mongoTemplate.insert(dataValueMngDb);
		} catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
		}

	}

	@Override
	public List<DataValueMngDb> findDataValueMngDbByDataValueId(String dataValueId) {

		return mongoTemplate.find(new Query(Criteria.where("dataValueId").is(new Long(dataValueId).toString())), DataValueMngDb.class);
	
	}

	@Override
	public DataValueMngDb findById(BigInteger id) {
		return mongoTemplate.findById(id, DataValueMngDb.class);    
	}

	@Override
	public void insert(DataValueMngDb dataValueMngDb) {
		mongoTemplate.insert(dataValueMngDb);
		
	}

	@Override
	public List<DataValueMngDb> findAll() {
		return mongoTemplate.findAll(DataValueMngDb.class);	
	}



}
