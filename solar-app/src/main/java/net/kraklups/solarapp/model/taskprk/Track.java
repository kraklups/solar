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
	
	public Track() {
		// TODO Auto-generated constructor stub
	}

	public Track(String taskName, Calendar creationDate,
			Park park, Role role, UserProfile userProfile, Calendar tvf, Report report) {
		super(taskName, creationDate, park, role, userProfile);
		
		this.tvf = tvf;
		this.report = report;
	}

	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name="reportId")	
	public Report getReport() {
		return report;
	}
	
	public void setReport(Report report) {
		this.report = report;
	}
	
	public Calendar getTvf(){
		return tvf;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public void setTvf(Calendar tvf) {
		this.tvf = tvf;
	}	
	
}
