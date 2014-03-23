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
 * Home object for domain model class PcrRobotscriptSourceView.
 * @see com.cardiodx.db.waban.view.PcrRobotscriptSourceView
 * @author Hibernate Tools
 */
public class PcrRobotscriptSourceViewHome {

	private static final Log log = LogFactory
			.getLog(PcrRobotscriptSourceViewHome.class);

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

	public void persist(PcrRobotscriptSourceView transientInstance) {
		log.debug("persisting PcrRobotscriptSourceView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(PcrRobotscriptSourceView instance) {
		log.debug("attaching dirty PcrRobotscriptSourceView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PcrRobotscriptSourceView instance) {
		log.debug("attaching clean PcrRobotscriptSourceView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(PcrRobotscriptSourceView persistentInstance) {
		log.debug("deleting PcrRobotscriptSourceView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PcrRobotscriptSourceView merge(
			PcrRobotscriptSourceView detachedInstance) {
		log.debug("merging PcrRobotscriptSourceView instance");
		try {
			PcrRobotscriptSourceView result = (PcrRobotscriptSourceView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public PcrRobotscriptSourceView findById(
			com.cardiodx.db.waban.view.PcrRobotscriptSourceViewId id) {
		log.debug("getting PcrRobotscriptSourceView instance with id: " + id);
		try {
			PcrRobotscriptSourceView instance = (PcrRobotscriptSourceView) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.view.PcrRobotscriptSourceView",
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

	public List<PcrRobotscriptSourceView> findByExample(
			PcrRobotscriptSourceView instance) {
		log.debug("finding PcrRobotscriptSourceView instance by example");
		try {
			List<PcrRobotscriptSourceView> results = (List<PcrRobotscriptSourceView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.PcrRobotscriptSourceView")
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
