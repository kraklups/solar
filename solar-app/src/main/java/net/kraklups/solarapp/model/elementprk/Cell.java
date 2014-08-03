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
@Table(name="Cell")
@PrimaryKeyJoinColumn(name = "elementPrkId", referencedColumnName = "cellId")
public class Cell extends ElementPrk {

	private ArrayPanel arrayPanel;
	private StringLine stringLine;
	
	public Cell() {
		// TODO Auto-generated constructor stub
	}

	public Cell(String elementName, String elementTag, Calendar tvi,
			Calendar lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park) {
		super(elementName, elementTag, tvi, lastAccess, userProfile,
				dataLogger, park);
		// TODO Auto-generated constructor stub
	}

	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name="arrayPanelId")	
	public ArrayPanel getArrayPanel() {
		return arrayPanel;
	}
	
	public void setArrayPanel(ArrayPanel arrayPanel) {
		this.arrayPanel = arrayPanel;
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