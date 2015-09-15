package net.kraklups.solarapp.web.formatters;

import java.text.ParseException;
import java.util.Locale;

import net.kraklups.solarapp.model.report.Report;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class ReportFormatter implements Formatter<Report> {

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(ReportFormatter.class);
	
	@Override
	public String print(Report report, Locale locale) {
		
//		logger.info("merde print: " + report);
		
		return report.getReportId().toString();
	}

	@Override
	public Report parse(String reportId, Locale locale) throws ParseException {
		
//		logger.info("merde parse: " + reportId);
		
		Report report = new Report();
		report.setReportId(Long.parseLong(reportId));
		
		return report;
	}
}
