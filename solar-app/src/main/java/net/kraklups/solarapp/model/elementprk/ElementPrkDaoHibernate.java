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

	@Override
	@SuppressWarnings("unchecked")	
	public List<StringLine> getStringLines(int startIndex, int count)
			throws InstanceNotFoundException {

		List<StringLine> stringLines = (List<StringLine>)  getSession().createQuery(
	        	"SELECT a FROM StringLine a " +
	        	"ORDER BY a.stringLineId").
	           	setFirstResult(startIndex).
	           	setMaxResults(count).list();
		
		if (stringLines == null) {
			throw new InstanceNotFoundException(null, StringLine.class.getName());
		} else {
			return stringLines;
		}
	}

	@Override
	@SuppressWarnings("unchecked")	
	public List<ArrayPanel> getArrayPanels(int startIndex, int count)
			throws InstanceNotFoundException {

		List<ArrayPanel> arrayPanels = (List<ArrayPanel>)  getSession().createQuery(
	        	"SELECT a FROM ArrayPanel a " +
	        	"ORDER BY a.arrayPanelId").
	           	setFirstResult(startIndex).
	           	setMaxResults(count).list();
		
		if (arrayPanels == null) {
			throw new InstanceNotFoundException(null, ArrayPanel.class.getName());
		} else {
			return arrayPanels;
		}
	}

	@Override
	@SuppressWarnings("unchecked")	
	public List<ArrayBox> getArrayBoxs(int startIndex, int count)
			throws InstanceNotFoundException {

		List<ArrayBox> arrayBoxs = (List<ArrayBox>)  getSession().createQuery(
	        	"SELECT a FROM ArrayBox a " +
	        	"ORDER BY a.arrayBoxId").
	           	setFirstResult(startIndex).
	           	setMaxResults(count).list();
		
		if (arrayBoxs == null) {
			throw new InstanceNotFoundException(null, ArrayBox.class.getName());
		} else {
			return arrayBoxs;
		}
	}

	@Override
	@SuppressWarnings("unchecked")	
	public List<Counter> getCounters(int startIndex, int count)
			throws InstanceNotFoundException {

		List<Counter> counters = (List<Counter>)  getSession().createQuery(
	        	"SELECT a FROM Counter a " +
	        	"ORDER BY a.counterId").
	           	setFirstResult(startIndex).
	           	setMaxResults(count).list();
		
		if (counters == null) {
			throw new InstanceNotFoundException(null, Counter.class.getName());
		} else {
			return counters;
		}
	}

	@Override
	@SuppressWarnings("unchecked")	
	public List<MediumVoltage> getMediumVoltages(int startIndex, int count)
			throws InstanceNotFoundException {

		List<MediumVoltage> mediumVoltages = (List<MediumVoltage>)  getSession().createQuery(
	        	"SELECT a FROM MediumVoltage a " +
	        	"ORDER BY a.mediumVoltageId").
	           	setFirstResult(startIndex).
	           	setMaxResults(count).list();
		
		if (mediumVoltages == null) {
			throw new InstanceNotFoundException(null, MediumVoltage.class.getName());
		} else {
			return mediumVoltages;
		}
	}

	@Override
	@SuppressWarnings("unchecked")	
	public List<ExtractionPoint> getExtractionPoints(int startIndex, int count)
			throws InstanceNotFoundException {

		List<ExtractionPoint> extractionPoints = (List<ExtractionPoint>)  getSession().createQuery(
	        	"SELECT a FROM ExtractionPoint a " +
	        	"ORDER BY a.extractionPointId").
	           	setFirstResult(startIndex).
	           	setMaxResults(count).list();
		
		if (extractionPoints == null) {
			throw new InstanceNotFoundException(null, ExtractionPoint.class.getName());
		} else {
			return extractionPoints;
		}
	}

	@Override
	@SuppressWarnings("unchecked")	
	public List<ElectricalSubstation> getElectricalSubstations(int startIndex,
			int count) throws InstanceNotFoundException {

		List<ElectricalSubstation> electricalSubstations = (List<ElectricalSubstation>)  getSession().createQuery(
	        	"SELECT a FROM ElectricalSubstation a " +
	        	"ORDER BY a.electricalSubstationId").
	           	setFirstResult(startIndex).
	           	setMaxResults(count).list();
		
		if (electricalSubstations == null) {
			throw new InstanceNotFoundException(null, ElectricalSubstation.class.getName());
		} else {
			return electricalSubstations;
		}
	}



}
