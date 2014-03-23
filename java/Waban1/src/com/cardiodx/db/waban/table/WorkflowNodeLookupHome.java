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
 * Home object for domain model class WorkflowNodeLookup.
 * @see com.cardiodx.db.waban.table.WorkflowNodeLookup
 * @author Hibernate Tools
 */
public class WorkflowNodeLookupHome {

	private static final Log log = LogFactory
			.getLog(WorkflowNodeLookupHome.class);

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

	public void persist(WorkflowNodeLookup transientInstance) {
		log.debug("persisting WorkflowNodeLookup instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(WorkflowNodeLookup instance) {
		log.debug("attaching dirty WorkflowNodeLookup instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(WorkflowNodeLookup instance) {
		log.debug("attaching clean WorkflowNodeLookup instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(WorkflowNodeLookup persistentInstance) {
		log.debug("deleting WorkflowNodeLookup instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public WorkflowNodeLookup merge(WorkflowNodeLookup detachedInstance) {
		log.debug("merging WorkflowNodeLookup instance");
		try {
			WorkflowNodeLookup result = (WorkflowNodeLookup) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public WorkflowNodeLookup findById(java.lang.String id) {
		log.debug("getting WorkflowNodeLookup instance with id: " + id);
		try {
			WorkflowNodeLookup instance = (WorkflowNodeLookup) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.WorkflowNodeLookup",
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

	public List<WorkflowNodeLookup> findByExample(WorkflowNodeLookup instance) {
		log.debug("finding WorkflowNodeLookup instance by example");
		try {
			List<WorkflowNodeLookup> results = (List<WorkflowNodeLookup>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.WorkflowNodeLookup")
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
