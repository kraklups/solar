package net.kraklups.solarapp.model.elementprk;

import java.util.List;

import net.kraklups.modelutil.dao.GenericDao;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;

public interface ElementPrkDao extends GenericDao<ElementPrk, Long> {

    /**
     * Returns a List of ElementPrk using the element tag (not element identifier)
     *
     * @param elementTag not the module identifier
     * @return list of elements
     */			     
     public List<ElementPrk> getElementsByElementTag(String elementPrkTag, int startIndex, int count) 
            throws InstanceNotFoundException; 	

     /**
      * Returns a list Cells (ElementPrk) using the stringLineId element identifier
      *
      * @param stringLineId element identifier
      * @return list of elements
      */		     
     public List<ElementPrk> getCellsByStringLine(Long stringLineId, int startIndex, int count) 
             throws InstanceNotFoundException; 	

     /**
      * Returns a list Cells (ElementPrk) using the arrayPanelId element identifier
      *
      * @param arrayPanelId element identifier
      * @return list of elements
      */		     
     public List<ElementPrk> getCellsByArrayPanel(Long arrayPanelId, int startIndex, int count) 
             throws InstanceNotFoundException;

     /**
      * Returns a list ArrayPanels (ElementPrk) using the stringLineId element identifier
      *
      * @param stringLineId element identifier
      * @return list of elements
      */		     
     public List<ElementPrk> getArrayPanelsByStringLine(Long stringLineId, int startIndex, int count) 
             throws InstanceNotFoundException;

     /**
      * Returns a list Inverters (ElementPrk) using the arrayBoxId element identifier
      *
      * @param arrayBox element identifier
      * @return list of elements
      */		     
     public List<ElementPrk> getInvertersByArrayBox(Long arrayBoxId, int startIndex, int count) 
             throws InstanceNotFoundException;   
     
     /**
      * Returns a list Inverters (ElementPrk) using the electricalSubstationId element identifier
      *
      * @param electricalSubstationId element identifier
      * @return list of elements
      */		     
     public List<ElementPrk> getInvertersByElectricalSubstation(Long electricalSubstationId, int startIndex, int count) 
             throws InstanceNotFoundException;        
     
     /**
      * Returns a list ElectricalSubstations (ElementPrk) using the mediumVoltageId element identifier
      *
      * @param mediumVoltageId element identifier
      * @return list of elements
      */		     
     public List<ElementPrk> getElectricalSubstationsByMediumVoltage(Long mediumVoltageId, int startIndex, int count) 
             throws InstanceNotFoundException;       
     
     /**
      * Returns a list MediumVoltages (ElementPrk) using the counterId element identifier
      *
      * @param counterId element identifier
      * @return list of elements
      */		     
     public List<ElementPrk> getMediumVoltagesByCounter(Long counterId, int startIndex, int count) 
             throws InstanceNotFoundException;     

     /**
      * Returns a list Inverters (ElementPrk) using the counterId element identifier
      *
      * @param counterId element identifier
      * @return list of elements
      */		     
     public List<ElementPrk> getInvertersByCounter(Long counterId, int startIndex, int count) 
             throws InstanceNotFoundException;
     
     /**
      * Returns a list MediumVoltages (ElementPrk) using the extractionPointId element identifier
      *
      * @param extractionPointId element identifier
      * @return list of elements
      */		     
     public List<ElementPrk> getMediumVoltagesByExtractionPoint(Long extractionPointId, int startIndex, int count) 
             throws InstanceNotFoundException;

     /**
      * Returns a list MediumVoltages (ElementPrk) using the extractionPointId element identifier
      *
      * @param extractionPointId element identifier
      * @return list of elements
      */		     
     public List<ElementPrk> getElementPrksByDataLogger(Long dataLoggerId, int startIndex, int count) 
             throws InstanceNotFoundException;
     
     public List<ElementPrk> getElementPrks(int startIndex, int count)
 			throws InstanceNotFoundException;
     
     public List<StringLine> getStringLines(int startIndex, int count)
 			throws InstanceNotFoundException;     
     
}
