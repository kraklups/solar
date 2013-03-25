package net.kraklups.solarapp.model.role;

import net.kraklups.modelutil.dao.GenericDaoHibernate;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.role.Role;

import org.springframework.stereotype.Repository;

@Repository("roleDao")
public class RoleDaoHibernate extends 
		GenericDaoHibernate<Role, Long> implements RoleDao{

	@Override
	public Role findByName(String roleName) throws InstanceNotFoundException {
		
		Role role = (Role) getSession().createQuery(
				"SELECT u FROM Role u WHERE u.roleName = :roleName")
    			.setParameter("roleName", roleName)
    			.uniqueResult();
		
		if (role == null) {
			throw new InstanceNotFoundException(roleName,Role.class.getName());
		} else {
			return role;
		}
	}

}
