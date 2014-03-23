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
 * Home object for domain model class AudIdentifiedSample.
 * @see com.cardiodx.db.waban.audit.AudIdentifiedSample
 * @author Hibernate Tools
 */
public class AudIdentifiedSampleHome {

	private static final Log log = LogFactory
			.getLog(AudIdentifiedSampleHome.class);

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

	public void persist(AudIdentifiedSample transientInstance) {
		log.debug("persisting AudIdentifiedSample instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AudIdentifiedSample instance) {
		log.debug("attaching dirty AudIdentifiedSample instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AudIdentifiedSample instance) {
		log.debug("attaching clean AudIdentifiedSample instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AudIdentifiedSample persistentInstance) {
		log.debug("deleting AudIdentifiedSample instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AudIdentifiedSample merge(AudIdentifiedSample detachedInstance) {
		log.debug("merging AudIdentifiedSample instance");
		try {
			AudIdentifiedSample result = (AudIdentifiedSample) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AudIdentifiedSample findById(java.math.BigDecimal id) {
		log.debug("getting AudIdentifiedSample instance with id: " + id);
		try {
			AudIdentifiedSample instance = (AudIdentifiedSample) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.audit.AudIdentifiedSample",
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

	public List<AudIdentifiedSample> findByExample(AudIdentifiedSample instance) {
		log.debug("finding AudIdentifiedSample instance by example");
		try {
			List<AudIdentifiedSample> results = (List<AudIdentifiedSample>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.audit.AudIdentifiedSample")
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
