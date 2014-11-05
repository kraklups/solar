package net.kraklups.solarapp.model.elementprk;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.PrimaryKeyJoinColumn;

import net.kraklups.solarapp.model.datalogger.DataLogger;
import net.kraklups.solarapp.model.park.Park;
import net.kraklups.solarapp.model.userprofile.UserProfile;

@Entity
@Table(name="ArrayBox")
@PrimaryKeyJoinColumn(name = "arrayBoxId", referencedColumnName = "elementPrkId")
public class ArrayBox extends ElementPrk {

	private StringLine stringLine;
	
	public ArrayBox() {
		// TODO Auto-generated constructor stub
	}

	public ArrayBox(String elementPrkName, String elementPrkTag, Date tvi,
			Date lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park, StringLine stringLine) {
		
		super(elementPrkName, elementPrkTag, tvi, lastAccess, userProfile,
				dataLogger, park);
				
		this.stringLine = stringLine;
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
