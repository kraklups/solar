package net.kraklups.solarapp.model.company;

import org.springframework.stereotype.Repository;

import net.kraklups.modelutil.dao.GenericDaoHibernate;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;

@Repository("companyDao")
public class CompanyDaoHibernate extends
		GenericDaoHibernate<Company, Long> implements CompanyDao {

}
