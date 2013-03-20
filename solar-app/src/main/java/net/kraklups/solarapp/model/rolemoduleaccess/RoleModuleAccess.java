package net.kraklups.solarapp.model.rolemoduleaccess;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.JoinColumn;
import javax.persistence.EmbeddedId;
import javax.persistence.Transient;

import net.kraklups.solarapp.model.module.Module;
import net.kraklups.solarapp.model.role.Role;

@Entity
@Table(name="RoleModuleAccess")
@AssociationOverrides({
	@AssociationOverride(name = "pk_role", joinColumns = @JoinColumn(name = "roleId")),
	@AssociationOverride(name = "pk_module", joinColumns = @JoinColumn(name = "moduleId"))
})
public class RoleModuleAccess implements Serializable {

	private RoleModuleAccessId pk = new RoleModuleAccessId(); 
	
	private enum Type {R, W, X, NULL};
	private Type type;
	
	public RoleModuleAccess() {	
	}

	@EmbeddedId
	public RoleModuleAccessId getPk() {
		return pk;
	}
	
	public void setPk(RoleModuleAccessId pk){
		this.pk = pk;
	}
		
	@Transient
	public Role getRole() {
		return getPk().getRole();
	}
	
	public void setRole(Role role) {
		getPk().setRole(role);
	}
	
	@Transient
	public Module getModule() {
		return getPk().getModule();
	}
	
	public void setModule(Module module) {
		getPk().setModule(module);
	}
	
	@Column(name = "accessFlag", nullable = false)
	public Type getType() {
		return this.type;
	}
	
	public void setType (Type type) {
		this.type = type;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		RoleModuleAccess that = (RoleModuleAccess) o;

		if (getPk() != null ? !getPk().equals(that.getPk())
				: that.getPk() != null)
			return false;

		return true;		
	}
	
	@Override
	public int hashCode() {
		return (getPk() != null ? getPk().hashCode() : 0);
	}
	
}
