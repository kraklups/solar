package net.kraklups.solarapp.model.alarm;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import net.kraklups.solarapp.model.eventtsk.EventTsk;

@Entity
@Table(name="Alarm")
public class Alarm {
	
	private Long alarmId;
	
	@NotEmpty
	@Size(min=6, max=30)	
	private String alarmTag;	

	//2014-07-04T12:08:56.235
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS")
	@NotNull
	private Date triggerDate;	
	
	private EventTsk eventTsk;
	
	public Alarm() {		
	}
	
	public Alarm(String alarmTag, Date triggerDate, EventTsk eventTsk) {
		this.alarmTag = alarmTag;
		this.triggerDate = triggerDate;
		this.eventTsk = eventTsk;
	}

	@SequenceGenerator(                                  // It only takes effect
			name="AlarmIdGenerator",                     // for databases providing
	        sequenceName="AlarmSeq", allocationSize=1)   // identifier generators.
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,
		generator="AlarmIdGenerator")
	@Column(name="alarmId", unique= true, nullable = false)
	public Long getAlarmId() {
		return alarmId;
	}
	
	public void setAlarmId(Long alarmId){
		this.alarmId = alarmId;
	}	

	@Temporal(TemporalType.TIMESTAMP)
	public void setTriggerDate(Date triggerDate) {
		this.triggerDate = triggerDate;
	}

	public Date getTriggerDate(){
		return triggerDate;
	}

	public String getAlarmTag() {
		return alarmTag;
	}
	
	public void setAlarmTag(String alarmTag) {
		this.alarmTag = alarmTag;
	}
	
	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name="eventTskId")	
	public EventTsk getEventTsk(){
		return eventTsk;
	}
	
	public void setEventTsk(EventTsk eventTsk) {
		this.eventTsk = eventTsk;
	}

	@Override
	public String toString() {
		return "Alarm [alarmId=" + alarmId + ", alarmTag=" + alarmTag + ", triggerDate=" + triggerDate + "]";
	}	
	
}
