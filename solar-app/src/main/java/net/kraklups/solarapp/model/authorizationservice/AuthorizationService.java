package net.kraklups.solarapp.model.authorizationservice;

import java.util.Calendar;

import net.kraklups.solarapp.model.role.Role;
import net.kraklups.solarapp.model.rolemoduleaccess.RoleModuleAccess;
import net.kraklups.solarapp.model.module.Module;
import net.kraklups.modelutil.exceptions.DuplicateInstanceException;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;

public interface AuthorizationService {

	public Role registerRole(Role role) 
			throws DuplicateInstanceException;
	
	public Role findRole(Long roleId) 
			throws InstanceNotFoundException;
	
	public void removeRole(Long roleId) 
			throws InstanceNotFoundException;
	
	public Role updateRole(Long roleId, String roleName, Calendar date, 
			String loginName, Long weight) 
			throws InstanceNotFoundException;

	public Role registerModule(Module module) 
			throws DuplicateInstanceException;
	
	public Role findModule(Long moduleId) 
			throws InstanceNotFoundException;
	
	public void removeModule(Long moduleId) 
			throws InstanceNotFoundException;
	
	public Role updateModule(Long moduleId, String Name, Calendar date) 
			throws InstanceNotFoundException;
	
	public RoleModuleAccess registerRoleModuleAccess() 
			throws InstanceNotFoundException;
	
	public void updateRoleModuleAccess() 
			throws InstanceNotFoundException;
	
	public RoleModuleAccess removeRoleModuleAccess() 
			throws InstanceNotFoundException;
	
	public RoleModuleAccess checkRoleModuleAccess() 
			throws InstanceNotFoundException;
	
}
