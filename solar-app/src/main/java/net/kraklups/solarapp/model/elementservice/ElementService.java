package net.kraklups.solarapp.model.elementservice;

import java.util.Calendar;
import java.util.List;

import net.kraklups.modelutil.exceptions.DuplicateInstanceException;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.datalogger.DataLogger;
import net.kraklups.solarapp.model.elementprk.ArrayBox;
import net.kraklups.solarapp.model.elementprk.ArrayPanel;
import net.kraklups.solarapp.model.elementprk.Cell;
import net.kraklups.solarapp.model.elementprk.Counter;
import net.kraklups.solarapp.model.elementprk.ElectricalSubstation;
import net.kraklups.solarapp.model.elementprk.ExtractionPoint;
import net.kraklups.solarapp.model.elementprk.Gps;
import net.kraklups.solarapp.model.elementprk.Inverter;
import net.kraklups.solarapp.model.elementprk.MediumVoltage;
import net.kraklups.solarapp.model.elementprk.SolarTracker;
import net.kraklups.solarapp.model.elementprk.StringLine;
import net.kraklups.solarapp.model.elementprk.WeatherStation;
import net.kraklups.solarapp.model.park.Park;
import net.kraklups.solarapp.model.userprofile.UserProfile;

public interface ElementService {

	public ArrayBox createArrayBox(String elementPrkName, String elementPrkTag, Calendar tvi,
			Calendar lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park, StringLine stringLine)
					throws DuplicateInstanceException;
	
	public ArrayBox updateArrayBox(Long arrayBoxId, String elementPrkName, String elementPrkTag, Calendar tvi,
			Calendar lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park, StringLine stringLine)
					throws InstanceNotFoundException;	
	
	public ArrayPanel createArrayPanel(String elementPrkName, String elementPrkTag, Calendar tvi,
			Calendar lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park)
					throws DuplicateInstanceException;
	
	public ArrayPanel updateArrayPanel(Long arrayBoxId, String elementPrkName, String elementPrkTag, Calendar tvi,
			Calendar lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park)
					throws InstanceNotFoundException;	

	public Cell createCell(String elementPrkName, String elementPrkTag, Calendar tvi,
			Calendar lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park, ArrayPanel arrayPanel, StringLine stringLine)
					throws DuplicateInstanceException;
	
	public Cell updateCell(Long arrayBoxId, String elementPrkName, String elementPrkTag, Calendar tvi,
			Calendar lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park, ArrayPanel arrayPanel, StringLine stringLine)
					throws InstanceNotFoundException;	

	public Counter createCounter(String elementPrkName, String elementPrkTag, Calendar tvi,
			Calendar lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park)
					throws DuplicateInstanceException;
	
	public Counter updateCounter(Long arrayBoxId, String elementPrkName, String elementPrkTag, Calendar tvi,
			Calendar lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park)
					throws InstanceNotFoundException;	
	
	public ElectricalSubstation createElectricalSubstation(String elementPrkName, String elementPrkTag, Calendar tvi,
			Calendar lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park, MediumVoltage mediumVoltage)
					throws DuplicateInstanceException;
	
	public ElectricalSubstation updateElectricalSubstation(Long arrayBoxId, String elementPrkName, String elementPrkTag, Calendar tvi,
			Calendar lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park, MediumVoltage mediumVoltage)
					throws InstanceNotFoundException;	
	
	public ExtractionPoint createExtractionPoint(String elementPrkName, String elementPrkTag, Calendar tvi,
			Calendar lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park)
					throws DuplicateInstanceException;
	
	public ExtractionPoint updateExtractionPoint(Long arrayBoxId, String elementPrkName, String elementPrkTag, Calendar tvi,
			Calendar lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park)
					throws InstanceNotFoundException;	
	
	public Gps createGps(String elementPrkName, String elementPrkTag, Calendar tvi,
			Calendar lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park)
					throws DuplicateInstanceException;
	
	public Gps updateGps(Long arrayBoxId, String elementPrkName, String elementPrkTag, Calendar tvi,
			Calendar lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park)
					throws InstanceNotFoundException;	
	
	public Inverter createInverter(String elementPrkName, String elementPrkTag, Calendar tvi,
			Calendar lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park, Counter counter, ArrayBox arrayBox, 
			ElectricalSubstation electricalSubstation)
					throws DuplicateInstanceException;
	
	public Inverter updateInverter(Long arrayBoxId, String elementPrkName, String elementPrkTag, Calendar tvi,
			Calendar lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park, Counter counter, ArrayBox arrayBox, 
			ElectricalSubstation electricalSubstation)
					throws InstanceNotFoundException;	
	
	public MediumVoltage createMediumVoltage(String elementPrkName, String elementPrkTag, Calendar tvi,
			Calendar lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park, ExtractionPoint extractionPoint)
					throws DuplicateInstanceException;
	
	public MediumVoltage updateMediumVoltage(Long arrayBoxId, String elementPrkName, String elementPrkTag, Calendar tvi,
			Calendar lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park, ExtractionPoint extractionPoint)
					throws InstanceNotFoundException;	
	
	public SolarTracker createSolarTracker(String elementPrkName, String elementPrkTag, Calendar tvi,
			Calendar lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park)
					throws DuplicateInstanceException;
	
	public SolarTracker updateSolarTracker(Long arrayBoxId, String elementPrkName, String elementPrkTag, Calendar tvi,
			Calendar lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park)
					throws InstanceNotFoundException;
	
	public StringLine createStringLine(String elementPrkName, String elementPrkTag, Calendar tvi,
			Calendar lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park, ArrayBox arrayBox)
					throws DuplicateInstanceException;
	
	public StringLine updateStringLine(Long arrayBoxId, String elementPrkName, String elementPrkTag, Calendar tvi,
			Calendar lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park, ArrayBox arrayBox)
					throws InstanceNotFoundException;	

	public WeatherStation createWeatherStation(String elementPrkName, String elementPrkTag, Calendar tvi,
			Calendar lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park)
					throws DuplicateInstanceException;
	
	public WeatherStation updateWeatherStation(Long arrayBoxId, String elementPrkName, String elementPrkTag, Calendar tvi,
			Calendar lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park)
					throws InstanceNotFoundException;	
	
	
}
