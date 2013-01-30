package net.kraklups.solarapp.model.role;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.persistence.TemporalType;
import javax.persistence.Temporal;
import javax.persistence.UniqueConstraint;

import net.kraklups.solarapp.model.rolemoduleaccess.RoleModuleAccess;

@Entity
@Table(name="Role", uniqueConstraints = {
		@UniqueConstraint(columnNames = "roleName") })
public class Role {

	private Long roleId;
	private String roleName;
	private Calendar date;
	private String loginName;
	private Long weight;
	private Set<RoleModuleAccess> roleModuleAccess = new HashSet<RoleModuleAccess>(0);
	
	public Role() {
	}
	
	public Role(String roleName, Calendar date, String loginName, Long weight) {
		
		this.roleName = roleName;
		this.date = date;
		this.loginName = loginName;
		this.weight = weight;
	}

	public Role(String roleName, Calendar date, String loginName, Long weight, Set<RoleModuleAccess> roleModuleAccess) {		

		this.roleName = roleName;
		this.date = date;
		this.loginName = loginName;
		this.weight = weight;
		this.roleModuleAccess = roleModuleAccess;
	}	
	
	@SequenceGenerator(                                    // It only takes effect
			name="RoleIdGenerator",                     // for databases providing
	        sequenceName="RoleSeq", allocationSize=1)   // identifier generators.
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,
		generator="RoleIdGenerator")
	@Column(name="roleId", unique= true, nullable = false)	
    public Long getRoleId() {
		return roleId;
	}	
	
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	
	public String getRoleName() {
		return roleName;
	}
	
	public void setRoleName(String roleName){
		this.roleName = roleName;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
    public Calendar getDate() {
		return date;
	}
	
	public void setDate(Calendar date){
		this.date = date;
	}	
	
	public String getLoginName() {
		return loginName;
	}
	
	public void setLoginName(String loginName){
		this.loginName = loginName;
	}
	
    public Long getWeight() {
		return weight;
	}	
	
	public void setWeight(Long weight) {
		this.weight = weight;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.role")
	public Set<RoleModuleAccess> getRoleModuleAccess() {
		return this.roleModuleAccess;
	}
	
	public void setRoleModuleAccess(Set<RoleModuleAccess> roleModuleAccess) {
		this.roleModuleAccess = roleModuleAccess;
	}
	
}
