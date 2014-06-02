package net.kraklups.solarapp.model.message;

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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TemporalType;
import javax.persistence.Temporal;

@Entity
@Table(name="Message")
public class Message {
	
	private Long messageId;
	private Calendar tvi;
	private String messageText;
	
	public Message() {
	}
	
	public Message(Long messageId, Calendar tvi, String messageText) {
		this.messageId = messageId;
		this.tvi = tvi;
		this.messageText = messageText;
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
	
	@Temporal(TemporalType.TIMESTAMP)
	public Calendar getTvi() {
		return tvi;
	}
	
	public void setTvi(Calendar tvi) {
		this.tvi = tvi;
	}
	
	public String getMessateText() {
		return messageText;
	}
	
	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}
	
	@Override
	public String toString() {
		return "Message [messageId=" + messageId + ", tvi=" + tvi + ", message text=" + messageText + "]";
	}	
}
