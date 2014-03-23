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
 * Home object for domain model class PcrCleanup.
 * @see com.cardiodx.db.waban.table.PcrCleanup
 * @author Hibernate Tools
 */
public class PcrCleanupHome {

	private static final Log log = LogFactory.getLog(PcrCleanupHome.class);

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

	public void persist(PcrCleanup transientInstance) {
		log.debug("persisting PcrCleanup instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(PcrCleanup instance) {
		log.debug("attaching dirty PcrCleanup instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PcrCleanup instance) {
		log.debug("attaching clean PcrCleanup instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(PcrCleanup persistentInstance) {
		log.debug("deleting PcrCleanup instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PcrCleanup merge(PcrCleanup detachedInstance) {
		log.debug("merging PcrCleanup instance");
		try {
			PcrCleanup result = (PcrCleanup) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public PcrCleanup findById(java.math.BigDecimal id) {
		log.debug("getting PcrCleanup instance with id: " + id);
		try {
			PcrCleanup instance = (PcrCleanup) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.PcrCleanup", id);
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

	public List<PcrCleanup> findByExample(PcrCleanup instance) {
		log.debug("finding PcrCleanup instance by example");
		try {
			List<PcrCleanup> results = (List<PcrCleanup>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.table.PcrCleanup")
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
