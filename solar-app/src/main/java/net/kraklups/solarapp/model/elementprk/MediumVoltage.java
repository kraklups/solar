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
@Table(name="MediumVoltage")
@PrimaryKeyJoinColumn(name = "elementPrkId", referencedColumnName = "mediumVoltageId")
public class MediumVoltage extends ElementPrk {

	private ExtractionPoint extractionPoint;
	
	public MediumVoltage() {
		// TODO Auto-generated constructor stub
	}

	public MediumVoltage(String elementPrkName, String elementPrkTag,
			Calendar tvi, Calendar lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park, ExtractionPoint extractionPoint) {
		
		super(elementPrkName, elementPrkTag, tvi, lastAccess, userProfile,
				dataLogger, park);
		
		this.extractionPoint = extractionPoint;
	}

	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name="extractionPointId")	
	public ExtractionPoint getExtractionPoint() {
		return extractionPoint;
	}
	
	public void setExtractionPoint(ExtractionPoint extractionPoint) {
		this.extractionPoint = extractionPoint;
	}
	
	
}
