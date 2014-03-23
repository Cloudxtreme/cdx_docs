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
 * Home object for domain model class SamplesgridView.
 * @see com.cardiodx.db.waban.view.SamplesgridView
 * @author Hibernate Tools
 */
public class SamplesgridViewHome {

	private static final Log log = LogFactory.getLog(SamplesgridViewHome.class);

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

	public void persist(SamplesgridView transientInstance) {
		log.debug("persisting SamplesgridView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(SamplesgridView instance) {
		log.debug("attaching dirty SamplesgridView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SamplesgridView instance) {
		log.debug("attaching clean SamplesgridView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(SamplesgridView persistentInstance) {
		log.debug("deleting SamplesgridView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SamplesgridView merge(SamplesgridView detachedInstance) {
		log.debug("merging SamplesgridView instance");
		try {
			SamplesgridView result = (SamplesgridView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public SamplesgridView findById(
			com.cardiodx.db.waban.view.SamplesgridViewId id) {
		log.debug("getting SamplesgridView instance with id: " + id);
		try {
			SamplesgridView instance = (SamplesgridView) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.SamplesgridView", id);
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

	public List<SamplesgridView> findByExample(SamplesgridView instance) {
		log.debug("finding SamplesgridView instance by example");
		try {
			List<SamplesgridView> results = (List<SamplesgridView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.SamplesgridView")
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
