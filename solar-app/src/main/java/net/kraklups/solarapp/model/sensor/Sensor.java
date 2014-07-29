package net.kraklups.solarapp.model.sensor;

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
import net.kraklups.solarapp.model.element.Element;
import net.kraklups.solarapp.model.park.Park;
import net.kraklups.solarapp.model.userprofile.UserProfile;

@Entity
@Table(name="Sensor")

public class Sensor {
	
	private Long sensorId;
	private String sensorTag;
	private String sensorType;
	private Element element;

	public Sensor() {
		// TODO Auto-generated constructor stub
	}

}
