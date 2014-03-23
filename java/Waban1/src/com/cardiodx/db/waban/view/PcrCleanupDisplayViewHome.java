package com.cardiodx.db.waban.view;

// Generated Jul 14, 2011 1:33:57 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class PcrCleanupDisplayView.
 * @see com.cardiodx.db.waban.view.PcrCleanupDisplayView
 * @author Hibernate Tools
 */
public class PcrCleanupDisplayViewHome {

	private static final Log log = LogFactory
			.getLog(PcrCleanupDisplayViewHome.class);

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

	public void persist(PcrCleanupDisplayView transientInstance) {
		log.debug("persisting PcrCleanupDisplayView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(PcrCleanupDisplayView instance) {
		log.debug("attaching dirty PcrCleanupDisplayView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PcrCleanupDisplayView instance) {
		log.debug("attaching clean PcrCleanupDisplayView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(PcrCleanupDisplayView persistentInstance) {
		log.debug("deleting PcrCleanupDisplayView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PcrCleanupDisplayView merge(PcrCleanupDisplayView detachedInstance) {
		log.debug("merging PcrCleanupDisplayView instance");
		try {
			PcrCleanupDisplayView result = (PcrCleanupDisplayView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public PcrCleanupDisplayView findById(
			com.cardiodx.db.waban.view.PcrCleanupDisplayViewId id) {
		log.debug("getting PcrCleanupDisplayView instance with id: " + id);
		try {
			PcrCleanupDisplayView instance = (PcrCleanupDisplayView) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.PcrCleanupDisplayView",
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

	public List<PcrCleanupDisplayView> findByExample(
			PcrCleanupDisplayView instance) {
		log.debug("finding PcrCleanupDisplayView instance by example");
		try {
			List<PcrCleanupDisplayView> results = (List<PcrCleanupDisplayView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.PcrCleanupDisplayView")
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
