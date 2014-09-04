package net.kraklups.solarapp.model.elementservice;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.kraklups.modelutil.exceptions.DuplicateInstanceException;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.datalogger.DataLogger;
import net.kraklups.solarapp.model.elementprk.ArrayBox;
import net.kraklups.solarapp.model.elementprk.ArrayPanel;
import net.kraklups.solarapp.model.elementprk.Cell;
import net.kraklups.solarapp.model.elementprk.Counter;
import net.kraklups.solarapp.model.elementprk.ElectricalSubstation;
import net.kraklups.solarapp.model.elementprk.ElementPrk;
import net.kraklups.solarapp.model.elementprk.ElementPrkDao;
import net.kraklups.solarapp.model.elementprk.ExtractionPoint;
import net.kraklups.solarapp.model.elementprk.Gps;
import net.kraklups.solarapp.model.elementprk.Inverter;
import net.kraklups.solarapp.model.elementprk.MediumVoltage;
import net.kraklups.solarapp.model.elementprk.SolarTracker;
import net.kraklups.solarapp.model.elementprk.StringLine;
import net.kraklups.solarapp.model.elementprk.WeatherStation;
import net.kraklups.solarapp.model.park.Park;
import net.kraklups.solarapp.model.sensor.Sensor;
import net.kraklups.solarapp.model.sensor.SensorDao;
import net.kraklups.solarapp.model.userprofile.UserProfile;

@Service("elementService")
@Transactional
public class ElementServiceImpl implements ElementService {

    @Autowired
    private ElementPrkDao elementPrkDao;
    
    @Autowired
    private SensorDao sensorDao;
	
	@Override
	public ArrayBox createArrayBox(String elementPrkName, String elementPrkTag,
			Calendar tvi, Calendar lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park, StringLine stringLine)
			throws DuplicateInstanceException {

			ArrayBox arrayBox = new ArrayBox(elementPrkName, elementPrkTag, tvi, lastAccess, userProfile, 
				dataLogger, park, stringLine);
			elementPrkDao.save(arrayBox); 
			
		return arrayBox;
	}

	@Override
	public ArrayBox updateArrayBox(Long arrayBoxId, String elementPrkName,
			String elementPrkTag, Calendar tvi, Calendar lastAccess,
			UserProfile userProfile, DataLogger dataLogger, Park park,
			StringLine stringLine) throws InstanceNotFoundException {

		ArrayBox arrayBox = (ArrayBox) elementPrkDao.find(arrayBoxId);
		
		arrayBox.setElementPrkName(elementPrkName);
		arrayBox.setElementPrkTag(elementPrkTag);
		arrayBox.setTvi(tvi);
		arrayBox.setLastAccess(lastAccess);
		arrayBox.setUserProfile(userProfile);
		arrayBox.setDataLogger(dataLogger);
		arrayBox.setPark(park);
		arrayBox.setStringLine(stringLine);
		
		return arrayBox;
	}

	@Override
	public ArrayPanel createArrayPanel(String elementPrkName,
			String elementPrkTag, Calendar tvi, Calendar lastAccess,
			UserProfile userProfile, DataLogger dataLogger, Park park)
			throws DuplicateInstanceException {

		ArrayPanel arrayPanel = new ArrayPanel(elementPrkName, elementPrkTag, tvi, lastAccess, userProfile, 
			dataLogger, park);
		elementPrkDao.save(arrayPanel); 
		
		return arrayPanel;	
	}

	@Override
	public ArrayPanel updateArrayPanel(Long arrayBoxId, String elementPrkName,
			String elementPrkTag, Calendar tvi, Calendar lastAccess,
			UserProfile userProfile, DataLogger dataLogger, Park park)
			throws InstanceNotFoundException {

		ArrayPanel arrayPanel = (ArrayPanel) elementPrkDao.find(arrayBoxId);
		
		arrayPanel.setElementPrkName(elementPrkName);
		arrayPanel.setElementPrkTag(elementPrkTag);
		arrayPanel.setTvi(tvi);
		arrayPanel.setLastAccess(lastAccess);
		arrayPanel.setUserProfile(userProfile);
		arrayPanel.setDataLogger(dataLogger);
		arrayPanel.setPark(park);
		
		return arrayPanel;
	}

	@Override
	public Cell createCell(String elementPrkName, String elementPrkTag,
			Calendar tvi, Calendar lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park, ArrayPanel arrayPanel,
			StringLine stringLine) throws DuplicateInstanceException {

		Cell cell = new Cell(elementPrkName, elementPrkTag, tvi, lastAccess, userProfile, 
				dataLogger, park, arrayPanel, stringLine);
		elementPrkDao.save(cell); 
			
		return cell;			
	}

	@Override
	public Cell updateCell(Long arrayBoxId, String elementPrkName,
			String elementPrkTag, Calendar tvi, Calendar lastAccess,
			UserProfile userProfile, DataLogger dataLogger, Park park,
			ArrayPanel arrayPanel, StringLine stringLine)
			throws InstanceNotFoundException {

		Cell cell = (Cell) elementPrkDao.find(arrayBoxId);
		
		cell.setElementPrkName(elementPrkName);
		cell.setElementPrkTag(elementPrkTag);
		cell.setTvi(tvi);
		cell.setLastAccess(lastAccess);
		cell.setUserProfile(userProfile);
		cell.setDataLogger(dataLogger);
		cell.setPark(park);
		cell.setArrayPanel(arrayPanel);
		cell.setStringLine(stringLine);
		
		return cell;	
	}

	@Override
	public Counter createCounter(String elementPrkName, String elementPrkTag,
			Calendar tvi, Calendar lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park) throws DuplicateInstanceException {

		Counter counter = new Counter(elementPrkName, elementPrkTag, tvi, lastAccess, userProfile, 
				dataLogger, park);
		elementPrkDao.save(counter); 
			
		return counter;		
	}

	@Override
	public Counter updateCounter(Long arrayBoxId, String elementPrkName,
			String elementPrkTag, Calendar tvi, Calendar lastAccess,
			UserProfile userProfile, DataLogger dataLogger, Park park)
			throws InstanceNotFoundException {

		Counter counter = (Counter) elementPrkDao.find(arrayBoxId);
		
		counter.setElementPrkName(elementPrkName);
		counter.setElementPrkTag(elementPrkTag);
		counter.setTvi(tvi);
		counter.setLastAccess(lastAccess);
		counter.setUserProfile(userProfile);
		counter.setDataLogger(dataLogger);
		counter.setPark(park);
		
		return counter;
	}

	@Override
	public ElectricalSubstation createElectricalSubstation(
			String elementPrkName, String elementPrkTag, Calendar tvi,
			Calendar lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park, MediumVoltage mediumVoltage)
			throws DuplicateInstanceException {
		
		ElectricalSubstation electricalSubstation = new ElectricalSubstation(elementPrkName, elementPrkTag, tvi, 
				lastAccess, userProfile, dataLogger, park, mediumVoltage);
		elementPrkDao.save(electricalSubstation); 
			
		return electricalSubstation;	
	}

	@Override
	public ElectricalSubstation updateElectricalSubstation(Long arrayBoxId,
			String elementPrkName, String elementPrkTag, Calendar tvi,
			Calendar lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park, MediumVoltage mediumVoltage)
			throws InstanceNotFoundException {

		ElectricalSubstation electricalSubstation = (ElectricalSubstation) elementPrkDao.find(arrayBoxId);
		
		electricalSubstation.setElementPrkName(elementPrkName);
		electricalSubstation.setElementPrkTag(elementPrkTag);
		electricalSubstation.setTvi(tvi);
		electricalSubstation.setLastAccess(lastAccess);
		electricalSubstation.setUserProfile(userProfile);
		electricalSubstation.setDataLogger(dataLogger);
		electricalSubstation.setPark(park);
		electricalSubstation.setMediumVoltage(mediumVoltage);
		
		return electricalSubstation;
	}

	@Override
	public ExtractionPoint createExtractionPoint(String elementPrkName,
			String elementPrkTag, Calendar tvi, Calendar lastAccess,
			UserProfile userProfile, DataLogger dataLogger, Park park)
			throws DuplicateInstanceException {
		
		ExtractionPoint extractionPoint = new ExtractionPoint(elementPrkName, elementPrkTag, tvi, lastAccess, userProfile, 
				dataLogger, park);
		elementPrkDao.save(extractionPoint); 
		
		return extractionPoint;	
	}

	@Override
	public ExtractionPoint updateExtractionPoint(Long arrayBoxId,
			String elementPrkName, String elementPrkTag, Calendar tvi,
			Calendar lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park) throws InstanceNotFoundException {
		
		ExtractionPoint extractionPoint = (ExtractionPoint) elementPrkDao.find(arrayBoxId);
		
		extractionPoint.setElementPrkName(elementPrkName);
		extractionPoint.setElementPrkTag(elementPrkTag);
		extractionPoint.setTvi(tvi);
		extractionPoint.setLastAccess(lastAccess);
		extractionPoint.setUserProfile(userProfile);
		extractionPoint.setDataLogger(dataLogger);
		extractionPoint.setPark(park);
		
		return extractionPoint;
	}

	@Override
	public Gps createGps(String elementPrkName, String elementPrkTag,
			Calendar tvi, Calendar lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park) throws DuplicateInstanceException {
		
		Gps gps = new Gps(elementPrkName, elementPrkTag, tvi, lastAccess, userProfile, 
				dataLogger, park);
		elementPrkDao.save(gps); 
			
		return gps;	
	}

	@Override
	public Gps updateGps(Long arrayBoxId, String elementPrkName,
			String elementPrkTag, Calendar tvi, Calendar lastAccess,
			UserProfile userProfile, DataLogger dataLogger, Park park)
			throws InstanceNotFoundException {
		
		Gps gps = (Gps) elementPrkDao.find(arrayBoxId);
		
		gps.setElementPrkName(elementPrkName);
		gps.setElementPrkTag(elementPrkTag);
		gps.setTvi(tvi);
		gps.setLastAccess(lastAccess);
		gps.setUserProfile(userProfile);
		gps.setDataLogger(dataLogger);
		gps.setPark(park);
		
		return gps;
	}

	@Override
	public Inverter createInverter(String elementPrkName, String elementPrkTag,
			Calendar tvi, Calendar lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park, Counter counter,
			ArrayBox arrayBox, ElectricalSubstation electricalSubstation)
			throws DuplicateInstanceException {

		Inverter inverter = new Inverter(elementPrkName, elementPrkTag, tvi, lastAccess, userProfile, 
				dataLogger, park, counter, arrayBox, electricalSubstation);
		elementPrkDao.save(inverter); 
			
		return inverter;
	}

	@Override
	public Inverter updateInverter(Long arrayBoxId, String elementPrkName,
			String elementPrkTag, Calendar tvi, Calendar lastAccess,
			UserProfile userProfile, DataLogger dataLogger, Park park,
			Counter counter, ArrayBox arrayBox,
			ElectricalSubstation electricalSubstation)
			throws InstanceNotFoundException {
		
		Inverter inverter = (Inverter) elementPrkDao.find(arrayBoxId);
		
		inverter.setElementPrkName(elementPrkName);
		inverter.setElementPrkTag(elementPrkTag);
		inverter.setTvi(tvi);
		inverter.setLastAccess(lastAccess);
		inverter.setUserProfile(userProfile);
		inverter.setDataLogger(dataLogger);
		inverter.setPark(park);
		inverter.setCounter(counter);
		inverter.setArrayBox(arrayBox);
		inverter.setElectricalSubstation(electricalSubstation);
		
		return inverter;
	}

	@Override
	public MediumVoltage createMediumVoltage(String elementPrkName,
			String elementPrkTag, Calendar tvi, Calendar lastAccess,
			UserProfile userProfile, DataLogger dataLogger, Park park,
			ExtractionPoint extractionPoint) throws DuplicateInstanceException {
		
		MediumVoltage mediumVoltage = new MediumVoltage(elementPrkName, elementPrkTag, tvi, lastAccess, userProfile, 
				dataLogger, park, extractionPoint);
		elementPrkDao.save(mediumVoltage); 
			
		return mediumVoltage;	
	}

	@Override
	public MediumVoltage updateMediumVoltage(Long arrayBoxId,
			String elementPrkName, String elementPrkTag, Calendar tvi,
			Calendar lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park, ExtractionPoint extractionPoint)
			throws InstanceNotFoundException {
		
		MediumVoltage mediumVoltage = (MediumVoltage) elementPrkDao.find(arrayBoxId);
		
		mediumVoltage.setElementPrkName(elementPrkName);
		mediumVoltage.setElementPrkTag(elementPrkTag);
		mediumVoltage.setTvi(tvi);
		mediumVoltage.setLastAccess(lastAccess);
		mediumVoltage.setUserProfile(userProfile);
		mediumVoltage.setDataLogger(dataLogger);
		mediumVoltage.setPark(park);
		mediumVoltage.setExtractionPoint(extractionPoint);
		
		return mediumVoltage;
	}

	@Override
	public SolarTracker createSolarTracker(String elementPrkName,
			String elementPrkTag, Calendar tvi, Calendar lastAccess,
			UserProfile userProfile, DataLogger dataLogger, Park park)
			throws DuplicateInstanceException {
	 
		SolarTracker solarTracker = new SolarTracker(elementPrkName, elementPrkTag, tvi, lastAccess, userProfile, 
				dataLogger, park);
		elementPrkDao.save(solarTracker); 
			
		return solarTracker;
	}

	@Override
	public SolarTracker updateSolarTracker(Long arrayBoxId,
			String elementPrkName, String elementPrkTag, Calendar tvi,
			Calendar lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park) throws InstanceNotFoundException {
		SolarTracker solarTracker = (SolarTracker) elementPrkDao.find(arrayBoxId);
		
		solarTracker.setElementPrkName(elementPrkName);
		solarTracker.setElementPrkTag(elementPrkTag);
		solarTracker.setTvi(tvi);
		solarTracker.setLastAccess(lastAccess);
		solarTracker.setUserProfile(userProfile);
		solarTracker.setDataLogger(dataLogger);
		solarTracker.setPark(park);
		
		return solarTracker;	}

	@Override
	public StringLine createStringLine(String elementPrkName,
			String elementPrkTag, Calendar tvi, Calendar lastAccess,
			UserProfile userProfile, DataLogger dataLogger, Park park,
			ArrayBox arrayBox) throws DuplicateInstanceException {
		
		StringLine stringLine = new StringLine(elementPrkName, elementPrkTag, tvi, lastAccess, userProfile, 
				dataLogger, park, arrayBox);
		elementPrkDao.save(stringLine); 
			
		return stringLine;
	}

	@Override
	public StringLine updateStringLine(Long arrayBoxId, String elementPrkName,
			String elementPrkTag, Calendar tvi, Calendar lastAccess,
			UserProfile userProfile, DataLogger dataLogger, Park park,
			ArrayBox arrayBox) throws InstanceNotFoundException {
		
		StringLine stringLine = (StringLine) elementPrkDao.find(arrayBoxId);
		
		stringLine.setElementPrkName(elementPrkName);
		stringLine.setElementPrkTag(elementPrkTag);
		stringLine.setTvi(tvi);
		stringLine.setLastAccess(lastAccess);
		stringLine.setUserProfile(userProfile);
		stringLine.setDataLogger(dataLogger);
		stringLine.setPark(park);
		stringLine.setArrayBox(arrayBox);
		
		return stringLine;
	}

	@Override
	public WeatherStation createWeatherStation(String elementPrkName,
			String elementPrkTag, Calendar tvi, Calendar lastAccess,
			UserProfile userProfile, DataLogger dataLogger, Park park)
			throws DuplicateInstanceException {
		
		WeatherStation weatherStation = new WeatherStation(elementPrkName, elementPrkTag, tvi, lastAccess, userProfile, 
				dataLogger, park);
		elementPrkDao.save(weatherStation); 
			
		return weatherStation;	
	}

	@Override
	public WeatherStation updateWeatherStation(Long arrayBoxId,
			String elementPrkName, String elementPrkTag, Calendar tvi,
			Calendar lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park) throws InstanceNotFoundException {
		
		WeatherStation weatherStation = (WeatherStation) elementPrkDao.find(arrayBoxId);
		
		weatherStation.setElementPrkName(elementPrkName);
		weatherStation.setElementPrkTag(elementPrkTag);
		weatherStation.setTvi(tvi);
		weatherStation.setLastAccess(lastAccess);
		weatherStation.setUserProfile(userProfile);
		weatherStation.setDataLogger(dataLogger);
		weatherStation.setPark(park);
		
		return weatherStation;
	}

	@Override
	public void assignParkElementPrk(ElementPrk elementPrk, Park park)
			throws InstanceNotFoundException {
		
		elementPrk.setPark(park);
	}

	@Override
	public void assignElementPrkNameElementPrk(ElementPrk elementPrk,
			String elementPrkName) throws InstanceNotFoundException {
		
		elementPrk.setElementPrkName(elementPrkName);
	}

	@Override
	public void assignElementPrkTagElementPrk(ElementPrk elementPrk,
			String elementPrkTag) throws InstanceNotFoundException {
		
		elementPrk.setElementPrkTag(elementPrkTag);
	}

	@Override
	public void assignTviElementPrk(ElementPrk elementPrk, Calendar tvi)
			throws InstanceNotFoundException {
		
		elementPrk.setTvi(tvi);
	}

	@Override
	public void assignLastAccessElementPrk(ElementPrk elementPrk, Calendar lastAccess)
			throws InstanceNotFoundException {
		
		elementPrk.setLastAccess(lastAccess);
	}

	@Override
	public void assignDataLoggerElementPrk(ElementPrk elementPrk,
			DataLogger dataLogger) throws InstanceNotFoundException {
		
		elementPrk.setDataLogger(dataLogger);
	}

	@Override
	public void assignUserProfileElementPrk(ElementPrk elementPrk,
			UserProfile userProfile) throws InstanceNotFoundException {
		
		elementPrk.setUserProfile(userProfile);
	}

	@Override
	public void assignStringLineArrayBox(ArrayBox arrayBox,
			StringLine stringLine) throws InstanceNotFoundException {
		
		arrayBox.setStringLine(stringLine);
	}

	@Override
	public void assignArrayPanelCell(Cell cell, ArrayPanel arrayPanel)
			throws InstanceNotFoundException {
		
		cell.setArrayPanel(arrayPanel);
	}

	@Override
	public void assignStringLineCell(Cell cell, StringLine stringLine)
			throws InstanceNotFoundException {
		
		cell.setStringLine(stringLine);
	}

	@Override
	public void assignMediumVoltageElectricalSubstation(
			ElectricalSubstation electricalSubstation,
			MediumVoltage mediumVoltage) throws InstanceNotFoundException {
		
		electricalSubstation.setMediumVoltage(mediumVoltage);
	}

	@Override
	public void assignArrayBoxInverter(Inverter inverter, ArrayBox arrayBox)
			throws InstanceNotFoundException {
		
		inverter.setArrayBox(arrayBox);
	}

	@Override
	public void assignCounterInverter(Inverter inverter, Counter counter)
			throws InstanceNotFoundException {
		
		inverter.setCounter(counter);
	}

	@Override
	public void assignElectricalSubstationInverter(Inverter inverter,
			ElectricalSubstation electricalSubstation)
			throws InstanceNotFoundException {
		
		inverter.setElectricalSubstation(electricalSubstation);
	}

	@Override
	public void assignExtractionPointMediumVoltage(MediumVoltage mediumVoltage,
			ExtractionPoint extractionPoint) throws InstanceNotFoundException {
		
		mediumVoltage.setExtractionPoint(extractionPoint);
	}

	@Override
	public void assignArrayBoxStringLine(StringLine stringLine,
			ArrayBox arrayBox) throws InstanceNotFoundException {
		
		stringLine.setArrayBox(arrayBox);
	}

	@Override
	public Sensor createSensor(String sensorTag, String sensorType,
			ElementPrk elementPrk) throws DuplicateInstanceException {
		
		Sensor sensor = new Sensor(sensorTag, sensorType, elementPrk);
		sensorDao.save(sensor);
		
		return sensor;
	}

	@Override
	public Sensor updateSensor(Long sensorId, String sensorTag,
			String sensorType, ElementPrk elementPrk)
			throws InstanceNotFoundException {
		
		Sensor sensor = (Sensor) sensorDao.find(sensorId);
		
		sensor.setSensorTag(sensorTag);
		sensor.setSensorType(sensorType);
		sensor.setElementPrk(elementPrk);
		
		return sensor;
	}

	@Override
	public void assignElementPrkSensor(Sensor sensor, ElementPrk elementPrk)
			throws InstanceNotFoundException {
		
		sensor.setElementPrk(elementPrk);
	}

	@Override
	public SensorBlock getSensorByElementPrkId(Long elementPrkId,
			int startIndex, int count) throws InstanceNotFoundException {

		List<Sensor> sensors = sensorDao.getSensorsByElementPrkId(elementPrkId, startIndex, count + 1);
		
		boolean existMoreSensors = sensors.size() == (count + 1);
		
		return new SensorBlock(sensors, existMoreSensors);
	}

	@Override
	public ElementPrkBlock getCellByStringLineId(Long stringLineId,
			int startIndex, int count) throws InstanceNotFoundException {
		
		List<ElementPrk> elements = elementPrkDao.getCellsByStringLine(stringLineId, startIndex, count + 1);
		
		boolean existMoreElements = elements.size() == (count + 1);
		
		return new ElementPrkBlock(elements, existMoreElements);
	}

	@Override
	public ElementPrkBlock getCellByArrayPanelId(Long arrayPanelId,
			int startIndex, int count) throws InstanceNotFoundException {

		List<ElementPrk> elements = elementPrkDao.getCellsByArrayPanel(arrayPanelId, startIndex, count + 1);
		
		boolean existMoreElements = elements.size() == (count + 1);
		
		return new ElementPrkBlock(elements, existMoreElements);	
	}

	@Override
	public ElementPrkBlock getArrayPanelByStringLineId(Long stringLineId,
			int startIndex, int count) throws InstanceNotFoundException {

		List<ElementPrk> elements = elementPrkDao.getArrayPanelsByStringLine(stringLineId, startIndex, count + 1);
		
		boolean existMoreElements = elements.size() == (count + 1);
		
		return new ElementPrkBlock(elements, existMoreElements);		
	}

	@Override
	public ElementPrkBlock getInverterByArrayBoxId(Long arrayBoxId,
			int startIndex, int count) throws InstanceNotFoundException {

		List<ElementPrk> elements = elementPrkDao.getInvertersByArrayBox(arrayBoxId, startIndex, count + 1);
		
		boolean existMoreElements = elements.size() == (count + 1);
		
		return new ElementPrkBlock(elements, existMoreElements);		
	}

	@Override
	public ElementPrkBlock getInverterByElectricalSubstationId(
			Long electricalSubstationId, int startIndex, int count)
			throws InstanceNotFoundException {

		List<ElementPrk> elements = elementPrkDao.getInvertersByElectricalSubstation(electricalSubstationId, startIndex, count + 1);
		
		boolean existMoreElements = elements.size() == (count + 1);
		
		return new ElementPrkBlock(elements, existMoreElements);			
	}

	@Override
	public ElementPrkBlock getElectricalSubstationByMediumVoltageId(
			Long mediumVoltageId, int startIndex, int count)
			throws InstanceNotFoundException {

		List<ElementPrk> elements = elementPrkDao.getElectricalSubstationsByMediumVoltage(mediumVoltageId, startIndex, count + 1);
		
		boolean existMoreElements = elements.size() == (count + 1);
		
		return new ElementPrkBlock(elements, existMoreElements);	
	}

	@Override
	public ElementPrkBlock getMediumVoltageByCounterId(Long counterId,
			int startIndex, int count) throws InstanceNotFoundException {

		List<ElementPrk> elements = elementPrkDao.getMediumVoltagesByCounter(counterId, startIndex, count + 1);
		
		boolean existMoreElements = elements.size() == (count + 1);
		
		return new ElementPrkBlock(elements, existMoreElements);		
	}

	@Override
	public ElementPrkBlock getInverterByCounterId(Long counterId, int startIndex,
			int count) throws InstanceNotFoundException {

		List<ElementPrk> elements = elementPrkDao.getInvertersByCounter(counterId, startIndex, count + 1);
		
		boolean existMoreElements = elements.size() == (count + 1);
		
		return new ElementPrkBlock(elements, existMoreElements);
	}

	@Override
	public ElementPrkBlock getMediumVoltageByExtractionPointId(
			Long extractionPointId, int startIndex, int count)
			throws InstanceNotFoundException {

		List<ElementPrk> elements = elementPrkDao.getMediumVoltagesByExtractionPoint(extractionPointId, startIndex, count + 1);
		
		boolean existMoreElements = elements.size() == (count + 1);
		
		return new ElementPrkBlock(elements, existMoreElements);
	
	}

}
