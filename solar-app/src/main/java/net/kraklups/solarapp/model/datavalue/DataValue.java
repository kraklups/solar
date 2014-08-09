package net.kraklups.solarapp.model.datavalue;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import net.kraklups.solarapp.model.datalogger.DataLogger;
import net.kraklups.solarapp.model.elementprk.ElementPrk;
import net.kraklups.solarapp.model.sensor.Sensor;
import net.kraklups.solarapp.model.taskprk.TaskPrk;

@Entity
@Table(name = "dataValue")
public class DataValue implements Serializable {

	@Id
	private Long dataValueId;
	private String dataType;
	private String dataInput;
	private Calendar tvi;
	private Calendar tvf;
	private TaskPrk taskPrk;
	private ElementPrk elementPrk;
	private DataLogger dataLogger;
	private Sensor sensor; 
	
	public DataValue() {
		// TODO Auto-generated constructor stub
	}
	
	public DataValue(String dataType, String dataInput,Calendar tvi, Calendar tvf, 
			TaskPrk taskPrk, ElementPrk elementPrk, DataLogger dataLogger, Sensor sensor) {
		
		this.dataType = dataType;
		this.dataInput = dataInput;
		this.tvi = tvi;
		this.tvf = tvf;
		this.taskPrk = taskPrk;
		this.elementPrk = elementPrk;
		this.dataLogger = dataLogger;
		this.sensor = sensor;		
	}

	public Long getDataValueId() {
		return dataValueId;
	}
	
	public void setDataValueId(Long dataValueId) {
		this.dataValueId = dataValueId;
	}

	public String getDataType() {
		return dataType;
	}
	
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}


	public String getDataInput() {
		return dataInput;
	}
	
	public void setDataInput(String dataInput) {
		this.dataInput = dataInput;
	}

//	@Temporal(TemporalType.TIMESTAMP)
        public Calendar getTvi() {
		return tvi;
	}
	
	public void setTvi(Calendar tvi){
		this.tvi = tvi;
	}

//	@Temporal(TemporalType.TIMESTAMP)
        public Calendar getTvf() {
		return tvf;
	}
	
	public void setTvf(Calendar tvf){
		this.tvf = tvf;
	}	

//	@ManyToOne(optional=false, fetch=FetchType.LAZY)
//	@JoinColumn(name="taskPrkId")	
	public TaskPrk getTaskPrk(){
		return taskPrk;
	}
	
	public void setTaskPrk(TaskPrk taskPrk){
		this.taskPrk = taskPrk;
	}	

//	@ManyToOne(optional=false, fetch=FetchType.LAZY)
//	@JoinColumn(name="elementPrkId")	
	public ElementPrk getElementPrk(){
		return elementPrk;
	}
	
	public void setElementPrk(ElementPrk elementPrk){
		this.elementPrk = elementPrk;
	}		

//	@ManyToOne(optional=false, fetch=FetchType.LAZY)
//	@JoinColumn(name="dataLoggerId")	
	public DataLogger getDataLogger(){
		return dataLogger;
	}
	
	public void setDataLogger(DataLogger dataLogger){
		this.dataLogger = dataLogger;
	}		

//	@ManyToOne(optional=false, fetch=FetchType.LAZY)
//	@JoinColumn(name="sensorId")	
	public Sensor getSensor(){
		return sensor;
	}
	
	public void setSensor(Sensor sensor){
		this.sensor = sensor;
	}		
	
	@Override
    public String toString() {
        return "DataValue [dataValueId=" + dataValueId + ", dataType=" + dataType + ", dataInput=" + dataInput + 
        		", tvi=" + tvi + ", tvf=" + tvf + ", TaskPrk=" + taskPrk.getTaskPrkId() + 
        		", ElementPrk=" + elementPrk.getElementPrkId() + ", DataLogger=" + dataLogger.getDataLoggerId() + 
        		", Sensor=" + sensor.getSensorId() + "]";
    }	

}
