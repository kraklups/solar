package net.kraklups.solarapp.model.timetable;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.TemporalType;
import javax.persistence.Temporal;

import net.kraklups.solarapp.model.park.Park;
import net.kraklups.solarapp.model.userprofile.UserProfile;

@Entity
@Table(name="Timetable")
public class Timetable {
	
	private Long timetableId;
	private String timetableTag;
	private UserProfile userProfile;
	private Calendar tvi;
	private Park park;
	
	public Timetable() {
	}
	
	public Timetable(Long timetableId, String timetableTag, UserProfile userProfile, Calendar tvi, Park park){
		this.timetableId = timetableId;
		this.timetableTag = timetableTag;
		this.userProfile = userProfile;
		this.tvi = tvi;
		this.park = park;
	}

	@SequenceGenerator(                                      // It only takes effect
			name="TimetableIdGenerator",                     // for databases providing
	        sequenceName="TimetableSeq", allocationSize=1)   // identifier generators.
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,
		generator="TimetableIdGenerator")
	@Column(name="timetableId", unique= true, nullable = false)
	public Long getTimetableId() {
		return timetableId;
	}
	
	public void setTimetableId(Long timetableId){
		this.timetableId = timetableId;
	}
	
	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name="userProfileId")	
	public UserProfile getUserProfile(){
		return userProfile;
	}
	
	public void setUserProfile(UserProfile userProfile){
		this.userProfile = userProfile;
	}
	
	public String getTimetableTag() {
		return timetableTag;
	}
	
	public void setTimetableTag(String timetableTag){
		this.timetableTag = timetableTag;
	}
	
	public Calendar getTvi(){
		return tvi;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public void setTvi(Calendar tvi) {
		this.tvi = tvi;
	}
	
	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name="parkId")	
	public Park getPark(){
		return park;
	}
	
	public void setPark(Park park){
		this.park = park;
	}

	@Override
	public String toString() {
		return "Timetable [timetableId=" + timetableId + ", etiqueta=" + timetableTag + ", loginName="
				+ userProfile.getLoginName() + ", tiempo validez inicial=" + tvi + ", Park=" + park.getParkName() + "]";
	}
}
