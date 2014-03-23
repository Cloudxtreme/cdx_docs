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
 * Home object for domain model class AutoaccessionLoadR.
 * @see com.cardiodx.db.waban.table.AutoaccessionLoadR
 * @author Hibernate Tools
 */
public class AutoaccessionLoadRHome {

	private static final Log log = LogFactory
			.getLog(AutoaccessionLoadRHome.class);

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

	public void persist(AutoaccessionLoadR transientInstance) {
		log.debug("persisting AutoaccessionLoadR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AutoaccessionLoadR instance) {
		log.debug("attaching dirty AutoaccessionLoadR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AutoaccessionLoadR instance) {
		log.debug("attaching clean AutoaccessionLoadR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AutoaccessionLoadR persistentInstance) {
		log.debug("deleting AutoaccessionLoadR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AutoaccessionLoadR merge(AutoaccessionLoadR detachedInstance) {
		log.debug("merging AutoaccessionLoadR instance");
		try {
			AutoaccessionLoadR result = (AutoaccessionLoadR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AutoaccessionLoadR findById(
			com.cardiodx.db.waban.table.AutoaccessionLoadRId id) {
		log.debug("getting AutoaccessionLoadR instance with id: " + id);
		try {
			AutoaccessionLoadR instance = (AutoaccessionLoadR) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.AutoaccessionLoadR",
							id);
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

	public List<AutoaccessionLoadR> findByExample(AutoaccessionLoadR instance) {
		log.debug("finding AutoaccessionLoadR instance by example");
		try {
			List<AutoaccessionLoadR> results = (List<AutoaccessionLoadR>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.AutoaccessionLoadR")
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
