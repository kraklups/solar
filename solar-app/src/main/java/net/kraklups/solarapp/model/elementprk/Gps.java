package net.kraklups.solarapp.model.elementprk;

import java.util.Calendar;

import net.kraklups.solarapp.model.datalogger.DataLogger;
import net.kraklups.solarapp.model.park.Park;
import net.kraklups.solarapp.model.userprofile.UserProfile;

public class Gps extends ElementPrk {

	public Gps() {
		// TODO Auto-generated constructor stub
	}

	public Gps(String elementName, String elementTag, Calendar tvi,
			Calendar lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park) {
		super(elementName, elementTag, tvi, lastAccess, userProfile,
				dataLogger, park);
		// TODO Auto-generated constructor stub
	}

}
