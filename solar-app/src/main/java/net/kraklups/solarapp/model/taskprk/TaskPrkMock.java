package net.kraklups.solarapp.model.taskprk;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import net.kraklups.solarapp.model.park.Park;
import net.kraklups.solarapp.model.report.Report;
import net.kraklups.solarapp.model.role.Role;
import net.kraklups.solarapp.model.userprofile.UserProfile;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class TaskPrkMock {

	private Long taskPrkId;
	
	@NotEmpty
	@Size(min=6, max=30)		
	private String taskName;
	
	//2014-07-04T12:08:56.235
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS")
	@NotNull	
	private Date creationDate;
	
	private Park park;
	private Role role;
	private UserProfile userProfile;
	
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS")
	@NotNull	
	private Date tvf;	
	
	private Report report;	
		
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

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Park getPark() {
		return park;
	}
	
	public void setPark(Park park) {
		this.park = park;
	}

	public Role getRole() {
		return role;
	}
	
	public void setRole(Role role) {
		this.role = role;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}
	
	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}
	
	public Date getTvf(){
		return tvf;
	}

	public void setTvf(Date tvf) {
		this.tvf = tvf;
	}		
	
	public Report getReport() {
		return report;
	}
	
	public void setReport(Report report) {
		this.report = report;
	}
	
}
