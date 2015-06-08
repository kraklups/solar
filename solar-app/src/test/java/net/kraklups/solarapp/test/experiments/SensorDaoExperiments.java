package net.kraklups.solarapp.test.experiments;

import org.hibernate.Transaction;

import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.elementprk.ElementPrk;
import net.kraklups.solarapp.model.sensor.Sensor;
import net.kraklups.solarapp.model.sensor.SensorDao;
import net.kraklups.solarapp.model.sensor.SensorDaoHibernate;

public class SensorDaoExperiments {

	public static void main(String[] args) {
		
		SensorDaoHibernate sensorDaoHibernate = new SensorDaoHibernate();
		sensorDaoHibernate.setSessionFactory(HibernateUtil
				.getSessionFactory());
		SensorDao sensorDao = sensorDaoHibernate;
		
		Transaction tx = HibernateUtil.getSessionFactory().getCurrentSession()
				.beginTransaction();
		
		try {
			
			// Register sensor
			//String sensorTag, String sensorType, ElementPrk elementPrk

			ElementPrk elementPrk = new ElementPrk();
			
			Sensor sensor = new Sensor("farleyero", "farleyomix", elementPrk);
			
			sensorDao.save(sensor);
			Long sensorId = sensor.getSensorId();
			System.out.println("Sensor with sensorId '" + sensorId
					+ "' has been created");
			System.out.println(sensor);
			
			// Find sensor.
			sensor = sensorDao.find(sensorId);
			System.out.println("User with userId '" + sensorId
					+ "' has been retrieved");
			System.out.println(sensor);						
			
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
