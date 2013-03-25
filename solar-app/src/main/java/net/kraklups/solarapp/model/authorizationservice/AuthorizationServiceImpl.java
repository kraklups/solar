package net.kraklups.solarapp.model.authorizationservice;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.kraklups.modelutil.exceptions.DuplicateInstanceException;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.module.Module;
import net.kraklups.solarapp.model.module.ModuleDao;
import net.kraklups.solarapp.model.role.Role;
import net.kraklups.solarapp.model.role.RoleDao;
import net.kraklups.solarapp.model.rolemoduleaccess.RoleModuleAccess;
import net.kraklups.solarapp.model.rolemoduleaccess.RoleModuleAccess.Type;
import net.kraklups.solarapp.model.rolemoduleaccess.RoleModuleAccessDao;

@Service("authorizationService")
@Transactional
public class AuthorizationServiceImpl implements AuthorizationService {

	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private ModuleDao moduleDao;
	
	@Autowired 
	private RoleModuleAccessDao roleModuleAccessDao;
		
	@Override
	public Role registerRole(String roleName, String loginName, Long weight) throws DuplicateInstanceException {
		
		try {
			roleDao.findByName(roleName);
			throw new DuplicateInstanceException(roleName, Role.class.getName()); 
		} catch (InstanceNotFoundException e) { 
			Calendar cal = Calendar.getInstance();
			Role role = new Role(roleName, cal, loginName, weight);
			roleDao.save(role);
			return role;
		}
	}

	@Override
	@Transactional(readOnly = true)	
	public Role findRole(Long roleId) throws InstanceNotFoundException {
		return roleDao.find(roleId);
	}

	@Override
	public void removeRole(Long roleId) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Role updateRole(Long roleId, String roleName, Calendar date,
			String loginName, Long weight) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Module registerModule(String moduleName) throws DuplicateInstanceException {

		try {
			moduleDao.findByName(moduleName);
			throw new DuplicateInstanceException(moduleName, Module.class.getName()); 
		} catch (InstanceNotFoundException e) { 
			Calendar cal = Calendar.getInstance();
			Module module = new Module(moduleName, cal);
			moduleDao.save(module);
			return module;
		}
	}

	@Override
	@Transactional(readOnly = true)		
	public Module findModule(Long moduleId) throws InstanceNotFoundException {
		return moduleDao.find(moduleId);
	}

	@Override
	public void removeModule(Long moduleId) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Module updateModule(Long moduleId, String Name, Calendar date)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoleModuleAccess registerRoleModuleAccess(Role role, Module module, Type type) throws DuplicateInstanceException {

		try {
			roleModuleAccessDao.findByName(role.getRoleName(),module.getModuleName());
			throw new DuplicateInstanceException(role.getRoleName()+module.getModuleName(), RoleModuleAccess.class.getName()); 
		} catch (InstanceNotFoundException e) { 
			RoleModuleAccess roleModuleAccess = new RoleModuleAccess();
			roleModuleAccess.setModule(module);
			roleModuleAccess.setRole(role);
			roleModuleAccess.setType(type);
			roleModuleAccessDao.save(roleModuleAccess);
			return roleModuleAccess;
		}		
	}

	@Override
	public void updateRoleModuleAccess() throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RoleModuleAccess removeRoleModuleAccess() throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoleModuleAccess checkRoleModuleAccess()	throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role findRoleByName(String roleName) throws InstanceNotFoundException {
		
		return roleDao.findByName(roleName);
		
	}

	@Override
	public Module findModuleByName(String moduleName) throws InstanceNotFoundException {

		return moduleDao.findByName(moduleName);
	
	}

}
