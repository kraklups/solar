package net.kraklups.solarapp.model.eventtsk;

import net.kraklups.modelutil.dao.GenericDaoHibernate;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.eventtsk.EventTsk;
import net.kraklups.solarapp.model.eventtsk.EventTskDao;

import org.springframework.stereotype.Repository;

@Repository("eventTskDao")
public class EventTskDaoHibernate extends 
	GenericDaoHibernate<EventTsk, Long> implements EventTskDao {

}
