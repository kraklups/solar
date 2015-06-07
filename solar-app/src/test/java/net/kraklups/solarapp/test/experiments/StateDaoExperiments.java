package net.kraklups.solarapp.test.experiments;

import org.hibernate.Transaction;

import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.state.State;
import net.kraklups.solarapp.model.state.StateDao;
import net.kraklups.solarapp.model.state.StateDaoHibernate;

public class StateDaoExperiments {

	public static void main(String[] args) {
		
		StateDaoHibernate stateDaoHibernate = new StateDaoHibernate();
		stateDaoHibernate.setSessionFactory(HibernateUtil
				.getSessionFactory());
		StateDao stateDao = stateDaoHibernate;
		
		Transaction tx = HibernateUtil.getSessionFactory().getCurrentSession()
				.beginTransaction();
		
		try {
			
			// Register state

			State state = new State();
			stateDao.save(state);
			Long stateId = state.getStateId();
			System.out.println("State with stateId '" + stateId
					+ "' has been created");
			System.out.println(state);

			// Find state.
			state = stateDao.find(stateId);
			System.out.println("User with userId '" + stateId
					+ "' has been retrieved");
			System.out.println(state);			
						
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
