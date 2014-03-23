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
 * Home object for domain model class AudTransitionMatrix.
 * @see com.cardiodx.db.waban.audit.AudTransitionMatrix
 * @author Hibernate Tools
 */
public class AudTransitionMatrixHome {

	private static final Log log = LogFactory
			.getLog(AudTransitionMatrixHome.class);

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

	public void persist(AudTransitionMatrix transientInstance) {
		log.debug("persisting AudTransitionMatrix instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AudTransitionMatrix instance) {
		log.debug("attaching dirty AudTransitionMatrix instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AudTransitionMatrix instance) {
		log.debug("attaching clean AudTransitionMatrix instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AudTransitionMatrix persistentInstance) {
		log.debug("deleting AudTransitionMatrix instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AudTransitionMatrix merge(AudTransitionMatrix detachedInstance) {
		log.debug("merging AudTransitionMatrix instance");
		try {
			AudTransitionMatrix result = (AudTransitionMatrix) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AudTransitionMatrix findById(java.math.BigDecimal id) {
		log.debug("getting AudTransitionMatrix instance with id: " + id);
		try {
			AudTransitionMatrix instance = (AudTransitionMatrix) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.audit.AudTransitionMatrix",
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

	public List<AudTransitionMatrix> findByExample(AudTransitionMatrix instance) {
		log.debug("finding AudTransitionMatrix instance by example");
		try {
			List<AudTransitionMatrix> results = (List<AudTransitionMatrix>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.audit.AudTransitionMatrix")
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
