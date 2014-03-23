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
 * Home object for domain model class AssayResultLoadR.
 * @see com.cardiodx.db.waban.table.AssayResultLoadR
 * @author Hibernate Tools
 */
public class AssayResultLoadRHome {

	private static final Log log = LogFactory
			.getLog(AssayResultLoadRHome.class);

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

	public void persist(AssayResultLoadR transientInstance) {
		log.debug("persisting AssayResultLoadR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AssayResultLoadR instance) {
		log.debug("attaching dirty AssayResultLoadR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AssayResultLoadR instance) {
		log.debug("attaching clean AssayResultLoadR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AssayResultLoadR persistentInstance) {
		log.debug("deleting AssayResultLoadR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AssayResultLoadR merge(AssayResultLoadR detachedInstance) {
		log.debug("merging AssayResultLoadR instance");
		try {
			AssayResultLoadR result = (AssayResultLoadR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AssayResultLoadR findById(
			com.cardiodx.db.waban.table.AssayResultLoadRId id) {
		log.debug("getting AssayResultLoadR instance with id: " + id);
		try {
			AssayResultLoadR instance = (AssayResultLoadR) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.AssayResultLoadR", id);
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

	public List<AssayResultLoadR> findByExample(AssayResultLoadR instance) {
		log.debug("finding AssayResultLoadR instance by example");
		try {
			List<AssayResultLoadR> results = (List<AssayResultLoadR>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.AssayResultLoadR")
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
