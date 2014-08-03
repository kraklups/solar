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
@Table(name="ArrayBox")
@PrimaryKeyJoinColumn(name = "elementPrkId", referencedColumnName = "arrayBoxId")
public class ArrayBox extends ElementPrk {

	private StringLine stringLine;
	
	public ArrayBox() {
		// TODO Auto-generated constructor stub
	}

	public ArrayBox(String elementPrkName, String elementPrkTag, Calendar tvi,
			Calendar lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park) {
		super(elementPrkName, elementPrkTag, tvi, lastAccess, userProfile,
				dataLogger, park);
		// TODO Auto-generated constructor stub
	}
	
	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name="stringLineId")	
	public StringLine getStringLine() {
		return stringLine;
	}
	
	public void setStringLine(StringLine stringLine) {
		this.stringLine = stringLine;
	}

}