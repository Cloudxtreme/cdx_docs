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
 * Home object for domain model class PhaseReportView.
 * @see com.cardiodx.db.waban.view.PhaseReportView
 * @author Hibernate Tools
 */
public class PhaseReportViewHome {

	private static final Log log = LogFactory.getLog(PhaseReportViewHome.class);

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

	public void persist(PhaseReportView transientInstance) {
		log.debug("persisting PhaseReportView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(PhaseReportView instance) {
		log.debug("attaching dirty PhaseReportView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PhaseReportView instance) {
		log.debug("attaching clean PhaseReportView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(PhaseReportView persistentInstance) {
		log.debug("deleting PhaseReportView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PhaseReportView merge(PhaseReportView detachedInstance) {
		log.debug("merging PhaseReportView instance");
		try {
			PhaseReportView result = (PhaseReportView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public PhaseReportView findById(
			com.cardiodx.db.waban.view.PhaseReportViewId id) {
		log.debug("getting PhaseReportView instance with id: " + id);
		try {
			PhaseReportView instance = (PhaseReportView) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.PhaseReportView", id);
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

	public List<PhaseReportView> findByExample(PhaseReportView instance) {
		log.debug("finding PhaseReportView instance by example");
		try {
			List<PhaseReportView> results = (List<PhaseReportView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.PhaseReportView")
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
