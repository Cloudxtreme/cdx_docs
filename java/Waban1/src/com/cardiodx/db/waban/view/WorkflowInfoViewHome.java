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
 * Home object for domain model class WorkflowInfoView.
 * @see com.cardiodx.db.waban.view.WorkflowInfoView
 * @author Hibernate Tools
 */
public class WorkflowInfoViewHome {

	private static final Log log = LogFactory
			.getLog(WorkflowInfoViewHome.class);

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

	public void persist(WorkflowInfoView transientInstance) {
		log.debug("persisting WorkflowInfoView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(WorkflowInfoView instance) {
		log.debug("attaching dirty WorkflowInfoView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(WorkflowInfoView instance) {
		log.debug("attaching clean WorkflowInfoView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(WorkflowInfoView persistentInstance) {
		log.debug("deleting WorkflowInfoView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public WorkflowInfoView merge(WorkflowInfoView detachedInstance) {
		log.debug("merging WorkflowInfoView instance");
		try {
			WorkflowInfoView result = (WorkflowInfoView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public WorkflowInfoView findById(
			com.cardiodx.db.waban.view.WorkflowInfoViewId id) {
		log.debug("getting WorkflowInfoView instance with id: " + id);
		try {
			WorkflowInfoView instance = (WorkflowInfoView) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.WorkflowInfoView", id);
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

	public List<WorkflowInfoView> findByExample(WorkflowInfoView instance) {
		log.debug("finding WorkflowInfoView instance by example");
		try {
			List<WorkflowInfoView> results = (List<WorkflowInfoView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.WorkflowInfoView")
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
