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
 * Home object for domain model class WorklistR.
 * @see com.cardiodx.db.waban.table.WorklistR
 * @author Hibernate Tools
 */
public class WorklistRHome {

	private static final Log log = LogFactory.getLog(WorklistRHome.class);

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

	public void persist(WorklistR transientInstance) {
		log.debug("persisting WorklistR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(WorklistR instance) {
		log.debug("attaching dirty WorklistR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(WorklistR instance) {
		log.debug("attaching clean WorklistR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(WorklistR persistentInstance) {
		log.debug("deleting WorklistR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public WorklistR merge(WorklistR detachedInstance) {
		log.debug("merging WorklistR instance");
		try {
			WorklistR result = (WorklistR) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public WorklistR findById(com.cardiodx.db.waban.table.WorklistRId id) {
		log.debug("getting WorklistR instance with id: " + id);
		try {
			WorklistR instance = (WorklistR) sessionFactory.getCurrentSession()
					.get("com.cardiodx.db.waban.table.WorklistR", id);
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

	public List<WorklistR> findByExample(WorklistR instance) {
		log.debug("finding WorklistR instance by example");
		try {
			List<WorklistR> results = (List<WorklistR>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.table.WorklistR")
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
