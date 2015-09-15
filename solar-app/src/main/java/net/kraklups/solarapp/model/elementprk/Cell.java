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
@Table(name="Cell")
@PrimaryKeyJoinColumn(name = "cellId", referencedColumnName = "elementPrkId")
public class Cell extends ElementPrk implements java.io.Serializable {

	private static final long serialVersionUID = 8460475323353477282L;
	private ArrayPanel arrayPanel;
	private StringLine stringLine;
	
	public Cell() {
		// TODO Auto-generated constructor stub
	}

	public Cell(String elementName, String elementTag, Date tvi,
			Date lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park, Point mapElement, ArrayPanel arrayPanel, 
			StringLine stringLine) {
		
		super(elementName, elementTag, tvi, lastAccess, userProfile,
				dataLogger, park, mapElement);
		
		this.stringLine = stringLine;
		this.arrayPanel = arrayPanel;
	}

	@Column(name = "cellId", nullable = false, insertable = false, updatable = false)	
	public Long getCellId() {
		return super.getElementPrkId();
	}
		
	public void setCellId(Long cellId){
		super.setElementPrkId(cellId);
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
