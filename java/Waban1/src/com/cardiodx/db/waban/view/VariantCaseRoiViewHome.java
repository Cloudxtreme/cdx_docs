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
 * Home object for domain model class VariantCaseRoiView.
 * @see com.cardiodx.db.waban.view.VariantCaseRoiView
 * @author Hibernate Tools
 */
public class VariantCaseRoiViewHome {

	private static final Log log = LogFactory
			.getLog(VariantCaseRoiViewHome.class);

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

	public void persist(VariantCaseRoiView transientInstance) {
		log.debug("persisting VariantCaseRoiView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(VariantCaseRoiView instance) {
		log.debug("attaching dirty VariantCaseRoiView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(VariantCaseRoiView instance) {
		log.debug("attaching clean VariantCaseRoiView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(VariantCaseRoiView persistentInstance) {
		log.debug("deleting VariantCaseRoiView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public VariantCaseRoiView merge(VariantCaseRoiView detachedInstance) {
		log.debug("merging VariantCaseRoiView instance");
		try {
			VariantCaseRoiView result = (VariantCaseRoiView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public VariantCaseRoiView findById(
			com.cardiodx.db.waban.view.VariantCaseRoiViewId id) {
		log.debug("getting VariantCaseRoiView instance with id: " + id);
		try {
			VariantCaseRoiView instance = (VariantCaseRoiView) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.view.VariantCaseRoiView", id);
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

	public List<VariantCaseRoiView> findByExample(VariantCaseRoiView instance) {
		log.debug("finding VariantCaseRoiView instance by example");
		try {
			List<VariantCaseRoiView> results = (List<VariantCaseRoiView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.VariantCaseRoiView")
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
