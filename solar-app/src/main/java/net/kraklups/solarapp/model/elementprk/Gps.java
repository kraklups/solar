package net.kraklups.solarapp.model.elementprk;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.PrimaryKeyJoinColumn;

import net.kraklups.solarapp.model.datalogger.DataLogger;
import net.kraklups.solarapp.model.park.Park;
import net.kraklups.solarapp.model.userprofile.UserProfile;

@Entity
@Table(name="Gps")
@PrimaryKeyJoinColumn(name = "gpsId", referencedColumnName = "elementPrkId")
public class Gps extends ElementPrk {

	public Gps() {
		// TODO Auto-generated constructor stub
	}

	public Gps(String elementName, String elementTag, Date tvi,
			Date lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park) {
		super(elementName, elementTag, tvi, lastAccess, userProfile,
				dataLogger, park);
		// TODO Auto-generated constructor stub
	}

}
