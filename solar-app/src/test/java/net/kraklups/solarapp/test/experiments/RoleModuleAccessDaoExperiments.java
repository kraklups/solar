package net.kraklups.solarapp.test.experiments;

import org.hibernate.Transaction;

import net.kraklups.solarapp.model.rolemoduleaccess.RoleModuleAccess;
import net.kraklups.solarapp.model.rolemoduleaccess.RoleModuleAccessDao;
import net.kraklups.solarapp.model.rolemoduleaccess.RoleModuleAccessDaoHibernate;

public class RoleModuleAccessDaoExperiments {
	
	public static void main(String[] args) {
		
		RoleModuleAccessDaoHibernate roleModuleAccessDaoHibernate = new RoleModuleAccessDaoHibernate();
		roleModuleAccessDaoHibernate.setSessionFactory(HibernateUtil
				.getSessionFactory());
		RoleModuleAccessDao roleModuleAccessDao = roleModuleAccessDaoHibernate;
		
		Transaction tx = HibernateUtil.getSessionFactory().getCurrentSession()
				.beginTransaction();
		
		try {
			// Register RoleModuleAccess
			RoleModuleAccess roleModuleAccess = new RoleModuleAccess();
			roleModuleAccessDao.save(roleModuleAccess);
			System.out.println(roleModuleAccess);
						
			
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
