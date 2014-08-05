package net.kraklups.solarapp.model.taskprk;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.PrimaryKeyJoinColumn;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.Table;

import org.bson.types.ObjectId;

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

	public Synchronize(String taskName, Calendar creationDate,
			Park park, Role role, UserProfile userProfile) {
		super(taskName, creationDate, park, role, userProfile);
		// TODO Auto-generated constructor stub
	}

}
