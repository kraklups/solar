package net.kraklups.solarapp.model.report;

import java.sql.Timestamp;
import java.util.List;

import net.kraklups.modelutil.dao.GenericDao;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;

public interface ReportDao extends GenericDao<Report, Long> {

    /**
     * Returns a List of Report using the userProfileId
     *
     * @param auserProfileId
     * @return list of reports
     */			     
     public List<Report> getReportsByUserProfileId(Long userProfileId, int startIndex, int count) 
            throws InstanceNotFoundException; 	

     /**
      * Returns a List of Report using the dateRequest (not element identifier)
      *
      * @param dateRequest not the module identifier
      * @return list of reports
      */			     
      public List<Report> getReportsByDateRequest(Timestamp dateRequest, int startIndex, int count) 
             throws InstanceNotFoundException; 	
     
      /**
       * Returns a List of TaskPrk using the parkId (not element identifier)
       *
       * @param parkId not the module identifier
       * @return list of taskPrks
       */			     
       public List<Report> getReportsByParkId(Long parkId, int startIndex, int count) 
              throws InstanceNotFoundException; 	

	
}
