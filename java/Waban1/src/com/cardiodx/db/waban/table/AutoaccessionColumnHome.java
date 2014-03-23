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
 * Home object for domain model class AutoaccessionColumn.
 * @see com.cardiodx.db.waban.table.AutoaccessionColumn
 * @author Hibernate Tools
 */
public class AutoaccessionColumnHome {

	private static final Log log = LogFactory
			.getLog(AutoaccessionColumnHome.class);

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

	public void persist(AutoaccessionColumn transientInstance) {
		log.debug("persisting AutoaccessionColumn instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AutoaccessionColumn instance) {
		log.debug("attaching dirty AutoaccessionColumn instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AutoaccessionColumn instance) {
		log.debug("attaching clean AutoaccessionColumn instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AutoaccessionColumn persistentInstance) {
		log.debug("deleting AutoaccessionColumn instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AutoaccessionColumn merge(AutoaccessionColumn detachedInstance) {
		log.debug("merging AutoaccessionColumn instance");
		try {
			AutoaccessionColumn result = (AutoaccessionColumn) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AutoaccessionColumn findById(
			com.cardiodx.db.waban.table.AutoaccessionColumnId id) {
		log.debug("getting AutoaccessionColumn instance with id: " + id);
		try {
			AutoaccessionColumn instance = (AutoaccessionColumn) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.AutoaccessionColumn",
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

	public List<AutoaccessionColumn> findByExample(AutoaccessionColumn instance) {
		log.debug("finding AutoaccessionColumn instance by example");
		try {
			List<AutoaccessionColumn> results = (List<AutoaccessionColumn>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.AutoaccessionColumn")
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
