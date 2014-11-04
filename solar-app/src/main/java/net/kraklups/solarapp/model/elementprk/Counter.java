package net.kraklups.solarapp.model.elementprk;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.PrimaryKeyJoinColumn;

import net.kraklups.solarapp.model.datalogger.DataLogger;
import net.kraklups.solarapp.model.park.Park;
import net.kraklups.solarapp.model.userprofile.UserProfile;

@Entity
@Table(name="Counter")
@PrimaryKeyJoinColumn(name = "counterId", referencedColumnName = "elementPrkId")
public class Counter extends ElementPrk {

	public Counter() {
		// TODO Auto-generated constructor stub
	}

	public Counter(String elementPrkName, String elementPrkTag, Timestamp tvi,
			Timestamp lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park) {
		super(elementPrkName, elementPrkTag, tvi, lastAccess, userProfile,
				dataLogger, park);
		// TODO Auto-generated constructor stub
	}

}
