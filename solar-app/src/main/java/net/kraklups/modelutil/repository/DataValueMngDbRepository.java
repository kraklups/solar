package net.kraklups.modelutil.repository;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;

import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.mngdb.datavaluemngdb.DataValueMngDb;

@NoRepositoryBean
public interface DataValueMngDbRepository {

	public void createDataValueMngDb(String dataValueId, String dataType, String dataInput,Calendar tvi, Calendar tvf, 
			String taskPrkId, String elementPrkId, String dataLoggerId, String sensorId);
	
    public List<DataValueMngDb> getDataValueMngDbByDataValueId(Long dataValueId,
			int startIndex, int count) throws InstanceNotFoundException;
	
    public List<DataValueMngDb> findDataValueMngDbByDataValueId(String dataValueId);
    
    public DataValueMngDb findById(BigInteger id);
    
    public void insert(DataValueMngDb dataValueMngDb);
    
    public List<DataValueMngDb> findAll();
    
}
