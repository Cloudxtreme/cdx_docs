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
 * Home object for domain model class SamplesYearlyView.
 * @see com.cardiodx.db.waban.view.SamplesYearlyView
 * @author Hibernate Tools
 */
public class SamplesYearlyViewHome {

	private static final Log log = LogFactory
			.getLog(SamplesYearlyViewHome.class);

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

	public void persist(SamplesYearlyView transientInstance) {
		log.debug("persisting SamplesYearlyView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(SamplesYearlyView instance) {
		log.debug("attaching dirty SamplesYearlyView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SamplesYearlyView instance) {
		log.debug("attaching clean SamplesYearlyView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(SamplesYearlyView persistentInstance) {
		log.debug("deleting SamplesYearlyView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SamplesYearlyView merge(SamplesYearlyView detachedInstance) {
		log.debug("merging SamplesYearlyView instance");
		try {
			SamplesYearlyView result = (SamplesYearlyView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public SamplesYearlyView findById(
			com.cardiodx.db.waban.view.SamplesYearlyViewId id) {
		log.debug("getting SamplesYearlyView instance with id: " + id);
		try {
			SamplesYearlyView instance = (SamplesYearlyView) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.SamplesYearlyView", id);
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

	public List<SamplesYearlyView> findByExample(SamplesYearlyView instance) {
		log.debug("finding SamplesYearlyView instance by example");
		try {
			List<SamplesYearlyView> results = (List<SamplesYearlyView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.SamplesYearlyView")
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
