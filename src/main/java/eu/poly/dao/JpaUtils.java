package eu.poly.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtils {
//	public static EntityManager getEntityManager() {
//		return Persistence.createEntityManagerFactory("OE").createEntityManager();
//	}

	private static EntityManagerFactory factory;

	public static EntityManager getEntityManager() {
		if (factory == null || !factory.isOpen()) {
			factory = Persistence.createEntityManagerFactory("OE");
		}
		return factory.createEntityManager();
	}

	public static void shutdown() {
		if(factory !=null&&factory.isOpen()) {
			factory.close();
		}
		factory=null;
	}
}
