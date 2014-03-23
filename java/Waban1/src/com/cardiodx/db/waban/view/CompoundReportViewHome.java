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
 * Home object for domain model class CompoundReportView.
 * @see com.cardiodx.db.waban.view.CompoundReportView
 * @author Hibernate Tools
 */
public class CompoundReportViewHome {

	private static final Log log = LogFactory
			.getLog(CompoundReportViewHome.class);

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

	public void persist(CompoundReportView transientInstance) {
		log.debug("persisting CompoundReportView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(CompoundReportView instance) {
		log.debug("attaching dirty CompoundReportView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CompoundReportView instance) {
		log.debug("attaching clean CompoundReportView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(CompoundReportView persistentInstance) {
		log.debug("deleting CompoundReportView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CompoundReportView merge(CompoundReportView detachedInstance) {
		log.debug("merging CompoundReportView instance");
		try {
			CompoundReportView result = (CompoundReportView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public CompoundReportView findById(
			com.cardiodx.db.waban.view.CompoundReportViewId id) {
		log.debug("getting CompoundReportView instance with id: " + id);
		try {
			CompoundReportView instance = (CompoundReportView) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.view.CompoundReportView", id);
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

	public List<CompoundReportView> findByExample(CompoundReportView instance) {
		log.debug("finding CompoundReportView instance by example");
		try {
			List<CompoundReportView> results = (List<CompoundReportView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.CompoundReportView")
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
