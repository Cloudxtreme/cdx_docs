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
 * Home object for domain model class AccessionLock.
 * @see com.cardiodx.db.waban.table.AccessionLock
 * @author Hibernate Tools
 */
public class AccessionLockHome {

	private static final Log log = LogFactory.getLog(AccessionLockHome.class);

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

	public void persist(AccessionLock transientInstance) {
		log.debug("persisting AccessionLock instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AccessionLock instance) {
		log.debug("attaching dirty AccessionLock instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AccessionLock instance) {
		log.debug("attaching clean AccessionLock instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AccessionLock persistentInstance) {
		log.debug("deleting AccessionLock instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AccessionLock merge(AccessionLock detachedInstance) {
		log.debug("merging AccessionLock instance");
		try {
			AccessionLock result = (AccessionLock) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AccessionLock findById(java.math.BigDecimal id) {
		log.debug("getting AccessionLock instance with id: " + id);
		try {
			AccessionLock instance = (AccessionLock) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.AccessionLock", id);
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

	public List<AccessionLock> findByExample(AccessionLock instance) {
		log.debug("finding AccessionLock instance by example");
		try {
			List<AccessionLock> results = (List<AccessionLock>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.table.AccessionLock")
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
