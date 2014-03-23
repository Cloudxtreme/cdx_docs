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
 * Home object for domain model class CaseRoiStatusView.
 * @see com.cardiodx.db.waban.view.CaseRoiStatusView
 * @author Hibernate Tools
 */
public class CaseRoiStatusViewHome {

	private static final Log log = LogFactory
			.getLog(CaseRoiStatusViewHome.class);

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

	public void persist(CaseRoiStatusView transientInstance) {
		log.debug("persisting CaseRoiStatusView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(CaseRoiStatusView instance) {
		log.debug("attaching dirty CaseRoiStatusView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CaseRoiStatusView instance) {
		log.debug("attaching clean CaseRoiStatusView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(CaseRoiStatusView persistentInstance) {
		log.debug("deleting CaseRoiStatusView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CaseRoiStatusView merge(CaseRoiStatusView detachedInstance) {
		log.debug("merging CaseRoiStatusView instance");
		try {
			CaseRoiStatusView result = (CaseRoiStatusView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public CaseRoiStatusView findById(
			com.cardiodx.db.waban.view.CaseRoiStatusViewId id) {
		log.debug("getting CaseRoiStatusView instance with id: " + id);
		try {
			CaseRoiStatusView instance = (CaseRoiStatusView) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.CaseRoiStatusView", id);
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

	public List<CaseRoiStatusView> findByExample(CaseRoiStatusView instance) {
		log.debug("finding CaseRoiStatusView instance by example");
		try {
			List<CaseRoiStatusView> results = (List<CaseRoiStatusView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.CaseRoiStatusView")
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
