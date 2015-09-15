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
@Table(name="Gps")
@PrimaryKeyJoinColumn(name = "gpsId", referencedColumnName = "elementPrkId")
public class Gps extends ElementPrk implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8868666633517727244L;

	public Gps() {
		// TODO Auto-generated constructor stub
	}

	public Gps(String elementName, String elementTag, Date tvi,
			Date lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park, Point mapElement) {
		
		super(elementName, elementTag, tvi, lastAccess, userProfile,
				dataLogger, park, mapElement);
		// TODO Auto-generated constructor stub
	}

	@Column(name = "gpsId", nullable = false, insertable = false, updatable = false)	
	public Long getGpsId() {
		return super.getElementPrkId();
	}
		
	public void setGpsId(Long gpsId){
		super.setElementPrkId(gpsId);
	}	
	
}
