package net.kraklups.solarapp.model.taskprk;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.PrimaryKeyJoinColumn;

import net.kraklups.solarapp.model.elementprk.ElementPrk;
import net.kraklups.solarapp.model.park.Park;
import net.kraklups.solarapp.model.role.Role;
import net.kraklups.solarapp.model.userprofile.UserProfile;

@Entity
@Table(name="Monitor")
@PrimaryKeyJoinColumn(name = "monitorId", referencedColumnName = "taskPrkId")
public class Monitor extends TaskPrk implements java.io.Serializable {

	private static final long serialVersionUID = -7246533759340007226L;
	
	private Set<ElementPrk> elementPrks = new HashSet<ElementPrk>(0);

	public Monitor() {
		// TODO Auto-generated constructor stub
	}

	public Monitor(String taskName, Date creationDate,
			Park park, Role role, UserProfile userProfile) {
		super(taskName, creationDate, park, role, userProfile);
		// TODO Auto-generated constructor stub
	}
	
	public Monitor(String taskName, Date creationDate,
			Park park, Role role, UserProfile userProfile, Set<ElementPrk> elementPrks) {
		super(taskName, creationDate, park, role, userProfile);
		this.elementPrks = elementPrks; 
	}
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "monitors")
	public Set<ElementPrk> getElementPrks() {
		return this.elementPrks;
	}
	
	public void setElementPrks(Set<ElementPrk> elementPrks) {
		this.elementPrks = elementPrks; 
	}

}
