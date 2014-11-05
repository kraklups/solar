package net.kraklups.solarapp.model.report;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.kraklups.modelutil.dao.GenericDaoHibernate;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;

@Repository("reportDao")
public class ReportDaoHibernate extends 
		GenericDaoHibernate<Report, Long> implements ReportDao
{

	@Override
	@SuppressWarnings("unchecked")
	public List<Report> getReportsByUserProfileId(Long userProfileId,
			int startIndex, int count) throws InstanceNotFoundException {
		
		List<Report> reports = (List<Report>)  getSession().createQuery(
	        	"SELECT a FROM Report a WHERE a.userProfileId = :userProfileId " +
	        	"ORDER BY a.userProfileId").
	         	setParameter("userProfileId", userProfileId).
	           	setFirstResult(startIndex).
	           	setMaxResults(count).list();
		
		if (reports == null) {
			throw new InstanceNotFoundException(userProfileId, Report.class.getName());
		} else {
			return reports;
		}	
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Report> getReportsByDateRequest(Date dateRequest,
			int startIndex, int count) throws InstanceNotFoundException {

		List<Report> reports = (List<Report>)  getSession().createQuery(
	        	"SELECT a FROM Report a WHERE a.dateRequest = :dateRequest " +
	        	"ORDER BY a.dateRequest").
	         	setParameter("dateRequest", dateRequest).
	           	setFirstResult(startIndex).
	           	setMaxResults(count).list();
		
		if (reports == null) {
			throw new InstanceNotFoundException(dateRequest, Report.class.getName());
		} else {
			return reports;
		}	
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Report> getReportsByParkId(Long parkId, int startIndex,
			int count) throws InstanceNotFoundException {
		
		List<Report> reports = (List<Report>)  getSession().createQuery(
	        	"SELECT a FROM Report a WHERE a.parkId = :parkId " +
	        	"ORDER BY a.dateRequest").
	         	setParameter("parkId", parkId).
	           	setFirstResult(startIndex).
	           	setMaxResults(count).list();
		
		if (reports == null) {
			throw new InstanceNotFoundException(parkId, Report.class.getName());
		} else {
			return reports;
		}	
	}

}
