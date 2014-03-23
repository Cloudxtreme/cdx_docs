package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:46 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class PcrCleanupContainer.
 * @see com.cardiodx.db.waban.table.PcrCleanupContainer
 * @author Hibernate Tools
 */
public class PcrCleanupContainerHome {

	private static final Log log = LogFactory
			.getLog(PcrCleanupContainerHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext()
					.lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(PcrCleanupContainer transientInstance) {
		log.debug("persisting PcrCleanupContainer instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(PcrCleanupContainer instance) {
		log.debug("attaching dirty PcrCleanupContainer instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PcrCleanupContainer instance) {
		log.debug("attaching clean PcrCleanupContainer instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(PcrCleanupContainer persistentInstance) {
		log.debug("deleting PcrCleanupContainer instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PcrCleanupContainer merge(PcrCleanupContainer detachedInstance) {
		log.debug("merging PcrCleanupContainer instance");
		try {
			PcrCleanupContainer result = (PcrCleanupContainer) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public PcrCleanupContainer findById(java.math.BigDecimal id) {
		log.debug("getting PcrCleanupContainer instance with id: " + id);
		try {
			PcrCleanupContainer instance = (PcrCleanupContainer) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.PcrCleanupContainer",
							id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<PcrCleanupContainer> findByExample(PcrCleanupContainer instance) {
		log.debug("finding PcrCleanupContainer instance by example");
		try {
			List<PcrCleanupContainer> results = (List<PcrCleanupContainer>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.PcrCleanupContainer")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
