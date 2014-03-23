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
 * Home object for domain model class AssemblyLoad.
 * @see com.cardiodx.db.waban.table.AssemblyLoad
 * @author Hibernate Tools
 */
public class AssemblyLoadHome {

	private static final Log log = LogFactory.getLog(AssemblyLoadHome.class);

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

	public void persist(AssemblyLoad transientInstance) {
		log.debug("persisting AssemblyLoad instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AssemblyLoad instance) {
		log.debug("attaching dirty AssemblyLoad instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AssemblyLoad instance) {
		log.debug("attaching clean AssemblyLoad instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AssemblyLoad persistentInstance) {
		log.debug("deleting AssemblyLoad instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AssemblyLoad merge(AssemblyLoad detachedInstance) {
		log.debug("merging AssemblyLoad instance");
		try {
			AssemblyLoad result = (AssemblyLoad) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AssemblyLoad findById(java.math.BigDecimal id) {
		log.debug("getting AssemblyLoad instance with id: " + id);
		try {
			AssemblyLoad instance = (AssemblyLoad) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.AssemblyLoad", id);
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

	public List<AssemblyLoad> findByExample(AssemblyLoad instance) {
		log.debug("finding AssemblyLoad instance by example");
		try {
			List<AssemblyLoad> results = (List<AssemblyLoad>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.table.AssemblyLoad")
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
