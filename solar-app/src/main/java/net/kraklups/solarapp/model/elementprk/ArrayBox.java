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
@Table(name="ArrayBox")
@PrimaryKeyJoinColumn(name = "arrayBoxId", referencedColumnName = "elementPrkId")
public class ArrayBox extends ElementPrk implements java.io.Serializable {

	private static final long serialVersionUID = -169651705716922095L;
	
	public ArrayBox() {
		// TODO Auto-generated constructor stub
	}

	public ArrayBox(String elementPrkName, String elementPrkTag, Date tvi,
			Date lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park, Point mapElement) {
		
		super(elementPrkName, elementPrkTag, tvi, lastAccess, userProfile,
				dataLogger, park, mapElement);
				
	}

	@Column(name = "arrayBoxId", nullable = false, insertable = false, updatable = false)	
	public Long getArrayBoxId() {
		return super.getElementPrkId();
	}
		
	public void setArrayBoxId(Long arrayBoxId){
		super.setElementPrkId(arrayBoxId);
	}	
	

}
