package net.kraklups.solarapp.model.messageevent;

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
@Table(name="MessageEvent")
public class MessageEvent {
	
	private Long messageEventId;

	@NotEmpty
	@Size(min=1, max=50)
	private String messageEventText;	
	
	//2014-07-04T12:08:56.235	
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS")
	@NotNull	
	private Date tvi;
	
	private EventTsk eventTsk;
	
	public MessageEvent() {
	}
	
	public MessageEvent(Date tvi, String messageEventText, EventTsk eventTsk) {
		this.tvi = tvi;
		this.messageEventText = messageEventText;
		this.eventTsk = eventTsk;		
	}

	@SequenceGenerator(                                    // It only takes effect
			name="MessageIdGenerator",                     // for databases providing
	        sequenceName="MessageEventSeq", allocationSize=1)   // identifier generators.
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,
		generator="MessageIdGenerator")
	@Column(name="messageEventId", unique= true, nullable = false)
	public Long getMessageEventId() {
		return messageEventId;
	}
	
	public void setMessageEventId(Long messageEventId) {
		this.messageEventId = messageEventId;
	}
	
	public Date getTvi() {
		return tvi;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public void setTvi(Date tvi) {
		this.tvi = tvi;
	}
	
	public String getMessageEventText() {
		return messageEventText;
	}
	
	public void setMessageEventText(String messageEventText) {
		this.messageEventText = messageEventText;
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
		return "MessageEvent [messageEventId=" + messageEventId + ", tvi=" + tvi + ", messageEventText=" + messageEventText + "]";
	}	
}
