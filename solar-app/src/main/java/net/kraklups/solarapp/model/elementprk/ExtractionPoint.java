package net.kraklups.solarapp.model.elementprk;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.PrimaryKeyJoinColumn;

import net.kraklups.solarapp.model.datalogger.DataLogger;
import net.kraklups.solarapp.model.park.Park;
import net.kraklups.solarapp.model.userprofile.UserProfile;

@Entity
@Table(name="ExtractionPoint")
@PrimaryKeyJoinColumn(name = "extractionPointId", referencedColumnName = "elementPrkId")
public class ExtractionPoint extends ElementPrk {

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

}
