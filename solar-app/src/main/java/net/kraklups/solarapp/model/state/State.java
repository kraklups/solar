package net.kraklups.solarapp.model.state;

import java.util.Calendar;

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
import javax.persistence.TemporalType;
import javax.persistence.Temporal;

import net.kraklups.solarapp.model.eventtsk.EventTsk;
import net.kraklups.solarapp.model.statetype.StateType;
import net.kraklups.solarapp.model.taskprk.TaskPrk;
import net.kraklups.solarapp.model.taskprk.Upkeep;
import net.kraklups.solarapp.model.park.Park;

@Entity
@Table(name="State")
public class State {

	private Long stateId;
	private Calendar tvi;
	private Calendar tvf;
	private Park park;
	private EventTsk eventTsk;
	private Upkeep upkeep;
	private StateType stateType;
	
	public State() {		
	}
	
	public State(Long stateId, Calendar tvi, Calendar tvf, Park park, EventTsk eventTsk, TaskPrk taskPrk, Upkeep upkeep, StateType stateType) {
		this.stateId = stateId;
		this.tvi = tvi;
		this.tvf = tvf;
		this.park = park;
		this.eventTsk = eventTsk;
		this.upkeep = upkeep;
		this.stateType = stateType;
	}
	
	@SequenceGenerator(                                  // It only takes effect
			name="StateIdGenerator",                     // for databases providing
	        sequenceName="StateSeq", allocationSize=1)   // identifier generators.
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,
		generator="StateIdGenerator")
	@Column(name="stateId", unique= true, nullable = false)
	public Long getStateId() {
		return stateId;
	}	
	
	public void setStateId(Long stateId){
		this.stateId = stateId;
	}
	
	public Calendar getTvi(){
		return tvi;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public void setTvi(Calendar tvi) {
		this.tvi = tvi;
	}

	public Calendar getTvf(){
		return tvf;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public void setTvf(Calendar tvf) {
		this.tvf = tvf;
	}
	
	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name="parkId")	
	public Park getPark(){
		return park;
	}
	
	public void setPark(Park park){
		this.park = park;
	}

	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name="eventTskId")	
	public EventTsk getEventTsk(){
		return eventTsk;
	}
	
	public void setEventTsk(EventTsk eventTsk){
		this.eventTsk = eventTsk;
	}	

	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name="upkeepId")	
	public Upkeep getUpkeep(){
		return upkeep;
	}
	
	public void setUpkeep(Upkeep upkeep){
		this.upkeep = upkeep;
	}

	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name="stateTypeId")	
	public StateType getStateType(){
		return stateType;
	}
	
	public void setStateType(StateType stateType){
		this.stateType = stateType;
	}
	
	@Override
	public String toString() {
		return "State [stateId=" + stateId + ", tvi=" + tvi + ", tvf=" + tvf + ", Park=" + park.getParkName() +
				", EventTsk=" + eventTsk.getEventTskId() + ", TaskPrk=" + upkeep.getTaskPrkId() + 
				", StateType=" + stateType.getStateTypeId() +  "]";
	}
}
