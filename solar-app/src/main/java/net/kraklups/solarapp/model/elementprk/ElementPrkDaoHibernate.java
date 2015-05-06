package net.kraklups.solarapp.model.elementprk;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.kraklups.modelutil.dao.GenericDaoHibernate;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;

@Repository("elementDao")
public class ElementPrkDaoHibernate extends 
	GenericDaoHibernate<ElementPrk, Long> implements ElementPrkDao {

	@Override
	@SuppressWarnings("unchecked")
	public List<ElementPrk> getElementsByElementTag(String elementPrkTag,
			int startIndex, int count) throws InstanceNotFoundException {

		List<ElementPrk> elements = (List<ElementPrk>)  getSession().createQuery(
	        	"SELECT a FROM ElementPrk a WHERE a.elementPrkTag = :elementPrkTag " +
	        	"ORDER BY a.elementPrkId").
	         	setParameter("elementPrkTag", elementPrkTag).
	           	setFirstResult(startIndex).
	           	setMaxResults(count).list();
		
		if (elements == null) {
			throw new InstanceNotFoundException(elementPrkTag, ElementPrk.class.getName());
		} else {
			return elements;
		}	
	}

	@Override
	@SuppressWarnings("unchecked")	
	public List<ElementPrk> getCellsByStringLine(Long stringLineId,
			int startIndex, int count) throws InstanceNotFoundException {

		List<ElementPrk> elements = (List<ElementPrk>)  getSession().createQuery(
	        	"SELECT a FROM Cell a WHERE a.stringLineId = :stringLineId " +
	        	"ORDER BY a.cellId").
	         	setParameter("stringLineId", stringLineId).
	           	setFirstResult(startIndex).
	           	setMaxResults(count).list();
		
		if (elements == null) {
			throw new InstanceNotFoundException(stringLineId, ElementPrk.class.getName());
		} else {
			return elements;
		}		
	}

	@Override
	@SuppressWarnings("unchecked")	
	public List<ElementPrk> getCellsByArrayPanel(Long arrayPanelId,
			int startIndex, int count) throws InstanceNotFoundException {

		List<ElementPrk> elements = (List<ElementPrk>)  getSession().createQuery(
	        	"SELECT a FROM Cell a WHERE a.arrayPanelId = :arrayPanelId " +
	        	"ORDER BY a.cellId").
	         	setParameter("arrayPanelId", arrayPanelId).
	           	setFirstResult(startIndex).
	           	setMaxResults(count).list();
		
		if (elements == null) {
			throw new InstanceNotFoundException(arrayPanelId, ElementPrk.class.getName());
		} else {
			return elements;
		}		
	}

	@Override
	@SuppressWarnings("unchecked")	
	public List<ElementPrk> getArrayPanelsByStringLine(Long stringLineId,
			int startIndex, int count) throws InstanceNotFoundException {

		List<ElementPrk> elements = (List<ElementPrk>)  getSession().createQuery(
	        	"SELECT a FROM ArrayPanel a WHERE a.stringLineId = :stringLineId " +
	        	"ORDER BY a.arrayPanelId").
	         	setParameter("stringLineId", stringLineId).
	           	setFirstResult(startIndex).
	           	setMaxResults(count).list();
		
		if (elements == null) {
			throw new InstanceNotFoundException(stringLineId, ElementPrk.class.getName());
		} else {
			return elements;
		}			
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ElementPrk> getInvertersByArrayBox(Long arrayBoxId,
			int startIndex, int count) throws InstanceNotFoundException {

		List<ElementPrk> elements = (List<ElementPrk>)  getSession().createQuery(
	        	"SELECT a FROM Inverter a WHERE a.arrayBoxId = :arrayBoxId " +
	        	"ORDER BY a.inverterId").
	         	setParameter("arrayBoxId", arrayBoxId).
	           	setFirstResult(startIndex).
	           	setMaxResults(count).list();
		
		if (elements == null) {
			throw new InstanceNotFoundException(arrayBoxId, ElementPrk.class.getName());
		} else {
			return elements;
		}		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ElementPrk> getInvertersByElectricalSubstation(
			Long electricalSubstationId, int startIndex, int count)
			throws InstanceNotFoundException {

		List<ElementPrk> elements = (List<ElementPrk>)  getSession().createQuery(
	        	"SELECT a FROM Inverter a WHERE a.electricalSubstationId = :electricalSubstationId " +
	        	"ORDER BY a.inverterId").
	         	setParameter("electricalSubstationId", electricalSubstationId).
	           	setFirstResult(startIndex).
	           	setMaxResults(count).list();
		
		if (elements == null) {
			throw new InstanceNotFoundException(electricalSubstationId, ElementPrk.class.getName());
		} else {
			return elements;
		}			
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ElementPrk> getElectricalSubstationsByMediumVoltage(
			Long mediumVoltageId, int startIndex, int count)
			throws InstanceNotFoundException {

		List<ElementPrk> elements = (List<ElementPrk>)  getSession().createQuery(
	        	"SELECT a FROM ElectricalSubstation a WHERE a.mediumVoltageId = :mediumVoltageId " +
	        	"ORDER BY a.electricalSubstationId").
	         	setParameter("mediumVoltageId", mediumVoltageId).
	           	setFirstResult(startIndex).
	           	setMaxResults(count).list();
		
		if (elements == null) {
			throw new InstanceNotFoundException(mediumVoltageId, ElementPrk.class.getName());
		} else {
			return elements;
		}				
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ElementPrk> getMediumVoltagesByCounter(Long counterId,
			int startIndex, int count) throws InstanceNotFoundException {

		List<ElementPrk> elements = (List<ElementPrk>)  getSession().createQuery(
	        	"SELECT a FROM MediumVoltage a WHERE a.counterId = :counterId " +
	        	"ORDER BY a.mediumVoltageId").
	         	setParameter("counterId", counterId).
	           	setFirstResult(startIndex).
	           	setMaxResults(count).list();
		
		if (elements == null) {
			throw new InstanceNotFoundException(counterId, ElementPrk.class.getName());
		} else {
			return elements;
		}		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ElementPrk> getInvertersByCounter(Long counterId,
			int startIndex, int count) throws InstanceNotFoundException {

		List<ElementPrk> elements = (List<ElementPrk>)  getSession().createQuery(
	        	"SELECT a FROM Inverter a WHERE a.counterId = :counterId " +
	        	"ORDER BY a.inverterId").
	         	setParameter("counterId", counterId).
	           	setFirstResult(startIndex).
	           	setMaxResults(count).list();
		
		if (elements == null) {
			throw new InstanceNotFoundException(counterId, ElementPrk.class.getName());
		} else {
			return elements;
		}				
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ElementPrk> getMediumVoltagesByExtractionPoint(
			Long extractionPointId, int startIndex, int count)
			throws InstanceNotFoundException {

		List<ElementPrk> elements = (List<ElementPrk>)  getSession().createQuery(
	        	"SELECT a FROM MediumVoltage a WHERE a.extractionPointId = :extractionPointId " +
	        	"ORDER BY a.mediumVoltageId").
	         	setParameter("extractionPointId", extractionPointId).
	           	setFirstResult(startIndex).
	           	setMaxResults(count).list();
		
		if (elements == null) {
			throw new InstanceNotFoundException(extractionPointId, ElementPrk.class.getName());
		} else {
			return elements;
		}			
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ElementPrk> getElementPrksByDataLogger(Long dataLoggerId,
			int startIndex, int count) throws InstanceNotFoundException {
		
		List<ElementPrk> elements = (List<ElementPrk>)  getSession().createQuery(
	        	"SELECT a FROM ElementPrk a WHERE a.dataLoggerId = :dataLoggerId " +
	        	"ORDER BY a.elemenPrkId").
	         	setParameter("dataLoggerId", dataLoggerId).
	           	setFirstResult(startIndex).
	           	setMaxResults(count).list();
		
		if (elements == null) {
			throw new InstanceNotFoundException(dataLoggerId, ElementPrk.class.getName());
		} else {
			return elements;
		}			
	}

	@Override
	@SuppressWarnings("unchecked")	
	public List<ElementPrk> getElementPrks(int startIndex, int count)
			throws InstanceNotFoundException {

		List<ElementPrk> elementPrks = (List<ElementPrk>)  getSession().createQuery(
	        	"SELECT a FROM ElementPrk a " +
	        	"ORDER BY a.elementPrkId").
	           	setFirstResult(startIndex).
	           	setMaxResults(count).list();
		
		if (elementPrks == null) {
			throw new InstanceNotFoundException(null, ElementPrk.class.getName());
		} else {
			return elementPrks;
		}
	}



}
