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
 * Home object for domain model class PendingSearchView.
 * @see com.cardiodx.db.waban.view.PendingSearchView
 * @author Hibernate Tools
 */
public class PendingSearchViewHome {

	private static final Log log = LogFactory
			.getLog(PendingSearchViewHome.class);

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

	public void persist(PendingSearchView transientInstance) {
		log.debug("persisting PendingSearchView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(PendingSearchView instance) {
		log.debug("attaching dirty PendingSearchView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PendingSearchView instance) {
		log.debug("attaching clean PendingSearchView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(PendingSearchView persistentInstance) {
		log.debug("deleting PendingSearchView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PendingSearchView merge(PendingSearchView detachedInstance) {
		log.debug("merging PendingSearchView instance");
		try {
			PendingSearchView result = (PendingSearchView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public PendingSearchView findById(
			com.cardiodx.db.waban.view.PendingSearchViewId id) {
		log.debug("getting PendingSearchView instance with id: " + id);
		try {
			PendingSearchView instance = (PendingSearchView) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.PendingSearchView", id);
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

	public List<PendingSearchView> findByExample(PendingSearchView instance) {
		log.debug("finding PendingSearchView instance by example");
		try {
			List<PendingSearchView> results = (List<PendingSearchView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.PendingSearchView")
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
