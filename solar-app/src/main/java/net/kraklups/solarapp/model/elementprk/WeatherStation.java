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
@Table(name="WeatherStation")
@PrimaryKeyJoinColumn(name = "elementPrkId", referencedColumnName = "weatherStationId")
public class WeatherStation extends ElementPrk {

	public WeatherStation() {
		// TODO Auto-generated constructor stub
	}

	public WeatherStation(String elementName, String elementTag, Calendar tvi,
			Calendar lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park) {
		super(elementName, elementTag, tvi, lastAccess, userProfile,
				dataLogger, park);
		// TODO Auto-generated constructor stub
	}

}