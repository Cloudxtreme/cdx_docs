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
 * Home object for domain model class ChecklistSample.
 * @see com.cardiodx.db.waban.table.ChecklistSample
 * @author Hibernate Tools
 */
public class ChecklistSampleHome {

	private static final Log log = LogFactory.getLog(ChecklistSampleHome.class);

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

	public void persist(ChecklistSample transientInstance) {
		log.debug("persisting ChecklistSample instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ChecklistSample instance) {
		log.debug("attaching dirty ChecklistSample instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ChecklistSample instance) {
		log.debug("attaching clean ChecklistSample instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ChecklistSample persistentInstance) {
		log.debug("deleting ChecklistSample instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ChecklistSample merge(ChecklistSample detachedInstance) {
		log.debug("merging ChecklistSample instance");
		try {
			ChecklistSample result = (ChecklistSample) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ChecklistSample findById(
			com.cardiodx.db.waban.table.ChecklistSampleId id) {
		log.debug("getting ChecklistSample instance with id: " + id);
		try {
			ChecklistSample instance = (ChecklistSample) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.ChecklistSample", id);
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

	public List<ChecklistSample> findByExample(ChecklistSample instance) {
		log.debug("finding ChecklistSample instance by example");
		try {
			List<ChecklistSample> results = (List<ChecklistSample>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.ChecklistSample")
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
