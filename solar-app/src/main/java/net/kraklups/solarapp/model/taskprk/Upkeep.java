package net.kraklups.solarapp.model.taskprk;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.PrimaryKeyJoinColumn;

import net.kraklups.solarapp.model.park.Park;
import net.kraklups.solarapp.model.role.Role;
import net.kraklups.solarapp.model.userprofile.UserProfile;

@Entity
@Table(name="Upkeep")
@PrimaryKeyJoinColumn(name = "upkeepId", referencedColumnName = "taskPrkId")
public class Upkeep extends TaskPrk {

	private static final long serialVersionUID = 8435842604520449680L;

	public Upkeep() {
	}

	public Upkeep(String taskName, Date creationDate,
			Park park, Role role, UserProfile userProfile) {
		
		super(taskName, creationDate, park, role, userProfile);
	}
	
	@Column(name = "upkeepId", nullable = false, insertable = false, updatable = false)	
	public Long getUpkeepId() {
		return super.getTaskPrkId();
	}
		
	public void setUpkeepId(Long upkeepId){
		super.setTaskPrkId(upkeepId);
	}	

}
