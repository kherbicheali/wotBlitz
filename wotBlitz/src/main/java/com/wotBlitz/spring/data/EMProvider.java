package com.wotBlitz.spring.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EMProvider {
	private static final String persitenceUnitName = "blitzPersiUnitH2";

	private static final EntityManagerFactory emf;
	private static final ThreadLocal<EntityManager> threadLocalEnityManager;
	// private static final Log logger = LogFactory.getLog(EMProvider.class);
	private static final Logger logger = LoggerFactory.getLogger(EMProvider.class);

	static {
		logger.info("-- EMF instanciation");
		emf = Persistence.createEntityManagerFactory(persitenceUnitName);
		threadLocalEnityManager = new ThreadLocal<EntityManager>();
	}

	/**
	 * <p>
	 * Provide a per-thread EntityManager "singleton" instance.
	 * <p>
	 * This method can be called as many times as needed per thread, and it will
	 * return the same EntityManager instance, until the manager is closed.
	 * 
	 * @return EntityManager singleton for this current thread
	 */
	public static EntityManager getEntityManager() {
		// logger.info("-- getEntityManager()");
		// logger.info("-- EMProvider threadName: "+Thread.currentThread().getName()+" threadId: "+Thread.currentThread().getId());
		EntityManager em = threadLocalEnityManager.get();
		if (em == null) {
			logger.info("-- em == null");
			em = emf.createEntityManager();
			threadLocalEnityManager.set(em);
		} else
			logger.info("-- em != null");
		return em;
	}

	/**
	 * <p>
	 * Close the EntityManager and set the thread's instance to null.
	 */
	public static void closeEntityManager() {
		logger.info("-- closeEntityManager()");
		EntityManager em = threadLocalEnityManager.get();
		if (em != null) {
			em.close();
			threadLocalEnityManager.set(null);
		}
	}

	/**
	 * <p>
	 * Close the EntityManagerFactory.
	 */
	public static void closeEntityManagerFactory() {
		logger.info("-- closeEntityManagerFactory()");
		emf.close();
	}

	/**
	 * <p>
	 * Initiate a transaction for the EntityManager on this thread.
	 * <p>
	 * The Transaction will remain open until commit or closeEntityManager is
	 * called.
	 */
	public static void beginTransaction() {
		logger.info("-- beginTransaction()");
		getEntityManager().getTransaction().begin();
	}

	/**
	 * <p>
	 * Undo an uncommitted transaction, in the event of an error or other problem.
	 */
	public static void rollback() {
		logger.info("-- rollback(");
		getEntityManager().getTransaction().rollback();
	}

	/**
	 * <p>
	 * Submit the changes to the persistence layer.
	 * <p>
	 * Until commit is called, rollback can be used to undo the transaction.
	 */
	public static void commit() {
		logger.info("-- commit()");
		getEntityManager().getTransaction().commit();
	}

	/**
	 * <p>
	 * Create a query for the EntityManager on this thread.
	 */
	public static Query createQuery(String query) {
		logger.info("-- createQuery("+query+")");
		return getEntityManager().createQuery(query);
	}
}