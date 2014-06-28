package net.kraklups.solarapp.model.eventtsk;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TemporalType;
import javax.persistence.Temporal;

import net.kraklups.solarapp.model.taskprk.TaskPrk;
import net.kraklups.solarapp.model.timetable.Timetable;

@Entity
@Table(name="EventTsk")
public class EventTsk {
	
	private Long eventTskId;
	private String tagET;	
	private String definitionET;
	private Calendar tvi;	
	private Calendar tvf;
	private TaskPrk taskPrk;
	private Timetable timetable;
	private Boolean triggerAlarm;
	private Boolean triggerMessage;

	public EventTsk() {
	}
	
	public EventTsk(Long eventTskId, Calendar tvi, Calendar tvf, String tagET, String definitionET, 
			TaskPrk taskPrk, Timetable timetable, Boolean triggerAlarm, Boolean triggerMessage) {
		this.eventTskId = eventTskId;
		this.tvi = tvi;
		this.tvf = tvf;
		this.tagET = tagET;
		this.definitionET = definitionET;
		this.taskPrk = taskPrk;
		this.timetable = timetable;
		this.triggerAlarm = triggerAlarm;
		this.triggerMessage = triggerMessage;
	}
	
	@SequenceGenerator(                                     // It only takes effect
			name="EventTskIdGenerator",                     // for databases providing
	        sequenceName="EventTskSeq", allocationSize=1)   // identifier generators.
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,
		generator="EventTskIdGenerator")
	@Column(name="eventTskId", unique= true, nullable = false)
	public Long getEventTskId() {
		return eventTskId;
	}
	
	public void setEventTskId(Long eventTskId){
		this.eventTskId = eventTskId;
	}	
	
	public Calendar getTvi(){
		return tvi;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public void setTvi(Calendar tvi) {
		this.tvi = tvi;
	}

	public Calendar getTvf(){
		return tvf;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public void setTvf(Calendar tvf) {
		this.tvf = tvf;
	}	

	public String getTagET() {
		return tagET;
	}
	
	public void setTagET(String tagET) {
		this.tagET = tagET;
	}

	public String getDefinitionET() {
		return definitionET;
	}
	
	public void setDefinitionET(String definitionET) {
		this.definitionET = definitionET;
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
	@JoinColumn(name="timetableId")	
	public Timetable getTimetable(){
		return timetable;
	}
	
	public void setTimetable(Timetable timetable){
		this.timetable = timetable;
	}
	
	public Boolean getTriggerAlarm() {
		return triggerAlarm;
	}
	
	public void setTriggerAlarm(Boolean triggerAlarm) {
		this.triggerAlarm = triggerAlarm;
	}
	
	public Boolean getTriggerMessage() {
		return triggerMessage;
	}
	
	public void setTriggerMessage(Boolean triggerMessage) {
		this.triggerMessage = triggerMessage;
	}	
	
	@Override
	public String toString() {
		return "EventTsk [eventTskId=" + eventTskId + ", tag=" + tagET +
			", definition=" + definitionET + ", tvi=" + tvi + ", tvf=" + tvf + ", triggerAlarm=" + triggerAlarm + 
			", triggerMessage=" + triggerMessage + ", timetableId=" + timetable.getTimetableId() + ", taskPrkId=" + taskPrk.getTaskPrkId() + "]";
	}
	
}
