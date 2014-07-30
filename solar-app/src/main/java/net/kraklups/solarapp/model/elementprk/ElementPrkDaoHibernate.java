package net.kraklups.solarapp.model.elementprk;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.kraklups.modelutil.dao.GenericDaoHibernate;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;

@Repository("elementDao")
public class ElementPrkDaoHibernate extends 
	GenericDaoHibernate<ElementPrk, Long> implements ElementPrkDao {

	@Override
	public List<ElementPrk> getElementsByElementTag(String elementTag,
			int startIndex, int count) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}



}
