package net.kraklups.solarapp.model.park;

import net.kraklups.modelutil.dao.GenericDaoHibernate;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.park.Park;
import net.kraklups.solarapp.model.park.ParkDao;

import org.springframework.stereotype.Repository;

@Repository("parkDao")
public class ParkDaoHibernate extends 
		GenericDaoHibernate<Park, Long> implements ParkDao {

	@Override
	public Park findByName(String parkName) throws InstanceNotFoundException {
		
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
}
