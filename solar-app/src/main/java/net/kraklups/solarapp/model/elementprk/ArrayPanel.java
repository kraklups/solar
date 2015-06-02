package net.kraklups.solarapp.model.elementprk;

import java.util.Date;

import javax.persistence.Column;
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
@Table(name="ArrayPanel")
@PrimaryKeyJoinColumn(name = "arrayPanelId", referencedColumnName = "elementPrkId")
public class ArrayPanel extends ElementPrk implements java.io.Serializable {

	private static final long serialVersionUID = 4714331747174978053L;
	private StringLine stringLine;	

	public ArrayPanel() {
		// TODO Auto-generated constructor stub
	}

	public ArrayPanel(String elementPrkName, String elementPrkTag,
			Date tvi, Date lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park, StringLine stringLine) {
		super(elementPrkName, elementPrkTag, tvi, lastAccess, userProfile,
				dataLogger, park);

		this.stringLine = stringLine;
	}

	@Column(name = "arrayPanelId", nullable = false, insertable = false, updatable = false)	
	public Long getArrayPanelId() {
		return super.getElementPrkId();
	}
		
	public void setArrayPanelId(Long arrayPanelId){
		super.setElementPrkId(arrayPanelId);
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
