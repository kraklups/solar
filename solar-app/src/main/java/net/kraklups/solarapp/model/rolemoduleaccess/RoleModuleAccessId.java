package net.kraklups.solarapp.model.rolemoduleaccess;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import net.kraklups.solarapp.model.module.Module;
import net.kraklups.solarapp.model.role.Role;

@Embeddable
public class RoleModuleAccessId implements Serializable {

	private static final long serialVersionUID = -8016268336157047004L;
	
	private Role role;
	private Module module;
	
	@ManyToOne
	public Role getRole() {
		return role;
	}
	
	public void setRole(Role role) {
		this.role = role;
	}
	
	@ManyToOne
	public Module getModule() {
		return module;
	}
	
	public void setModule(Module module) {
		this.module = module;
	}
	
	@Override
	public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoleModuleAccessId that = (RoleModuleAccessId) o;

        if (role != null ? !role.equals(that.role) : that.role != null) return false;
        if (module != null ? !module.equals(that.module) : that.module != null)
            return false;

        return true;
    }	
    
	@Override
	public int hashCode() {
        int result;
        result = (role != null ? role.hashCode() : 0);
        result = 31 * result + (module != null ? module.hashCode() : 0);
        return result;
    }
}
