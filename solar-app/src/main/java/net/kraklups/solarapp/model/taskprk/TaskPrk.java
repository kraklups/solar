package net.kraklups.solarapp.model.taskprk;

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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TemporalType;
import javax.persistence.Temporal;

@Entity
@Table(name="TaskPrk")
public class TaskPrk {
	
	private Long taskPrkId;

	@SequenceGenerator(                                      // It only takes effect
			name="TaskPrkIdGenerator",                     // for databases providing
	        sequenceName="TaskPrkSeq", allocationSize=1)   // identifier generators.
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,
		generator="TaskPrkIdGenerator")
	@Column(name="TaskPrkId", unique= true, nullable = false)
	public Long getTaskPrkId() {
		return taskPrkId;
	}
	
	public void setTaskPrkId(Long taskPrkId){
		this.taskPrkId = taskPrkId;
	}	
	
}
