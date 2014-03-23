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
 * Home object for domain model class WorkflowItemLookup.
 * @see com.cardiodx.db.waban.table.WorkflowItemLookup
 * @author Hibernate Tools
 */
public class WorkflowItemLookupHome {

	private static final Log log = LogFactory
			.getLog(WorkflowItemLookupHome.class);

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

	public void persist(WorkflowItemLookup transientInstance) {
		log.debug("persisting WorkflowItemLookup instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(WorkflowItemLookup instance) {
		log.debug("attaching dirty WorkflowItemLookup instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(WorkflowItemLookup instance) {
		log.debug("attaching clean WorkflowItemLookup instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(WorkflowItemLookup persistentInstance) {
		log.debug("deleting WorkflowItemLookup instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public WorkflowItemLookup merge(WorkflowItemLookup detachedInstance) {
		log.debug("merging WorkflowItemLookup instance");
		try {
			WorkflowItemLookup result = (WorkflowItemLookup) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public WorkflowItemLookup findById(java.lang.String id) {
		log.debug("getting WorkflowItemLookup instance with id: " + id);
		try {
			WorkflowItemLookup instance = (WorkflowItemLookup) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.WorkflowItemLookup",
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

	public List<WorkflowItemLookup> findByExample(WorkflowItemLookup instance) {
		log.debug("finding WorkflowItemLookup instance by example");
		try {
			List<WorkflowItemLookup> results = (List<WorkflowItemLookup>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.WorkflowItemLookup")
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
