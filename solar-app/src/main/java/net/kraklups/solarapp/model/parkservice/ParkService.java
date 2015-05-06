package net.kraklups.solarapp.model.parkservice;

import java.util.Date;

import com.vividsolutions.jts.geom.MultiPolygon;

import net.kraklups.modelutil.exceptions.DuplicateInstanceException;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.company.Company;
import net.kraklups.solarapp.model.park.Park;
import net.kraklups.solarapp.model.timetable.Timetable;
import net.kraklups.solarapp.model.userprofile.UserProfile;

public interface ParkService {

    public Park createPark(String parkName, Date startupDate, Date productionDate, UserProfile userProfile, 
    		Company company, MultiPolygon mapPark) throws DuplicateInstanceException;
    
    public Park savePark(Park park) throws DuplicateInstanceException;

    public Park updatePark(Long parkId, String parkName, Date startupDate, Date productionDate, UserProfile userProfile, 
    		Company company, MultiPolygon mapPark) throws InstanceNotFoundException;

    public Park findParkByName(String parkName)
            throws InstanceNotFoundException;
	
    public void assignLoginNamePark(Park park, UserProfile userProfile)
            throws InstanceNotFoundException;
    
    public void assignCompanyPark(Park park, Company company)
            throws InstanceNotFoundException;    
    
    public void assignGISPark(Park park, MultiPolygon mapPark)
            throws InstanceNotFoundException;    
    
    public ParkBlock getParkByLoginName(String loginName, int startIndex, int count) 
            throws InstanceNotFoundException;    
    
    public ParkBlock getParkByCompanyId(Long companyId, int startIndex, int count) 
            throws InstanceNotFoundException; 
    
    public Timetable createTimetable(String tag, UserProfile userProfile, Date tvi, Park park)
    		throws DuplicateInstanceException;
    
    public Timetable updateTimetable(Long timetableId, String timetableTag, UserProfile userProfile, Date tvi, Park park) 
    		throws InstanceNotFoundException; 
    
    public void assignParkTimetable(Timetable timetable, Park park)
    		throws InstanceNotFoundException;
    
    public void assignUserProfileTimetable(Timetable timetable, UserProfile userProfile)
    		throws InstanceNotFoundException;  
    
    public void assignTviTimetable(Timetable timetable, Date tvi)
    		throws InstanceNotFoundException;
    
    public Park getParkByTimetable(Timetable timetable)
    		throws InstanceNotFoundException;  
    
	public TimetableBlock getTimetables(int startIndex, int count) 
			throws InstanceNotFoundException;
    
}
