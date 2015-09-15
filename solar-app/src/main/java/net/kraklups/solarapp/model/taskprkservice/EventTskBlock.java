package net.kraklups.solarapp.model.taskprkservice;

import java.util.List;

import net.kraklups.solarapp.model.eventtsk.EventTsk;

public class EventTskBlock {

	private List<EventTsk> eventTsks;
	private boolean existMoreEventTsks;
	
	public EventTskBlock(List<EventTsk> eventTsks, boolean existMoreEventTsks) {
		
		this.eventTsks = eventTsks;
		this.existMoreEventTsks = existMoreEventTsks;
	}
	
	public List<EventTsk> getEventTsks() {
		return eventTsks;
	}
	
	public boolean getExistMoreEventTsks() {
		return existMoreEventTsks;
	}

}