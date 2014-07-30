package net.kraklups.solarapp.model.elementprk;

import java.util.List;

import net.kraklups.modelutil.dao.GenericDao;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;

public interface ElementPrkDao extends GenericDao<ElementPrk, Long> {

    /**
     * Returns a ElementPrk using the element tag (not element identifier)
     *
     * @param elementTag not the module identifier
     * @return list of elements
     */			
     
     public List<ElementPrk> getElementsByElementTag(String elementTag, int startIndex, int count) 
            throws InstanceNotFoundException; 	
	
}
