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
 * Home object for domain model class AudIdentifiedSampleAttR.
 * @see com.cardiodx.db.waban.audit.AudIdentifiedSampleAttR
 * @author Hibernate Tools
 */
public class AudIdentifiedSampleAttRHome {

	private static final Log log = LogFactory
			.getLog(AudIdentifiedSampleAttRHome.class);

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

	public void persist(AudIdentifiedSampleAttR transientInstance) {
		log.debug("persisting AudIdentifiedSampleAttR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AudIdentifiedSampleAttR instance) {
		log.debug("attaching dirty AudIdentifiedSampleAttR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AudIdentifiedSampleAttR instance) {
		log.debug("attaching clean AudIdentifiedSampleAttR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AudIdentifiedSampleAttR persistentInstance) {
		log.debug("deleting AudIdentifiedSampleAttR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AudIdentifiedSampleAttR merge(
			AudIdentifiedSampleAttR detachedInstance) {
		log.debug("merging AudIdentifiedSampleAttR instance");
		try {
			AudIdentifiedSampleAttR result = (AudIdentifiedSampleAttR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AudIdentifiedSampleAttR findById(
			com.cardiodx.db.waban.audit.AudIdentifiedSampleAttRId id) {
		log.debug("getting AudIdentifiedSampleAttR instance with id: " + id);
		try {
			AudIdentifiedSampleAttR instance = (AudIdentifiedSampleAttR) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.audit.AudIdentifiedSampleAttR",
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

	public List<AudIdentifiedSampleAttR> findByExample(
			AudIdentifiedSampleAttR instance) {
		log.debug("finding AudIdentifiedSampleAttR instance by example");
		try {
			List<AudIdentifiedSampleAttR> results = (List<AudIdentifiedSampleAttR>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.audit.AudIdentifiedSampleAttR")
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
