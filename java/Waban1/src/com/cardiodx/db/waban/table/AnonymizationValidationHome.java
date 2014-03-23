package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:46 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class AnonymizationValidation.
 * @see com.cardiodx.db.waban.table.AnonymizationValidation
 * @author Hibernate Tools
 */
public class AnonymizationValidationHome {

	private static final Log log = LogFactory
			.getLog(AnonymizationValidationHome.class);

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

	public void persist(AnonymizationValidation transientInstance) {
		log.debug("persisting AnonymizationValidation instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AnonymizationValidation instance) {
		log.debug("attaching dirty AnonymizationValidation instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AnonymizationValidation instance) {
		log.debug("attaching clean AnonymizationValidation instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AnonymizationValidation persistentInstance) {
		log.debug("deleting AnonymizationValidation instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AnonymizationValidation merge(
			AnonymizationValidation detachedInstance) {
		log.debug("merging AnonymizationValidation instance");
		try {
			AnonymizationValidation result = (AnonymizationValidation) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AnonymizationValidation findById(java.math.BigDecimal id) {
		log.debug("getting AnonymizationValidation instance with id: " + id);
		try {
			AnonymizationValidation instance = (AnonymizationValidation) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.table.AnonymizationValidation",
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

	public List<AnonymizationValidation> findByExample(
			AnonymizationValidation instance) {
		log.debug("finding AnonymizationValidation instance by example");
		try {
			List<AnonymizationValidation> results = (List<AnonymizationValidation>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.AnonymizationValidation")
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
