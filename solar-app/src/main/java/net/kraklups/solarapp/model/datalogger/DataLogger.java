package net.kraklups.solarapp.model.datalogger;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import net.kraklups.solarapp.model.datalogger.DataLogger;

@Entity
@Table(name="DataLogger")
public class DataLogger {

	private Long dataLoggerId;
	
	@NotEmpty
	@Size(min=6, max=30)	
	private String dataLoggerTag;
	
	@NotEmpty
	@Size(min=6, max=30)
	private String dataLoggerType;
	
	private DataLogger dataLoggerManager;
	
	private Set<DataLogger> dataLoggersManaged = new HashSet<DataLogger>(0);
	
	public DataLogger() {
	}
	
	public DataLogger(String dataLoggerTag, String dataLoggerType, DataLogger dataLoggerManager) {
		
		this.dataLoggerTag = dataLoggerTag;
		this.dataLoggerType = dataLoggerType;
		this.dataLoggerManager = dataLoggerManager;
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

	@NotNull
	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name="dataLoggerFK")
	public DataLogger getDataLoggerManager(){
		return dataLoggerManager;
	}
	
	public void setDataLoggerManager(DataLogger dataLoggerManager){
		this.dataLoggerManager = dataLoggerManager;
	}		
	
	@OneToMany(mappedBy="dataLoggerManager")
	public Set<DataLogger> getDataLoggersManaged() {
		return dataLoggersManaged;
	}
	
	public void setDataLoggersManaged(Set<DataLogger> dataLoggersManaged) {
		this.dataLoggersManaged = dataLoggersManaged;
	}
	
	@Override
	public String toString() {
		return "Park [dataLoggerId=" + dataLoggerId + ", dataLoggerTag=" + dataLoggerTag + ", dataLoggerType=" + dataLoggerType +  
                       ", DataLoggerSupervise=" + "]";
	}		
	
}
