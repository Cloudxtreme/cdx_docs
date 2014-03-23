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
 * Home object for domain model class LoadgelView.
 * @see com.cardiodx.db.waban.view.LoadgelView
 * @author Hibernate Tools
 */
public class LoadgelViewHome {

	private static final Log log = LogFactory.getLog(LoadgelViewHome.class);

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

	public void persist(LoadgelView transientInstance) {
		log.debug("persisting LoadgelView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(LoadgelView instance) {
		log.debug("attaching dirty LoadgelView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(LoadgelView instance) {
		log.debug("attaching clean LoadgelView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(LoadgelView persistentInstance) {
		log.debug("deleting LoadgelView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public LoadgelView merge(LoadgelView detachedInstance) {
		log.debug("merging LoadgelView instance");
		try {
			LoadgelView result = (LoadgelView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public LoadgelView findById(com.cardiodx.db.waban.view.LoadgelViewId id) {
		log.debug("getting LoadgelView instance with id: " + id);
		try {
			LoadgelView instance = (LoadgelView) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.LoadgelView", id);
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

	public List<LoadgelView> findByExample(LoadgelView instance) {
		log.debug("finding LoadgelView instance by example");
		try {
			List<LoadgelView> results = (List<LoadgelView>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.view.LoadgelView")
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
