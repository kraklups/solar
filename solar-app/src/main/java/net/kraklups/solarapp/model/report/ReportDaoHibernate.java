package net.kraklups.solarapp.model.report;

import org.springframework.stereotype.Repository;

import net.kraklups.modelutil.dao.GenericDaoHibernate;

@Repository("reportDao")
public class ReportDaoHibernate extends 
		GenericDaoHibernate<Report, Long> implements ReportDao
{

}
