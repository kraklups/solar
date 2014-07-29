package net.kraklups.solarapp.model.element;

import java.util.List;

import net.kraklups.modelutil.dao.GenericDao;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;

public interface ElementDao extends GenericDao<Element, Long> {

    /**
     * Returns a Element using the element tag (not element identifier)
     *
     * @param elementTag not the module identifier
     * @return list of elements
     */			
     
     public List<Element> getElementsByElementTag(String elementTag, int startIndex, int count) 
            throws InstanceNotFoundException; 	
	
}
