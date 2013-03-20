package net.kraklups.solarapp.test.experiments;

import java.util.Calendar;

import org.hibernate.Transaction;

import net.kraklups.solarapp.model.company.Company;
import net.kraklups.solarapp.model.company.CompanyDao;
import net.kraklups.solarapp.model.company.CompanyDaoHibernate;


public class CompanyDaoExperiments {
	
	public static void main(String[] args) {
		
		CompanyDaoHibernate companyDaoHibernate = new CompanyDaoHibernate();
		companyDaoHibernate.setSessionFactory(HibernateUtil
				.getSessionFactory());
		CompanyDao companyDao = companyDaoHibernate;
		
		Transaction tx = HibernateUtil.getSessionFactory().getCurrentSession()
				.beginTransaction();
		
		try {
			
			// Register company.
			Calendar startDate = Calendar.getInstance();
			Company company = new Company("thylacinus.net", startDate);
			companyDao.save(company);
			Long companyId = company.getCompanyId();
			System.out.println("Company with companyId '" + companyId
					+ "' has been created");
			System.out.println(company);
			
			
			
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
