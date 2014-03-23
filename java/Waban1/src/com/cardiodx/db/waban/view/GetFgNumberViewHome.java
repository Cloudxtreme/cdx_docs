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
 * Home object for domain model class GetFgNumberView.
 * @see com.cardiodx.db.waban.view.GetFgNumberView
 * @author Hibernate Tools
 */
public class GetFgNumberViewHome {

	private static final Log log = LogFactory.getLog(GetFgNumberViewHome.class);

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

	public void persist(GetFgNumberView transientInstance) {
		log.debug("persisting GetFgNumberView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(GetFgNumberView instance) {
		log.debug("attaching dirty GetFgNumberView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(GetFgNumberView instance) {
		log.debug("attaching clean GetFgNumberView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(GetFgNumberView persistentInstance) {
		log.debug("deleting GetFgNumberView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public GetFgNumberView merge(GetFgNumberView detachedInstance) {
		log.debug("merging GetFgNumberView instance");
		try {
			GetFgNumberView result = (GetFgNumberView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public GetFgNumberView findById(
			com.cardiodx.db.waban.view.GetFgNumberViewId id) {
		log.debug("getting GetFgNumberView instance with id: " + id);
		try {
			GetFgNumberView instance = (GetFgNumberView) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.GetFgNumberView", id);
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

	public List<GetFgNumberView> findByExample(GetFgNumberView instance) {
		log.debug("finding GetFgNumberView instance by example");
		try {
			List<GetFgNumberView> results = (List<GetFgNumberView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.GetFgNumberView")
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
