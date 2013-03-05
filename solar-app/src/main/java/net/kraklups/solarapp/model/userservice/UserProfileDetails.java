package net.kraklups.solarapp.model.userservice;

import java.util.Calendar;

import net.kraklups.solarapp.model.company.Company;
import net.kraklups.solarapp.model.role.Role;

public class UserProfileDetails {

	private String firstName;
	private String surname1;
	private String surname2;
	private String email;
	private Calendar date;
	private Boolean blocked;
	private Boolean erased;
	private Company company;
	private Role role;

	public UserProfileDetails(String firstName, String surname1, String surname2, 
			String email, Calendar date, Boolean blocked, Boolean erased, Company company, Role role) {
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
	
	public Calendar getDate() {
		return date;
	}
	
	public Boolean getBlocked() {
		return blocked;
	}

	public Boolean getErased() {
		return erased;
	}
	
	public Company getCompany() {
		return company;
	}
	
	public Role getRole() {
		return role;
	}
}
