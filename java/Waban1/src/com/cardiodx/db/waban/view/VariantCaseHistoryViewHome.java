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
 * Home object for domain model class VariantCaseHistoryView.
 * @see com.cardiodx.db.waban.view.VariantCaseHistoryView
 * @author Hibernate Tools
 */
public class VariantCaseHistoryViewHome {

	private static final Log log = LogFactory
			.getLog(VariantCaseHistoryViewHome.class);

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

	public void persist(VariantCaseHistoryView transientInstance) {
		log.debug("persisting VariantCaseHistoryView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(VariantCaseHistoryView instance) {
		log.debug("attaching dirty VariantCaseHistoryView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(VariantCaseHistoryView instance) {
		log.debug("attaching clean VariantCaseHistoryView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(VariantCaseHistoryView persistentInstance) {
		log.debug("deleting VariantCaseHistoryView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public VariantCaseHistoryView merge(VariantCaseHistoryView detachedInstance) {
		log.debug("merging VariantCaseHistoryView instance");
		try {
			VariantCaseHistoryView result = (VariantCaseHistoryView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public VariantCaseHistoryView findById(
			com.cardiodx.db.waban.view.VariantCaseHistoryViewId id) {
		log.debug("getting VariantCaseHistoryView instance with id: " + id);
		try {
			VariantCaseHistoryView instance = (VariantCaseHistoryView) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.view.VariantCaseHistoryView",
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

	public List<VariantCaseHistoryView> findByExample(
			VariantCaseHistoryView instance) {
		log.debug("finding VariantCaseHistoryView instance by example");
		try {
			List<VariantCaseHistoryView> results = (List<VariantCaseHistoryView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.VariantCaseHistoryView")
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