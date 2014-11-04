package net.kraklups.solarapp.model.elementprk;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
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
@Table(name="ElementPrk")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class ElementPrk {
	
	private Long elementPrkId;
	private String elementPrkName;
	private String elementPrkTag;
	private Timestamp tvi;
	private Timestamp lastAccess;
	private UserProfile userProfile;
	private DataLogger dataLogger;
	private Park park;
	
	@Type(type="org.hibernate.spatial.GeometryType")	
	private Point mapElement;	

	public ElementPrk() {
		// TODO Auto-generated constructor stub
	}
	
	public ElementPrk(String elementPrkName, String elementPrkTag, Timestamp tvi, Timestamp lastAccess, 
			UserProfile userProfile, DataLogger dataLogger, Park park) {
		
		this.elementPrkName = elementPrkName;
		this.elementPrkTag = elementPrkTag;
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
	@Column(name="elementPrkId", unique= true, nullable = false)	
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

	@Temporal(TemporalType.TIMESTAMP)
    public Timestamp getTvi() {
		return tvi;
	}
	
	public void setTvi(Timestamp tvi){
		this.tvi = tvi;
	}	
	
	@Temporal(TemporalType.TIMESTAMP)
    public Timestamp getLastAccess() {
		return lastAccess;
	}

	public void setLastAccess(Timestamp lastAccess){
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
	
	public void setMapElement(Point mapElement) {
		this.mapElement = mapElement;
	}

	@Override
	public String toString() {
		return "ElementPrk [elementPrkId=" + elementPrkId + ", nombre=" + elementPrkName + ", tag=" + elementPrkTag +
                       ", tvi=" + tvi + ", lastAccess=" + lastAccess + 
                       ", user_author =" + userProfile.getLoginName() + 
                       ", dataLoggerTag =" + dataLogger.getDataLoggerTag() +
                       ", parkName =" + park.getParkName() +
                       ", mapElement =" + mapElement.toText() + "]";
	}
	
}
