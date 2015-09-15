package net.kraklups.solarapp.model.sensor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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

import net.kraklups.solarapp.model.elementprk.ElementPrk;

@Entity
@Table(name="Sensor")
public class Sensor {
	
	private Long sensorId;
	
	@NotEmpty
	@Size(min=6, max=30)	
	private String sensorTag;
	
	@NotEmpty
	@Size(min=6, max=30)	
	private String sensorType;
	
	private ElementPrk elementPrk;

	public Sensor() {
		// TODO Auto-generated constructor stub
	}
	
	public Sensor(String sensorTag, String sensorType, ElementPrk elementPrk) {
	
		this.sensorTag = sensorTag;
		this.sensorType = sensorType;
		this.elementPrk = elementPrk;		
	}
	
	@SequenceGenerator(                                   // It only takes effect
			name="SensorIdGenerator",                     // for databases providing
	        sequenceName="SensorSeq", allocationSize=1)   // identifier generators.
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,
		generator="SensorIdGenerator")
	@Column(name="sensorId", unique= true, nullable = false)	
    public Long getSensorId() {
		return sensorId;
	}
	
	public void setSensorId(Long sensorId){
		this.sensorId = sensorId;
	}
	
	public String getSensorTag() {
		return sensorTag;
	}
	
	public void setSensorTag(String sensorTag){
		this.sensorTag = sensorTag;
	}

	public String getSensorType() {
		return sensorType;
	}
	
	public void setSensorType(String sensorType){
		this.sensorType = sensorType;
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
	
	@Override
	public String toString() {
		return "Park [sensorId=" + sensorId + ", sensorTag=" + sensorTag + ", sensorType=" + sensorType +  
                       ", DataLoggerSupervise=" + "]";
	}			
	
}
