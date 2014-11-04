package net.kraklups.solarapp.test.experiments;

import java.sql.Timestamp;
import java.util.Calendar;

import org.hibernate.Transaction;

import net.kraklups.solarapp.model.module.Module;
import net.kraklups.solarapp.model.module.ModuleDao;
import net.kraklups.solarapp.model.module.ModuleDaoHibernate;


public class ModuleDaoExperiments {
	
	public static void main(String[] args) {
		
		ModuleDaoHibernate moduleDaoHibernate = new ModuleDaoHibernate();
		moduleDaoHibernate.setSessionFactory(HibernateUtil
				.getSessionFactory());
		ModuleDao moduleDao = moduleDaoHibernate;
		
		Transaction tx = HibernateUtil.getSessionFactory().getCurrentSession()
				.beginTransaction();
		
		try {
			// Register module.
			Calendar calendar = Calendar.getInstance();
			Timestamp timestamp = new Timestamp(calendar.getTime().getTime());
			Module module = new Module("xXx", timestamp);
			moduleDao.save(module);
			Long moduleId = module.getModuleId();
			System.out.println("Company with companyId '" + moduleId
					+ "' has been created");
			System.out.println(module);
			
			
			
			// ... no more cases/entities/methods
			
		} catch (RuntimeException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			HibernateUtil.getSessionFactory().getCurrentSession().close();
		}

		HibernateUtil.shutdown();
		
	}

}
