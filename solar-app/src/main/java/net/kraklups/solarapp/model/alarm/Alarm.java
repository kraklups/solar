package net.kraklups.solarapp.model.alarm;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name="Alarm", uniqueConstraints = {
		@UniqueConstraint(columnNames = "Name") })
public class Alarm {
	
	private Long alarmId;
	private String alarmName;
	private Calendar triggerDate;
	private Calendar transactionTime; 
	
	public Alarm() {		
	}
	
	public Alarm(Long alarmId, String alarmName, Calendar triggerDate, Calendar transactionTime) {
		this.alarmId = alarmId;
		this.alarmName = alarmName;
		this.triggerDate = triggerDate;
		this.transactionTime = transactionTime;
	}

	
	
}
