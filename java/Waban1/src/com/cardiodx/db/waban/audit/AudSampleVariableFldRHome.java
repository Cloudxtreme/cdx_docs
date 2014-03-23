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
 * Home object for domain model class AudSampleVariableFldR.
 * @see com.cardiodx.db.waban.audit.AudSampleVariableFldR
 * @author Hibernate Tools
 */
public class AudSampleVariableFldRHome {

	private static final Log log = LogFactory
			.getLog(AudSampleVariableFldRHome.class);

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

	public void persist(AudSampleVariableFldR transientInstance) {
		log.debug("persisting AudSampleVariableFldR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AudSampleVariableFldR instance) {
		log.debug("attaching dirty AudSampleVariableFldR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AudSampleVariableFldR instance) {
		log.debug("attaching clean AudSampleVariableFldR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AudSampleVariableFldR persistentInstance) {
		log.debug("deleting AudSampleVariableFldR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AudSampleVariableFldR merge(AudSampleVariableFldR detachedInstance) {
		log.debug("merging AudSampleVariableFldR instance");
		try {
			AudSampleVariableFldR result = (AudSampleVariableFldR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AudSampleVariableFldR findById(
			com.cardiodx.db.waban.audit.AudSampleVariableFldRId id) {
		log.debug("getting AudSampleVariableFldR instance with id: " + id);
		try {
			AudSampleVariableFldR instance = (AudSampleVariableFldR) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.audit.AudSampleVariableFldR",
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

	public List<AudSampleVariableFldR> findByExample(
			AudSampleVariableFldR instance) {
		log.debug("finding AudSampleVariableFldR instance by example");
		try {
			List<AudSampleVariableFldR> results = (List<AudSampleVariableFldR>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.audit.AudSampleVariableFldR")
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
