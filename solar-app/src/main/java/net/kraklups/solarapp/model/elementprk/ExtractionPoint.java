package net.kraklups.solarapp.model.elementprk;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.PrimaryKeyJoinColumn;

import net.kraklups.solarapp.model.datalogger.DataLogger;
import net.kraklups.solarapp.model.park.Park;
import net.kraklups.solarapp.model.userprofile.UserProfile;

@Entity
@Table(name="ExtractionPoint")
@PrimaryKeyJoinColumn(name = "extractionPointId", referencedColumnName = "elementPrkId")
public class ExtractionPoint extends ElementPrk implements java.io.Serializable {

	private static final long serialVersionUID = 1379057683846064781L;

	public ExtractionPoint() {
		// TODO Auto-generated constructor stub
	}

	public ExtractionPoint(String elementPrkName, String elementPrkTag,
			Date tvi, Date lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park) {
		super(elementPrkName, elementPrkTag, tvi, lastAccess, userProfile,
				dataLogger, park);
		// TODO Auto-generated constructor stub
	}

	@Column(name = "extractionPointId", nullable = false, insertable = false, updatable = false)	
	public Long getExtractionPointId() {
		return super.getElementPrkId();
	}
		
	public void setExtractionPointId(Long extractionPointId){
		super.setElementPrkId(extractionPointId);
	}	
	
}
