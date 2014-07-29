package net.kraklups.solarapp.model.element;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.kraklups.modelutil.dao.GenericDaoHibernate;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;

@Repository("elementDao")
public class ElementDaoHibernate extends 
	GenericDaoHibernate<Element, Long> implements ElementDao {

	@Override
	public List<Element> getElementsByElementTag(String elementTag,
			int startIndex, int count) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}



}
