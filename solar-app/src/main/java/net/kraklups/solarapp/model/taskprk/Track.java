package net.kraklups.solarapp.model.taskprk;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import net.kraklups.solarapp.model.park.Park;
import net.kraklups.solarapp.model.report.Report;
import net.kraklups.solarapp.model.role.Role;
import net.kraklups.solarapp.model.userprofile.UserProfile;

@Entity
@Table(name="Track")
@PrimaryKeyJoinColumn(name = "trackId", referencedColumnName = "taskPrkId")
public class Track extends TaskPrk {

	private static final long serialVersionUID = -550692764739942399L;
	
	//2014-07-04T12:08:56.235
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS")
	@NotNull	
	private Date tvf;	
	
	private Report report;
	
	public Track() {
	}

	public Track(String taskName, Date creationDate,
			Park park, Role role, UserProfile userProfile, Date tvf, Report report) {
		
		super(taskName, creationDate, park, role, userProfile);
		
		this.tvf = tvf;
		this.report = report;
	}

	@Column(name = "trackId", nullable = false, insertable = false, updatable = false)	
	public Long getTrackId() {
		return super.getTaskPrkId();
	}
		
	public void setTrackId(Long trackId){
		super.setTaskPrkId(trackId);
	}	
	
	public Date getTvf(){
		return tvf;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public void setTvf(Date tvf) {
		this.tvf = tvf;
	}		
	
	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name="reportId")	
	public Report getReport() {
		return report;
	}
	
	public void setReport(Report report) {
		this.report = report;
	}
		
}
