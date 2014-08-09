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

@Service("elementService")
@Transactional
public class ElementServiceImpl implements ElementService {

	@Override
	public ArrayBox createArrayBox(String elementPrkName, String elementPrkTag,
			Calendar tvi, Calendar lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park, StringLine stringLine)
			throws DuplicateInstanceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayBox updateArrayBox(Long arrayBoxId, String elementPrkName,
			String elementPrkTag, Calendar tvi, Calendar lastAccess,
			UserProfile userProfile, DataLogger dataLogger, Park park,
			StringLine stringLine) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayPanel createArrayPanel(String elementPrkName,
			String elementPrkTag, Calendar tvi, Calendar lastAccess,
			UserProfile userProfile, DataLogger dataLogger, Park park)
			throws DuplicateInstanceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayPanel updateArrayPanel(Long arrayBoxId, String elementPrkName,
			String elementPrkTag, Calendar tvi, Calendar lastAccess,
			UserProfile userProfile, DataLogger dataLogger, Park park)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cell createCell(String elementPrkName, String elementPrkTag,
			Calendar tvi, Calendar lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park, ArrayPanel arrayPanel,
			StringLine stringLine) throws DuplicateInstanceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cell updateCell(Long arrayBoxId, String elementPrkName,
			String elementPrkTag, Calendar tvi, Calendar lastAccess,
			UserProfile userProfile, DataLogger dataLogger, Park park,
			ArrayPanel arrayPanel, StringLine stringLine)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Counter createCounter(String elementPrkName, String elementPrkTag,
			Calendar tvi, Calendar lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park) throws DuplicateInstanceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Counter updateCounter(Long arrayBoxId, String elementPrkName,
			String elementPrkTag, Calendar tvi, Calendar lastAccess,
			UserProfile userProfile, DataLogger dataLogger, Park park)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ElectricalSubstation createElectricalSubstation(
			String elementPrkName, String elementPrkTag, Calendar tvi,
			Calendar lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park, MediumVoltage mediumVoltage)
			throws DuplicateInstanceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ElectricalSubstation updateElectricalSubstation(Long arrayBoxId,
			String elementPrkName, String elementPrkTag, Calendar tvi,
			Calendar lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park, MediumVoltage mediumVoltage)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExtractionPoint createExtractionPoint(String elementPrkName,
			String elementPrkTag, Calendar tvi, Calendar lastAccess,
			UserProfile userProfile, DataLogger dataLogger, Park park)
			throws DuplicateInstanceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExtractionPoint updateExtractionPoint(Long arrayBoxId,
			String elementPrkName, String elementPrkTag, Calendar tvi,
			Calendar lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Gps createGps(String elementPrkName, String elementPrkTag,
			Calendar tvi, Calendar lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park) throws DuplicateInstanceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Gps updateGps(Long arrayBoxId, String elementPrkName,
			String elementPrkTag, Calendar tvi, Calendar lastAccess,
			UserProfile userProfile, DataLogger dataLogger, Park park)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Inverter createInverter(String elementPrkName, String elementPrkTag,
			Calendar tvi, Calendar lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park, Counter counter,
			ArrayBox arrayBox, ElectricalSubstation electricalSubstation)
			throws DuplicateInstanceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Inverter updateInverter(Long arrayBoxId, String elementPrkName,
			String elementPrkTag, Calendar tvi, Calendar lastAccess,
			UserProfile userProfile, DataLogger dataLogger, Park park,
			Counter counter, ArrayBox arrayBox,
			ElectricalSubstation electricalSubstation)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MediumVoltage createMediumVoltage(String elementPrkName,
			String elementPrkTag, Calendar tvi, Calendar lastAccess,
			UserProfile userProfile, DataLogger dataLogger, Park park,
			ExtractionPoint extractionPoint) throws DuplicateInstanceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MediumVoltage updateMediumVoltage(Long arrayBoxId,
			String elementPrkName, String elementPrkTag, Calendar tvi,
			Calendar lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park, ExtractionPoint extractionPoint)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SolarTracker createSolarTracker(String elementPrkName,
			String elementPrkTag, Calendar tvi, Calendar lastAccess,
			UserProfile userProfile, DataLogger dataLogger, Park park)
			throws DuplicateInstanceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SolarTracker updateSolarTracker(Long arrayBoxId,
			String elementPrkName, String elementPrkTag, Calendar tvi,
			Calendar lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StringLine createStringLine(String elementPrkName,
			String elementPrkTag, Calendar tvi, Calendar lastAccess,
			UserProfile userProfile, DataLogger dataLogger, Park park,
			ArrayBox arrayBox) throws DuplicateInstanceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StringLine updateStringLine(Long arrayBoxId, String elementPrkName,
			String elementPrkTag, Calendar tvi, Calendar lastAccess,
			UserProfile userProfile, DataLogger dataLogger, Park park,
			ArrayBox arrayBox) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WeatherStation createWeatherStation(String elementPrkName,
			String elementPrkTag, Calendar tvi, Calendar lastAccess,
			UserProfile userProfile, DataLogger dataLogger, Park park)
			throws DuplicateInstanceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WeatherStation updateWeatherStation(Long arrayBoxId,
			String elementPrkName, String elementPrkTag, Calendar tvi,
			Calendar lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void assignParkElementPrk(ElementPrk elementPrk, Park park)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assignElementPrkNameElementPrk(ElementPrk elementPrk,
			String elementPrkName) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assignElementPrkTagElementPrk(ElementPrk elementPrk,
			String elementPrkTag) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assignTviElementPrk(ElementPrk elementPrk, Calendar tvi)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assignLastAccessPrk(ElementPrk elementPrk, Calendar lastAccess)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assignDataLoggerElementPrk(ElementPrk elementPrk,
			DataLogger dataLogger) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assignUserProfileElementPrk(ElementPrk elementPrk,
			UserProfile userProfile) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assignStringLineArrayBox(ArrayBox arrayBox,
			StringLine stringLine) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assignArrayPanelCell(Cell cell, ArrayPanel arrayPanel)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assignStringLineCell(Cell cell, StringLine stringLine)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assignMediumVoltageElectricalSubstation(
			ElectricalSubstation electricalSubstation,
			MediumVoltage mediumVoltage) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assignArrayBoxInverter(Inverter inverter, ArrayBox arrayBox)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assignCounterInverter(Inverter inverter, Counter counter)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assignElectricalSubstationInverter(Inverter inverter,
			ElectricalSubstation electricalSubstation)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assignExtractionPointMediumVoltage(MediumVoltage mediumVoltage,
			ExtractionPoint extractionPoint) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void assignArrayBoxStringLine(StringLine stringLine,
			ArrayBox arrayBox) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Sensor createSensor(String sensorTag, String sensorType,
			ElementPrk elementPrk) throws DuplicateInstanceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sensor updateSensor(Long sensorId, String sensorTag,
			String sensorType, ElementPrk elementPrk)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void assignElementPrkSensor(Sensor sensor, ElementPrk elementPrk)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Sensor> getSensorByElementPrk(ElementPrk elementPrk,
			int startIndex, int count) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cell> getCellByStringLine(StringLine stringLine,
			int startIndex, int count) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cell> getCellByArrayPanel(ArrayPanel arrayPanel,
			int startIndex, int count) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArrayPanel> getArrayPanelByStringLine(StringLine stringLine,
			int startIndex, int count) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Inverter> getInverterByArrayBox(ArrayBox arrayBox,
			int startIndex, int count) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Inverter> getInverterByElectricalSubstation(
			ElectricalSubstation electricalSubstation, int startIndex, int count)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ElectricalSubstation> getElectricalSubstationByMediumVoltage(
			MediumVoltage mediumVoltage, int startIndex, int count)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MediumVoltage> getMediumVoltageByCounter(Counter counter,
			int startIndex, int count) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Inverter> getInverterByCounter(Counter counter, int startIndex,
			int count) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MediumVoltage> getMediumVoltageByExtractionPoint(
			ExtractionPoint extractionPoint, int startIndex, int count)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
