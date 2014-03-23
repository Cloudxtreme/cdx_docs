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
 * Home object for domain model class WorkflowDataLookup.
 * @see com.cardiodx.db.waban.table.WorkflowDataLookup
 * @author Hibernate Tools
 */
public class WorkflowDataLookupHome {

	private static final Log log = LogFactory
			.getLog(WorkflowDataLookupHome.class);

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

	public void persist(WorkflowDataLookup transientInstance) {
		log.debug("persisting WorkflowDataLookup instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(WorkflowDataLookup instance) {
		log.debug("attaching dirty WorkflowDataLookup instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(WorkflowDataLookup instance) {
		log.debug("attaching clean WorkflowDataLookup instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(WorkflowDataLookup persistentInstance) {
		log.debug("deleting WorkflowDataLookup instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public WorkflowDataLookup merge(WorkflowDataLookup detachedInstance) {
		log.debug("merging WorkflowDataLookup instance");
		try {
			WorkflowDataLookup result = (WorkflowDataLookup) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public WorkflowDataLookup findById(java.lang.String id) {
		log.debug("getting WorkflowDataLookup instance with id: " + id);
		try {
			WorkflowDataLookup instance = (WorkflowDataLookup) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.WorkflowDataLookup",
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

	public List<WorkflowDataLookup> findByExample(WorkflowDataLookup instance) {
		log.debug("finding WorkflowDataLookup instance by example");
		try {
			List<WorkflowDataLookup> results = (List<WorkflowDataLookup>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.WorkflowDataLookup")
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
