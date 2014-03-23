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
 * Home object for domain model class MasterMixSetupView.
 * @see com.cardiodx.db.waban.view.MasterMixSetupView
 * @author Hibernate Tools
 */
public class MasterMixSetupViewHome {

	private static final Log log = LogFactory
			.getLog(MasterMixSetupViewHome.class);

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

	public void persist(MasterMixSetupView transientInstance) {
		log.debug("persisting MasterMixSetupView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(MasterMixSetupView instance) {
		log.debug("attaching dirty MasterMixSetupView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MasterMixSetupView instance) {
		log.debug("attaching clean MasterMixSetupView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(MasterMixSetupView persistentInstance) {
		log.debug("deleting MasterMixSetupView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MasterMixSetupView merge(MasterMixSetupView detachedInstance) {
		log.debug("merging MasterMixSetupView instance");
		try {
			MasterMixSetupView result = (MasterMixSetupView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public MasterMixSetupView findById(
			com.cardiodx.db.waban.view.MasterMixSetupViewId id) {
		log.debug("getting MasterMixSetupView instance with id: " + id);
		try {
			MasterMixSetupView instance = (MasterMixSetupView) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.view.MasterMixSetupView", id);
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

	public List<MasterMixSetupView> findByExample(MasterMixSetupView instance) {
		log.debug("finding MasterMixSetupView instance by example");
		try {
			List<MasterMixSetupView> results = (List<MasterMixSetupView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.MasterMixSetupView")
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
