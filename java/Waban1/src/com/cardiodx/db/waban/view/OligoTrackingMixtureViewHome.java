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
 * Home object for domain model class OligoTrackingMixtureView.
 * @see com.cardiodx.db.waban.view.OligoTrackingMixtureView
 * @author Hibernate Tools
 */
public class OligoTrackingMixtureViewHome {

	private static final Log log = LogFactory
			.getLog(OligoTrackingMixtureViewHome.class);

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

	public void persist(OligoTrackingMixtureView transientInstance) {
		log.debug("persisting OligoTrackingMixtureView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(OligoTrackingMixtureView instance) {
		log.debug("attaching dirty OligoTrackingMixtureView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(OligoTrackingMixtureView instance) {
		log.debug("attaching clean OligoTrackingMixtureView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(OligoTrackingMixtureView persistentInstance) {
		log.debug("deleting OligoTrackingMixtureView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public OligoTrackingMixtureView merge(
			OligoTrackingMixtureView detachedInstance) {
		log.debug("merging OligoTrackingMixtureView instance");
		try {
			OligoTrackingMixtureView result = (OligoTrackingMixtureView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public OligoTrackingMixtureView findById(
			com.cardiodx.db.waban.view.OligoTrackingMixtureViewId id) {
		log.debug("getting OligoTrackingMixtureView instance with id: " + id);
		try {
			OligoTrackingMixtureView instance = (OligoTrackingMixtureView) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.view.OligoTrackingMixtureView",
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

	public List<OligoTrackingMixtureView> findByExample(
			OligoTrackingMixtureView instance) {
		log.debug("finding OligoTrackingMixtureView instance by example");
		try {
			List<OligoTrackingMixtureView> results = (List<OligoTrackingMixtureView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.OligoTrackingMixtureView")
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
