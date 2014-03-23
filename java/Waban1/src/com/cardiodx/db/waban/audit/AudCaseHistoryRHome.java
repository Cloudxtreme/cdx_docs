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
 * Home object for domain model class AudCaseHistoryR.
 * @see com.cardiodx.db.waban.audit.AudCaseHistoryR
 * @author Hibernate Tools
 */
public class AudCaseHistoryRHome {

	private static final Log log = LogFactory.getLog(AudCaseHistoryRHome.class);

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

	public void persist(AudCaseHistoryR transientInstance) {
		log.debug("persisting AudCaseHistoryR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AudCaseHistoryR instance) {
		log.debug("attaching dirty AudCaseHistoryR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AudCaseHistoryR instance) {
		log.debug("attaching clean AudCaseHistoryR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AudCaseHistoryR persistentInstance) {
		log.debug("deleting AudCaseHistoryR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AudCaseHistoryR merge(AudCaseHistoryR detachedInstance) {
		log.debug("merging AudCaseHistoryR instance");
		try {
			AudCaseHistoryR result = (AudCaseHistoryR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AudCaseHistoryR findById(
			com.cardiodx.db.waban.audit.AudCaseHistoryRId id) {
		log.debug("getting AudCaseHistoryR instance with id: " + id);
		try {
			AudCaseHistoryR instance = (AudCaseHistoryR) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.audit.AudCaseHistoryR", id);
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

	public List<AudCaseHistoryR> findByExample(AudCaseHistoryR instance) {
		log.debug("finding AudCaseHistoryR instance by example");
		try {
			List<AudCaseHistoryR> results = (List<AudCaseHistoryR>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.audit.AudCaseHistoryR")
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
