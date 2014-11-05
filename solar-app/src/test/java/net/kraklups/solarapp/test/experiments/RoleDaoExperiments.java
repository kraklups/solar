package net.kraklups.solarapp.test.experiments;

import java.util.Date;
import java.util.Calendar;

import org.hibernate.Transaction;

import net.kraklups.solarapp.model.role.Role;
import net.kraklups.solarapp.model.role.RoleDao;
import net.kraklups.solarapp.model.role.RoleDaoHibernate;
import net.kraklups.solarapp.model.userprofile.UserProfile;

public class RoleDaoExperiments {
	
	public static void main(String[] args) {
	
		RoleDaoHibernate roleDaoHibernate = new RoleDaoHibernate();
		roleDaoHibernate.setSessionFactory(HibernateUtil
				.getSessionFactory());
		RoleDao roleDao = roleDaoHibernate;
		
		Transaction tx = HibernateUtil.getSessionFactory().getCurrentSession()
				.beginTransaction();
		
		try {
			// Register module. Need UserProfile created FK dependency loginName...
			Calendar calendar = Calendar.getInstance();
			Date timestamp = new Date(calendar.getTime().getTime());
			Long weight = new Long("1");
			UserProfile userProfile = new UserProfile();
			
			Role role = new Role("jelon", timestamp, userProfile, weight);
			roleDao.save(role);
			Long roleId = role.getRoleId();
			System.out.println("Company with companyId '" + roleId
					+ "' has been created");
			System.out.println(role);
			
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
