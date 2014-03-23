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
 * Home object for domain model class VendProjForecastedView.
 * @see com.cardiodx.db.waban.view.VendProjForecastedView
 * @author Hibernate Tools
 */
public class VendProjForecastedViewHome {

	private static final Log log = LogFactory
			.getLog(VendProjForecastedViewHome.class);

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

	public void persist(VendProjForecastedView transientInstance) {
		log.debug("persisting VendProjForecastedView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(VendProjForecastedView instance) {
		log.debug("attaching dirty VendProjForecastedView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(VendProjForecastedView instance) {
		log.debug("attaching clean VendProjForecastedView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(VendProjForecastedView persistentInstance) {
		log.debug("deleting VendProjForecastedView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public VendProjForecastedView merge(VendProjForecastedView detachedInstance) {
		log.debug("merging VendProjForecastedView instance");
		try {
			VendProjForecastedView result = (VendProjForecastedView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public VendProjForecastedView findById(
			com.cardiodx.db.waban.view.VendProjForecastedViewId id) {
		log.debug("getting VendProjForecastedView instance with id: " + id);
		try {
			VendProjForecastedView instance = (VendProjForecastedView) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.view.VendProjForecastedView",
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

	public List<VendProjForecastedView> findByExample(
			VendProjForecastedView instance) {
		log.debug("finding VendProjForecastedView instance by example");
		try {
			List<VendProjForecastedView> results = (List<VendProjForecastedView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.VendProjForecastedView")
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
