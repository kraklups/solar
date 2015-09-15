package net.kraklups.solarapp.model.module;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.kraklups.modelutil.dao.GenericDaoHibernate;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.module.Module;

@Repository("moduleDao")
public class ModuleDaoHibernate extends 
		GenericDaoHibernate<Module, Long> implements ModuleDao {

	@Override
	public Module findByName(String moduleName) throws InstanceNotFoundException {
		
		Module module = (Module) getSession().createQuery(
			"SELECT u FROM Module u WHERE u.moduleName = :moduleName")
			.setParameter("moduleName", moduleName)
			.uniqueResult();
	
		if (module == null) {
			throw new InstanceNotFoundException(moduleName,Module.class.getName());
		} else {
			return module;
		}	
	}

	@Override
	@SuppressWarnings("unchecked")	
	public List<Module> getModules(int startIndex, int count)
			throws InstanceNotFoundException {

		List<Module> modules = (List<Module>)  getSession().createQuery(
	        	"SELECT a FROM Module a " +
	        	"ORDER BY a.moduleId").
	           	setFirstResult(startIndex).
	           	setMaxResults(count).list();
		
		if (modules == null) {
			throw new InstanceNotFoundException(null, Module.class.getName());
		} else {
			return modules;
		}
	}

}
