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
 * Home object for domain model class PcrSetupDisplayView.
 * @see com.cardiodx.db.waban.view.PcrSetupDisplayView
 * @author Hibernate Tools
 */
public class PcrSetupDisplayViewHome {

	private static final Log log = LogFactory
			.getLog(PcrSetupDisplayViewHome.class);

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

	public void persist(PcrSetupDisplayView transientInstance) {
		log.debug("persisting PcrSetupDisplayView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(PcrSetupDisplayView instance) {
		log.debug("attaching dirty PcrSetupDisplayView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PcrSetupDisplayView instance) {
		log.debug("attaching clean PcrSetupDisplayView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(PcrSetupDisplayView persistentInstance) {
		log.debug("deleting PcrSetupDisplayView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PcrSetupDisplayView merge(PcrSetupDisplayView detachedInstance) {
		log.debug("merging PcrSetupDisplayView instance");
		try {
			PcrSetupDisplayView result = (PcrSetupDisplayView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public PcrSetupDisplayView findById(
			com.cardiodx.db.waban.view.PcrSetupDisplayViewId id) {
		log.debug("getting PcrSetupDisplayView instance with id: " + id);
		try {
			PcrSetupDisplayView instance = (PcrSetupDisplayView) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.PcrSetupDisplayView",
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

	public List<PcrSetupDisplayView> findByExample(PcrSetupDisplayView instance) {
		log.debug("finding PcrSetupDisplayView instance by example");
		try {
			List<PcrSetupDisplayView> results = (List<PcrSetupDisplayView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.PcrSetupDisplayView")
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
