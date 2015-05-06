package net.kraklups.solarapp.model.sensor;

import java.util.List;

import net.kraklups.modelutil.dao.GenericDao;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;

public interface SensorDao extends GenericDao<Sensor, Long> {

    /**
     * Returns a Sensor using the sensor tag (not sensor identifier)
     *
     * @param sensorTag not the module identifier
     * @return list of sensors
     */			
     
     public List<Sensor> getSensorsBySensorTag(String sensorTag, int startIndex, int count) 
            throws InstanceNotFoundException; 

     public List<Sensor> getSensorsByElementPrkId(Long elementPrkId, int startIndex, int count) 
             throws InstanceNotFoundException;	
     
     public List<Sensor> getSensors(int startIndex, int count)
 			throws InstanceNotFoundException;     
}
