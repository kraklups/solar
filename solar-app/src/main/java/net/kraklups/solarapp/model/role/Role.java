package net.kraklups.solarapp.model.role;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Role {

	private Long roleId;
	private String roleName;
	private Calendar date;
	private String loginName;
	private Long weight;
	
	public Role() {
	}
	
	public Role(String roleName, Calendar date, String loginName, Long weight) {

		/**
		 * NOTE: "roleId" *must* be left as "null" since its value is
		 * automatically generated.
		 */		
		
		this.roleName = roleName;
		this.date = date;
		this.loginName = loginName;
		this.weight = weight;
	}
	@Column(name="roleId")
	@SequenceGenerator(                                    // It only takes effect
			name="RoleIdGenerator",                     // for databases providing
	        sequenceName="RoleSeq", allocationSize=1)   // identifier generators.
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,
		generator="RoleIdGenerator")
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
	
}
