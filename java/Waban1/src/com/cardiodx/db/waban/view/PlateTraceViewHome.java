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
 * Home object for domain model class PlateTraceView.
 * @see com.cardiodx.db.waban.view.PlateTraceView
 * @author Hibernate Tools
 */
public class PlateTraceViewHome {

	private static final Log log = LogFactory.getLog(PlateTraceViewHome.class);

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

	public void persist(PlateTraceView transientInstance) {
		log.debug("persisting PlateTraceView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(PlateTraceView instance) {
		log.debug("attaching dirty PlateTraceView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PlateTraceView instance) {
		log.debug("attaching clean PlateTraceView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(PlateTraceView persistentInstance) {
		log.debug("deleting PlateTraceView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PlateTraceView merge(PlateTraceView detachedInstance) {
		log.debug("merging PlateTraceView instance");
		try {
			PlateTraceView result = (PlateTraceView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public PlateTraceView findById(
			com.cardiodx.db.waban.view.PlateTraceViewId id) {
		log.debug("getting PlateTraceView instance with id: " + id);
		try {
			PlateTraceView instance = (PlateTraceView) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.PlateTraceView", id);
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

	public List<PlateTraceView> findByExample(PlateTraceView instance) {
		log.debug("finding PlateTraceView instance by example");
		try {
			List<PlateTraceView> results = (List<PlateTraceView>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.view.PlateTraceView")
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
