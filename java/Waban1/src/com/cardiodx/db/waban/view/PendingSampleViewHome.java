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
 * Home object for domain model class PendingSampleView.
 * @see com.cardiodx.db.waban.view.PendingSampleView
 * @author Hibernate Tools
 */
public class PendingSampleViewHome {

	private static final Log log = LogFactory
			.getLog(PendingSampleViewHome.class);

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

	public void persist(PendingSampleView transientInstance) {
		log.debug("persisting PendingSampleView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(PendingSampleView instance) {
		log.debug("attaching dirty PendingSampleView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PendingSampleView instance) {
		log.debug("attaching clean PendingSampleView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(PendingSampleView persistentInstance) {
		log.debug("deleting PendingSampleView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PendingSampleView merge(PendingSampleView detachedInstance) {
		log.debug("merging PendingSampleView instance");
		try {
			PendingSampleView result = (PendingSampleView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public PendingSampleView findById(
			com.cardiodx.db.waban.view.PendingSampleViewId id) {
		log.debug("getting PendingSampleView instance with id: " + id);
		try {
			PendingSampleView instance = (PendingSampleView) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.PendingSampleView", id);
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

	public List<PendingSampleView> findByExample(PendingSampleView instance) {
		log.debug("finding PendingSampleView instance by example");
		try {
			List<PendingSampleView> results = (List<PendingSampleView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.PendingSampleView")
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
