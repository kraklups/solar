package net.kraklups.solarapp.model.taskprkservice;

import java.util.List;

import net.kraklups.solarapp.model.alarm.Alarm;

public class AlarmBlock {

	private List<Alarm> alarms;
	private boolean existMoreAlarms;
	
	public AlarmBlock(List<Alarm> alarms, boolean existMoreAlarms) {
		
		this.alarms = alarms;
		this.existMoreAlarms = existMoreAlarms;
	}
	
	public List<Alarm> getAlarms() {
		return alarms;
	}
	
	public boolean getExistMoreAlarms() {
		return existMoreAlarms;
	}

}
