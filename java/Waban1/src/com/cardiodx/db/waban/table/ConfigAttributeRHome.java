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
 * Home object for domain model class ConfigAttributeR.
 * @see com.cardiodx.db.waban.table.ConfigAttributeR
 * @author Hibernate Tools
 */
public class ConfigAttributeRHome {

	private static final Log log = LogFactory
			.getLog(ConfigAttributeRHome.class);

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

	public void persist(ConfigAttributeR transientInstance) {
		log.debug("persisting ConfigAttributeR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ConfigAttributeR instance) {
		log.debug("attaching dirty ConfigAttributeR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ConfigAttributeR instance) {
		log.debug("attaching clean ConfigAttributeR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ConfigAttributeR persistentInstance) {
		log.debug("deleting ConfigAttributeR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ConfigAttributeR merge(ConfigAttributeR detachedInstance) {
		log.debug("merging ConfigAttributeR instance");
		try {
			ConfigAttributeR result = (ConfigAttributeR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ConfigAttributeR findById(
			com.cardiodx.db.waban.table.ConfigAttributeRId id) {
		log.debug("getting ConfigAttributeR instance with id: " + id);
		try {
			ConfigAttributeR instance = (ConfigAttributeR) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.ConfigAttributeR", id);
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

	public List<ConfigAttributeR> findByExample(ConfigAttributeR instance) {
		log.debug("finding ConfigAttributeR instance by example");
		try {
			List<ConfigAttributeR> results = (List<ConfigAttributeR>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.ConfigAttributeR")
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
