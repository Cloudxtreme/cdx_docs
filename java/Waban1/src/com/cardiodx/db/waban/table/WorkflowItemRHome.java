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
 * Home object for domain model class WorkflowItemR.
 * @see com.cardiodx.db.waban.table.WorkflowItemR
 * @author Hibernate Tools
 */
public class WorkflowItemRHome {

	private static final Log log = LogFactory.getLog(WorkflowItemRHome.class);

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

	public void persist(WorkflowItemR transientInstance) {
		log.debug("persisting WorkflowItemR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(WorkflowItemR instance) {
		log.debug("attaching dirty WorkflowItemR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(WorkflowItemR instance) {
		log.debug("attaching clean WorkflowItemR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(WorkflowItemR persistentInstance) {
		log.debug("deleting WorkflowItemR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public WorkflowItemR merge(WorkflowItemR detachedInstance) {
		log.debug("merging WorkflowItemR instance");
		try {
			WorkflowItemR result = (WorkflowItemR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public WorkflowItemR findById(com.cardiodx.db.waban.table.WorkflowItemRId id) {
		log.debug("getting WorkflowItemR instance with id: " + id);
		try {
			WorkflowItemR instance = (WorkflowItemR) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.WorkflowItemR", id);
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

	public List<WorkflowItemR> findByExample(WorkflowItemR instance) {
		log.debug("finding WorkflowItemR instance by example");
		try {
			List<WorkflowItemR> results = (List<WorkflowItemR>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.table.WorkflowItemR")
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
