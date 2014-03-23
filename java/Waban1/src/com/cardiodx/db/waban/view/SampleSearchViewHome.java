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
 * Home object for domain model class SampleSearchView.
 * @see com.cardiodx.db.waban.view.SampleSearchView
 * @author Hibernate Tools
 */
public class SampleSearchViewHome {

	private static final Log log = LogFactory
			.getLog(SampleSearchViewHome.class);

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

	public void persist(SampleSearchView transientInstance) {
		log.debug("persisting SampleSearchView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(SampleSearchView instance) {
		log.debug("attaching dirty SampleSearchView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SampleSearchView instance) {
		log.debug("attaching clean SampleSearchView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(SampleSearchView persistentInstance) {
		log.debug("deleting SampleSearchView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SampleSearchView merge(SampleSearchView detachedInstance) {
		log.debug("merging SampleSearchView instance");
		try {
			SampleSearchView result = (SampleSearchView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public SampleSearchView findById(
			com.cardiodx.db.waban.view.SampleSearchViewId id) {
		log.debug("getting SampleSearchView instance with id: " + id);
		try {
			SampleSearchView instance = (SampleSearchView) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.SampleSearchView", id);
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

	public List<SampleSearchView> findByExample(SampleSearchView instance) {
		log.debug("finding SampleSearchView instance by example");
		try {
			List<SampleSearchView> results = (List<SampleSearchView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.SampleSearchView")
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
