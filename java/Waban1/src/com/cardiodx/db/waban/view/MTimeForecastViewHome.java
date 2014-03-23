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
 * Home object for domain model class MTimeForecastView.
 * @see com.cardiodx.db.waban.view.MTimeForecastView
 * @author Hibernate Tools
 */
public class MTimeForecastViewHome {

	private static final Log log = LogFactory
			.getLog(MTimeForecastViewHome.class);

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

	public void persist(MTimeForecastView transientInstance) {
		log.debug("persisting MTimeForecastView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(MTimeForecastView instance) {
		log.debug("attaching dirty MTimeForecastView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MTimeForecastView instance) {
		log.debug("attaching clean MTimeForecastView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(MTimeForecastView persistentInstance) {
		log.debug("deleting MTimeForecastView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MTimeForecastView merge(MTimeForecastView detachedInstance) {
		log.debug("merging MTimeForecastView instance");
		try {
			MTimeForecastView result = (MTimeForecastView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public MTimeForecastView findById(
			com.cardiodx.db.waban.view.MTimeForecastViewId id) {
		log.debug("getting MTimeForecastView instance with id: " + id);
		try {
			MTimeForecastView instance = (MTimeForecastView) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.MTimeForecastView", id);
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

	public List<MTimeForecastView> findByExample(MTimeForecastView instance) {
		log.debug("finding MTimeForecastView instance by example");
		try {
			List<MTimeForecastView> results = (List<MTimeForecastView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.MTimeForecastView")
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
