package net.kraklups.solarapp.model.elementprk;

import java.util.Calendar;

import net.kraklups.solarapp.model.datalogger.DataLogger;
import net.kraklups.solarapp.model.park.Park;
import net.kraklups.solarapp.model.userprofile.UserProfile;

public class ArrayPanel extends ElementPrk {

	public ArrayPanel() {
		// TODO Auto-generated constructor stub
	}

	public ArrayPanel(String elementPrkName, String elementPrkTag,
			Calendar tvi, Calendar lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park) {
		super(elementPrkName, elementPrkTag, tvi, lastAccess, userProfile,
				dataLogger, park);
		// TODO Auto-generated constructor stub
	}

}
