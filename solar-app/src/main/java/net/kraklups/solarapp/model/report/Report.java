package net.kraklups.solarapp.model.report;

import java.util.Calendar;

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

import net.kraklups.solarapp.model.userprofile.UserProfile;

@Entity
@Table(name="Report")
public class Report {

	private Long reportId;
	private String reportTitle;
	private Calendar dateRequest;
	private Calendar dateServed;
	private UserProfile userProfile;
	private String urlReport;
	
	public Report() {		
	}
	
	public Report(String reportTitle, Calendar dateRequest, Calendar dateServed, UserProfile userProfile, String urlReport) {
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
	
	public Calendar getDateRequest() {
		return dateRequest;
	}

	public void setDateRequest(Calendar dateRequest) {
		this.dateRequest = dateRequest;
	}

	public Calendar getDateServed() {
		return dateServed;
	}

	public void setDateServed(Calendar dateServed) {
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
