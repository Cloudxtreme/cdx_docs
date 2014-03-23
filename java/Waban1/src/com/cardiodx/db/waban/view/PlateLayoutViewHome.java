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
 * Home object for domain model class PlateLayoutView.
 * @see com.cardiodx.db.waban.view.PlateLayoutView
 * @author Hibernate Tools
 */
public class PlateLayoutViewHome {

	private static final Log log = LogFactory.getLog(PlateLayoutViewHome.class);

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

	public void persist(PlateLayoutView transientInstance) {
		log.debug("persisting PlateLayoutView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(PlateLayoutView instance) {
		log.debug("attaching dirty PlateLayoutView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PlateLayoutView instance) {
		log.debug("attaching clean PlateLayoutView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(PlateLayoutView persistentInstance) {
		log.debug("deleting PlateLayoutView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PlateLayoutView merge(PlateLayoutView detachedInstance) {
		log.debug("merging PlateLayoutView instance");
		try {
			PlateLayoutView result = (PlateLayoutView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public PlateLayoutView findById(
			com.cardiodx.db.waban.view.PlateLayoutViewId id) {
		log.debug("getting PlateLayoutView instance with id: " + id);
		try {
			PlateLayoutView instance = (PlateLayoutView) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.PlateLayoutView", id);
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

	public List<PlateLayoutView> findByExample(PlateLayoutView instance) {
		log.debug("finding PlateLayoutView instance by example");
		try {
			List<PlateLayoutView> results = (List<PlateLayoutView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.PlateLayoutView")
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
