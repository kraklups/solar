package net.kraklups.solarapp.model.rolemoduleaccess;

import net.kraklups.modelutil.dao.GenericDao;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;

public interface RoleModuleAccessDao extends GenericDao<RoleModuleAccess, Long> {
	
	public RoleModuleAccess findByName(String roleName, String moduleName) throws InstanceNotFoundException;	

}
