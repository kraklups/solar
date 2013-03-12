package net.kraklups.solarapp.test.model.module;

import java.util.Calendar;

import org.hibernate.Transaction;

import net.kraklups.solarapp.model.module.Module;
import net.kraklups.solarapp.model.module.ModuleDao;
import net.kraklups.solarapp.model.module.ModuleDaoHibernate;

import net.kraklups.solarapp.test.experiments.HibernateUtil;

public class ModuleDaoExperiments {
	
	public static void main(String[] args) {
		ModuleDaoHibernate moduleDaoHibernate = new ModuleDaoHibernate();
		moduleDaoHibernate.setSessionFactory(HibernateUtil
				.getSessionFactory());
		
		
	}

}
