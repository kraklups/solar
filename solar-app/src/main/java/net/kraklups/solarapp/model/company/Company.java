package net.kraklups.solarapp.model.company;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Immutable;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Entity
@Immutable
@Table(name="Company", uniqueConstraints = {
	@UniqueConstraint(columnNames = "companyName") })
public class Company implements java.io.Serializable {

	private static final long serialVersionUID = 1236220179752539048L;

	private Long companyId;
	
	@NotEmpty
	@Size(min=6, max=30)	
	private String companyName;
	
	@DateTimeFormat(pattern="MM/dd/yyyy")
	@NotNull @Past	
	private Date date;
	
	public Company() {
	}
	
	public Company(String companyName, Date date){
		
		/**
		 * NOTE: "companyId" *must* be left as "null" since its value is
		 * automatically generated.
		 */		
		
		this.companyName = companyName;
		this.date = date;
	}
	
	@SequenceGenerator(                                    // It only takes effect
			name="CompanyIdGenerator",                     // for databases providing
	        sequenceName="CompanySeq", allocationSize=1)   // identifier generators.
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,
		generator="CompanyIdGenerator")
	@Column(name="companyId", unique= true, nullable = false)
    public Long getCompanyId() {
		return companyId;
	}
	
	public void setCompanyId(Long companyId){
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}
	
	public void setCompanyName(String companyName){
		this.companyName = companyName;
	}
	
    public Date getDate() {
		return date;
	}
    
    @Temporal(TemporalType.TIMESTAMP)    
    public void setDate(Date date){
		this.date = date;
	}
	
	
	
}
