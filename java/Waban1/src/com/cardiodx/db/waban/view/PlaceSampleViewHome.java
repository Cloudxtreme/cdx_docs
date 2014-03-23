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
 * Home object for domain model class PlaceSampleView.
 * @see com.cardiodx.db.waban.view.PlaceSampleView
 * @author Hibernate Tools
 */
public class PlaceSampleViewHome {

	private static final Log log = LogFactory.getLog(PlaceSampleViewHome.class);

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

	public void persist(PlaceSampleView transientInstance) {
		log.debug("persisting PlaceSampleView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(PlaceSampleView instance) {
		log.debug("attaching dirty PlaceSampleView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PlaceSampleView instance) {
		log.debug("attaching clean PlaceSampleView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(PlaceSampleView persistentInstance) {
		log.debug("deleting PlaceSampleView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PlaceSampleView merge(PlaceSampleView detachedInstance) {
		log.debug("merging PlaceSampleView instance");
		try {
			PlaceSampleView result = (PlaceSampleView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public PlaceSampleView findById(
			com.cardiodx.db.waban.view.PlaceSampleViewId id) {
		log.debug("getting PlaceSampleView instance with id: " + id);
		try {
			PlaceSampleView instance = (PlaceSampleView) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.PlaceSampleView", id);
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

	public List<PlaceSampleView> findByExample(PlaceSampleView instance) {
		log.debug("finding PlaceSampleView instance by example");
		try {
			List<PlaceSampleView> results = (List<PlaceSampleView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.PlaceSampleView")
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
