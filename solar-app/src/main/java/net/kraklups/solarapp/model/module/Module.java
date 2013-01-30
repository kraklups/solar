package net.kraklups.solarapp.model.module;

import java.util.Calendar;

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

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name="Module", uniqueConstraints = {
		@UniqueConstraint(columnNames = "moduleName") })
public class Module {

	private Long moduleId;
	private String moduleName;
	private Calendar date;	
	
	public Module() {
	}
	
	public Module(String moduleName, Calendar date) {

		/**
		 * NOTE: "moduleId" *must* be left as "null" since its value is
		 * automatically generated.
		 */
		
		this.moduleName = moduleName;
		this.date = date;
	}

	@SequenceGenerator(                                    // It only takes effect
			name="ModuleIdGenerator",                     // for databases providing
	        sequenceName="ModuleSeq", allocationSize=1)   // identifier generators.
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,
		generator="ModuleIdGenerator")
	@Column(name="moduleId", unique= true, nullable = false)	
    public Long getModuleId() {
		return moduleId;
	}
	
	public void setModuleId(Long companyId){
		this.moduleId = companyId;
	}

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
	
	
}
