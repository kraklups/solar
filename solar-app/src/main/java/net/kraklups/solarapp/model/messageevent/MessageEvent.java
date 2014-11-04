package net.kraklups.solarapp.model.messageevent;

import java.sql.Timestamp;

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

import net.kraklups.solarapp.model.eventtsk.EventTsk;

@Entity
@Table(name="MessageEvent")
public class MessageEvent {
	
	private Long messageId;
			
	private Timestamp tvi;
	
	private String messageText;
	private EventTsk eventTsk;
	
	public MessageEvent() {
	}
	
	public MessageEvent(Timestamp tvi, String messageText, EventTsk eventTsk) {
		this.tvi = tvi;
		this.messageText = messageText;
		this.eventTsk = eventTsk;		
	}

	@SequenceGenerator(                                    // It only takes effect
			name="MessageIdGenerator",                     // for databases providing
	        sequenceName="MessageSeq", allocationSize=1)   // identifier generators.
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,
		generator="MessageIdGenerator")
	@Column(name="messageId", unique= true, nullable = false)
	public Long getMessageId() {
		return messageId;
	}
	
	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}
	
	public Timestamp getTvi() {
		return tvi;
	}
	
	public void setTvi(Timestamp tvi) {
		this.tvi = tvi;
	}
	
	public String getMessageText() {
		return messageText;
	}
	
	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}
	
	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name="eventTskId")	
	public EventTsk getEventTsk(){
		return eventTsk;
	}
	
	public void setEventTsk(EventTsk eventTsk){
		this.eventTsk = eventTsk;
	}	
	
	@Override
	public String toString() {
		return "MessageEvent [messageId=" + messageId + ", tvi=" + tvi + ", messageText=" + messageText + "]";
	}	
}
