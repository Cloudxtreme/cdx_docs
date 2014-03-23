package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:46 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class WorkflowSubWorkflow.
 * @see com.cardiodx.db.waban.table.WorkflowSubWorkflow
 * @author Hibernate Tools
 */
public class WorkflowSubWorkflowHome {

	private static final Log log = LogFactory
			.getLog(WorkflowSubWorkflowHome.class);

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

	public void persist(WorkflowSubWorkflow transientInstance) {
		log.debug("persisting WorkflowSubWorkflow instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(WorkflowSubWorkflow instance) {
		log.debug("attaching dirty WorkflowSubWorkflow instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(WorkflowSubWorkflow instance) {
		log.debug("attaching clean WorkflowSubWorkflow instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(WorkflowSubWorkflow persistentInstance) {
		log.debug("deleting WorkflowSubWorkflow instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public WorkflowSubWorkflow merge(WorkflowSubWorkflow detachedInstance) {
		log.debug("merging WorkflowSubWorkflow instance");
		try {
			WorkflowSubWorkflow result = (WorkflowSubWorkflow) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public WorkflowSubWorkflow findById(
			com.cardiodx.db.waban.table.WorkflowSubWorkflowId id) {
		log.debug("getting WorkflowSubWorkflow instance with id: " + id);
		try {
			WorkflowSubWorkflow instance = (WorkflowSubWorkflow) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.WorkflowSubWorkflow",
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

	public List<WorkflowSubWorkflow> findByExample(WorkflowSubWorkflow instance) {
		log.debug("finding WorkflowSubWorkflow instance by example");
		try {
			List<WorkflowSubWorkflow> results = (List<WorkflowSubWorkflow>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.WorkflowSubWorkflow")
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
