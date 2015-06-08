package net.kraklups.solarapp.test.experiments;

import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.datalogger.DataLogger;
import net.kraklups.solarapp.model.datavalue.DataValue;
import net.kraklups.solarapp.model.datavalue.DataValueDao;
import net.kraklups.solarapp.model.datavalue.DataValueDaoHibernate;
import net.kraklups.solarapp.model.elementprk.ElementPrk;
import net.kraklups.solarapp.model.sensor.Sensor;
import net.kraklups.solarapp.model.taskprk.Synchronize;

import org.hibernate.Transaction;

public class DataValueDaoExperiments {

	public static void main(String[] args) {
		
		DataValueDaoHibernate dataValueDaoHibernate = new DataValueDaoHibernate();
		dataValueDaoHibernate.setSessionFactory(HibernateUtil
				.getSessionFactory());
		DataValueDao dataValueDao = dataValueDaoHibernate;
		
		Transaction tx = HibernateUtil.getSessionFactory().getCurrentSession()
				.beginTransaction();
		
		try {
			
			// Register dataValue
			//Synchronize synchronize, ElementPrk elementPrk, 
			//DataLogger dataLogger, Sensor sensor

			Synchronize synchronize = new Synchronize();
			DataLogger dataLogger = new DataLogger();
			Sensor sensor = new Sensor();
			ElementPrk elementPrk = new ElementPrk();			
			
			DataValue dataValue = new DataValue(synchronize, elementPrk, dataLogger, sensor);
			
			dataValueDao.save(dataValue);
			Long dataValueId = dataValue.getDataValueId();
			System.out.println("DataValue with dataValueId '" + dataValueId
					+ "' has been created");
			System.out.println(dataValue);
			
			// Find dataValue.
			dataValue = dataValueDao.find(dataValueId);
			System.out.println("User with userId '" + dataValueId
					+ "' has been retrieved");
			System.out.println(dataValue);						
			
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
