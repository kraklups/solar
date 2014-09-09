package net.kraklups.solarapp.model.report;

import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.kraklups.modelutil.dao.GenericDaoHibernate;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.taskprk.TaskPrk;

@Repository("reportDao")
public class ReportDaoHibernate extends 
		GenericDaoHibernate<Report, Long> implements ReportDao
{

	@Override
	public List<Report> getReportsByUserProfileId(Long userProfileId,
			int startIndex, int count) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Report> getReportsByDateRequest(Calendar dateRequest,
			int startIndex, int count) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Report> getReportsByParkId(Long parkId, int startIndex,
			int count) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
