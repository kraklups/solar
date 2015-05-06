package net.kraklups.solarapp.model.timetable;

import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import net.kraklups.solarapp.model.park.Park;
import net.kraklups.solarapp.model.userprofile.UserProfile;

@Entity
@Table(name="TimetableBlock")
public class Timetable {
	
	private Long timetableId;
	
	@NotEmpty
	@Size(min=6, max=30)	
	private String timetableTag;
	
	private UserProfile userProfile;
	
	@DateTimeFormat(pattern="MM/dd/yyyy")
	@NotNull	
	private Date tvi;
	
	private Park park;
	
	public Timetable() {
	}
	
	public Timetable(String timetableTag, UserProfile userProfile, Date tvi, Park park){
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
	
	public Date getTvi(){
		return tvi;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public void setTvi(Date tvi) {
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
		return "TimetableBlock [timetableId=" + timetableId + ", etiqueta=" + timetableTag + ", loginName="
				+ userProfile.getLoginName() + ", tiempo validez inicial=" + tvi + ", Park=" + park.getParkName() + "]";
	}
}
