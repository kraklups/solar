package net.kraklups.solarapp.model.state;

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

import org.springframework.format.annotation.DateTimeFormat;

import net.kraklups.solarapp.model.eventtsk.EventTsk;
import net.kraklups.solarapp.model.statetype.StateType;
import net.kraklups.solarapp.model.taskprk.Upkeep;
import net.kraklups.solarapp.model.park.Park;

@Entity
@Table(name="State")
public class State {

	private Long stateId;
	
	//2014-07-04T12:08:56.235
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS")
	@NotNull	
	private Date tvi;
	
	//2014-07-04T12:08:56.235
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS")
	@NotNull	
	private Date tvf;
	
	private Park park;
	private EventTsk eventTsk;
	private Upkeep upkeep;
	private StateType stateType;
	
	public State() {		
	}
	
	public State(Date tvi, Date tvf, Park park, EventTsk eventTsk, Upkeep upkeep, StateType stateType) {
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
	
	public Date getTvi(){
		return tvi;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public void setTvi(Date tvi) {
		this.tvi = tvi;
	}

	public Date getTvf(){
		return tvf;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public void setTvf(Date tvf) {
		this.tvf = tvf;
	}
	
	@NotNull
	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name="parkId")	
	public Park getPark(){
		return park;
	}
	
	public void setPark(Park park){
		this.park = park;
	}

	@NotNull
	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name="eventTskId")	
	public EventTsk getEventTsk(){
		return eventTsk;
	}
	
	public void setEventTsk(EventTsk eventTsk){
		this.eventTsk = eventTsk;
	}	

	@NotNull
	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name="upkeepId")	
	public Upkeep getUpkeep(){
		return upkeep;
	}
	
	public void setUpkeep(Upkeep upkeep){
		this.upkeep = upkeep;
	}

	@NotNull
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
		return "State [stateId=" + stateId + ", tvi=" + tvi + ", tvf=" + tvf +  "]";
	}
}
