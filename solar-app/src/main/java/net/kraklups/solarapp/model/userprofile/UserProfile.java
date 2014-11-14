package net.kraklups.solarapp.model.userprofile;

import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import net.kraklups.solarapp.model.company.Company;
import net.kraklups.solarapp.model.role.Role;

@Entity
@Table(name="UserProfile", uniqueConstraints = {
		@UniqueConstraint(columnNames = "loginName") })
public class UserProfile {

	private Long userProfileId;
	private String loginName;
	private String encryptedPassword;
	private String firstName;
	private String surname1;
	private String surname2;	
	private String email;
	private Date date;
	private Boolean blocked;
	private Boolean erased;
	private Company company;
	private Role role;
	private long version;

	public UserProfile() {
	}
	
	public UserProfile(String loginName, String encryptedPassword,
			String firstName, String surname1, String surname2, String email, 
			Date date, Boolean blocked, Boolean erased, Company company, Role role) {

		this.loginName = loginName;
		this.encryptedPassword = encryptedPassword;
		this.firstName = firstName;
		this.surname1 = surname1;
		this.surname2 = surname2;		
		this.email = email;
		this.date = date;
		this.blocked = blocked;
		this.erased = erased;
		this.company = company;
		this.role = role;
	}

	@SequenceGenerator(                                      // It only takes effect for
	name = "UserProfileIdGenerator",                         // databases providing identifier
	sequenceName = "UserProfileSeq", allocationSize=1)       // generators.
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "UserProfileIdGenerator")
	@Column(name="userProfileId", unique= true, nullable = false)	
	public Long getUserProfileId() {
		return userProfileId;
	}

	public void setUserProfileId(Long userProfileId) {
		this.userProfileId = userProfileId;
	}

	@Column(name="loginName", unique=true)
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	@Column(name = "enPassword")
	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname1() {
		return surname1;
	}

	public void setSurname1(String surname1) {
		this.surname1 = surname1;
	}

	public String getSurname2() {
		return surname2;
	}

	public void setSurname2(String surname2) {
		this.surname2 = surname2;
	}	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDate() {
		return date;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Boolean getBlocked () {
		return blocked;
	}
	
	public void setBlocked(Boolean blocked) {
		this.blocked = blocked;
	}

	public Boolean getErased () {
		return erased;
	}
	
	public void setErased(Boolean erased) {
		this.erased = erased;
	}	
	
	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name="companyId")
	public Company getCompany() {
		return company;
	}
	
	public void setCompany(Company company) {
		this.company = company;
	}
	
	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name="roleId")
	public Role getRole() {
		return role;
	}
	
	public void setRole(Role role) {
		this.role = role;
	}	
	
	@Version
	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "UserProfile [userProfileId=" + userProfileId + ", loginName="
				+ loginName + ", encryptedPassword=" + encryptedPassword
				+ ", firstName=" + firstName + ", surname1=" + surname1
				+ ", surname2=" + surname2 + ", blocked=" + blocked+ ", erased=" + erased  
				+ ", email=" + email + ", version=" + version + "]";
	}

}
