package net.kraklups.solarapp.model.role;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import net.kraklups.solarapp.model.rolemoduleaccess.RoleModuleAccess;
import net.kraklups.solarapp.model.userprofile.UserProfile;

@Entity
@Table(name="Role", uniqueConstraints = {
		@UniqueConstraint(columnNames = "roleName") })
public class Role {

	private Long roleId;

	@NotEmpty
	@Size(min=6, max=30)
	private String roleName;
	
	@DateTimeFormat(pattern="MM/dd/yyyy")
	@NotNull	
	private Date date;
	
	private UserProfile userProfile;
	
	@NotNull
	private Long weight;
	
	private Set<RoleModuleAccess> roleModuleAccess = new HashSet<RoleModuleAccess>(0);
	
	public Role() {
	}
	
	public Role(String roleName, Date date, UserProfile userProfile, Long weight) {
		
		this.roleName = roleName;
		this.date = date;
		this.userProfile = userProfile;
		this.weight = weight;
	}

	public Role(String roleName, Date date, UserProfile userProfile, Long weight, Set<RoleModuleAccess> roleModuleAccess) {		

		this.roleName = roleName;
		this.date = date;
		this.userProfile = userProfile;
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
	
    public Date getDate() {
		return date;
	}

    @Temporal(TemporalType.TIMESTAMP)
	public void setDate(Date date){
		this.date = date;
	}	
	
	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name="userProfileId")		
	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
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
