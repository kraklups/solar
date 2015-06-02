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
@Table(name="SolarTracker")
@PrimaryKeyJoinColumn(name = "solarTrackerId", referencedColumnName = "elementPrkId")
public class SolarTracker extends ElementPrk implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2255007157602134302L;

	public SolarTracker() {
		// TODO Auto-generated constructor stub
	}

	public SolarTracker(String elementPrkName, String elementPrkTag,
			Date tvi, Date lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park) {
		super(elementPrkName, elementPrkTag, tvi, lastAccess, userProfile,
				dataLogger, park);
		// TODO Auto-generated constructor stub
	}

	@Column(name = "solarTrackerId", nullable = false, insertable = false, updatable = false)	
	public Long getSolarTrackerId() {
		return super.getElementPrkId();
	}
		
	public void setSolarTrackerId(Long solarTrackerId){
		super.setElementPrkId(solarTrackerId);
	}	
	
}
