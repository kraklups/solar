package net.kraklups.solarapp.model.elementprk;

import java.util.Calendar;

import net.kraklups.solarapp.model.datalogger.DataLogger;
import net.kraklups.solarapp.model.park.Park;
import net.kraklups.solarapp.model.userprofile.UserProfile;

public class Cell extends ElementPrk {

	public Cell() {
		// TODO Auto-generated constructor stub
	}

	public Cell(String elementName, String elementTag, Calendar tvi,
			Calendar lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park) {
		super(elementName, elementTag, tvi, lastAccess, userProfile,
				dataLogger, park);
		// TODO Auto-generated constructor stub
	}

}
