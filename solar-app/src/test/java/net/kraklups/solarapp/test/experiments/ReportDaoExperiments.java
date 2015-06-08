package net.kraklups.solarapp.test.experiments;

import java.util.Calendar;
import java.util.Date;

import org.hibernate.Transaction;

import net.kraklups.solarapp.model.report.Report;
import net.kraklups.solarapp.model.report.ReportDao;
import net.kraklups.solarapp.model.report.ReportDaoHibernate;
import net.kraklups.solarapp.model.userprofile.UserProfile;

public class ReportDaoExperiments {

	public static void main(String[] args) {
		
		ReportDaoHibernate reportDaoHibernate = new ReportDaoHibernate();
		reportDaoHibernate.setSessionFactory(HibernateUtil
				.getSessionFactory());
		ReportDao reportDao = reportDaoHibernate;
		
		Transaction tx = HibernateUtil.getSessionFactory().getCurrentSession()
				.beginTransaction();
		
		try {
			
			// Register report
			//String reportTitle, Date dateRequest, Date dateServed, UserProfile userProfile, 
			//String urlReport

			Calendar calendar = Calendar.getInstance();
			Date timestamp = new Date(calendar.getTime().getTime());
			
			UserProfile userProfile = new UserProfile();
			
			Report report = new Report("farleyotitle", timestamp, timestamp, userProfile, "farleyoURL");
			
			reportDao.save(report);
			Long reportId = report.getReportId();
			System.out.println("Report with reportId '" + reportId
					+ "' has been created");
			System.out.println(report);
			
						
			// ... no more cases/entities/methods			
			
			tx.commit();			
			
		} catch (RuntimeException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			HibernateUtil.getSessionFactory().getCurrentSession().close();
		}

		HibernateUtil.shutdown();
		
	}


}
