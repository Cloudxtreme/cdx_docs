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
 * Home object for domain model class AudQcReviewR.
 * @see com.cardiodx.db.waban.audit.AudQcReviewR
 * @author Hibernate Tools
 */
public class AudQcReviewRHome {

	private static final Log log = LogFactory.getLog(AudQcReviewRHome.class);

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

	public void persist(AudQcReviewR transientInstance) {
		log.debug("persisting AudQcReviewR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AudQcReviewR instance) {
		log.debug("attaching dirty AudQcReviewR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AudQcReviewR instance) {
		log.debug("attaching clean AudQcReviewR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AudQcReviewR persistentInstance) {
		log.debug("deleting AudQcReviewR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AudQcReviewR merge(AudQcReviewR detachedInstance) {
		log.debug("merging AudQcReviewR instance");
		try {
			AudQcReviewR result = (AudQcReviewR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AudQcReviewR findById(com.cardiodx.db.waban.audit.AudQcReviewRId id) {
		log.debug("getting AudQcReviewR instance with id: " + id);
		try {
			AudQcReviewR instance = (AudQcReviewR) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.audit.AudQcReviewR", id);
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

	public List<AudQcReviewR> findByExample(AudQcReviewR instance) {
		log.debug("finding AudQcReviewR instance by example");
		try {
			List<AudQcReviewR> results = (List<AudQcReviewR>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.audit.AudQcReviewR")
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
