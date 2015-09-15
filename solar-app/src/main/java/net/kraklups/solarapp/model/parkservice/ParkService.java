package net.kraklups.solarapp.model.parkservice;

import java.util.Date;

import com.vividsolutions.jts.geom.MultiPolygon;

import net.kraklups.modelutil.exceptions.DuplicateInstanceException;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.company.Company;
import net.kraklups.solarapp.model.eventtsk.EventTsk;
import net.kraklups.solarapp.model.park.Park;
import net.kraklups.solarapp.model.state.State;
import net.kraklups.solarapp.model.statetype.StateType;
import net.kraklups.solarapp.model.taskprk.Upkeep;
import net.kraklups.solarapp.model.timetable.Timetable;
import net.kraklups.solarapp.model.userprofile.UserProfile;

public interface ParkService {

    public Park createPark(String parkName, Date startupDate, Date productionDate, UserProfile userProfile, 
    		Company company, MultiPolygon mapPark) throws DuplicateInstanceException;
    
    public Park savePark(Park park) throws DuplicateInstanceException;

    public Park updatePark(Park park) throws InstanceNotFoundException;

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
	
    public State createState(Date tvi, Date tvf, Park park, EventTsk eventTsk, Upkeep upkeep, StateType stateType)
    		throws DuplicateInstanceException;
    
    public State updateState(Long stateId, Date tvi, Date tvf, Park park, EventTsk eventTsk, Upkeep upkeep, StateType stateType) 
    		throws InstanceNotFoundException; 

    public void assignParkState(State state, Park park)
    		throws InstanceNotFoundException;
    
    public void assignEventTskState(State state, EventTsk eventTsk)
    		throws InstanceNotFoundException;  

    public void assignUpkeepState(State state, Upkeep upkeep)
    		throws InstanceNotFoundException;  
    
    public void assignTviState(State state, Date tvi)
    		throws InstanceNotFoundException;

    public void assignStateTypeState(State state, StateType stateType)
    		throws InstanceNotFoundException;  

    public void assignTvfState(State state, Date tvf)
    		throws InstanceNotFoundException;	
	
    public State saveState(State state)
    		throws DuplicateInstanceException;
    
	public StateTypeBlock getStateTypes(int startIndex, int count) 
			throws InstanceNotFoundException;    
    
	public ParkBlock getParks(int startIndex, int count) 
			throws InstanceNotFoundException;
	
	public StateBlock getStates(int startIndex, int count) 
			throws InstanceNotFoundException;  	
	
	public Park findPark(Long parkId)
            throws InstanceNotFoundException;
	
	public State findState(Long stateId)
            throws InstanceNotFoundException;	
	
	public Timetable findTimetable(Long timetableId)
            throws InstanceNotFoundException;	
	
	public StateType findStateType(Long stateTypeId)
            throws InstanceNotFoundException;		

    public Timetable saveTimetable(Timetable timetable)
    		throws DuplicateInstanceException;	
	
}
