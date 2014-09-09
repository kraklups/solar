package net.kraklups.solarapp.model.statetype;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@Table(name="StateType")
public class StateType {
	
	private Long stateTypeId;
	private String nameST;
	private String definitionST;

	public StateType() {		
	}
	
	public StateType(Long stateTypeId, String nameST, String definitionST) {
		this.stateTypeId = stateTypeId;
		this.nameST = nameST;
		this.definitionST = definitionST;
	}
	
	@SequenceGenerator(                                      // It only takes effect
			name="StateTypeIdGenerator",                     // for databases providing
	        sequenceName="StateTypeSeq", allocationSize=1)   // identifier generators.
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,
		generator="StateTypeIdGenerator")
	@Column(name="stateTypeId", unique= true, nullable = false)
	public Long getStateTypeId() {
		return stateTypeId;
	}
	
	public void setStateTypeId(Long stateTypeId){
		this.stateTypeId = stateTypeId;
	}
	
	public String getNameST() {
		return nameST;
	}
	
	public void setNameST(String nameST) {
		this.nameST = nameST;
	}

	public String getDefinitionST() {
		return definitionST;
	}
	
	public void setDefinitionST(String definitionST) {
		this.definitionST = definitionST;
	}
	
	@Override
	public String toString() {
		return "StateType [stateTypeId=" + stateTypeId + ", nombre=" + nameST + ", " +
				", definition=" + definitionST + "]";
	}	
	
}
