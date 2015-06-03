package net.kraklups.solarapp.model.alarm;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

public class AlarmDTO implements java.io.Serializable {
	
	private static final long serialVersionUID = -8263760842698202465L;

	private String alarmTag;	

	private Date triggerDate;	
		
	private String eventTskId;
	
	private String ruleEventTsk;
	
	public AlarmDTO() {		
	}
	
	public AlarmDTO(String alarmTag, Date triggerDate, String eventTskId, String ruleEventTsk) {
		this.eventTskId = eventTskId;
		this.alarmTag = alarmTag;
		this.triggerDate = triggerDate;
		this.ruleEventTsk = ruleEventTsk;
	}

	public String getEventTskId() {
		return eventTskId;
	}
	
	public void setEventTskId(String eventTskId) {
		this.eventTskId = eventTskId;
	}	

	public String getAlarmTag() {
		return alarmTag;
	}
	
	public void setAlarmTag(String alarmTag) {
		this.alarmTag = alarmTag;
	}	
	
	@JsonSerialize(using=DateSerializer.class)	
	public Date getTriggerDate() {
		return triggerDate;
	}
	
	public void setTriggerDate(Date triggerDate) {
		this.triggerDate = triggerDate;
	}		
	
	public String getRuleEventTsk() {
		return ruleEventTsk;
	}
	
	public void setRulEventTsk(String ruleEventTsk) {
		this.ruleEventTsk = ruleEventTsk;
	}
			
	@Override
    public String toString() {
        return "AlarmMngDb [eventTskId=" + eventTskId + ", alarmTag=" + alarmTag +  
        		", triggerDate=" + triggerDate + ", ruleEventTsk=" + ruleEventTsk + "]";
    }	
}
