package net.kraklups.solarapp.model.datavalue;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import net.kraklups.solarapp.model.datalogger.DataLogger;
import net.kraklups.solarapp.model.elementprk.ElementPrk;
import net.kraklups.solarapp.model.sensor.Sensor;
import net.kraklups.solarapp.model.taskprk.TaskPrk;

@Entity
@Table(name="DataValue")
@Inheritance(strategy=InheritanceType.JOINED)
public class DataValue {
	
	private String dataValueId;
	
	private TaskPrk taskPrk;
	
	private ElementPrk elementPrk;
	
	private DataLogger dataLogger;
	
	private Sensor sensor; 

	public DataValue() {
		// TODO Auto-generated constructor stub
	}
	
	public DataValue(TaskPrk taskPrk, ElementPrk elementPrk, 
			DataLogger dataLogger, Sensor sensor) {
		
		this.taskPrk = taskPrk;
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
	public String getDataValueId() {
		return dataValueId;
	}
	
	public void setDataValueId(String dataValueId) {
		this.dataValueId = dataValueId;
	}

	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name="taskPrkId")	
	public TaskPrk getTaskPrk(){
		return taskPrk;
	}
	
	public void setTaskPrk(TaskPrk taskPrk){
		this.taskPrk = taskPrk;
	}	

	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name="elementPrkId")	
	public ElementPrk getElementPrk(){
		return elementPrk;
	}
	
	public void setElementPrk(ElementPrk elementPrk){
		this.elementPrk = elementPrk;
	}		

	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name="dataLoggerId")	
	public DataLogger getDataLogger(){
		return dataLogger;
	}
	
	public void setDataLogger(DataLogger dataLogger){
		this.dataLogger = dataLogger;
	}		

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
        return "DataValueMngDb [dataValueId=" + dataValueId + ", TaskPrk=" + taskPrk.getTaskPrkId() + 
        		", ElementPrk=" + elementPrk.getElementPrkId() + ", DataLogger=" + dataLogger.getDataLoggerId() + 
        		", Sensor=" + sensor.getSensorId() + "]";
    }	

}
