package net.kraklups.solarapp.test.experiments;

import org.hibernate.Transaction;

import net.kraklups.solarapp.model.report.Report;
import net.kraklups.solarapp.model.report.ReportDao;
import net.kraklups.solarapp.model.report.ReportDaoHibernate;

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

			Report report = new Report();
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
