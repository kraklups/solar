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
	private DataLogger dataLogger; 
	
	public DataLogger() {
		// TODO Auto-generated constructor stub
	}
	
	public DataLogger(Long dataLoggerId, DataLogger dataLogger) {
		this.dataLoggerId = dataLoggerId;
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
		return "Park [dataLoggerId=" + dataLoggerId + 
                       ", DataLoggerSupervise=" + dataLogger.getDataLoggerId() + "]";
	}		
	
}
