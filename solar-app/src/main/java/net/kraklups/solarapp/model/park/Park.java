package net.kraklups.solarapp.model.park;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import net.kraklups.solarapp.model.company.Company;
import net.kraklups.solarapp.model.userprofile.UserProfile;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.vividsolutions.jts.geom.MultiPolygon;

@Entity
@Table(name="Park", uniqueConstraints = {
		@UniqueConstraint(columnNames = "parkName") })
public class Park implements java.io.Serializable {
	
	private static final long serialVersionUID = 2984860031831160751L;

	private Long parkId;
	
	@NotEmpty
	@Size(min=6, max=30)
	private String parkName;
	
	@DateTimeFormat(pattern="MM/dd/yyyy")
	@NotNull @Past
	private Date startupDate;
	
	@DateTimeFormat(pattern="MM/dd/yyyy")
    @NotNull @Past
	private Date productionDate;
	
	private UserProfile userProfile;
	
	private Company company;	
	
//	@MapPark
	private MultiPolygon mapPark;
	
	public Park() {		
	}
	
	public Park(String parkName, Date startupDate, Date productionDate, UserProfile userProfile, 
			Company company, MultiPolygon mapPark) {
	
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
	
    public Date getStartupDate() {
		return startupDate;
	}

    @Temporal(TemporalType.TIMESTAMP)
	public void setStartupDate(Date startupDate){
		this.startupDate = startupDate;
	}
	
    public Date getProductionDate() {
		return productionDate;
	}
	
    @Temporal(TemporalType.TIMESTAMP)    
	public void setProductionDate(Date productionDate){
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
