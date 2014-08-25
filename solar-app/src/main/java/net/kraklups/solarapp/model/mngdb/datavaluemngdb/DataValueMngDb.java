package net.kraklups.solarapp.model.mngdb.datavaluemngdb;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import net.kraklups.solarapp.model.datalogger.DataLogger;
import net.kraklups.solarapp.model.elementprk.ElementPrk;
import net.kraklups.solarapp.model.sensor.Sensor;
import net.kraklups.solarapp.model.taskprk.TaskPrk;

@Entity
@Table(name = "dataValueMngDb")
public class DataValueMngDb implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2134365755739425165L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable=false, unique=true)
	private BigInteger id;
	
	@Column(name="dataValueId", nullable=false)
	private String dataValueId;
	
	@Column(name="dataType", nullable=false)
	private String dataType;
	
	@Column(name="dataInput", nullable=false)	
	private String dataInput;
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name="tvi")
	private Calendar tvi;

	@Temporal(TemporalType.TIMESTAMP)
    @Column(name="tvf")
	private Calendar tvf;
	
	@Column(name="taskPrkId", nullable=false)	
	private String taskPrkId;
	
	@Column(name="elementPrkId", nullable=false)	
	private String elementPrkId;

	@Column(name="dataLoggerId", nullable=false)
	private String dataLoggerId;
	
	@Column(name="sensorId", nullable=false)
	private String sensorId; 
		
	public DataValueMngDb() {
		// TODO Auto-generated constructor stub
	}
	
	public DataValueMngDb(String dataValueId, String dataType, String dataInput, Calendar tvi, Calendar tvf, 
			String taskPrkId, String elementPrkId, String dataLoggerId, String sensorId) {
		
		this.dataValueId = dataValueId;
		this.dataType = dataType;
		this.dataInput = dataInput;
		this.tvi = tvi;
		this.tvf = tvf;
		this.taskPrkId = taskPrkId;
		this.elementPrkId = elementPrkId;
		this.dataLoggerId = dataLoggerId;
		this.sensorId = sensorId;		
	}
	
	public BigInteger getId() {
        return id;
    }
 
    public void setId(BigInteger id) {
        this.id = id;
    }	

	public String getDataValueId() {
		return dataValueId;
	}
	
	public void setDataValueId(String dataValueId) {
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

    public Calendar getTvi() {
		return tvi;
	}
	
	public void setTvi(Calendar tvi){
		this.tvi = tvi;
	}

    public Calendar getTvf() {
		return tvf;
	}
	
	public void setTvf(Calendar tvf){
		this.tvf = tvf;
	}	

	public String getTaskPrkId(){
		return taskPrkId;
	}
	
	public void setTaskPrkId(String taskPrkId){
		this.taskPrkId = taskPrkId;
	}	

	public String getElementPrkId(){
		return elementPrkId;
	}
	
	public void setElementPrkId(String elementPrkId){
		this.elementPrkId = elementPrkId;
	}		

	public String getDataLoggerId(){
		return dataLoggerId;
	}
	
	public void setDataLoggerId(String dataLoggerId){
		this.dataLoggerId = dataLoggerId;
	}		

	public String getSensorId(){
		return sensorId;
	}
	
	public void setSensorId(String sensorId){
		this.sensorId = sensorId;
	}		
	
	@Override
    public String toString() {
        return "DataValueMngDb [dataValueId=" + dataValueId + ", dataType=" + dataType + ", dataInput=" + dataInput + 
        		", tvi=" + tvi + ", tvf=" + tvf + ", TaskPrk=" + taskPrkId + 
        		", ElementPrk=" + elementPrkId + ", DataLogger=" + dataLoggerId + 
        		", Sensor=" + sensorId + "]";
    }	

}
