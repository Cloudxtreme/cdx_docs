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
 * Home object for domain model class CrossMatchOutputR.
 * @see com.cardiodx.db.waban.table.CrossMatchOutputR
 * @author Hibernate Tools
 */
public class CrossMatchOutputRHome {

	private static final Log log = LogFactory
			.getLog(CrossMatchOutputRHome.class);

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

	public void persist(CrossMatchOutputR transientInstance) {
		log.debug("persisting CrossMatchOutputR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(CrossMatchOutputR instance) {
		log.debug("attaching dirty CrossMatchOutputR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CrossMatchOutputR instance) {
		log.debug("attaching clean CrossMatchOutputR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(CrossMatchOutputR persistentInstance) {
		log.debug("deleting CrossMatchOutputR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CrossMatchOutputR merge(CrossMatchOutputR detachedInstance) {
		log.debug("merging CrossMatchOutputR instance");
		try {
			CrossMatchOutputR result = (CrossMatchOutputR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public CrossMatchOutputR findById(
			com.cardiodx.db.waban.table.CrossMatchOutputRId id) {
		log.debug("getting CrossMatchOutputR instance with id: " + id);
		try {
			CrossMatchOutputR instance = (CrossMatchOutputR) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.table.CrossMatchOutputR", id);
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

	public List<CrossMatchOutputR> findByExample(CrossMatchOutputR instance) {
		log.debug("finding CrossMatchOutputR instance by example");
		try {
			List<CrossMatchOutputR> results = (List<CrossMatchOutputR>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.CrossMatchOutputR")
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
