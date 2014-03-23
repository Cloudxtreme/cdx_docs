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
 * Home object for domain model class CpRunView.
 * @see com.cardiodx.db.waban.view.CpRunView
 * @author Hibernate Tools
 */
public class CpRunViewHome {

	private static final Log log = LogFactory.getLog(CpRunViewHome.class);

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

	public void persist(CpRunView transientInstance) {
		log.debug("persisting CpRunView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(CpRunView instance) {
		log.debug("attaching dirty CpRunView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CpRunView instance) {
		log.debug("attaching clean CpRunView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(CpRunView persistentInstance) {
		log.debug("deleting CpRunView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CpRunView merge(CpRunView detachedInstance) {
		log.debug("merging CpRunView instance");
		try {
			CpRunView result = (CpRunView) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public CpRunView findById(com.cardiodx.db.waban.view.CpRunViewId id) {
		log.debug("getting CpRunView instance with id: " + id);
		try {
			CpRunView instance = (CpRunView) sessionFactory.getCurrentSession()
					.get("com.cardiodx.db.waban.view.CpRunView", id);
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

	public List<CpRunView> findByExample(CpRunView instance) {
		log.debug("finding CpRunView instance by example");
		try {
			List<CpRunView> results = (List<CpRunView>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.view.CpRunView")
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
