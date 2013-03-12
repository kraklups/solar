package net.kraklups.solarapp.model.rolemoduleaccess;

import org.springframework.stereotype.Repository;

import net.kraklups.modelutil.dao.GenericDaoHibernate;

@Repository("roleModuleAccess")
public class RoleModuleAccessDaoHibernate extends 
		GenericDaoHibernate<RoleModuleAccess, Long> implements RoleModuleAccessDao {

}
