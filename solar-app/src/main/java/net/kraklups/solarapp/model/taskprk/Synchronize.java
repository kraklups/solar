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
@Table(name="Synchronize")
@PrimaryKeyJoinColumn(name = "synchronizeId", referencedColumnName = "taskPrkId")
public class Synchronize extends TaskPrk implements java.io.Serializable {
	
	private static final long serialVersionUID = 5713333023352008921L;

	public Synchronize() {
	}

	public Synchronize(String taskName, Date creationDate,
			Park park, Role role, UserProfile userProfile) {
		
		super(taskName, creationDate, park, role, userProfile);		
	}

	@Column(name = "synchronizeId", nullable = false, insertable = false, updatable = false)	
	public Long getSynchronizeId() {
		return super.getTaskPrkId();
	}
		
	public void setSynchronizeId(Long synchronizeId){
		super.setTaskPrkId(synchronizeId);
	}		
	
}
