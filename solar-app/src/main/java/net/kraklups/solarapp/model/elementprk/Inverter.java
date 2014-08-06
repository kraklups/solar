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
@Table(name="Inverter")
@PrimaryKeyJoinColumn(name = "elementPrkId", referencedColumnName = "inverterId")
public class Inverter extends ElementPrk {

	private Counter counter;
	private ArrayBox arrayBox;
	private ElectricalSubstation electricalSubstation;
	
	public Inverter() {
		// TODO Auto-generated constructor stub
	}

	public Inverter(String elementPrkName, String elementPrkTag, Calendar tvi,
			Calendar lastAccess, UserProfile userProfile,
			DataLogger dataLogger, Park park, Counter counter, ArrayBox arrayBox, 
			ElectricalSubstation electricalSubstation) {
		
		super(elementPrkName, elementPrkTag, tvi, lastAccess, userProfile,
				dataLogger, park);
		
		this.counter = counter;
		this.arrayBox = arrayBox;
		this.electricalSubstation = electricalSubstation;
	}

	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name="counterId")	
	public Counter getCounter() {
		return counter;
	}
	
	public void setCounter(Counter counter) {
		this.counter = counter;
	}	
	
	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name="arrayBoxId")	
	public ArrayBox getArrayBox() {
		return arrayBox;
	}
	
	public void setArrayBox(ArrayBox arrayBox) {
		this.arrayBox = arrayBox;
	}
	
	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name="electricalSubstationId")	
	public ElectricalSubstation getElectricalSubstation() {
		return electricalSubstation;
	}
	
	public void setElectricalSubstation(ElectricalSubstation electricalSubstation) {
		this.electricalSubstation = electricalSubstation;
	}
	
	
}
