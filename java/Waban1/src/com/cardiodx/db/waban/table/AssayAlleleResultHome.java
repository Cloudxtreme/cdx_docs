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
 * Home object for domain model class AssayAlleleResult.
 * @see com.cardiodx.db.waban.table.AssayAlleleResult
 * @author Hibernate Tools
 */
public class AssayAlleleResultHome {

	private static final Log log = LogFactory
			.getLog(AssayAlleleResultHome.class);

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

	public void persist(AssayAlleleResult transientInstance) {
		log.debug("persisting AssayAlleleResult instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AssayAlleleResult instance) {
		log.debug("attaching dirty AssayAlleleResult instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AssayAlleleResult instance) {
		log.debug("attaching clean AssayAlleleResult instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AssayAlleleResult persistentInstance) {
		log.debug("deleting AssayAlleleResult instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AssayAlleleResult merge(AssayAlleleResult detachedInstance) {
		log.debug("merging AssayAlleleResult instance");
		try {
			AssayAlleleResult result = (AssayAlleleResult) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AssayAlleleResult findById(
			com.cardiodx.db.waban.table.AssayAlleleResultId id) {
		log.debug("getting AssayAlleleResult instance with id: " + id);
		try {
			AssayAlleleResult instance = (AssayAlleleResult) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.table.AssayAlleleResult", id);
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

	public List<AssayAlleleResult> findByExample(AssayAlleleResult instance) {
		log.debug("finding AssayAlleleResult instance by example");
		try {
			List<AssayAlleleResult> results = (List<AssayAlleleResult>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.AssayAlleleResult")
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
