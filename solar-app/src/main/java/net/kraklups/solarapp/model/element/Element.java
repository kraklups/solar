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
	
	
	
}
