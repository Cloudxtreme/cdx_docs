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
 * Home object for domain model class WorkflowItemLookupR.
 * @see com.cardiodx.db.waban.table.WorkflowItemLookupR
 * @author Hibernate Tools
 */
public class WorkflowItemLookupRHome {

	private static final Log log = LogFactory
			.getLog(WorkflowItemLookupRHome.class);

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

	public void persist(WorkflowItemLookupR transientInstance) {
		log.debug("persisting WorkflowItemLookupR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(WorkflowItemLookupR instance) {
		log.debug("attaching dirty WorkflowItemLookupR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(WorkflowItemLookupR instance) {
		log.debug("attaching clean WorkflowItemLookupR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(WorkflowItemLookupR persistentInstance) {
		log.debug("deleting WorkflowItemLookupR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public WorkflowItemLookupR merge(WorkflowItemLookupR detachedInstance) {
		log.debug("merging WorkflowItemLookupR instance");
		try {
			WorkflowItemLookupR result = (WorkflowItemLookupR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public WorkflowItemLookupR findById(
			com.cardiodx.db.waban.table.WorkflowItemLookupRId id) {
		log.debug("getting WorkflowItemLookupR instance with id: " + id);
		try {
			WorkflowItemLookupR instance = (WorkflowItemLookupR) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.WorkflowItemLookupR",
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

	public List<WorkflowItemLookupR> findByExample(WorkflowItemLookupR instance) {
		log.debug("finding WorkflowItemLookupR instance by example");
		try {
			List<WorkflowItemLookupR> results = (List<WorkflowItemLookupR>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.WorkflowItemLookupR")
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
