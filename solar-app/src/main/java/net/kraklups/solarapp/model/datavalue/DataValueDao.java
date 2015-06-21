package net.kraklups.solarapp.model.datavalue;

import java.util.List;

import net.kraklups.modelutil.dao.GenericDao;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;

public interface DataValueDao extends GenericDao<DataValue, Long>  {

    /**
     * Returns a List of DataValue using the taskPrkId
     *
     * @param taskPrkId
     * @return list of dataValues
     */	
	public List<DataValue> getDataValuesByTaskPrkId(Long taskPrkId, int startIndex, int count) 
            throws InstanceNotFoundException; 	
    
    /**
     * Returns a List of DataValue using the elementPrkId
     *
     * @param elementPrkId
     * @return list of dataValues
     */	
	public List<DataValue> getDataValuesByElementPrkId(Long elementPrkId, int startIndex, int count) 
            throws InstanceNotFoundException; 	
	
    /**
     * Returns a List of DataValue using the dataLoggerId
     *
     * @param dataLoggerId
     * @return list of dataValues
     */	
	public List<DataValue> getDataValuesByDataLoggerId(Long dataLoggerId, int startIndex, int count) 
            throws InstanceNotFoundException; 	
	
    /**
     * Returns a List of DataValue using the sensorId
     *
     * @param sensorId
     * @return list of dataValues
     */	
	public List<DataValue> getDataValuesBySensorId(Long sensorId, int startIndex, int count) 
            throws InstanceNotFoundException; 		

    public List<DataValue> getDataValues(int startIndex, int count)
			throws InstanceNotFoundException;	
	
}
