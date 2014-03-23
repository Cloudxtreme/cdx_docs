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
 * Home object for domain model class WorkflowNodeR.
 * @see com.cardiodx.db.waban.table.WorkflowNodeR
 * @author Hibernate Tools
 */
public class WorkflowNodeRHome {

	private static final Log log = LogFactory.getLog(WorkflowNodeRHome.class);

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

	public void persist(WorkflowNodeR transientInstance) {
		log.debug("persisting WorkflowNodeR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(WorkflowNodeR instance) {
		log.debug("attaching dirty WorkflowNodeR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(WorkflowNodeR instance) {
		log.debug("attaching clean WorkflowNodeR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(WorkflowNodeR persistentInstance) {
		log.debug("deleting WorkflowNodeR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public WorkflowNodeR merge(WorkflowNodeR detachedInstance) {
		log.debug("merging WorkflowNodeR instance");
		try {
			WorkflowNodeR result = (WorkflowNodeR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public WorkflowNodeR findById(com.cardiodx.db.waban.table.WorkflowNodeRId id) {
		log.debug("getting WorkflowNodeR instance with id: " + id);
		try {
			WorkflowNodeR instance = (WorkflowNodeR) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.WorkflowNodeR", id);
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

	public List<WorkflowNodeR> findByExample(WorkflowNodeR instance) {
		log.debug("finding WorkflowNodeR instance by example");
		try {
			List<WorkflowNodeR> results = (List<WorkflowNodeR>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.table.WorkflowNodeR")
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
