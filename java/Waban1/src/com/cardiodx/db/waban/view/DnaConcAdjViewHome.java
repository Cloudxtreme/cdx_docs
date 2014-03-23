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
 * Home object for domain model class DnaConcAdjView.
 * @see com.cardiodx.db.waban.view.DnaConcAdjView
 * @author Hibernate Tools
 */
public class DnaConcAdjViewHome {

	private static final Log log = LogFactory.getLog(DnaConcAdjViewHome.class);

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

	public void persist(DnaConcAdjView transientInstance) {
		log.debug("persisting DnaConcAdjView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(DnaConcAdjView instance) {
		log.debug("attaching dirty DnaConcAdjView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(DnaConcAdjView instance) {
		log.debug("attaching clean DnaConcAdjView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(DnaConcAdjView persistentInstance) {
		log.debug("deleting DnaConcAdjView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public DnaConcAdjView merge(DnaConcAdjView detachedInstance) {
		log.debug("merging DnaConcAdjView instance");
		try {
			DnaConcAdjView result = (DnaConcAdjView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public DnaConcAdjView findById(
			com.cardiodx.db.waban.view.DnaConcAdjViewId id) {
		log.debug("getting DnaConcAdjView instance with id: " + id);
		try {
			DnaConcAdjView instance = (DnaConcAdjView) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.DnaConcAdjView", id);
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

	public List<DnaConcAdjView> findByExample(DnaConcAdjView instance) {
		log.debug("finding DnaConcAdjView instance by example");
		try {
			List<DnaConcAdjView> results = (List<DnaConcAdjView>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.view.DnaConcAdjView")
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
