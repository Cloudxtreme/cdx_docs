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
 * Home object for domain model class OligoTrackingDisplayView.
 * @see com.cardiodx.db.waban.view.OligoTrackingDisplayView
 * @author Hibernate Tools
 */
public class OligoTrackingDisplayViewHome {

	private static final Log log = LogFactory
			.getLog(OligoTrackingDisplayViewHome.class);

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

	public void persist(OligoTrackingDisplayView transientInstance) {
		log.debug("persisting OligoTrackingDisplayView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(OligoTrackingDisplayView instance) {
		log.debug("attaching dirty OligoTrackingDisplayView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(OligoTrackingDisplayView instance) {
		log.debug("attaching clean OligoTrackingDisplayView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(OligoTrackingDisplayView persistentInstance) {
		log.debug("deleting OligoTrackingDisplayView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public OligoTrackingDisplayView merge(
			OligoTrackingDisplayView detachedInstance) {
		log.debug("merging OligoTrackingDisplayView instance");
		try {
			OligoTrackingDisplayView result = (OligoTrackingDisplayView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public OligoTrackingDisplayView findById(
			com.cardiodx.db.waban.view.OligoTrackingDisplayViewId id) {
		log.debug("getting OligoTrackingDisplayView instance with id: " + id);
		try {
			OligoTrackingDisplayView instance = (OligoTrackingDisplayView) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.view.OligoTrackingDisplayView",
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

	public List<OligoTrackingDisplayView> findByExample(
			OligoTrackingDisplayView instance) {
		log.debug("finding OligoTrackingDisplayView instance by example");
		try {
			List<OligoTrackingDisplayView> results = (List<OligoTrackingDisplayView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.OligoTrackingDisplayView")
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
