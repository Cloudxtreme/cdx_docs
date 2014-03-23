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
 * Home object for domain model class WorkflowTransition.
 * @see com.cardiodx.db.waban.table.WorkflowTransition
 * @author Hibernate Tools
 */
public class WorkflowTransitionHome {

	private static final Log log = LogFactory
			.getLog(WorkflowTransitionHome.class);

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

	public void persist(WorkflowTransition transientInstance) {
		log.debug("persisting WorkflowTransition instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(WorkflowTransition instance) {
		log.debug("attaching dirty WorkflowTransition instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(WorkflowTransition instance) {
		log.debug("attaching clean WorkflowTransition instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(WorkflowTransition persistentInstance) {
		log.debug("deleting WorkflowTransition instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public WorkflowTransition merge(WorkflowTransition detachedInstance) {
		log.debug("merging WorkflowTransition instance");
		try {
			WorkflowTransition result = (WorkflowTransition) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public WorkflowTransition findById(
			com.cardiodx.db.waban.table.WorkflowTransitionId id) {
		log.debug("getting WorkflowTransition instance with id: " + id);
		try {
			WorkflowTransition instance = (WorkflowTransition) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.WorkflowTransition",
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

	public List<WorkflowTransition> findByExample(WorkflowTransition instance) {
		log.debug("finding WorkflowTransition instance by example");
		try {
			List<WorkflowTransition> results = (List<WorkflowTransition>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.WorkflowTransition")
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
