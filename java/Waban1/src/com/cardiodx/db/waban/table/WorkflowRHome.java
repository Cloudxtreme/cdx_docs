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
 * Home object for domain model class WorkflowR.
 * @see com.cardiodx.db.waban.table.WorkflowR
 * @author Hibernate Tools
 */
public class WorkflowRHome {

	private static final Log log = LogFactory.getLog(WorkflowRHome.class);

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

	public void persist(WorkflowR transientInstance) {
		log.debug("persisting WorkflowR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(WorkflowR instance) {
		log.debug("attaching dirty WorkflowR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(WorkflowR instance) {
		log.debug("attaching clean WorkflowR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(WorkflowR persistentInstance) {
		log.debug("deleting WorkflowR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public WorkflowR merge(WorkflowR detachedInstance) {
		log.debug("merging WorkflowR instance");
		try {
			WorkflowR result = (WorkflowR) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public WorkflowR findById(com.cardiodx.db.waban.table.WorkflowRId id) {
		log.debug("getting WorkflowR instance with id: " + id);
		try {
			WorkflowR instance = (WorkflowR) sessionFactory.getCurrentSession()
					.get("com.cardiodx.db.waban.table.WorkflowR", id);
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

	public List<WorkflowR> findByExample(WorkflowR instance) {
		log.debug("finding WorkflowR instance by example");
		try {
			List<WorkflowR> results = (List<WorkflowR>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.table.WorkflowR")
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
