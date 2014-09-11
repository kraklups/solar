package net.kraklups.solarapp.model.park;

import java.util.List;

import net.kraklups.modelutil.dao.GenericDaoHibernate;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.park.Park;
import net.kraklups.solarapp.model.park.ParkDao;

import org.springframework.stereotype.Repository;

@Repository("parkDao")
public class ParkDaoHibernate extends 
		GenericDaoHibernate<Park, Long> implements ParkDao {

	@Override
	public Park findByParkName(String parkName) throws InstanceNotFoundException {
		
		Park park = (Park) getSession().createQuery(
			"SELECT u FROM Park u WHERE u.parkName = :parkName")
			.setParameter("parkName", parkName)
			.uniqueResult();
	
		if (park == null) {
			throw new InstanceNotFoundException(parkName,Park.class.getName());
		} else {
			return park;
		}	
	}

	@Override
	@SuppressWarnings("unchecked")	
	public List<Park> getParksByLoginName(String loginName, int startIndex, int count)
			throws InstanceNotFoundException {
		
		List<Park> parks = (List<Park>)  getSession().createQuery(
	        	"SELECT a FROM Park a WHERE a.loginName = :loginName " +
	        	"ORDER BY a.parkId").
	         	setParameter("loginName", loginName).
	           	setFirstResult(startIndex).
	           	setMaxResults(count).list();
		
		if (parks == null) {
			throw new InstanceNotFoundException(loginName, Park.class.getName());
		} else {
			return parks;
		}	
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Park> getParksByCompanyId(Long companyId, int startIndex, int count)
			throws InstanceNotFoundException {
		
		List<Park> parks = (List<Park>)  getSession().createQuery(
	        	"SELECT a FROM Park a WHERE a.companyId = :companyId " +
	        	"ORDER BY a.parkId").
	         	setParameter("companyId", companyId).
	           	setFirstResult(startIndex).
	           	setMaxResults(count).list();
		
		if (parks == null) {
			throw new InstanceNotFoundException(companyId, Park.class.getName());
		} else {
			return parks;
		}			
	}
}
