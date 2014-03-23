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
 * Home object for domain model class ConflictResolutionView.
 * @see com.cardiodx.db.waban.view.ConflictResolutionView
 * @author Hibernate Tools
 */
public class ConflictResolutionViewHome {

	private static final Log log = LogFactory
			.getLog(ConflictResolutionViewHome.class);

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

	public void persist(ConflictResolutionView transientInstance) {
		log.debug("persisting ConflictResolutionView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ConflictResolutionView instance) {
		log.debug("attaching dirty ConflictResolutionView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ConflictResolutionView instance) {
		log.debug("attaching clean ConflictResolutionView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ConflictResolutionView persistentInstance) {
		log.debug("deleting ConflictResolutionView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ConflictResolutionView merge(ConflictResolutionView detachedInstance) {
		log.debug("merging ConflictResolutionView instance");
		try {
			ConflictResolutionView result = (ConflictResolutionView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ConflictResolutionView findById(
			com.cardiodx.db.waban.view.ConflictResolutionViewId id) {
		log.debug("getting ConflictResolutionView instance with id: " + id);
		try {
			ConflictResolutionView instance = (ConflictResolutionView) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.view.ConflictResolutionView",
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

	public List<ConflictResolutionView> findByExample(
			ConflictResolutionView instance) {
		log.debug("finding ConflictResolutionView instance by example");
		try {
			List<ConflictResolutionView> results = (List<ConflictResolutionView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.ConflictResolutionView")
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
