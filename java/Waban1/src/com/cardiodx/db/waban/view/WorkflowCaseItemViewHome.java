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
 * Home object for domain model class WorkflowCaseItemView.
 * @see com.cardiodx.db.waban.view.WorkflowCaseItemView
 * @author Hibernate Tools
 */
public class WorkflowCaseItemViewHome {

	private static final Log log = LogFactory
			.getLog(WorkflowCaseItemViewHome.class);

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

	public void persist(WorkflowCaseItemView transientInstance) {
		log.debug("persisting WorkflowCaseItemView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(WorkflowCaseItemView instance) {
		log.debug("attaching dirty WorkflowCaseItemView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(WorkflowCaseItemView instance) {
		log.debug("attaching clean WorkflowCaseItemView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(WorkflowCaseItemView persistentInstance) {
		log.debug("deleting WorkflowCaseItemView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public WorkflowCaseItemView merge(WorkflowCaseItemView detachedInstance) {
		log.debug("merging WorkflowCaseItemView instance");
		try {
			WorkflowCaseItemView result = (WorkflowCaseItemView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public WorkflowCaseItemView findById(
			com.cardiodx.db.waban.view.WorkflowCaseItemViewId id) {
		log.debug("getting WorkflowCaseItemView instance with id: " + id);
		try {
			WorkflowCaseItemView instance = (WorkflowCaseItemView) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.WorkflowCaseItemView",
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

	public List<WorkflowCaseItemView> findByExample(
			WorkflowCaseItemView instance) {
		log.debug("finding WorkflowCaseItemView instance by example");
		try {
			List<WorkflowCaseItemView> results = (List<WorkflowCaseItemView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.WorkflowCaseItemView")
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
