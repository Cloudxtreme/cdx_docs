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
 * Home object for domain model class AudPcrCleanupR.
 * @see com.cardiodx.db.waban.audit.AudPcrCleanupR
 * @author Hibernate Tools
 */
public class AudPcrCleanupRHome {

	private static final Log log = LogFactory.getLog(AudPcrCleanupRHome.class);

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

	public void persist(AudPcrCleanupR transientInstance) {
		log.debug("persisting AudPcrCleanupR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AudPcrCleanupR instance) {
		log.debug("attaching dirty AudPcrCleanupR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AudPcrCleanupR instance) {
		log.debug("attaching clean AudPcrCleanupR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AudPcrCleanupR persistentInstance) {
		log.debug("deleting AudPcrCleanupR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AudPcrCleanupR merge(AudPcrCleanupR detachedInstance) {
		log.debug("merging AudPcrCleanupR instance");
		try {
			AudPcrCleanupR result = (AudPcrCleanupR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AudPcrCleanupR findById(
			com.cardiodx.db.waban.audit.AudPcrCleanupRId id) {
		log.debug("getting AudPcrCleanupR instance with id: " + id);
		try {
			AudPcrCleanupR instance = (AudPcrCleanupR) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.audit.AudPcrCleanupR", id);
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

	public List<AudPcrCleanupR> findByExample(AudPcrCleanupR instance) {
		log.debug("finding AudPcrCleanupR instance by example");
		try {
			List<AudPcrCleanupR> results = (List<AudPcrCleanupR>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.audit.AudPcrCleanupR")
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
