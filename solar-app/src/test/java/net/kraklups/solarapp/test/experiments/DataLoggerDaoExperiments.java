package net.kraklups.solarapp.test.experiments;

import org.hibernate.Transaction;

import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.datalogger.DataLogger;
import net.kraklups.solarapp.model.datalogger.DataLoggerDao;
import net.kraklups.solarapp.model.datalogger.DataLoggerDaoHibernate;

public class DataLoggerDaoExperiments {

	public static void main(String[] args) {
		
		DataLoggerDaoHibernate dataLoggerDaoHibernate = new DataLoggerDaoHibernate();
		dataLoggerDaoHibernate.setSessionFactory(HibernateUtil
				.getSessionFactory());
		DataLoggerDao dataLoggerDao = dataLoggerDaoHibernate;
		
		Transaction tx = HibernateUtil.getSessionFactory().getCurrentSession()
				.beginTransaction();
		
		try {
			
			// Register dataLogger

			DataLogger dataLogger = new DataLogger();
			dataLoggerDao.save(dataLogger);
			Long dataLoggerId = dataLogger.getDataLoggerId();
			System.out.println("DataLogger with dataLoggerId '" + dataLoggerId
					+ "' has been created");
			System.out.println(dataLogger);

			// Find dataLogger.
			dataLogger = dataLoggerDao.find(dataLoggerId);
			System.out.println("User with userId '" + dataLoggerId
					+ "' has been retrieved");
			System.out.println(dataLogger);			
						
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
