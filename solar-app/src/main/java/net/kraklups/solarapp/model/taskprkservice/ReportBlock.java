package net.kraklups.solarapp.model.taskprkservice;

import java.util.List;

import net.kraklups.solarapp.model.report.Report;

public class ReportBlock {

	private List<Report> reports;
	private boolean existMoreReports;
	
	public ReportBlock(List<Report> reports, boolean existMoreReports) {
		
		this.reports = reports;
		this.existMoreReports = existMoreReports;
	}
	
	public List<Report> getReports() {
		return reports;
	}
	
	public boolean getExistMoreReports() {
		return existMoreReports;
	}

}
