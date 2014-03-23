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
 * Home object for domain model class WorkflowCaseSeqItemView.
 * @see com.cardiodx.db.waban.view.WorkflowCaseSeqItemView
 * @author Hibernate Tools
 */
public class WorkflowCaseSeqItemViewHome {

	private static final Log log = LogFactory
			.getLog(WorkflowCaseSeqItemViewHome.class);

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

	public void persist(WorkflowCaseSeqItemView transientInstance) {
		log.debug("persisting WorkflowCaseSeqItemView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(WorkflowCaseSeqItemView instance) {
		log.debug("attaching dirty WorkflowCaseSeqItemView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(WorkflowCaseSeqItemView instance) {
		log.debug("attaching clean WorkflowCaseSeqItemView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(WorkflowCaseSeqItemView persistentInstance) {
		log.debug("deleting WorkflowCaseSeqItemView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public WorkflowCaseSeqItemView merge(
			WorkflowCaseSeqItemView detachedInstance) {
		log.debug("merging WorkflowCaseSeqItemView instance");
		try {
			WorkflowCaseSeqItemView result = (WorkflowCaseSeqItemView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public WorkflowCaseSeqItemView findById(
			com.cardiodx.db.waban.view.WorkflowCaseSeqItemViewId id) {
		log.debug("getting WorkflowCaseSeqItemView instance with id: " + id);
		try {
			WorkflowCaseSeqItemView instance = (WorkflowCaseSeqItemView) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.view.WorkflowCaseSeqItemView",
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

	public List<WorkflowCaseSeqItemView> findByExample(
			WorkflowCaseSeqItemView instance) {
		log.debug("finding WorkflowCaseSeqItemView instance by example");
		try {
			List<WorkflowCaseSeqItemView> results = (List<WorkflowCaseSeqItemView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.WorkflowCaseSeqItemView")
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
