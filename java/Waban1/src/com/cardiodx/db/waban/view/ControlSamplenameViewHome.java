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
 * Home object for domain model class ControlSamplenameView.
 * @see com.cardiodx.db.waban.view.ControlSamplenameView
 * @author Hibernate Tools
 */
public class ControlSamplenameViewHome {

	private static final Log log = LogFactory
			.getLog(ControlSamplenameViewHome.class);

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

	public void persist(ControlSamplenameView transientInstance) {
		log.debug("persisting ControlSamplenameView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ControlSamplenameView instance) {
		log.debug("attaching dirty ControlSamplenameView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ControlSamplenameView instance) {
		log.debug("attaching clean ControlSamplenameView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ControlSamplenameView persistentInstance) {
		log.debug("deleting ControlSamplenameView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ControlSamplenameView merge(ControlSamplenameView detachedInstance) {
		log.debug("merging ControlSamplenameView instance");
		try {
			ControlSamplenameView result = (ControlSamplenameView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ControlSamplenameView findById(
			com.cardiodx.db.waban.view.ControlSamplenameViewId id) {
		log.debug("getting ControlSamplenameView instance with id: " + id);
		try {
			ControlSamplenameView instance = (ControlSamplenameView) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.ControlSamplenameView",
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

	public List<ControlSamplenameView> findByExample(
			ControlSamplenameView instance) {
		log.debug("finding ControlSamplenameView instance by example");
		try {
			List<ControlSamplenameView> results = (List<ControlSamplenameView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.ControlSamplenameView")
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
