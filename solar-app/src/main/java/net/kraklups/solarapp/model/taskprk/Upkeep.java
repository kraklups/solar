package net.kraklups.solarapp.model.taskprk;

import java.util.Calendar;

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

	public Upkeep() {
		// TODO Auto-generated constructor stub
	}

	public Upkeep(Long taskPrkId, String taskName, Calendar creationDate,
			Park park, Role role, UserProfile userProfile) {
		super(taskPrkId, taskName, creationDate, park, role, userProfile);
		// TODO Auto-generated constructor stub
	}
		

}
