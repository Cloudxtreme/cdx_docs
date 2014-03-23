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
 * Home object for domain model class ReagentSelectedView.
 * @see com.cardiodx.db.waban.view.ReagentSelectedView
 * @author Hibernate Tools
 */
public class ReagentSelectedViewHome {

	private static final Log log = LogFactory
			.getLog(ReagentSelectedViewHome.class);

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

	public void persist(ReagentSelectedView transientInstance) {
		log.debug("persisting ReagentSelectedView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ReagentSelectedView instance) {
		log.debug("attaching dirty ReagentSelectedView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ReagentSelectedView instance) {
		log.debug("attaching clean ReagentSelectedView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ReagentSelectedView persistentInstance) {
		log.debug("deleting ReagentSelectedView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ReagentSelectedView merge(ReagentSelectedView detachedInstance) {
		log.debug("merging ReagentSelectedView instance");
		try {
			ReagentSelectedView result = (ReagentSelectedView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ReagentSelectedView findById(
			com.cardiodx.db.waban.view.ReagentSelectedViewId id) {
		log.debug("getting ReagentSelectedView instance with id: " + id);
		try {
			ReagentSelectedView instance = (ReagentSelectedView) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.ReagentSelectedView",
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

	public List<ReagentSelectedView> findByExample(ReagentSelectedView instance) {
		log.debug("finding ReagentSelectedView instance by example");
		try {
			List<ReagentSelectedView> results = (List<ReagentSelectedView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.ReagentSelectedView")
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
