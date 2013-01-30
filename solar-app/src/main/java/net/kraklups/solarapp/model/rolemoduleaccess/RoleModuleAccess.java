package net.kraklups.solarapp.model.rolemoduleaccess;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TemporalType;
import javax.persistence.Temporal;
import javax.persistence.UniqueConstraint;
import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.JoinColumn;
import javax.persistence.EmbeddedId;
import javax.persistence.Transient;

@Entity
@Table(name="RoleModuleAccess")
@AssociationOverrides({
	@AssociationOverride(name = "", joincolumns = @JoinColumn(name = ""))
	@AssociationOverride(name = "", joincolumns = @JoinColumn(name = ""))
})
public class RoleModuleAccess {

	private enum Type {R, W, X, NULL};
	
	private Long roleId;
	private Long moduleId;
	private Type type;
	
	public RoleModuleAccess() {	
	}

	public RoleModuleAccess(Long roleId, Long moduleId, Type type) {
		this.roleId = roleId;
		this.moduleId = moduleId;
		this.type = type;
	}
	
	public Long getRoleId() {
		return roleId;
	}
	
	public void setRoleId(Long roleId){
		this.roleId = roleId;
	}
	
	public Long getModuleId() {
		return moduleId;
	}
	
	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}
	
	public Type getType() {
		return type;
	}
	
	public void setType(Type type) {
		this.type = type;
	}
	
}
