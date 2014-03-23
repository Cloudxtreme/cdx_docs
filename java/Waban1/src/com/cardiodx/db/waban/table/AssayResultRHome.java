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
 * Home object for domain model class AssayResultR.
 * @see com.cardiodx.db.waban.table.AssayResultR
 * @author Hibernate Tools
 */
public class AssayResultRHome {

	private static final Log log = LogFactory.getLog(AssayResultRHome.class);

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

	public void persist(AssayResultR transientInstance) {
		log.debug("persisting AssayResultR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AssayResultR instance) {
		log.debug("attaching dirty AssayResultR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AssayResultR instance) {
		log.debug("attaching clean AssayResultR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AssayResultR persistentInstance) {
		log.debug("deleting AssayResultR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AssayResultR merge(AssayResultR detachedInstance) {
		log.debug("merging AssayResultR instance");
		try {
			AssayResultR result = (AssayResultR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AssayResultR findById(com.cardiodx.db.waban.table.AssayResultRId id) {
		log.debug("getting AssayResultR instance with id: " + id);
		try {
			AssayResultR instance = (AssayResultR) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.AssayResultR", id);
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

	public List<AssayResultR> findByExample(AssayResultR instance) {
		log.debug("finding AssayResultR instance by example");
		try {
			List<AssayResultR> results = (List<AssayResultR>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.table.AssayResultR")
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
