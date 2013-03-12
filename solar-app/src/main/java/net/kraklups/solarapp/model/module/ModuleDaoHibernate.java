package net.kraklups.solarapp.model.module;

import org.springframework.stereotype.Repository;

import net.kraklups.modelutil.dao.GenericDaoHibernate;

@Repository("moduleDao")
public class ModuleDaoHibernate extends 
		GenericDaoHibernate<Module, Long> implements ModuleDao {

}
