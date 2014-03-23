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
 * Home object for domain model class ConfigAttrDisplayView.
 * @see com.cardiodx.db.waban.view.ConfigAttrDisplayView
 * @author Hibernate Tools
 */
public class ConfigAttrDisplayViewHome {

	private static final Log log = LogFactory
			.getLog(ConfigAttrDisplayViewHome.class);

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

	public void persist(ConfigAttrDisplayView transientInstance) {
		log.debug("persisting ConfigAttrDisplayView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ConfigAttrDisplayView instance) {
		log.debug("attaching dirty ConfigAttrDisplayView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ConfigAttrDisplayView instance) {
		log.debug("attaching clean ConfigAttrDisplayView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ConfigAttrDisplayView persistentInstance) {
		log.debug("deleting ConfigAttrDisplayView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ConfigAttrDisplayView merge(ConfigAttrDisplayView detachedInstance) {
		log.debug("merging ConfigAttrDisplayView instance");
		try {
			ConfigAttrDisplayView result = (ConfigAttrDisplayView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ConfigAttrDisplayView findById(
			com.cardiodx.db.waban.view.ConfigAttrDisplayViewId id) {
		log.debug("getting ConfigAttrDisplayView instance with id: " + id);
		try {
			ConfigAttrDisplayView instance = (ConfigAttrDisplayView) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.ConfigAttrDisplayView",
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

	public List<ConfigAttrDisplayView> findByExample(
			ConfigAttrDisplayView instance) {
		log.debug("finding ConfigAttrDisplayView instance by example");
		try {
			List<ConfigAttrDisplayView> results = (List<ConfigAttrDisplayView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.ConfigAttrDisplayView")
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
