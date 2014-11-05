package net.kraklups.solarapp.model.taskprk;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.PrimaryKeyJoinColumn;

import net.kraklups.solarapp.model.park.Park;
import net.kraklups.solarapp.model.role.Role;
import net.kraklups.solarapp.model.userprofile.UserProfile;

@Entity
@Table(name="Monitor")
@PrimaryKeyJoinColumn(name = "monitorId", referencedColumnName = "taskPrkId")
public class Monitor extends TaskPrk {

	public Monitor() {
		// TODO Auto-generated constructor stub
	}

	public Monitor(String taskName, Date creationDate,
			Park park, Role role, UserProfile userProfile) {
		super(taskName, creationDate, park, role, userProfile);
		// TODO Auto-generated constructor stub
	}

}
