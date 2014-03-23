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
 * Home object for domain model class PlatePendingView.
 * @see com.cardiodx.db.waban.view.PlatePendingView
 * @author Hibernate Tools
 */
public class PlatePendingViewHome {

	private static final Log log = LogFactory
			.getLog(PlatePendingViewHome.class);

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

	public void persist(PlatePendingView transientInstance) {
		log.debug("persisting PlatePendingView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(PlatePendingView instance) {
		log.debug("attaching dirty PlatePendingView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PlatePendingView instance) {
		log.debug("attaching clean PlatePendingView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(PlatePendingView persistentInstance) {
		log.debug("deleting PlatePendingView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PlatePendingView merge(PlatePendingView detachedInstance) {
		log.debug("merging PlatePendingView instance");
		try {
			PlatePendingView result = (PlatePendingView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public PlatePendingView findById(
			com.cardiodx.db.waban.view.PlatePendingViewId id) {
		log.debug("getting PlatePendingView instance with id: " + id);
		try {
			PlatePendingView instance = (PlatePendingView) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.PlatePendingView", id);
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

	public List<PlatePendingView> findByExample(PlatePendingView instance) {
		log.debug("finding PlatePendingView instance by example");
		try {
			List<PlatePendingView> results = (List<PlatePendingView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.PlatePendingView")
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
