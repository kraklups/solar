package net.kraklups.solarapp.model.element;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.TemporalType;
import javax.persistence.Temporal;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

import net.kraklups.solarapp.model.datalogger.DataLogger;
import net.kraklups.solarapp.model.userprofile.UserProfile;

@Entity
@Table(name="Element")
public class Element {
	
	private Long elementId;
	private String elementName;
	private String elementTag;
	private Calendar tvi;
	private Calendar lastDate;
	private UserProfile userProfile;
	private DataLogger dataLogger;

	public Element() {
		// TODO Auto-generated constructor stub
	}
	
	public Element(String elementName, String elementTag, Calendar tvi, Calendar lastDate, UserProfile userProfile, DataLogger dataLogger) {
		this.elementName = elementName;
		this.elementTag = elementTag;
		this.tvi = tvi;
		this.lastDate = lastDate;
		this.userProfile = userProfile;
		this.dataLogger = dataLogger;
	}

}
