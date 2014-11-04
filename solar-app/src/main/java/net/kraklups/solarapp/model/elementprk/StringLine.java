package net.kraklups.solarapp.model.elementprk;

import java.sql.Timestamp;

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
@Table(name="StringLine")
@PrimaryKeyJoinColumn(name = "stringLineId", referencedColumnName = "elementPrkId")
public class StringLine extends ElementPrk {

	private ArrayBox arrayBox;
	
	public StringLine() {
		// TODO Auto-generated constructor stub
	}

	public StringLine(String elementPrkName, String elementPrkTag,
			Timestamp tvi, Timestamp lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park, ArrayBox arrayBox) {
		
		super(elementPrkName, elementPrkTag, tvi, lastAccess, userProfile,
				dataLogger, park);

		this.arrayBox = arrayBox;
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
