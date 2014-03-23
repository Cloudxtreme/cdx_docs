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
 * Home object for domain model class WorkflowSampleItemView.
 * @see com.cardiodx.db.waban.view.WorkflowSampleItemView
 * @author Hibernate Tools
 */
public class WorkflowSampleItemViewHome {

	private static final Log log = LogFactory
			.getLog(WorkflowSampleItemViewHome.class);

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

	public void persist(WorkflowSampleItemView transientInstance) {
		log.debug("persisting WorkflowSampleItemView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(WorkflowSampleItemView instance) {
		log.debug("attaching dirty WorkflowSampleItemView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(WorkflowSampleItemView instance) {
		log.debug("attaching clean WorkflowSampleItemView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(WorkflowSampleItemView persistentInstance) {
		log.debug("deleting WorkflowSampleItemView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public WorkflowSampleItemView merge(WorkflowSampleItemView detachedInstance) {
		log.debug("merging WorkflowSampleItemView instance");
		try {
			WorkflowSampleItemView result = (WorkflowSampleItemView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public WorkflowSampleItemView findById(
			com.cardiodx.db.waban.view.WorkflowSampleItemViewId id) {
		log.debug("getting WorkflowSampleItemView instance with id: " + id);
		try {
			WorkflowSampleItemView instance = (WorkflowSampleItemView) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.view.WorkflowSampleItemView",
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

	public List<WorkflowSampleItemView> findByExample(
			WorkflowSampleItemView instance) {
		log.debug("finding WorkflowSampleItemView instance by example");
		try {
			List<WorkflowSampleItemView> results = (List<WorkflowSampleItemView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.WorkflowSampleItemView")
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
