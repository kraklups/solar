package net.kraklups.solarapp.model.elementprk;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import net.kraklups.solarapp.model.datalogger.DataLogger;
import net.kraklups.solarapp.model.park.Park;
import net.kraklups.solarapp.model.userprofile.UserProfile;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.vividsolutions.jts.geom.Point;

public class ElementPrkMock {

	private Long elementPrkId;
	
	@NotEmpty
	@Size(min=6, max=30)
	private String elementPrkName;
	
	@Size(min=6, max=30)
	@NotEmpty
	private String elementPrkTag;
	
	//2014-07-04T12:08:56.235
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS")
	@NotNull		
	private Date tvi;
	
	//2014-07-04T12:08:56.235
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS")
	@NotNull		
	private Date lastAccess;
	
	private UserProfile userProfile;
	private DataLogger dataLogger;
	private Park park;
	private Point mapElement;	
	
	private StringLine stringLine;
	private ArrayPanel arrayPanel;
	private MediumVoltage mediumVoltage;
	private Counter counter;
	private ArrayBox arrayBox;
	private ElectricalSubstation electricalSubstation;	
	private ExtractionPoint extractionPoint;
	
	
    public Long getElementPrkId() {
		return elementPrkId;
	}
	
	public void setElementPrkId(Long elementPrkId){
		this.elementPrkId = elementPrkId;
	}
	
	public String getElementPrkName() {
		return elementPrkName;
	}
	
	public void setElementPrkName(String elementPrkName){
		this.elementPrkName = elementPrkName;
	}
	
	public String getElementPrkTag() {
		return elementPrkTag;
	}
	
	public void setElementPrkTag(String elementPrkTag){
		this.elementPrkTag = elementPrkTag;
	}

    public Date getTvi() {
		return tvi;
	}


	public void setTvi(Date tvi){
		this.tvi = tvi;
	}	
	
    public Date getLastAccess() {
		return lastAccess;
	}


	public void setLastAccess(Date lastAccess){
		this.lastAccess = lastAccess;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile){
		this.userProfile = userProfile;
	}

	public DataLogger getDataLogger(){
		return dataLogger;
	}
	
	public void setDataLogger(DataLogger dataLogger){
		this.dataLogger = dataLogger;
	}

	public Park getPark(){
		return park;
	}
	
	public void setPark(Park park){
		this.park = park;
	}

	public Point getMapElement() {
		return mapElement;
	}
	
	public void setMapElement(Point mapElement) {
		this.mapElement = mapElement;
	}
	
	public StringLine getStringLine() {
		return stringLine;
	}
	
	public void setStringLine(StringLine stringLine) {
		this.stringLine = stringLine;
	}
	
	public ArrayPanel getArrayPanel() {
		return arrayPanel;
	}
	
	public void setArrayPanel(ArrayPanel arrayPanel) {
		this.arrayPanel = arrayPanel;
	}	

	public MediumVoltage getMediumVoltage() {
		return mediumVoltage;
	}
	
	public void setMediumVoltage(MediumVoltage mediumVoltage) {
		this.mediumVoltage = mediumVoltage;
	}	
	
	public Counter getCounter() {
		return counter;
	}
	
	public void setCounter(Counter counter) {
		this.counter = counter;
	}	
	
	public ArrayBox getArrayBox() {
		return arrayBox;
	}
	
	public void setArrayBox(ArrayBox arrayBox) {
		this.arrayBox = arrayBox;
	}
	
	public ElectricalSubstation getElectricalSubstation() {
		return electricalSubstation;
	}
	
	public void setElectricalSubstation(ElectricalSubstation electricalSubstation) {
		this.electricalSubstation = electricalSubstation;
	}	

	public ExtractionPoint getExtractionPoint() {
		return extractionPoint;
	}
	
	public void setExtractionPoint(ExtractionPoint extractionPoint) {
		this.extractionPoint = extractionPoint;
	}
	
	
}
