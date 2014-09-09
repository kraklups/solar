package net.kraklups.solarapp.model.messageevent;

import net.kraklups.modelutil.dao.GenericDaoHibernate;

import net.kraklups.solarapp.model.messageevent.MessageEvent;
import net.kraklups.solarapp.model.messageevent.MessageEventDao;

import org.springframework.stereotype.Repository;

@Repository("messageDao")
public class MessageEventDaoHibernate extends 
		GenericDaoHibernate<MessageEvent, Long> implements MessageEventDao{

}
