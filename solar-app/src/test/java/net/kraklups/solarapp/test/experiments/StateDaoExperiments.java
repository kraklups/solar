package net.kraklups.solarapp.test.experiments;

import java.util.Calendar;
import java.util.Date;

import org.hibernate.Transaction;

import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.eventtsk.EventTsk;
import net.kraklups.solarapp.model.park.Park;
import net.kraklups.solarapp.model.state.State;
import net.kraklups.solarapp.model.state.StateDao;
import net.kraklups.solarapp.model.state.StateDaoHibernate;
import net.kraklups.solarapp.model.statetype.StateType;
import net.kraklups.solarapp.model.taskprk.Upkeep;

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
			//Date tvi, Date tvf, Park park, EventTsk eventTsk, Upkeep upkeep, StateType stateType
			
			Calendar calendar = Calendar.getInstance();
			Date timestamp = new Date(calendar.getTime().getTime());

			Park park = new Park();
			EventTsk eventTsk = new EventTsk();
			Upkeep upkeep = new Upkeep();
			StateType stateType = new StateType();
			
			State state = new State(timestamp, timestamp, park, eventTsk, upkeep, stateType);
			
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
