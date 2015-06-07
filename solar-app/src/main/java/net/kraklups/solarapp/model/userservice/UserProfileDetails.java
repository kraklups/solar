package net.kraklups.solarapp.model.userservice;

import java.util.Date;

import net.kraklups.solarapp.model.company.Company;
import net.kraklups.solarapp.model.role.Role;

public class UserProfileDetails {

	private String firstName;
	private String surname1;
	private String surname2;
	private String email;
	private Date date;
	private Boolean enabled;
	private Boolean accountNonExpired;
	private Boolean credentialsNonExpired;
	private Boolean accountNonLocked;	
	private Company company;
	private Role role;
	
	public UserProfileDetails(String firstName, String surname1, String surname2, 
			String email, Date date, Boolean enabled, Boolean accountNonExpired, 
			Boolean credentialsNonExpired, Boolean accountNonLocked, 
			Company company, Role role) {
		
		this.firstName = firstName;
		this.surname1 = surname1;
		this.surname2 = surname2;
		this.email = email;
		this.date = date;
		this.enabled = enabled;
		this.accountNonExpired = accountNonExpired;
		this.credentialsNonExpired = credentialsNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.company = company;
		this.role = role;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getSurname1() {
		return surname1;
	}
	
	public String getSurname2() {
		return surname2;
	}	

	public String getEmail() {
		return email;
	}
	
	public Date getDate() {
		return date;
	}
	
	public Boolean getEnabled() {
		return enabled;
	}

	public Boolean getAccountNonExpired() {
		return accountNonExpired;
	}

	public Boolean getCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public Boolean getAccountNonLocked() {
		return accountNonLocked;
	}

	public Company getCompany() {
		return company;
	}
	
	public Role getRole() {
		return role;
	}
}
