package net.kraklups.solarapp.model.datalogger;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.TemporalType;
import javax.persistence.Temporal;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

import net.kraklups.solarapp.model.datalogger.DataLogger;
import net.kraklups.solarapp.model.park.Park;
import net.kraklups.solarapp.model.userprofile.UserProfile;

@Entity
@Table(name="DataLogger")
public class DataLogger {

	private Long dataLoggerId;
	private String dataLoggerTag;
	private String dataLoggerType;
	private DataLogger dataLogger; 
	
	public DataLogger() {
		// TODO Auto-generated constructor stub
	}
	
	public DataLogger(String dataLoggerTag, String dataLoggerType, DataLogger dataLogger) {
		
		this.dataLoggerTag = dataLoggerTag;
		this.dataLoggerType = dataLoggerType;
		this.dataLogger = dataLogger;
	}

	@SequenceGenerator(                                 // It only takes effect
			name="DataLoggerIdGenerator",                     // for databases providing
	        sequenceName="DataLoggerSeq", allocationSize=1)   // identifier generators.
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,
		generator="DataLoggerIdGenerator")
	@Column(name="dataLoggerId", unique= true, nullable = false)
    public Long getDataLoggerId() {
		return dataLoggerId;
	}
	
	public void setDataLoggerId(Long dataLoggerId){
		this.dataLoggerId = dataLoggerId;
	}	
		
	public String getDataLoggerTag() {
		return dataLoggerTag;
	}
	
	public void setDataLoggerTag(String dataLoggerTag){
		this.dataLoggerTag = dataLoggerTag;
	}

	public String getDataLoggerType() {
		return dataLoggerType;
	}
	
	public void setDataLoggerType(String dataLoggerType){
		this.dataLoggerType = dataLoggerType;
	}	

	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name="dataLoggerId")	
	public DataLogger getDataLogger(){
		return dataLogger;
	}
	
	public void setDataLogger(DataLogger dataLogger){
		this.dataLogger = dataLogger;
	}		
	
	@Override
	public String toString() {
		return "Park [dataLoggerId=" + dataLoggerId + ", dataLoggerTag=" + dataLoggerTag + ", dataLoggerType=" + dataLoggerType +  
                       ", DataLoggerSupervise=" + dataLogger.getDataLoggerId() + "]";
	}		
	
}
