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
 * Home object for domain model class AudPendingSample.
 * @see com.cardiodx.db.waban.audit.AudPendingSample
 * @author Hibernate Tools
 */
public class AudPendingSampleHome {

	private static final Log log = LogFactory
			.getLog(AudPendingSampleHome.class);

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

	public void persist(AudPendingSample transientInstance) {
		log.debug("persisting AudPendingSample instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AudPendingSample instance) {
		log.debug("attaching dirty AudPendingSample instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AudPendingSample instance) {
		log.debug("attaching clean AudPendingSample instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AudPendingSample persistentInstance) {
		log.debug("deleting AudPendingSample instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AudPendingSample merge(AudPendingSample detachedInstance) {
		log.debug("merging AudPendingSample instance");
		try {
			AudPendingSample result = (AudPendingSample) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AudPendingSample findById(java.math.BigDecimal id) {
		log.debug("getting AudPendingSample instance with id: " + id);
		try {
			AudPendingSample instance = (AudPendingSample) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.audit.AudPendingSample", id);
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

	public List<AudPendingSample> findByExample(AudPendingSample instance) {
		log.debug("finding AudPendingSample instance by example");
		try {
			List<AudPendingSample> results = (List<AudPendingSample>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.audit.AudPendingSample")
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
