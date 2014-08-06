package net.kraklups.solarapp.model.elementprk;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import net.kraklups.solarapp.model.datalogger.DataLogger;
import net.kraklups.solarapp.model.park.Park;
import net.kraklups.solarapp.model.userprofile.UserProfile;

@Entity
@Table(name="ElectricalSubstation")
@PrimaryKeyJoinColumn(name = "elementPrkId", referencedColumnName = "electricalSubstationId")
public class ElectricalSubstation extends ElementPrk {

	private MediumVoltage mediumVoltage;
	
	public ElectricalSubstation() {
		// TODO Auto-generated constructor stub
	}

	public ElectricalSubstation(String elementPrkName, String elementPrkTag,
			Calendar tvi, Calendar lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park, MediumVoltage mediumVoltage) {
		
		super(elementPrkName, elementPrkTag, tvi, lastAccess, userProfile,
				dataLogger, park);
		
		this.mediumVoltage = mediumVoltage;
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
