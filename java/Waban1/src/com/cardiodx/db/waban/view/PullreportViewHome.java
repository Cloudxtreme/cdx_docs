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
 * Home object for domain model class PullreportView.
 * @see com.cardiodx.db.waban.view.PullreportView
 * @author Hibernate Tools
 */
public class PullreportViewHome {

	private static final Log log = LogFactory.getLog(PullreportViewHome.class);

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

	public void persist(PullreportView transientInstance) {
		log.debug("persisting PullreportView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(PullreportView instance) {
		log.debug("attaching dirty PullreportView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PullreportView instance) {
		log.debug("attaching clean PullreportView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(PullreportView persistentInstance) {
		log.debug("deleting PullreportView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PullreportView merge(PullreportView detachedInstance) {
		log.debug("merging PullreportView instance");
		try {
			PullreportView result = (PullreportView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public PullreportView findById(
			com.cardiodx.db.waban.view.PullreportViewId id) {
		log.debug("getting PullreportView instance with id: " + id);
		try {
			PullreportView instance = (PullreportView) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.PullreportView", id);
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

	public List<PullreportView> findByExample(PullreportView instance) {
		log.debug("finding PullreportView instance by example");
		try {
			List<PullreportView> results = (List<PullreportView>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.view.PullreportView")
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
