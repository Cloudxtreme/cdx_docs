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
 * Home object for domain model class ChecklistStepsView.
 * @see com.cardiodx.db.waban.view.ChecklistStepsView
 * @author Hibernate Tools
 */
public class ChecklistStepsViewHome {

	private static final Log log = LogFactory
			.getLog(ChecklistStepsViewHome.class);

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

	public void persist(ChecklistStepsView transientInstance) {
		log.debug("persisting ChecklistStepsView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ChecklistStepsView instance) {
		log.debug("attaching dirty ChecklistStepsView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ChecklistStepsView instance) {
		log.debug("attaching clean ChecklistStepsView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ChecklistStepsView persistentInstance) {
		log.debug("deleting ChecklistStepsView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ChecklistStepsView merge(ChecklistStepsView detachedInstance) {
		log.debug("merging ChecklistStepsView instance");
		try {
			ChecklistStepsView result = (ChecklistStepsView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ChecklistStepsView findById(
			com.cardiodx.db.waban.view.ChecklistStepsViewId id) {
		log.debug("getting ChecklistStepsView instance with id: " + id);
		try {
			ChecklistStepsView instance = (ChecklistStepsView) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.view.ChecklistStepsView", id);
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

	public List<ChecklistStepsView> findByExample(ChecklistStepsView instance) {
		log.debug("finding ChecklistStepsView instance by example");
		try {
			List<ChecklistStepsView> results = (List<ChecklistStepsView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.ChecklistStepsView")
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
