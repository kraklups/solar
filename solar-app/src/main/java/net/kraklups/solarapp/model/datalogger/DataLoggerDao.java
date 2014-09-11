package net.kraklups.solarapp.model.datalogger;

import java.util.List;

import net.kraklups.modelutil.dao.GenericDao;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;

public interface DataLoggerDao extends GenericDao<DataLogger, Long> {
		
    /**
     * Returns a DataLogger using the datalogger tag (not datalogger identifier)
     *
     * @param dataLoggerTag not the module identifier
     * @return list of dataloggers
     */			
     
     public List<DataLogger> getDataLoggerByDataLoggerId(Long dataLoggerId, int startIndex, int count) 
            throws InstanceNotFoundException; 

}
