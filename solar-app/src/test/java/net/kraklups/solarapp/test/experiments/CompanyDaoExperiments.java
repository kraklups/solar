package net.kraklups.solarapp.test.experiments;

import java.util.Date;
import java.util.Calendar;

import org.hibernate.Transaction;

import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
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
			Calendar calendar = Calendar.getInstance();
			Date timestamp = new Date(calendar.getTime().getTime());
			Company company = new Company("thylacinus.net", timestamp);
			companyDao.save(company);
			Long companyId = company.getCompanyId();
			System.out.println("Company with companyId '" + companyId
					+ "' has been created");
			System.out.println(company);
			
			// Find user.
			company = companyDao.find(companyId);
			System.out.println("User with userId '" + companyId
					+ "' has been retrieved");
			System.out.println(companyId);			
			
			// ... no more cases/entities/methods			
			
			tx.commit();			
			
		} catch (RuntimeException e) {
			e.printStackTrace();
			tx.rollback();
		} catch (InstanceNotFoundException e) {
			e.printStackTrace();
			tx.commit();
		} finally {
			HibernateUtil.getSessionFactory().getCurrentSession().close();
		}

		HibernateUtil.shutdown();
		
	}

}
