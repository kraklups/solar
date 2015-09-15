package net.kraklups.solarapp.model.elementprk;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.PrimaryKeyJoinColumn;

import com.vividsolutions.jts.geom.Point;

import net.kraklups.solarapp.model.datalogger.DataLogger;
import net.kraklups.solarapp.model.park.Park;
import net.kraklups.solarapp.model.userprofile.UserProfile;

@Entity
@Table(name="WeatherStation")
@PrimaryKeyJoinColumn(name = "weatherStationId", referencedColumnName = "elementPrkId")
public class WeatherStation extends ElementPrk implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1411890365524632576L;

	public WeatherStation() {
		// TODO Auto-generated constructor stub
	}

	public WeatherStation(String elementName, String elementTag, Date tvi,
			Date lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park, Point mapElement) {
		
		super(elementName, elementTag, tvi, lastAccess, userProfile,
				dataLogger, park, mapElement);
		// TODO Auto-generated constructor stub
	}

	@Column(name = "weatherStationId", nullable = false, insertable = false, updatable = false)	
	public Long getWeatherStationId() {
		return super.getElementPrkId();
	}
		
	public void setWeatherStationId(Long weatherStationId){
		super.setElementPrkId(weatherStationId);
	}	
	
}
