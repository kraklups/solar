package net.kraklups.solarapp.model.authorizationservice;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.kraklups.modelutil.exceptions.DuplicateInstanceException;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.companyservice.CompanyService;
import net.kraklups.solarapp.model.module.Module;
import net.kraklups.solarapp.model.role.Role;
import net.kraklups.solarapp.model.rolemoduleaccess.RoleModuleAccess;

@Service("authorizationService")
@Transactional
public class AuthorizationServiceImpl implements AuthorizationService {

	@Override
	public Role registerRole(Role role) throws DuplicateInstanceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role findRole(Long roleId) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
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
	public Role registerModule(Module module) throws DuplicateInstanceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role findModule(Long moduleId) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeModule(Long moduleId) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Role updateModule(Long moduleId, String Name, Calendar date)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoleModuleAccess registerRoleModuleAccess()
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateRoleModuleAccess() throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RoleModuleAccess removeRoleModuleAccess()
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoleModuleAccess checkRoleModuleAccess()
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
