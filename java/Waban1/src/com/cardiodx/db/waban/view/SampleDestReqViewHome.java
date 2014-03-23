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
 * Home object for domain model class SampleDestReqView.
 * @see com.cardiodx.db.waban.view.SampleDestReqView
 * @author Hibernate Tools
 */
public class SampleDestReqViewHome {

	private static final Log log = LogFactory
			.getLog(SampleDestReqViewHome.class);

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

	public void persist(SampleDestReqView transientInstance) {
		log.debug("persisting SampleDestReqView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(SampleDestReqView instance) {
		log.debug("attaching dirty SampleDestReqView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SampleDestReqView instance) {
		log.debug("attaching clean SampleDestReqView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(SampleDestReqView persistentInstance) {
		log.debug("deleting SampleDestReqView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SampleDestReqView merge(SampleDestReqView detachedInstance) {
		log.debug("merging SampleDestReqView instance");
		try {
			SampleDestReqView result = (SampleDestReqView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public SampleDestReqView findById(
			com.cardiodx.db.waban.view.SampleDestReqViewId id) {
		log.debug("getting SampleDestReqView instance with id: " + id);
		try {
			SampleDestReqView instance = (SampleDestReqView) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.SampleDestReqView", id);
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

	public List<SampleDestReqView> findByExample(SampleDestReqView instance) {
		log.debug("finding SampleDestReqView instance by example");
		try {
			List<SampleDestReqView> results = (List<SampleDestReqView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.SampleDestReqView")
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
