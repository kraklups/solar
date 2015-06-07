package net.kraklups.solarapp.model.elementprk;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.PrimaryKeyJoinColumn;

import com.vividsolutions.jts.geom.Point;

import net.kraklups.solarapp.model.datalogger.DataLogger;
import net.kraklups.solarapp.model.park.Park;
import net.kraklups.solarapp.model.userprofile.UserProfile;

@Entity
@Table(name="ElectricalSubstation")
@PrimaryKeyJoinColumn(name = "electricalSubstationId", referencedColumnName = "elementPrkId")
public class ElectricalSubstation extends ElementPrk implements java.io.Serializable {

	private static final long serialVersionUID = -7181551274157189676L;
	private MediumVoltage mediumVoltage;
	
	public ElectricalSubstation() {
		// TODO Auto-generated constructor stub
	}

	public ElectricalSubstation(String elementPrkName, String elementPrkTag,
			Date tvi, Date lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park, Point mapElement, MediumVoltage mediumVoltage) {
		
		super(elementPrkName, elementPrkTag, tvi, lastAccess, userProfile,
				dataLogger, park, mapElement);
		
		this.mediumVoltage = mediumVoltage;
	}

	@Column(name = "electricalSubstationId", nullable = false, insertable = false, updatable = false)	
	public Long getElectricalSubstationId() {
		return super.getElementPrkId();
	}
		
	public void setElectricalSubstationId(Long electricalSubstationId){
		super.setElementPrkId(electricalSubstationId);
	}	
	
	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name="mediumVoltageId")	
	public MediumVoltage getMediumVoltage() {
		return mediumVoltage;
	}
	
	public void setMediumVoltage(MediumVoltage mediumVoltage) {
		this.mediumVoltage = mediumVoltage;
	}	
	
}
