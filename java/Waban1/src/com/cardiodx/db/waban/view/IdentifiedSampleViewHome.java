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
 * Home object for domain model class IdentifiedSampleView.
 * @see com.cardiodx.db.waban.view.IdentifiedSampleView
 * @author Hibernate Tools
 */
public class IdentifiedSampleViewHome {

	private static final Log log = LogFactory
			.getLog(IdentifiedSampleViewHome.class);

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

	public void persist(IdentifiedSampleView transientInstance) {
		log.debug("persisting IdentifiedSampleView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(IdentifiedSampleView instance) {
		log.debug("attaching dirty IdentifiedSampleView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(IdentifiedSampleView instance) {
		log.debug("attaching clean IdentifiedSampleView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(IdentifiedSampleView persistentInstance) {
		log.debug("deleting IdentifiedSampleView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public IdentifiedSampleView merge(IdentifiedSampleView detachedInstance) {
		log.debug("merging IdentifiedSampleView instance");
		try {
			IdentifiedSampleView result = (IdentifiedSampleView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public IdentifiedSampleView findById(
			com.cardiodx.db.waban.view.IdentifiedSampleViewId id) {
		log.debug("getting IdentifiedSampleView instance with id: " + id);
		try {
			IdentifiedSampleView instance = (IdentifiedSampleView) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.IdentifiedSampleView",
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

	public List<IdentifiedSampleView> findByExample(
			IdentifiedSampleView instance) {
		log.debug("finding IdentifiedSampleView instance by example");
		try {
			List<IdentifiedSampleView> results = (List<IdentifiedSampleView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.IdentifiedSampleView")
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
