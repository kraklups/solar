package net.kraklups.solarapp.model.park;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

import net.kraklups.solarapp.model.company.Company;
import net.kraklups.solarapp.model.userprofile.UserProfile;

import org.hibernate.annotations.Type;

import com.vividsolutions.jts.geom.MultiPolygon;

@Entity
@Table(name="Park", uniqueConstraints = {
		@UniqueConstraint(columnNames = "parkName") })
public class Park {
	
	private Long parkId;
	private String parkName;
	
	private Timestamp startupDate;
	private Timestamp productionDate;
	
	private UserProfile userProfile;
	private Company company;	
		
	private MultiPolygon mapPark;
	
	public Park() {		
	}
	
	public Park(String parkName, Timestamp startupDate, Timestamp productionDate, UserProfile userProfile, Company company, MultiPolygon mapPark) {
	
		this.parkName = parkName;
		this.startupDate = startupDate;
		this.productionDate = productionDate;		
		this.userProfile = userProfile;
		this.company = company;
		this.mapPark = mapPark;
	}
	
	@SequenceGenerator(                                 // It only takes effect
			name="ParkIdGenerator",                     // for databases providing
	        sequenceName="ParkSeq", allocationSize=1)   // identifier generators.
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,
		generator="ParkIdGenerator")
	@Column(name="parkId", unique= true, nullable = false)	
    public Long getParkId() {
		return parkId;
	}
	
	public void setParkId(Long parkId){
		this.parkId = parkId;
	}

	@Column(name="parkName", unique= true, nullable = false)
	public String getParkName() {
		return parkName;
	}
	
	public void setParkName(String parkName){
		this.parkName = parkName;
	}
	
    public Timestamp getStartupDate() {
		return startupDate;
	}
	
	public void setStartupDate(Timestamp startupDate){
		this.startupDate = startupDate;
	}
	
    public Timestamp getProductionDate() {
		return productionDate;
	}
	
	public void setProductionDate(Timestamp productionDate){
		this.productionDate = productionDate;
	}	

	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name="userProfileId")		
	public UserProfile getUserProfile() {
		return userProfile;
	}
	
	public void setUserProfile(UserProfile userProfile){
		this.userProfile = userProfile;
	}
	
	@Type(type="org.hibernate.spatial.GeometryType")	
	public MultiPolygon getMapPark() {
		return mapPark;
	}
	
	public void setMapPark(MultiPolygon mapPark) {
		this.mapPark = mapPark;
	}

	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name="companyId")	
	public Company getCompany(){
		return company;
	}
	
	public void setCompany(Company company){
		this.company = company;
	}
	
	@Override
	public String toString() {
		return "Park [parkId=" + parkId + ", nombre=" + parkName + ", startupDate=" + startupDate +
                       ", productionDate=" + productionDate + ", company=" + company.getCompanyName() + 
                       ", user_author=" + userProfile.getLoginName() + 
                       "mapPark=" + mapPark.toText() + "]";
	}	
	
}
