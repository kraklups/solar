package net.kraklups.solarapp.model.alarm;

import java.util.Calendar;

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
import javax.persistence.TemporalType;
import javax.persistence.Temporal;

import net.kraklups.solarapp.model.eventtsk.EventTsk;

@Entity
@Table(name="Alarm")
public class Alarm {
	
	private Long alarmId;
	private String alarmTag;
	
	private Calendar triggerDate;
	
	private EventTsk eventTsk;
	
	public Alarm() {		
	}
	
	public Alarm(String alarmTag, Calendar triggerDate, EventTsk eventTsk) {
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
	public void setTriggerDate(Calendar triggerDate) {
		this.triggerDate = triggerDate;
	}

	public Calendar getTriggerDate(){
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
