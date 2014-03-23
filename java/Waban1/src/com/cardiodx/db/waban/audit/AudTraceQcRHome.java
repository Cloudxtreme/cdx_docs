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
 * Home object for domain model class AudTraceQcR.
 * @see com.cardiodx.db.waban.audit.AudTraceQcR
 * @author Hibernate Tools
 */
public class AudTraceQcRHome {

	private static final Log log = LogFactory.getLog(AudTraceQcRHome.class);

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

	public void persist(AudTraceQcR transientInstance) {
		log.debug("persisting AudTraceQcR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AudTraceQcR instance) {
		log.debug("attaching dirty AudTraceQcR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AudTraceQcR instance) {
		log.debug("attaching clean AudTraceQcR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AudTraceQcR persistentInstance) {
		log.debug("deleting AudTraceQcR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AudTraceQcR merge(AudTraceQcR detachedInstance) {
		log.debug("merging AudTraceQcR instance");
		try {
			AudTraceQcR result = (AudTraceQcR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AudTraceQcR findById(com.cardiodx.db.waban.audit.AudTraceQcRId id) {
		log.debug("getting AudTraceQcR instance with id: " + id);
		try {
			AudTraceQcR instance = (AudTraceQcR) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.audit.AudTraceQcR", id);
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

	public List<AudTraceQcR> findByExample(AudTraceQcR instance) {
		log.debug("finding AudTraceQcR instance by example");
		try {
			List<AudTraceQcR> results = (List<AudTraceQcR>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.audit.AudTraceQcR")
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
