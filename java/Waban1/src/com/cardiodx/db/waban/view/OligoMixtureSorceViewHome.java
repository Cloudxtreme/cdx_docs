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
 * Home object for domain model class OligoMixtureSorceView.
 * @see com.cardiodx.db.waban.view.OligoMixtureSorceView
 * @author Hibernate Tools
 */
public class OligoMixtureSorceViewHome {

	private static final Log log = LogFactory
			.getLog(OligoMixtureSorceViewHome.class);

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

	public void persist(OligoMixtureSorceView transientInstance) {
		log.debug("persisting OligoMixtureSorceView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(OligoMixtureSorceView instance) {
		log.debug("attaching dirty OligoMixtureSorceView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(OligoMixtureSorceView instance) {
		log.debug("attaching clean OligoMixtureSorceView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(OligoMixtureSorceView persistentInstance) {
		log.debug("deleting OligoMixtureSorceView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public OligoMixtureSorceView merge(OligoMixtureSorceView detachedInstance) {
		log.debug("merging OligoMixtureSorceView instance");
		try {
			OligoMixtureSorceView result = (OligoMixtureSorceView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public OligoMixtureSorceView findById(
			com.cardiodx.db.waban.view.OligoMixtureSorceViewId id) {
		log.debug("getting OligoMixtureSorceView instance with id: " + id);
		try {
			OligoMixtureSorceView instance = (OligoMixtureSorceView) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.OligoMixtureSorceView",
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

	public List<OligoMixtureSorceView> findByExample(
			OligoMixtureSorceView instance) {
		log.debug("finding OligoMixtureSorceView instance by example");
		try {
			List<OligoMixtureSorceView> results = (List<OligoMixtureSorceView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.OligoMixtureSorceView")
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
