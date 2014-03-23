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
 * Home object for domain model class AudIdentifiedSampleR.
 * @see com.cardiodx.db.waban.audit.AudIdentifiedSampleR
 * @author Hibernate Tools
 */
public class AudIdentifiedSampleRHome {

	private static final Log log = LogFactory
			.getLog(AudIdentifiedSampleRHome.class);

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

	public void persist(AudIdentifiedSampleR transientInstance) {
		log.debug("persisting AudIdentifiedSampleR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AudIdentifiedSampleR instance) {
		log.debug("attaching dirty AudIdentifiedSampleR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AudIdentifiedSampleR instance) {
		log.debug("attaching clean AudIdentifiedSampleR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AudIdentifiedSampleR persistentInstance) {
		log.debug("deleting AudIdentifiedSampleR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AudIdentifiedSampleR merge(AudIdentifiedSampleR detachedInstance) {
		log.debug("merging AudIdentifiedSampleR instance");
		try {
			AudIdentifiedSampleR result = (AudIdentifiedSampleR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AudIdentifiedSampleR findById(
			com.cardiodx.db.waban.audit.AudIdentifiedSampleRId id) {
		log.debug("getting AudIdentifiedSampleR instance with id: " + id);
		try {
			AudIdentifiedSampleR instance = (AudIdentifiedSampleR) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.audit.AudIdentifiedSampleR",
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

	public List<AudIdentifiedSampleR> findByExample(
			AudIdentifiedSampleR instance) {
		log.debug("finding AudIdentifiedSampleR instance by example");
		try {
			List<AudIdentifiedSampleR> results = (List<AudIdentifiedSampleR>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.audit.AudIdentifiedSampleR")
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
