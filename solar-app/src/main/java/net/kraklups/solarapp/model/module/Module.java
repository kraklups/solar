package net.kraklups.solarapp.model.module;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TemporalType;
import javax.persistence.Temporal;
import javax.persistence.UniqueConstraint;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import net.kraklups.solarapp.model.rolemoduleaccess.RoleModuleAccess;

@Entity
@Table(name="Module", uniqueConstraints = {
		@UniqueConstraint(columnNames = "moduleName") })
public class Module {

	private Long moduleId;
	private String moduleName;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)		
	private Calendar date;
	
	private Set<RoleModuleAccess> roleModuleAccess = new HashSet <RoleModuleAccess>(0);
	
	public Module() {
	}
	
	public Module(String moduleName, Calendar date) {		
		this.moduleName = moduleName;
		this.date = date;
	}
	
	public Module(String moduleName, Calendar date, Set<RoleModuleAccess> roleModuleAccess) {		
		this.moduleName = moduleName;
		this.date = date;
		this.roleModuleAccess = roleModuleAccess;
	}	

	@SequenceGenerator(                                   // It only takes effect
			name="ModuleIdGenerator",                     // for databases providing
	        sequenceName="ModuleSeq", allocationSize=1)   // identifier generators.
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,
		generator="ModuleIdGenerator")
	@Column(name="moduleId", unique= true, nullable = false)	
    public Long getModuleId() {
		return moduleId;
	}
	
	public void setModuleId(Long moduleId){
		this.moduleId = moduleId;
	}

	@Column(name="moduleName", unique= true, nullable = false)
	public String getModuleName() {
		return moduleName;
	}
	
	public void setModuleName(String moduleName){
		this.moduleName = moduleName;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
    public Calendar getDate() {
		return date;
	}
	
	public void setDate(Calendar date){
		this.date = date;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.module", cascade=CascadeType.ALL)
	public Set<RoleModuleAccess> getRoleModuleAccess() {
		return this.roleModuleAccess;
	}
	
	public void setRoleModuleAccess(Set<RoleModuleAccess> roleModuleAccess) {
		this.roleModuleAccess = roleModuleAccess;
	}
}
