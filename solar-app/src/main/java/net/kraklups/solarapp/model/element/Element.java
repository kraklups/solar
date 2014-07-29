package net.kraklups.solarapp.model.element;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.TemporalType;
import javax.persistence.Temporal;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

import org.hibernate.annotations.Type;
import com.vividsolutions.jts.geom.Point;

import net.kraklups.solarapp.model.datalogger.DataLogger;
import net.kraklups.solarapp.model.park.Park;
import net.kraklups.solarapp.model.userprofile.UserProfile;

@Entity
@Table(name="Element")
public class Element {
	
	private Long elementId;
	private String elementName;
	private String elementTag;
	private Calendar tvi;
	private Calendar lastAccess;
	private UserProfile userProfile;
	private DataLogger dataLogger;
	private Park park;
	
	@Type(type="org.hibernate.spatial.GeometryType")	
	private Point mapElement;	

	public Element() {
		// TODO Auto-generated constructor stub
	}
	
	public Element(String elementName, String elementTag, Calendar tvi, Calendar lastAccess, 
			UserProfile userProfile, DataLogger dataLogger, Park park) {
		
		this.elementName = elementName;
		this.elementTag = elementTag;
		this.tvi = tvi;
		this.lastAccess = lastAccess;
		this.userProfile = userProfile;
		this.dataLogger = dataLogger;
		this.park = park;
	}

	@SequenceGenerator(                                 // It only takes effect
			name="ElementIdGenerator",                     // for databases providing
	        sequenceName="ElementSeq", allocationSize=1)   // identifier generators.
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,
		generator="ElementIdGenerator")
	@Column(name="elementId", unique= true, nullable = false)	
    public Long getElementId() {
		return elementId;
	}
	
	public void setElementId(Long elementId){
		this.elementId = elementId;
	}
	
	public String getElementName() {
		return elementName;
	}
	
	public void setElementName(String elementName){
		this.elementName = elementName;
	}
	
	public String getElementTag() {
		return elementTag;
	}
	
	public void setElementTag(String elementTag){
		this.elementTag = elementTag;
	}

	@Temporal(TemporalType.TIMESTAMP)
        public Calendar getTvi() {
		return tvi;
	}
	
	public void setTvi(Calendar tvi){
		this.tvi = tvi;
	}	
	
	@Temporal(TemporalType.TIMESTAMP)
    public Calendar getLastAccess() {
		return lastAccess;
	}

	public void setLastAccess(Calendar lastAccess){
		this.lastAccess = lastAccess;
	}

	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name="userProfileId")		
	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile){
		this.userProfile = userProfile;
	}

	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name="dataLoggerId")	
	public DataLogger getDataLogger(){
		return dataLogger;
	}
	
	public void setDataLogger(DataLogger dataLogger){
		this.dataLogger = dataLogger;
	}

	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name="parkId")	
	public Park getPark(){
		return park;
	}
	
	public void setPark(Park park){
		this.park = park;
	}
	
	public Point getMapElement() {
		return mapElement;
	}
	
	public void setMapPark(Point mapElement) {
		this.mapElement = mapElement;
	}

	@Override
	public String toString() {
		return "Element [elementId=" + elementId + ", nombre=" + elementName + ", tag=" + elementTag +
                       ", tvi=" + tvi + ", lastAccess=" + lastAccess + 
                       ", user_author =" + userProfile.getLoginName() + 
                       ", dataLoggerTag =" + dataLogger.getDataLoggerTag() +
                       ", parkName =" + park.getParkName() +
                       "mapElement =" + mapElement.toText() + "]";
	}
	
}
