package net.kraklups.solarapp.model.role;

import java.util.List;

import net.kraklups.modelutil.dao.GenericDaoHibernate;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.role.Role;

import org.springframework.stereotype.Repository;

@Repository("roleDao")
public class RoleDaoHibernate extends 
		GenericDaoHibernate<Role, Long> implements RoleDao{

	@Override
	public Role findByName(String roleName) 
			throws InstanceNotFoundException {
		
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

	@Override
	@SuppressWarnings("unchecked")	
	public List<Role> getRoles(int startIndex, int count)
			throws InstanceNotFoundException {

		List<Role> roles = (List<Role>)  getSession().createQuery(
	        	"SELECT a FROM Role a " +
	        	"ORDER BY a.roleId").
	           	setFirstResult(startIndex).
	           	setMaxResults(count).list();
		
		if (roles == null) {
			throw new InstanceNotFoundException(null, Role.class.getName());
		} else {
			return roles;
		}
	}

}
