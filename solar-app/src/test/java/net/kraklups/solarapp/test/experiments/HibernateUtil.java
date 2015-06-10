package net.kraklups.solarapp.test.experiments;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistry;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;

	static {
		try {
			// Create the SessionFactory from
			// hibernate-config-experiments.xml
			Configuration configuration = new Configuration().configure("hibernate-config-experiments.xml");
			
			StandardServiceRegistryBuilder standardServiceRegistry = new StandardServiceRegistryBuilder();
			standardServiceRegistry.applySettings(configuration.getProperties());
			StandardServiceRegistry serviceRegistry = standardServiceRegistry.build();
			
		    sessionFactory = configuration.buildSessionFactory(serviceRegistry);

		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		// Close caches and connection pools
		getSessionFactory().close();
	}

}
