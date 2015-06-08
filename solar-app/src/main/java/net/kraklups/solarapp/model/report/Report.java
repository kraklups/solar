package net.kraklups.solarapp.model.report;

import java.util.Date;

import javax.persistence.Entity;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;
import org.springframework.format.annotation.DateTimeFormat;

import net.kraklups.solarapp.model.userprofile.UserProfile;

@Entity
@Table(name="Report")
public class Report {

	private Long reportId;
	
	@NotEmpty
	@Size(min=6, max=50)	
	private String reportTitle;

	//2014-07-04T12:08:56.235
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS")
	@NotNull	
	private Date dateRequest;
	
	//2014-07-04T12:08:56.235	
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS")
	@NotNull	
	private Date dateServed;
	
	private UserProfile userProfile;
	
	@URL
	@NotEmpty
	private String urlReport;
	
	public Report() {		
	}
	
	public Report(String reportTitle, Date dateRequest, Date dateServed, UserProfile userProfile, 
			String urlReport) {
		
		this.reportTitle = reportTitle;
		this.dateRequest = dateRequest;
		this.dateServed = dateServed;
		this.userProfile = userProfile;
		this.urlReport = urlReport;
		
	}
	
	@SequenceGenerator(                                   // It only takes effect
			name="ReportIdGenerator",                     // for databases providing
	        sequenceName="ReportSeq", allocationSize=1) // identifier generators.
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,
		generator="ReportIdGenerator")
	@Column(name="ReportId", unique= true, nullable = false)
	public Long getReportId() {
		return reportId;
	}
	
	public void setReportId(Long reportId){
		this.reportId = reportId;
	}	
	
	public String getReportTitle() {
		return reportTitle;
	}
	
	public void setReportTitle(String reportTitle) {
		this.reportTitle = reportTitle;
	}
	
	public Date getDateRequest() {
		return dateRequest;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public void setDateRequest(Date dateRequest) {
		this.dateRequest = dateRequest;
	}

	public Date getDateServed() {
		return dateServed;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public void setDateServed(Date dateServed) {
		this.dateServed = dateServed;
	}

	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name="userProfileId")		
	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public String getUrlReport() {
		return urlReport;
	}

	public void setUrlReport(String urlReport) {
		this.urlReport = urlReport;
	}
	
	@Override
	public String toString() {
		return "Report [reportId=" + reportId + ", reportTitle=" + reportTitle +
			", dateRequest=" + dateRequest + ", dateServed=" + dateServed + ", loginRequest=" + userProfile.getLoginName() +
			", urlReport=" + urlReport + "]";
	}		
	
}
