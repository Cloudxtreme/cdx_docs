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
 * Home object for domain model class AudTransitionMatrixR.
 * @see com.cardiodx.db.waban.audit.AudTransitionMatrixR
 * @author Hibernate Tools
 */
public class AudTransitionMatrixRHome {

	private static final Log log = LogFactory
			.getLog(AudTransitionMatrixRHome.class);

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

	public void persist(AudTransitionMatrixR transientInstance) {
		log.debug("persisting AudTransitionMatrixR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AudTransitionMatrixR instance) {
		log.debug("attaching dirty AudTransitionMatrixR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AudTransitionMatrixR instance) {
		log.debug("attaching clean AudTransitionMatrixR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AudTransitionMatrixR persistentInstance) {
		log.debug("deleting AudTransitionMatrixR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AudTransitionMatrixR merge(AudTransitionMatrixR detachedInstance) {
		log.debug("merging AudTransitionMatrixR instance");
		try {
			AudTransitionMatrixR result = (AudTransitionMatrixR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AudTransitionMatrixR findById(
			com.cardiodx.db.waban.audit.AudTransitionMatrixRId id) {
		log.debug("getting AudTransitionMatrixR instance with id: " + id);
		try {
			AudTransitionMatrixR instance = (AudTransitionMatrixR) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.audit.AudTransitionMatrixR",
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

	public List<AudTransitionMatrixR> findByExample(
			AudTransitionMatrixR instance) {
		log.debug("finding AudTransitionMatrixR instance by example");
		try {
			List<AudTransitionMatrixR> results = (List<AudTransitionMatrixR>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.audit.AudTransitionMatrixR")
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
