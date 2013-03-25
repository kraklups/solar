package net.kraklups.solarapp.model.rolemoduleaccess;

import org.springframework.stereotype.Repository;

import net.kraklups.modelutil.dao.GenericDaoHibernate;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;

@Repository("roleModuleAccess")
public class RoleModuleAccessDaoHibernate extends 
		GenericDaoHibernate<RoleModuleAccess, Long> implements RoleModuleAccessDao {
	
	@Override
	public RoleModuleAccess findByName(String roleName, String moduleName) 
			throws InstanceNotFoundException {
		
		RoleModuleAccess roleModuleAccess = (RoleModuleAccess) getSession().createQuery(
				"SELECT u, v FROM RoleModuleAccess u WHERE u.roleName = :roleName AND v.moduleName = :moduleName")
    			.setParameter("roleName", roleName)
    			.setParameter("moduleName", moduleName)
    			.uniqueResult();  
		
		if (roleModuleAccess == null) {
			throw new InstanceNotFoundException(roleName+moduleName, RoleModuleAccess.class.getName());
		} else {
			return roleModuleAccess;
		}		
	}

}
