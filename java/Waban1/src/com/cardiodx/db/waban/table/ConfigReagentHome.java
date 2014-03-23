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
 * Home object for domain model class ConfigReagent.
 * @see com.cardiodx.db.waban.table.ConfigReagent
 * @author Hibernate Tools
 */
public class ConfigReagentHome {

	private static final Log log = LogFactory.getLog(ConfigReagentHome.class);

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

	public void persist(ConfigReagent transientInstance) {
		log.debug("persisting ConfigReagent instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ConfigReagent instance) {
		log.debug("attaching dirty ConfigReagent instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ConfigReagent instance) {
		log.debug("attaching clean ConfigReagent instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ConfigReagent persistentInstance) {
		log.debug("deleting ConfigReagent instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ConfigReagent merge(ConfigReagent detachedInstance) {
		log.debug("merging ConfigReagent instance");
		try {
			ConfigReagent result = (ConfigReagent) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ConfigReagent findById(java.math.BigDecimal id) {
		log.debug("getting ConfigReagent instance with id: " + id);
		try {
			ConfigReagent instance = (ConfigReagent) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.ConfigReagent", id);
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

	public List<ConfigReagent> findByExample(ConfigReagent instance) {
		log.debug("finding ConfigReagent instance by example");
		try {
			List<ConfigReagent> results = (List<ConfigReagent>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.table.ConfigReagent")
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
