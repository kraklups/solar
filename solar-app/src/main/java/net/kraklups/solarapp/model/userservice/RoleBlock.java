package net.kraklups.solarapp.model.userservice;

import java.util.List;

import net.kraklups.solarapp.model.role.Role;

public class RoleBlock {

	private List<Role> roles;
	private boolean existMoreRoles;
	
	public RoleBlock(List<Role> roles, boolean existMoreRoles) {
		
		this.roles = roles;
		this.existMoreRoles = existMoreRoles;
	}
	
	public List<Role> getRoles() {
		return roles;
	}
	
	public boolean getExistMoreRoles() {
		return existMoreRoles;
	}
}
