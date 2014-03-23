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
 * Home object for domain model class WorkflowNodeLookupR.
 * @see com.cardiodx.db.waban.table.WorkflowNodeLookupR
 * @author Hibernate Tools
 */
public class WorkflowNodeLookupRHome {

	private static final Log log = LogFactory
			.getLog(WorkflowNodeLookupRHome.class);

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

	public void persist(WorkflowNodeLookupR transientInstance) {
		log.debug("persisting WorkflowNodeLookupR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(WorkflowNodeLookupR instance) {
		log.debug("attaching dirty WorkflowNodeLookupR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(WorkflowNodeLookupR instance) {
		log.debug("attaching clean WorkflowNodeLookupR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(WorkflowNodeLookupR persistentInstance) {
		log.debug("deleting WorkflowNodeLookupR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public WorkflowNodeLookupR merge(WorkflowNodeLookupR detachedInstance) {
		log.debug("merging WorkflowNodeLookupR instance");
		try {
			WorkflowNodeLookupR result = (WorkflowNodeLookupR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public WorkflowNodeLookupR findById(
			com.cardiodx.db.waban.table.WorkflowNodeLookupRId id) {
		log.debug("getting WorkflowNodeLookupR instance with id: " + id);
		try {
			WorkflowNodeLookupR instance = (WorkflowNodeLookupR) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.WorkflowNodeLookupR",
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

	public List<WorkflowNodeLookupR> findByExample(WorkflowNodeLookupR instance) {
		log.debug("finding WorkflowNodeLookupR instance by example");
		try {
			List<WorkflowNodeLookupR> results = (List<WorkflowNodeLookupR>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.WorkflowNodeLookupR")
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
