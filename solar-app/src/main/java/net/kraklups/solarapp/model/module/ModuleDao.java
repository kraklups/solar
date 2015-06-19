package net.kraklups.solarapp.model.module;

import java.util.List;

import net.kraklups.modelutil.dao.GenericDao;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;

public interface ModuleDao extends GenericDao<Module, Long>{

    /**
     * Returns a Module using the module name (not module identifier)
     *
     * @param moduleName not the module identifier
     * @return the Module
     */			
	public Module findByName(String moduleName) throws InstanceNotFoundException; 
	
    public List<Module> getModules(int startIndex, int count)
			throws InstanceNotFoundException; 

}
