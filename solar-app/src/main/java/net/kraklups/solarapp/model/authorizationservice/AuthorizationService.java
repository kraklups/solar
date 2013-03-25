package net.kraklups.solarapp.model.authorizationservice;

import java.util.Calendar;

import net.kraklups.solarapp.model.role.Role;
import net.kraklups.solarapp.model.rolemoduleaccess.RoleModuleAccess;
import net.kraklups.solarapp.model.module.Module;
import net.kraklups.modelutil.exceptions.DuplicateInstanceException;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.rolemoduleaccess.RoleModuleAccess.Type;

public interface AuthorizationService {

	public Role registerRole(String roleName, String loginName, Long weight) 
			throws DuplicateInstanceException;
	
	public Role findRole(Long roleId) throws InstanceNotFoundException;
	
	public Role findRoleByName(String roleName)	throws InstanceNotFoundException;	
	
	public void removeRole(Long roleId) throws InstanceNotFoundException;
	
	public Role updateRole(Long roleId, String roleName, Calendar date, 
			String loginName, Long weight) throws InstanceNotFoundException;

	public Module registerModule(String moduleName) throws DuplicateInstanceException;
	
	public Module findModule(Long moduleId) throws InstanceNotFoundException;
	
	public Module findModuleByName(String moduleName) throws InstanceNotFoundException;	
	
	public void removeModule(Long moduleId) throws InstanceNotFoundException;
	
	public Module updateModule(Long moduleId, String Name, Calendar date) 
			throws InstanceNotFoundException;
	
	public RoleModuleAccess registerRoleModuleAccess(Role role, Module module, Type type) 
			throws DuplicateInstanceException;
	
	public void updateRoleModuleAccess() throws InstanceNotFoundException;
	
	public RoleModuleAccess removeRoleModuleAccess() throws InstanceNotFoundException;
	
	public RoleModuleAccess checkRoleModuleAccess() throws InstanceNotFoundException;
	
}
