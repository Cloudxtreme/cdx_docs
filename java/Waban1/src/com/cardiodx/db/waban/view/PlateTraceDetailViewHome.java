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
 * Home object for domain model class PlateTraceDetailView.
 * @see com.cardiodx.db.waban.view.PlateTraceDetailView
 * @author Hibernate Tools
 */
public class PlateTraceDetailViewHome {

	private static final Log log = LogFactory
			.getLog(PlateTraceDetailViewHome.class);

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

	public void persist(PlateTraceDetailView transientInstance) {
		log.debug("persisting PlateTraceDetailView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(PlateTraceDetailView instance) {
		log.debug("attaching dirty PlateTraceDetailView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PlateTraceDetailView instance) {
		log.debug("attaching clean PlateTraceDetailView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(PlateTraceDetailView persistentInstance) {
		log.debug("deleting PlateTraceDetailView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PlateTraceDetailView merge(PlateTraceDetailView detachedInstance) {
		log.debug("merging PlateTraceDetailView instance");
		try {
			PlateTraceDetailView result = (PlateTraceDetailView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public PlateTraceDetailView findById(
			com.cardiodx.db.waban.view.PlateTraceDetailViewId id) {
		log.debug("getting PlateTraceDetailView instance with id: " + id);
		try {
			PlateTraceDetailView instance = (PlateTraceDetailView) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.PlateTraceDetailView",
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

	public List<PlateTraceDetailView> findByExample(
			PlateTraceDetailView instance) {
		log.debug("finding PlateTraceDetailView instance by example");
		try {
			List<PlateTraceDetailView> results = (List<PlateTraceDetailView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.PlateTraceDetailView")
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
