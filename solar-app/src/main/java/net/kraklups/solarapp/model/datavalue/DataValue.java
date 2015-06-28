package net.kraklups.solarapp.model.datavalue;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import net.kraklups.solarapp.model.datalogger.DataLogger;
import net.kraklups.solarapp.model.elementprk.ElementPrk;
import net.kraklups.solarapp.model.sensor.Sensor;
import net.kraklups.solarapp.model.taskprk.Synchronize;

@Entity
@Table(name="DataValue")
public class DataValue {
	
	private Long dataValueId;
	private Synchronize synchronize;
	private ElementPrk elementPrk;
	private DataLogger dataLogger;	
	private Sensor sensor; 

	public DataValue() {
		// TODO Auto-generated constructor stub
	}
	
	public DataValue(Synchronize synchronize, ElementPrk elementPrk, 
			DataLogger dataLogger, Sensor sensor) {
		
		this.synchronize = synchronize;
		this.elementPrk = elementPrk;
		this.dataLogger = dataLogger;
		this.sensor = sensor;		
	}
	
	@SequenceGenerator(                                    // It only takes effect
			name="DataValueIdGenerator",                     // for databases providing
	        sequenceName="DataValueSeq", allocationSize=1)   // identifier generators.
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,
		generator="DataValueIdGenerator")
	@Column(name="DataValueId", unique= true, nullable = false)
	public Long getDataValueId() {
		return dataValueId;
	}
	
	public void setDataValueId(Long dataValueId) {
		this.dataValueId = dataValueId;
	}

	@NotNull
	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name="synchronizeId")	
	public Synchronize getSynchronize(){
		return synchronize;
	}
	
	public void setSynchronize(Synchronize synchronize){
		this.synchronize = synchronize;
	}	
	
	@NotNull
	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name="elementPrkId")	
	public ElementPrk getElementPrk(){
		return elementPrk;
	}
	
	public void setElementPrk(ElementPrk elementPrk){
		this.elementPrk = elementPrk;
	}		

	@NotNull
	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name="dataLoggerId")	
	public DataLogger getDataLogger(){
		return dataLogger;
	}
	
	public void setDataLogger(DataLogger dataLogger){
		this.dataLogger = dataLogger;
	}		

	@NotNull
	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name="sensorId")	
	public Sensor getSensor(){
		return sensor;
	}
	
	public void setSensor(Sensor sensor){
		this.sensor = sensor;
	}		
	
	@Override
    public String toString() {
        return "DataValueMngDb [dataValueId=" + dataValueId + "]";
    }	

}
