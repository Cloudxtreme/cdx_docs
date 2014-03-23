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
 * Home object for domain model class CdxFaxAttempt.
 * @see com.cardiodx.db.waban.table.CdxFaxAttempt
 * @author Hibernate Tools
 */
public class CdxFaxAttemptHome {

	private static final Log log = LogFactory.getLog(CdxFaxAttemptHome.class);

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

	public void persist(CdxFaxAttempt transientInstance) {
		log.debug("persisting CdxFaxAttempt instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(CdxFaxAttempt instance) {
		log.debug("attaching dirty CdxFaxAttempt instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CdxFaxAttempt instance) {
		log.debug("attaching clean CdxFaxAttempt instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(CdxFaxAttempt persistentInstance) {
		log.debug("deleting CdxFaxAttempt instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CdxFaxAttempt merge(CdxFaxAttempt detachedInstance) {
		log.debug("merging CdxFaxAttempt instance");
		try {
			CdxFaxAttempt result = (CdxFaxAttempt) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public CdxFaxAttempt findById(java.math.BigDecimal id) {
		log.debug("getting CdxFaxAttempt instance with id: " + id);
		try {
			CdxFaxAttempt instance = (CdxFaxAttempt) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.CdxFaxAttempt", id);
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

	public List<CdxFaxAttempt> findByExample(CdxFaxAttempt instance) {
		log.debug("finding CdxFaxAttempt instance by example");
		try {
			List<CdxFaxAttempt> results = (List<CdxFaxAttempt>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.table.CdxFaxAttempt")
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
