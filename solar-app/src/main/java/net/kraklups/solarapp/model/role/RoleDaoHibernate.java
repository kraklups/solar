package net.kraklups.solarapp.model.role;

import net.kraklups.modelutil.dao.GenericDaoHibernate;

import org.springframework.stereotype.Repository;

@Repository("roleDao")
public class RoleDaoHibernate extends 
		GenericDaoHibernate<Role, Long> implements RoleDao{

}
