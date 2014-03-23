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
 * Home object for domain model class WorkflowStepR.
 * @see com.cardiodx.db.waban.table.WorkflowStepR
 * @author Hibernate Tools
 */
public class WorkflowStepRHome {

	private static final Log log = LogFactory.getLog(WorkflowStepRHome.class);

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

	public void persist(WorkflowStepR transientInstance) {
		log.debug("persisting WorkflowStepR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(WorkflowStepR instance) {
		log.debug("attaching dirty WorkflowStepR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(WorkflowStepR instance) {
		log.debug("attaching clean WorkflowStepR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(WorkflowStepR persistentInstance) {
		log.debug("deleting WorkflowStepR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public WorkflowStepR merge(WorkflowStepR detachedInstance) {
		log.debug("merging WorkflowStepR instance");
		try {
			WorkflowStepR result = (WorkflowStepR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public WorkflowStepR findById(com.cardiodx.db.waban.table.WorkflowStepRId id) {
		log.debug("getting WorkflowStepR instance with id: " + id);
		try {
			WorkflowStepR instance = (WorkflowStepR) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.WorkflowStepR", id);
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

	public List<WorkflowStepR> findByExample(WorkflowStepR instance) {
		log.debug("finding WorkflowStepR instance by example");
		try {
			List<WorkflowStepR> results = (List<WorkflowStepR>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.table.WorkflowStepR")
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
