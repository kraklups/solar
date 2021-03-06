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
@Table(name="MediumVoltage")
@PrimaryKeyJoinColumn(name = "mediumVoltageId", referencedColumnName = "elementPrkId")
public class MediumVoltage extends ElementPrk implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4302775535543496691L;
	private ExtractionPoint extractionPoint;
	
	public MediumVoltage() {
		// TODO Auto-generated constructor stub
	}

	public MediumVoltage(String elementPrkName, String elementPrkTag,
			Date tvi, Date lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park, Point mapElement, ExtractionPoint extractionPoint) {
		
		super(elementPrkName, elementPrkTag, tvi, lastAccess, userProfile,
				dataLogger, park, mapElement);
		
		this.extractionPoint = extractionPoint;
	}

	@Column(name = "mediumVoltageId", nullable = false, insertable = false, updatable = false)	
	public Long getMediumVoltageId() {
		return super.getElementPrkId();
	}
		
	public void setMediumVoltageId(Long mediumVoltageId){
		super.setElementPrkId(mediumVoltageId);
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
