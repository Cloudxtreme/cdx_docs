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
 * Home object for domain model class PcrRoiCountView.
 * @see com.cardiodx.db.waban.view.PcrRoiCountView
 * @author Hibernate Tools
 */
public class PcrRoiCountViewHome {

	private static final Log log = LogFactory.getLog(PcrRoiCountViewHome.class);

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

	public void persist(PcrRoiCountView transientInstance) {
		log.debug("persisting PcrRoiCountView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(PcrRoiCountView instance) {
		log.debug("attaching dirty PcrRoiCountView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PcrRoiCountView instance) {
		log.debug("attaching clean PcrRoiCountView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(PcrRoiCountView persistentInstance) {
		log.debug("deleting PcrRoiCountView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PcrRoiCountView merge(PcrRoiCountView detachedInstance) {
		log.debug("merging PcrRoiCountView instance");
		try {
			PcrRoiCountView result = (PcrRoiCountView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public PcrRoiCountView findById(
			com.cardiodx.db.waban.view.PcrRoiCountViewId id) {
		log.debug("getting PcrRoiCountView instance with id: " + id);
		try {
			PcrRoiCountView instance = (PcrRoiCountView) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.PcrRoiCountView", id);
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

	public List<PcrRoiCountView> findByExample(PcrRoiCountView instance) {
		log.debug("finding PcrRoiCountView instance by example");
		try {
			List<PcrRoiCountView> results = (List<PcrRoiCountView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.PcrRoiCountView")
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
