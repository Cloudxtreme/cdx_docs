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
 * Home object for domain model class SamplereceptionloadidView.
 * @see com.cardiodx.db.waban.view.SamplereceptionloadidView
 * @author Hibernate Tools
 */
public class SamplereceptionloadidViewHome {

	private static final Log log = LogFactory
			.getLog(SamplereceptionloadidViewHome.class);

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

	public void persist(SamplereceptionloadidView transientInstance) {
		log.debug("persisting SamplereceptionloadidView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(SamplereceptionloadidView instance) {
		log.debug("attaching dirty SamplereceptionloadidView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SamplereceptionloadidView instance) {
		log.debug("attaching clean SamplereceptionloadidView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(SamplereceptionloadidView persistentInstance) {
		log.debug("deleting SamplereceptionloadidView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SamplereceptionloadidView merge(
			SamplereceptionloadidView detachedInstance) {
		log.debug("merging SamplereceptionloadidView instance");
		try {
			SamplereceptionloadidView result = (SamplereceptionloadidView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public SamplereceptionloadidView findById(
			com.cardiodx.db.waban.view.SamplereceptionloadidViewId id) {
		log.debug("getting SamplereceptionloadidView instance with id: " + id);
		try {
			SamplereceptionloadidView instance = (SamplereceptionloadidView) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.view.SamplereceptionloadidView",
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

	public List<SamplereceptionloadidView> findByExample(
			SamplereceptionloadidView instance) {
		log.debug("finding SamplereceptionloadidView instance by example");
		try {
			List<SamplereceptionloadidView> results = (List<SamplereceptionloadidView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.SamplereceptionloadidView")
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
