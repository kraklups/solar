package net.kraklups.solarapp.model.taskprk;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.PrimaryKeyJoinColumn;

import net.kraklups.solarapp.model.park.Park;
import net.kraklups.solarapp.model.role.Role;
import net.kraklups.solarapp.model.userprofile.UserProfile;

@Entity
@Table(name="Synchronize")
@PrimaryKeyJoinColumn(name = "synchronizeId", referencedColumnName = "taskPrkId")
public class Synchronize extends TaskPrk {
	
	public Synchronize() {
		// TODO Auto-generated constructor stub
	}

	public Synchronize(String taskName, Date creationDate,
			Park park, Role role, UserProfile userProfile) {
		super(taskName, creationDate, park, role, userProfile);		
	}
	
}
