package net.kraklups.solarapp.test.experiments;

import org.hibernate.Transaction;

import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.messageevent.MessageEvent;
import net.kraklups.solarapp.model.messageevent.MessageEventDao;
import net.kraklups.solarapp.model.messageevent.MessageEventDaoHibernate;

public class MessageEventDaoExperiments {

	public static void main(String[] args) {
		
		MessageEventDaoHibernate messageEventDaoHibernate = new MessageEventDaoHibernate();
		messageEventDaoHibernate.setSessionFactory(HibernateUtil
				.getSessionFactory());
		MessageEventDao messageEventDao = messageEventDaoHibernate;
		
		Transaction tx = HibernateUtil.getSessionFactory().getCurrentSession()
				.beginTransaction();
		
		try {
			
			// Register messageEvent

			MessageEvent messageEvent = new MessageEvent();
			messageEventDao.save(messageEvent);
			Long messageEventId = messageEvent.getMessageEventId();
			System.out.println("MessageEvent with messageEventId '" + messageEventId
					+ "' has been created");
			System.out.println(messageEvent);

			// Find messageEvent.
			messageEvent = messageEventDao.find(messageEventId);
			System.out.println("User with userId '" + messageEventId
					+ "' has been retrieved");
			System.out.println(messageEvent);			
						
			// ... no more cases/entities/methods			
			
			tx.commit();			
			
		} catch (RuntimeException e) {
			e.printStackTrace();
			tx.rollback();
		} catch (InstanceNotFoundException e) {
			e.printStackTrace();
			tx.commit();
		} finally {
			HibernateUtil.getSessionFactory().getCurrentSession().close();
		}

		HibernateUtil.shutdown();
		
	}


}
