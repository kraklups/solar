package net.kraklups.solarapp.model.taskprk;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import net.kraklups.solarapp.model.park.Park;
import net.kraklups.solarapp.model.report.Report;
import net.kraklups.solarapp.model.role.Role;
import net.kraklups.solarapp.model.userprofile.UserProfile;

@Entity
@Table(name="Track")
@PrimaryKeyJoinColumn(name = "trackId", referencedColumnName = "taskPrkId")
public class Track extends TaskPrk {

	private Calendar tvf;	
	private Report report;
	private UserProfile userProfile;
	
	public Track() {
		// TODO Auto-generated constructor stub
	}

	public Track(Long taskPrkId, String taskName, Calendar creationDate,
			Park park, Role role, UserProfile userProfile) {
		super(taskPrkId, taskName, creationDate, park, role, userProfile);
		// TODO Auto-generated constructor stub
	}

	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name="reportId")	
	public Report getReport() {
		return report;
	}
	
	public void setReport(Report report) {
		this.report = report;
	}
	
	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name="userProfileId")		
	public UserProfile getUserProfile() {
		return userProfile;
	}
	
	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}	

	public Calendar getTvf(){
		return tvf;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public void setTvf(Calendar tvf) {
		this.tvf = tvf;
	}	
	
}
