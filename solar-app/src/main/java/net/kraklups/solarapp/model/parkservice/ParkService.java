package net.kraklups.solarapp.model.parkservice;

import java.util.Calendar;
import java.util.List;

import com.vividsolutions.jts.geom.MultiPolygon;

import net.kraklups.modelutil.exceptions.DuplicateInstanceException;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.park.Park;

public interface ParkService {

    public Park createPark(String parkName, Calendar startupDate, Calendar productionDate, String loginName, 
    		String company, MultiPolygon mapPark) throws DuplicateInstanceException;

    public void updatePark(String parkName, Calendar startupDate, Calendar productionDate, String loginName, 
    		String company, MultiPolygon mapPark) throws InstanceNotFoundException;

    public Park findParkByName(String parkName)
            throws InstanceNotFoundException;
	
    public void assignLoginNamePark(Park park, String loginName)
            throws InstanceNotFoundException;
    
    public void assignCompanyPark(Park park, String company)
            throws InstanceNotFoundException;    
    
    public void assignGISPark(Park park, MultiPolygon mapPark)
            throws InstanceNotFoundException;    
    
    public List<Park> getParksByLoginName(String loginName, int startIndex, int count) 
            throws InstanceNotFoundException;    
    
    public List<Park> getParksByCompany(String company, int startIndex, int count) 
            throws InstanceNotFoundException;    
}
