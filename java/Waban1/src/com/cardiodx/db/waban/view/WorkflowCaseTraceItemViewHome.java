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
 * Home object for domain model class WorkflowCaseTraceItemView.
 * @see com.cardiodx.db.waban.view.WorkflowCaseTraceItemView
 * @author Hibernate Tools
 */
public class WorkflowCaseTraceItemViewHome {

	private static final Log log = LogFactory
			.getLog(WorkflowCaseTraceItemViewHome.class);

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

	public void persist(WorkflowCaseTraceItemView transientInstance) {
		log.debug("persisting WorkflowCaseTraceItemView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(WorkflowCaseTraceItemView instance) {
		log.debug("attaching dirty WorkflowCaseTraceItemView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(WorkflowCaseTraceItemView instance) {
		log.debug("attaching clean WorkflowCaseTraceItemView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(WorkflowCaseTraceItemView persistentInstance) {
		log.debug("deleting WorkflowCaseTraceItemView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public WorkflowCaseTraceItemView merge(
			WorkflowCaseTraceItemView detachedInstance) {
		log.debug("merging WorkflowCaseTraceItemView instance");
		try {
			WorkflowCaseTraceItemView result = (WorkflowCaseTraceItemView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public WorkflowCaseTraceItemView findById(
			com.cardiodx.db.waban.view.WorkflowCaseTraceItemViewId id) {
		log.debug("getting WorkflowCaseTraceItemView instance with id: " + id);
		try {
			WorkflowCaseTraceItemView instance = (WorkflowCaseTraceItemView) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.view.WorkflowCaseTraceItemView",
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

	public List<WorkflowCaseTraceItemView> findByExample(
			WorkflowCaseTraceItemView instance) {
		log.debug("finding WorkflowCaseTraceItemView instance by example");
		try {
			List<WorkflowCaseTraceItemView> results = (List<WorkflowCaseTraceItemView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.WorkflowCaseTraceItemView")
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
