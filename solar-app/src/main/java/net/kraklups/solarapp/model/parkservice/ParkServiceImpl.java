package net.kraklups.solarapp.model.parkservice;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vividsolutions.jts.geom.MultiPolygon;

import net.kraklups.modelutil.exceptions.DuplicateInstanceException;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.company.Company;
import net.kraklups.solarapp.model.park.Park;
import net.kraklups.solarapp.model.state.StateDao;
import net.kraklups.solarapp.model.statetype.StateTypeDao;
import net.kraklups.solarapp.model.timetable.Timetable;
import net.kraklups.solarapp.model.timetable.TimetableDao;
import net.kraklups.solarapp.model.userprofile.UserProfile;
import net.kraklups.solarapp.model.park.ParkDao;

@Service("parkService")
@Transactional
public class ParkServiceImpl implements ParkService {

    @Autowired
    private ParkDao parkDao;
    
    @Autowired
    private TimetableDao timetableDao;
    
    @Autowired
    private StateDao stateDao;
    
    @Autowired
    private StateTypeDao stateTypeDao;
    
    
	@Override
	public Park createPark(String parkName, Date startupDate,
			Date productionDate, UserProfile userProfile, Company company,
			MultiPolygon mapPark) throws DuplicateInstanceException {
		
        try {
            parkDao.findByParkName(parkName);
            throw new DuplicateInstanceException(parkName,
                    Park.class.getName());
        } catch (InstanceNotFoundException e) {
        	
            Park park = new Park(parkName, startupDate, productionDate, userProfile, company, mapPark);

            parkDao.save(park);
         
            return park;
        }
	}

	@Override
	public Park updatePark(Long parkId, String parkName, Date startupDate,
			Date productionDate, UserProfile userProfile, Company company,
			MultiPolygon mapPark) throws InstanceNotFoundException {
		
		Park park = parkDao.find(parkId);
		
		park.setParkName(parkName);
		park.setStartupDate(startupDate);
		park.setProductionDate(productionDate);
		park.setUserProfile(userProfile);
		park.setCompany(company);
		park.setMapPark(mapPark);
		
		return park;
	}

	@Override
	public Park findParkByName(String parkName)
			throws InstanceNotFoundException {
		
		return parkDao.findByParkName(parkName);
	}

	@Override
	public void assignLoginNamePark(Park park, UserProfile userProfile)
			throws InstanceNotFoundException {
		
		park.setUserProfile(userProfile);
	}

	@Override
	public void assignCompanyPark(Park park, Company company)
			throws InstanceNotFoundException {
		
		park.setCompany(company);
	}

	@Override
	public void assignGISPark(Park park, MultiPolygon mapPark)
			throws InstanceNotFoundException {
		
		park.setMapPark(mapPark);
	}

	@Override
	public ParkBlock getParkByLoginName(String loginName, int startIndex,
			int count) throws InstanceNotFoundException {
		
		List<Park> parks = parkDao.getParksByLoginName(loginName, startIndex, count +1);
		
		boolean existMoreParks = parks.size() == (count +1);
		
		return new ParkBlock(parks, existMoreParks);
	}

	@Override
	public ParkBlock getParkByCompanyId(Long companyId, int startIndex,
			int count) throws InstanceNotFoundException {
		
		List<Park> parks = parkDao.getParksByCompanyId(companyId, startIndex, count +1);
		
		boolean existMoreParks = parks.size() == (count +1);
		
		return new ParkBlock(parks, existMoreParks);
	}

	@Override
	public Timetable createTimetable(String tag, UserProfile userProfile,
			Date tvi, Park park) throws DuplicateInstanceException {
		
		Timetable timetable = new Timetable(tag, userProfile, tvi, park);
		
		timetableDao.save(timetable);
		
		return null;
	}

	@Override
	public Timetable updateTimetable(Long timetableId, String timetableTag,
			UserProfile userProfile, Date tvi, Park park)
			throws InstanceNotFoundException {
		
		Timetable timetable = timetableDao.find(timetableId);
		
		timetable.setTimetableTag(timetableTag);
		timetable.setTvi(tvi);
		timetable.setUserProfile(userProfile);
		timetable.setPark(park);
		
		return timetable;
	}

	@Override
	public void assignParkTimetable(Timetable timetable, Park park)
			throws InstanceNotFoundException {
		
		timetable.setPark(park);
	}

	@Override
	public void assignUserProfileTimetable(Timetable timetable, UserProfile userProfile)
			throws InstanceNotFoundException {
		
		timetable.setUserProfile(userProfile);
	}

	@Override
	public void assignTviTimetable(Timetable timetable, Date tvi)
			throws InstanceNotFoundException {
		
		timetable.setTvi(tvi);
	}

	@Override
	public Park getParkByTimetable(Timetable timetable)
			throws InstanceNotFoundException {
		
		return timetable.getPark();
	}


}
