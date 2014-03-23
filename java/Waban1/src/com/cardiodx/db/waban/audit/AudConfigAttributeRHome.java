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
 * Home object for domain model class AudConfigAttributeR.
 * @see com.cardiodx.db.waban.audit.AudConfigAttributeR
 * @author Hibernate Tools
 */
public class AudConfigAttributeRHome {

	private static final Log log = LogFactory
			.getLog(AudConfigAttributeRHome.class);

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

	public void persist(AudConfigAttributeR transientInstance) {
		log.debug("persisting AudConfigAttributeR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AudConfigAttributeR instance) {
		log.debug("attaching dirty AudConfigAttributeR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AudConfigAttributeR instance) {
		log.debug("attaching clean AudConfigAttributeR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AudConfigAttributeR persistentInstance) {
		log.debug("deleting AudConfigAttributeR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AudConfigAttributeR merge(AudConfigAttributeR detachedInstance) {
		log.debug("merging AudConfigAttributeR instance");
		try {
			AudConfigAttributeR result = (AudConfigAttributeR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AudConfigAttributeR findById(
			com.cardiodx.db.waban.audit.AudConfigAttributeRId id) {
		log.debug("getting AudConfigAttributeR instance with id: " + id);
		try {
			AudConfigAttributeR instance = (AudConfigAttributeR) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.audit.AudConfigAttributeR",
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

	public List<AudConfigAttributeR> findByExample(AudConfigAttributeR instance) {
		log.debug("finding AudConfigAttributeR instance by example");
		try {
			List<AudConfigAttributeR> results = (List<AudConfigAttributeR>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.audit.AudConfigAttributeR")
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
