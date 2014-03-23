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
 * Home object for domain model class WorkflowNodeData.
 * @see com.cardiodx.db.waban.table.WorkflowNodeData
 * @author Hibernate Tools
 */
public class WorkflowNodeDataHome {

	private static final Log log = LogFactory
			.getLog(WorkflowNodeDataHome.class);

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

	public void persist(WorkflowNodeData transientInstance) {
		log.debug("persisting WorkflowNodeData instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(WorkflowNodeData instance) {
		log.debug("attaching dirty WorkflowNodeData instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(WorkflowNodeData instance) {
		log.debug("attaching clean WorkflowNodeData instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(WorkflowNodeData persistentInstance) {
		log.debug("deleting WorkflowNodeData instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public WorkflowNodeData merge(WorkflowNodeData detachedInstance) {
		log.debug("merging WorkflowNodeData instance");
		try {
			WorkflowNodeData result = (WorkflowNodeData) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public WorkflowNodeData findById(
			com.cardiodx.db.waban.table.WorkflowNodeDataId id) {
		log.debug("getting WorkflowNodeData instance with id: " + id);
		try {
			WorkflowNodeData instance = (WorkflowNodeData) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.WorkflowNodeData", id);
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

	public List<WorkflowNodeData> findByExample(WorkflowNodeData instance) {
		log.debug("finding WorkflowNodeData instance by example");
		try {
			List<WorkflowNodeData> results = (List<WorkflowNodeData>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.WorkflowNodeData")
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
