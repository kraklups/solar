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
@Table(name="Counter")
@PrimaryKeyJoinColumn(name = "counterId", referencedColumnName = "elementPrkId")
public class Counter extends ElementPrk implements java.io.Serializable {

	private static final long serialVersionUID = 8704437745152614696L;

	public Counter() {
		// TODO Auto-generated constructor stub
	}

	public Counter(String elementPrkName, String elementPrkTag, Date tvi,
			Date lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park) {
		super(elementPrkName, elementPrkTag, tvi, lastAccess, userProfile,
				dataLogger, park);
		// TODO Auto-generated constructor stub
	}

	@Column(name = "counterId", nullable = false, insertable = false, updatable = false)	
	public Long getCounterId() {
		return super.getElementPrkId();
	}
		
	public void setCounterId(Long counterId){
		super.setElementPrkId(counterId);
	}	
	
}
