package net.kraklups.solarapp.model.eventtsk;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

public class EventTskDTO implements java.io.Serializable {

	private static final long serialVersionUID = 9110589812006935816L;

	private String eventTskId;
	
	private String synchronizeId;
	
	private String dataValueId;
	
	private Date tvi;
	
	private Date tvf;
	
	private String ruleEventTsk;

	public EventTskDTO() {
	}
	
	public EventTskDTO(String eventTskId, String synchronizeId, String dataValueId, Date tvi, Date tvf, String ruleEventTsk) {
		this.eventTskId = eventTskId;
		this.synchronizeId = synchronizeId;
		this.dataValueId = dataValueId;
		this.tvi = tvi;
		this.tvf = tvf;
		this.ruleEventTsk = ruleEventTsk;
	}

	public String getEventTskId() {
		return eventTskId;
	}
	
	public void setEventTskId(String eventTskId) {
		this.eventTskId = eventTskId;
	}	
	
	public String getSynchronizeId() {
		return synchronizeId;
	}
	
	public void setSynchronizeId(String synchronizeId) {
		this.synchronizeId = synchronizeId;
	}	
	
	public String getDataValueId() {
		return dataValueId;
	}
	
	@JsonSerialize(using=DateSerializer.class)	
	public Date getTvi() {
		return tvi;
	}	
	
	public void setTvi(Date tvi) {
		this.tvi = tvi;
	}		
	
	@JsonSerialize(using=DateSerializer.class)	
	public Date getTvf() {
		return tvf;
	}	
	
	public void setTvf(Date tvf) {
		this.tvf = tvf;
	}			
	
	public void setDataValueId(String dataValueId) {
		this.dataValueId = dataValueId;
	}	
	
	public String getRuleEventTsk() {
		return ruleEventTsk;
	}
	
	public void setRulEventTsk(String ruleEventTsk) {
		this.ruleEventTsk = ruleEventTsk;
	}
	
	@Override
    public String toString() {
        return "EventTskMongoDB [eventTskId=" + eventTskId + ", synchronizeId=" + synchronizeId + 
        		", dataValueId=" + dataValueId +  
        		", tvi=" + tvi + ", ruleEventTsk=" + ruleEventTsk + "]";
    }	
	
}
