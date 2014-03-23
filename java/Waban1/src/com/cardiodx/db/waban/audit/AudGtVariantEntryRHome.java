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
 * Home object for domain model class AudGtVariantEntryR.
 * @see com.cardiodx.db.waban.audit.AudGtVariantEntryR
 * @author Hibernate Tools
 */
public class AudGtVariantEntryRHome {

	private static final Log log = LogFactory
			.getLog(AudGtVariantEntryRHome.class);

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

	public void persist(AudGtVariantEntryR transientInstance) {
		log.debug("persisting AudGtVariantEntryR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AudGtVariantEntryR instance) {
		log.debug("attaching dirty AudGtVariantEntryR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AudGtVariantEntryR instance) {
		log.debug("attaching clean AudGtVariantEntryR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AudGtVariantEntryR persistentInstance) {
		log.debug("deleting AudGtVariantEntryR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AudGtVariantEntryR merge(AudGtVariantEntryR detachedInstance) {
		log.debug("merging AudGtVariantEntryR instance");
		try {
			AudGtVariantEntryR result = (AudGtVariantEntryR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AudGtVariantEntryR findById(
			com.cardiodx.db.waban.audit.AudGtVariantEntryRId id) {
		log.debug("getting AudGtVariantEntryR instance with id: " + id);
		try {
			AudGtVariantEntryR instance = (AudGtVariantEntryR) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.audit.AudGtVariantEntryR",
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

	public List<AudGtVariantEntryR> findByExample(AudGtVariantEntryR instance) {
		log.debug("finding AudGtVariantEntryR instance by example");
		try {
			List<AudGtVariantEntryR> results = (List<AudGtVariantEntryR>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.audit.AudGtVariantEntryR")
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
