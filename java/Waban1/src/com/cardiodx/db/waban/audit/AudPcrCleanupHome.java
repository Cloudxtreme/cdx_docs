package com.cardiodx.db.waban.audit;

// Generated Jul 14, 2011 1:33:02 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class AudPcrCleanup.
 * @see com.cardiodx.db.waban.audit.AudPcrCleanup
 * @author Hibernate Tools
 */
public class AudPcrCleanupHome {

	private static final Log log = LogFactory.getLog(AudPcrCleanupHome.class);

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

	public void persist(AudPcrCleanup transientInstance) {
		log.debug("persisting AudPcrCleanup instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AudPcrCleanup instance) {
		log.debug("attaching dirty AudPcrCleanup instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AudPcrCleanup instance) {
		log.debug("attaching clean AudPcrCleanup instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AudPcrCleanup persistentInstance) {
		log.debug("deleting AudPcrCleanup instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AudPcrCleanup merge(AudPcrCleanup detachedInstance) {
		log.debug("merging AudPcrCleanup instance");
		try {
			AudPcrCleanup result = (AudPcrCleanup) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AudPcrCleanup findById(java.math.BigDecimal id) {
		log.debug("getting AudPcrCleanup instance with id: " + id);
		try {
			AudPcrCleanup instance = (AudPcrCleanup) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.audit.AudPcrCleanup", id);
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

	public List<AudPcrCleanup> findByExample(AudPcrCleanup instance) {
		log.debug("finding AudPcrCleanup instance by example");
		try {
			List<AudPcrCleanup> results = (List<AudPcrCleanup>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.audit.AudPcrCleanup")
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
