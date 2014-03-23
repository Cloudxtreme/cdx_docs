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
 * Home object for domain model class PendingSampleAttributeView.
 * @see com.cardiodx.db.waban.view.PendingSampleAttributeView
 * @author Hibernate Tools
 */
public class PendingSampleAttributeViewHome {

	private static final Log log = LogFactory
			.getLog(PendingSampleAttributeViewHome.class);

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

	public void persist(PendingSampleAttributeView transientInstance) {
		log.debug("persisting PendingSampleAttributeView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(PendingSampleAttributeView instance) {
		log.debug("attaching dirty PendingSampleAttributeView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PendingSampleAttributeView instance) {
		log.debug("attaching clean PendingSampleAttributeView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(PendingSampleAttributeView persistentInstance) {
		log.debug("deleting PendingSampleAttributeView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PendingSampleAttributeView merge(
			PendingSampleAttributeView detachedInstance) {
		log.debug("merging PendingSampleAttributeView instance");
		try {
			PendingSampleAttributeView result = (PendingSampleAttributeView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public PendingSampleAttributeView findById(
			com.cardiodx.db.waban.view.PendingSampleAttributeViewId id) {
		log.debug("getting PendingSampleAttributeView instance with id: " + id);
		try {
			PendingSampleAttributeView instance = (PendingSampleAttributeView) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.view.PendingSampleAttributeView",
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

	public List<PendingSampleAttributeView> findByExample(
			PendingSampleAttributeView instance) {
		log.debug("finding PendingSampleAttributeView instance by example");
		try {
			List<PendingSampleAttributeView> results = (List<PendingSampleAttributeView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.PendingSampleAttributeView")
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
