package net.kraklups.solarapp.model.elementprk;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.PrimaryKeyJoinColumn;

import com.vividsolutions.jts.geom.Point;

import net.kraklups.solarapp.model.datalogger.DataLogger;
import net.kraklups.solarapp.model.park.Park;
import net.kraklups.solarapp.model.userprofile.UserProfile;

@Entity
@Table(name="StringLine")
@PrimaryKeyJoinColumn(name = "stringLineId", referencedColumnName = "elementPrkId")
public class StringLine extends ElementPrk implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7333101383382942282L;
	private ArrayBox arrayBox;
	
	public StringLine() {
		// TODO Auto-generated constructor stub
	}

	public StringLine(String elementPrkName, String elementPrkTag,
			Date tvi, Date lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park, Point mapElement, ArrayBox arrayBox) {
		
		super(elementPrkName, elementPrkTag, tvi, lastAccess, userProfile,
				dataLogger, park, mapElement);

		this.arrayBox = arrayBox;
	}

	@Column(name = "stringLineId", nullable = false, insertable = false, updatable = false)	
	public Long getStringLineId() {
		return super.getElementPrkId();
	}
		
	public void setStringLineId(Long stringLineId){
		super.setElementPrkId(stringLineId);
	}	
	
	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name="arrayBoxId")	
	public ArrayBox getArrayBox() {
		return arrayBox;
	}
	
	public void setArrayBox(ArrayBox arrayBox) {
		this.arrayBox = arrayBox;
	}	

}
