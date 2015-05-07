package net.kraklups.solarapp.model.elementprk;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

import com.vividsolutions.jts.geom.Point;

import net.kraklups.solarapp.model.datalogger.DataLogger;
import net.kraklups.solarapp.model.park.Park;
import net.kraklups.solarapp.model.taskprk.Monitor;
import net.kraklups.solarapp.model.userprofile.UserProfile;

@Entity
@Table(name="ElementPrk")
@Inheritance(strategy=InheritanceType.JOINED)
public class ElementPrk implements java.io.Serializable {
	
	private static final long serialVersionUID = -8979274625904669832L;
	
	private Long elementPrkId;
	private String elementPrkName;
	private String elementPrkTag;
	private Date tvi;
	private Date lastAccess;
	private UserProfile userProfile;
	private DataLogger dataLogger;
	private Park park;
	private Set<Monitor> monitors = new HashSet<Monitor>(0);	
	private Point mapElement;	

	public ElementPrk() {
		// TODO Auto-generated constructor stub
	}
	
	public ElementPrk(String elementPrkName, String elementPrkTag, Date tvi, Date lastAccess, 
			UserProfile userProfile, DataLogger dataLogger, Park park) {
		
		this.elementPrkName = elementPrkName;
		this.elementPrkTag = elementPrkTag;
		this.tvi = tvi;
		this.lastAccess = lastAccess;
		this.userProfile = userProfile;
		this.dataLogger = dataLogger;
		this.park = park;
	}
	
	public ElementPrk(String elementPrkName, String elementPrkTag, Date tvi, Date lastAccess, 
			UserProfile userProfile, DataLogger dataLogger, Park park, Set<Monitor> monitors) {
		
		this.elementPrkName = elementPrkName;
		this.elementPrkTag = elementPrkTag;
		this.tvi = tvi;
		this.lastAccess = lastAccess;
		this.userProfile = userProfile;
		this.dataLogger = dataLogger;
		this.park = park;
		this.monitors = monitors;
	}
	
	@SequenceGenerator(                                 // It only takes effect
			name="ElementIdGenerator",                     // for databases providing
	        sequenceName="ElementPrkSeq", allocationSize=1)   // identifier generators.
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

    public Date getTvi() {
		return tvi;
	}

    @Temporal(TemporalType.TIMESTAMP)
	public void setTvi(Date tvi){
		this.tvi = tvi;
	}	
	
    public Date getLastAccess() {
		return lastAccess;
	}

    @Temporal(TemporalType.TIMESTAMP)
	public void setLastAccess(Date lastAccess){
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

	@Type(type="org.hibernate.spatial.GeometryType")	
	public Point getMapElement() {
		return mapElement;
	}
	
	public void setMapElement(Point mapElement) {
		this.mapElement = mapElement;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "monitor_elementprk", joinColumns = { 
			@JoinColumn(name = "elementPrkId", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "monitorId", 
					nullable = false, updatable = false) })
	public Set<Monitor> getMonitors() {
		return this.monitors;
	}
	
	public void setMonitors(Set<Monitor> monitors){
		this.monitors = monitors;	
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
