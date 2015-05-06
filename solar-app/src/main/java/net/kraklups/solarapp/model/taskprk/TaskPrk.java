package net.kraklups.solarapp.model.taskprk;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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

import net.kraklups.solarapp.model.park.Park;
import net.kraklups.solarapp.model.role.Role;
import net.kraklups.solarapp.model.userprofile.UserProfile;

@Entity
@Table(name="TaskPrk")
@Inheritance(strategy=InheritanceType.JOINED)
public class TaskPrk implements java.io.Serializable {
	
	private static final long serialVersionUID = 6497472672620027142L;
	
	private Long taskPrkId;
	private String taskName;
	private Date creationDate;
	private Park park;
	private Role role;
	private UserProfile userProfile;
		
	public TaskPrk() {		
	}
	
	public TaskPrk(String taskName, Date creationDate, Park park, Role role, UserProfile userProfile) {
		this.taskName = taskName;
		this.creationDate = creationDate;
		this.park = park;
		this.role = role;
		this.userProfile = userProfile;
	}
	
	@SequenceGenerator(                                    // It only takes effect
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
	
	public String getTaskName() {
		return taskName;
	}
	
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	
	public Date getCreationDate() {
		return creationDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name="parkId")	
	public Park getPark() {
		return park;
	}
	
	public void setPark(Park park) {
		this.park = park;
	}

	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name="roleId")	
	public Role getRole() {
		return role;
	}
	
	public void setRole(Role role) {
		this.role = role;
	}

	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name="userProfileId")		
	public UserProfile getUserProfile() {
		return userProfile;
	}
	
	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}
	
	@Override
	public String toString() {
		return "TaskPrk [taskPrkId=" + taskPrkId + ", taskName=" + taskName +
			", parkId=" + park.getParkId() + ", roleId=" + role.getRoleId() + ", userProfile=" + userProfile.getLoginName() + "]";
	}	
	
}
