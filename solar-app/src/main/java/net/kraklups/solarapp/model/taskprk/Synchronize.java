package net.kraklups.solarapp.model.taskprk;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.math.BigInteger;

import javax.persistence.Id;

import net.kraklups.solarapp.model.park.Park;
import net.kraklups.solarapp.model.role.Role;
import net.kraklups.solarapp.model.userprofile.UserProfile;

//@Entity
//@Table(name="Synchronize")
//@PrimaryKeyJoinColumn(name = "synchronizeId", referencedColumnName = "taskPrkId")
public class Synchronize extends TaskPrk {

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name="synchronizeId", nullable=false, unique=true)
	private BigInteger synchronizeKeyHashId;
	
//	@Temporal(TemporalType.TIMESTAMP)
//  @Column(name="tvi")	
	private Calendar tvi;
	
	public Synchronize() {
		// TODO Auto-generated constructor stub
	}

	public Synchronize(String taskName, Calendar creationDate,
			Park park, Role role, UserProfile userProfile, Calendar tvi) {
		super(taskName, creationDate, park, role, userProfile);

		this.tvi = tvi;
	}
	
	public BigInteger getSynchronizeKeyHashId() {
		return synchronizeKeyHashId;
	}
	
	public void setSynchronizeKeyHashId(BigInteger synchronizeKeyHashId) {
		this.synchronizeKeyHashId = synchronizeKeyHashId;
	}
	
//	@Temporal(TemporalType.TIMESTAMP)
    public Calendar getTvi() {
		return tvi;
	}

	public void setTvi(Calendar tvi){
		this.tvi = tvi;
	}	

}
