package net.kraklups.solarapp.model.company;

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

import org.hibernate.annotations.Immutable;
import javax.persistence.UniqueConstraint;


@Entity
@Immutable
@Table(name="Company", uniqueConstraints = {
	@UniqueConstraint(columnNames = "companyName") })
public class Company {

	private Long companyId;
	private String companyName;
	private Calendar date;
	
	public Company() {
	}
	
	public Company(String companyName, Calendar date){
		
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
	
	@Temporal(TemporalType.TIMESTAMP)
    public Calendar getDate() {
		return date;
	}
	
	public void setDate(Calendar date){
		this.date = date;
	}
	
	
	
}
