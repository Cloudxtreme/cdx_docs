package com.cardiodx.db.waban.view;

// Generated Jul 14, 2011 1:33:57 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class ConfigReagentDisplayView.
 * @see com.cardiodx.db.waban.view.ConfigReagentDisplayView
 * @author Hibernate Tools
 */
public class ConfigReagentDisplayViewHome {

	private static final Log log = LogFactory
			.getLog(ConfigReagentDisplayViewHome.class);

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

	public void persist(ConfigReagentDisplayView transientInstance) {
		log.debug("persisting ConfigReagentDisplayView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ConfigReagentDisplayView instance) {
		log.debug("attaching dirty ConfigReagentDisplayView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ConfigReagentDisplayView instance) {
		log.debug("attaching clean ConfigReagentDisplayView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ConfigReagentDisplayView persistentInstance) {
		log.debug("deleting ConfigReagentDisplayView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ConfigReagentDisplayView merge(
			ConfigReagentDisplayView detachedInstance) {
		log.debug("merging ConfigReagentDisplayView instance");
		try {
			ConfigReagentDisplayView result = (ConfigReagentDisplayView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ConfigReagentDisplayView findById(
			com.cardiodx.db.waban.view.ConfigReagentDisplayViewId id) {
		log.debug("getting ConfigReagentDisplayView instance with id: " + id);
		try {
			ConfigReagentDisplayView instance = (ConfigReagentDisplayView) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.view.ConfigReagentDisplayView",
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

	public List<ConfigReagentDisplayView> findByExample(
			ConfigReagentDisplayView instance) {
		log.debug("finding ConfigReagentDisplayView instance by example");
		try {
			List<ConfigReagentDisplayView> results = (List<ConfigReagentDisplayView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.ConfigReagentDisplayView")
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
