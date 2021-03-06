package net.kraklups.solarapp.model.elementservice;

import java.util.Date;

import com.vividsolutions.jts.geom.Point;

import net.kraklups.modelutil.exceptions.DuplicateInstanceException;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.datalogger.DataLogger;
import net.kraklups.solarapp.model.elementprk.ArrayBox;
import net.kraklups.solarapp.model.elementprk.ArrayPanel;
import net.kraklups.solarapp.model.elementprk.Cell;
import net.kraklups.solarapp.model.elementprk.Counter;
import net.kraklups.solarapp.model.elementprk.ElectricalSubstation;
import net.kraklups.solarapp.model.elementprk.ElementPrk;
import net.kraklups.solarapp.model.elementprk.ExtractionPoint;
import net.kraklups.solarapp.model.elementprk.Gps;
import net.kraklups.solarapp.model.elementprk.Inverter;
import net.kraklups.solarapp.model.elementprk.MediumVoltage;
import net.kraklups.solarapp.model.elementprk.SolarTracker;
import net.kraklups.solarapp.model.elementprk.StringLine;
import net.kraklups.solarapp.model.elementprk.WeatherStation;
import net.kraklups.solarapp.model.park.Park;
import net.kraklups.solarapp.model.sensor.Sensor;
import net.kraklups.solarapp.model.userprofile.UserProfile;

public interface ElementService {

	public ElementPrk createElementPrk(String elementPrkName, String elementPrkTag, Date tvi,
			Date lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park, Point mapElement)
					throws DuplicateInstanceException;
	
	public ArrayBox createArrayBox(String elementPrkName, String elementPrkTag, Date tvi,
			Date lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park, Point mapElement)
					throws DuplicateInstanceException;
	
	public ArrayBox updateArrayBox(Long arrayBoxId, String elementPrkName, String elementPrkTag, Date tvi,
			Date lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park, Point mapElement)
					throws InstanceNotFoundException;	
	
	public ArrayPanel createArrayPanel(String elementPrkName, String elementPrkTag, Date tvi,
			Date lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park, Point mapElement, StringLine stringLine)
					throws DuplicateInstanceException;
	
	public ArrayPanel updateArrayPanel(Long arrayBoxId, String elementPrkName, String elementPrkTag, Date tvi,
			Date lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park, Point mapElement, StringLine stringLine)
					throws InstanceNotFoundException;	

	public Cell createCell(String elementPrkName, String elementPrkTag, Date tvi,
			Date lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park, Point mapElement, ArrayPanel arrayPanel, StringLine stringLine)
					throws DuplicateInstanceException;
	
	public Cell updateCell(Long arrayBoxId, String elementPrkName, String elementPrkTag, Date tvi,
			Date lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park, Point mapElement, ArrayPanel arrayPanel, StringLine stringLine)
					throws InstanceNotFoundException;	

	public Counter createCounter(String elementPrkName, String elementPrkTag, Date tvi,
			Date lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park, Point mapElement)
					throws DuplicateInstanceException;
	
	public Counter updateCounter(Long arrayBoxId, String elementPrkName, String elementPrkTag, Date tvi,
			Date lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park, Point mapElement)
					throws InstanceNotFoundException;	
	
	public ElectricalSubstation createElectricalSubstation(String elementPrkName, String elementPrkTag, Date tvi,
			Date lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park, Point mapElement, MediumVoltage mediumVoltage)
					throws DuplicateInstanceException;
	
	public ElectricalSubstation updateElectricalSubstation(Long arrayBoxId, String elementPrkName, String elementPrkTag, Date tvi,
			Date lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park, Point mapElement, MediumVoltage mediumVoltage)
					throws InstanceNotFoundException;	
	
	public ExtractionPoint createExtractionPoint(String elementPrkName, String elementPrkTag, Date tvi,
			Date lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park, Point mapElement)
					throws DuplicateInstanceException;
	
	public ExtractionPoint updateExtractionPoint(Long arrayBoxId, String elementPrkName, String elementPrkTag, Date tvi,
			Date lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park, Point mapElement)
					throws InstanceNotFoundException;	
	
	public Gps createGps(String elementPrkName, String elementPrkTag, Date tvi,
			Date lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park, Point mapElement)
					throws DuplicateInstanceException;
	
	public Gps updateGps(Long arrayBoxId, String elementPrkName, String elementPrkTag, Date tvi,
			Date lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park, Point mapElement)
					throws InstanceNotFoundException;	
	
	public Inverter createInverter(String elementPrkName, String elementPrkTag, Date tvi,
			Date lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park, Point mapElement, Counter counter, ArrayBox arrayBox, 
			ElectricalSubstation electricalSubstation)
					throws DuplicateInstanceException;
	
	public Inverter updateInverter(Long arrayBoxId, String elementPrkName, String elementPrkTag, Date tvi,
			Date lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park, Point mapElement, Counter counter, ArrayBox arrayBox, 
			ElectricalSubstation electricalSubstation)
					throws InstanceNotFoundException;	
	
	public MediumVoltage createMediumVoltage(String elementPrkName, String elementPrkTag, Date tvi,
			Date lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park, Point mapElement, ExtractionPoint extractionPoint)
					throws DuplicateInstanceException;
	
	public MediumVoltage updateMediumVoltage(Long arrayBoxId, String elementPrkName, String elementPrkTag, Date tvi,
			Date lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park, Point mapElement, ExtractionPoint extractionPoint)
					throws InstanceNotFoundException;	
	
	public SolarTracker createSolarTracker(String elementPrkName, String elementPrkTag, Date tvi,
			Date lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park, Point mapElement)
					throws DuplicateInstanceException;
	
	public SolarTracker updateSolarTracker(Long arrayBoxId, String elementPrkName, String elementPrkTag, Date tvi,
			Date lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park, Point mapElement)
					throws InstanceNotFoundException;
	
	public StringLine createStringLine(String elementPrkName, String elementPrkTag, Date tvi,
			Date lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park, Point mapElement, ArrayBox arrayBox)
					throws DuplicateInstanceException;
	
	public StringLine updateStringLine(Long arrayBoxId, String elementPrkName, String elementPrkTag, Date tvi,
			Date lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park, Point mapElement, ArrayBox arrayBox)
					throws InstanceNotFoundException;	

	public WeatherStation createWeatherStation(String elementPrkName, String elementPrkTag, Date tvi,
			Date lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park, Point mapElement)
					throws DuplicateInstanceException;
	
	public WeatherStation updateWeatherStation(Long arrayBoxId, String elementPrkName, String elementPrkTag, Date tvi,
			Date lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park, Point mapElement)
					throws InstanceNotFoundException;	
	
	public void assignParkElementPrk(ElementPrk elementPrk, Park park) 
			throws InstanceNotFoundException;

	public void assignElementPrkNameElementPrk(ElementPrk elementPrk, String elementPrkName) 
			throws InstanceNotFoundException;

	public void assignElementPrkTagElementPrk(ElementPrk elementPrk, String elementPrkTag) 
			throws InstanceNotFoundException;

	public void assignTviElementPrk(ElementPrk elementPrk, Date tvi) 
			throws InstanceNotFoundException;

	public void assignLastAccessElementPrk(ElementPrk elementPrk, Date lastAccess) 
			throws InstanceNotFoundException;

	public void assignDataLoggerElementPrk(ElementPrk elementPrk, DataLogger dataLogger) 
			throws InstanceNotFoundException;

	public void assignUserProfileElementPrk(ElementPrk elementPrk, UserProfile userProfile) 
			throws InstanceNotFoundException;
	
	public void assignStringLineArrayPanel(ArrayPanel arrayPanel, StringLine stringLine) 
			throws InstanceNotFoundException;

	public void assignArrayPanelCell(Cell cell, ArrayPanel arrayPanel) 
			throws InstanceNotFoundException;

	public void assignStringLineCell(Cell cell, StringLine stringLine) 
			throws InstanceNotFoundException;

	public void assignMediumVoltageElectricalSubstation(ElectricalSubstation electricalSubstation, MediumVoltage mediumVoltage) 
			throws InstanceNotFoundException;

	public void assignArrayBoxInverter(Inverter inverter, ArrayBox arrayBox) 
			throws InstanceNotFoundException;

	public void assignCounterInverter(Inverter inverter, Counter counter) 
			throws InstanceNotFoundException;

	public void assignElectricalSubstationInverter(Inverter inverter, ElectricalSubstation electricalSubstation) 
			throws InstanceNotFoundException;

	public void assignExtractionPointMediumVoltage(MediumVoltage mediumVoltage, ExtractionPoint extractionPoint) 
			throws InstanceNotFoundException;

	public void assignArrayBoxStringLine(StringLine stringLine, ArrayBox arrayBox) 
			throws InstanceNotFoundException;	
	
	public Sensor createSensor(String sensorTag, String sensorType, ElementPrk elementPrk)
			throws DuplicateInstanceException;

	public Sensor updateSensor(Long sensorId, String sensorTag, String sensorType, ElementPrk elementPrk)
			throws InstanceNotFoundException;	
	
	public void assignElementPrkSensor(Sensor sensor, ElementPrk elementPrk) 
			throws InstanceNotFoundException;	

	public SensorBlock getSensorByElementPrkId(Long elementPrkId, int startIndex, int count)
			throws InstanceNotFoundException;	

	public ElementPrkBlock getCellByStringLineId(Long stringLineId, int startIndex, int count)
			throws InstanceNotFoundException;	

	public ElementPrkBlock getCellByArrayPanelId(Long arrayPanelId, int startIndex, int count)
			throws InstanceNotFoundException;

	public ElementPrkBlock getArrayPanelByStringLineId(Long stringLineId, int startIndex, int count)
			throws InstanceNotFoundException;

	public ElementPrkBlock getInverterByArrayBoxId(Long arrayBoxId, int startIndex, int count)
			throws InstanceNotFoundException;

	public ElementPrkBlock getInverterByElectricalSubstationId(Long electricalSubstationId, int startIndex, int count)
			throws InstanceNotFoundException;

	public ElementPrkBlock getElectricalSubstationByMediumVoltageId(Long mediumVoltageId, int startIndex, int count)
			throws InstanceNotFoundException;

	public ElementPrkBlock getMediumVoltageByCounterId(Long counterId, int startIndex, int count)
			throws InstanceNotFoundException;	

	public ElementPrkBlock getInverterByCounterId(Long counterId, int startIndex, int count)
			throws InstanceNotFoundException;
	
	public ElementPrkBlock getMediumVoltageByExtractionPointId(Long extractionPointId, int startIndex, int count)
			throws InstanceNotFoundException;	
	
	public ElementPrkBlock getElementPrkByDataLoggerId(Long dataLoggerId, int startIndex, int count) 
			throws InstanceNotFoundException;
	
	public SensorBlock getSensors(int startIndex, int count) 
			throws InstanceNotFoundException;
	
	public ElementPrkBlock getElementPrks(int startIndex, int count) 
			throws InstanceNotFoundException;	
	
    public Sensor saveSensor(Sensor sensor)
    		throws DuplicateInstanceException;	
    
    public ElementPrk saveElementPrk(ElementPrk elementPrk)
    		throws DuplicateInstanceException;	 
    
	public StringLineBlock getStringLines(int startIndex, int count) 
			throws InstanceNotFoundException;    
	
    public ArrayPanel saveElementPrk(ArrayPanel arrayPanel)
    		throws DuplicateInstanceException;
    
    public StringLine saveElementPrk(StringLine stringLine)
    		throws DuplicateInstanceException;    
    
    public Cell saveElementPrk(Cell cell)
    		throws DuplicateInstanceException;    
    
    public Counter saveElementPrk(Counter counter)
    		throws DuplicateInstanceException;
    
    public ElectricalSubstation saveElementPrk(ElectricalSubstation electricalSubstation)
    		throws DuplicateInstanceException;
    
    public ExtractionPoint saveElementPrk(ExtractionPoint extractionPoint)
    		throws DuplicateInstanceException;
    
    public Gps saveElementPrk(Gps gps)
    		throws DuplicateInstanceException;
    
    public Inverter saveElementPrk(Inverter inverter)
    		throws DuplicateInstanceException;
    
    public MediumVoltage saveElementPrk(MediumVoltage mediumVoltage)
    		throws DuplicateInstanceException;
    
    public SolarTracker saveElementPrk(SolarTracker solarTracker)
    		throws DuplicateInstanceException;
    
    public ArrayBox saveElementPrk(ArrayBox arrayBox)
    		throws DuplicateInstanceException;
    
    public WeatherStation saveElementPrk(WeatherStation weatherStation)
    		throws DuplicateInstanceException;

	public ArrayPanelBlock getArrayPanels(int startIndex, int count) 
			throws InstanceNotFoundException; 
	
	public MediumVoltageBlock getMediumVoltages(int startIndex, int count) 
			throws InstanceNotFoundException; 	
	
	public CounterBlock getCounters(int startIndex, int count) 
			throws InstanceNotFoundException; 
	
	public ArrayBoxBlock getArrayBoxs(int startIndex, int count) 
			throws InstanceNotFoundException;  	
	
	public ElectricalSubstationBlock getElectricalSubstations(int startIndex, int count) 
			throws InstanceNotFoundException; 	
	
	public ExtractionPointBlock getExtractionPoints(int startIndex, int count) 
			throws InstanceNotFoundException; 	
	
	public ElementPrk findElementPrk(Long elementPrkId)
            throws InstanceNotFoundException;

	public Sensor findSensor(Long sensorId)
            throws InstanceNotFoundException;	
	
}
