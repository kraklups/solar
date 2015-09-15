package net.kraklups.solarapp.model.role;

import java.util.List;

import net.kraklups.modelutil.dao.GenericDao;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.role.Role;

public interface RoleDao extends GenericDao<Role, Long> {
	
    /**
     * Returns a Role using the role name (not role identifier)
     *
     * @param roleName not the role identifier
     * @return the Role
     */			
	public Role findByName(String roleName) throws InstanceNotFoundException;	

    public List<Role> getRoles(int startIndex, int count)
			throws InstanceNotFoundException; 
	
}
