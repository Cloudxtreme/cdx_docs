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
 * Home object for domain model class VariantChecklistCaseidView.
 * @see com.cardiodx.db.waban.view.VariantChecklistCaseidView
 * @author Hibernate Tools
 */
public class VariantChecklistCaseidViewHome {

	private static final Log log = LogFactory
			.getLog(VariantChecklistCaseidViewHome.class);

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

	public void persist(VariantChecklistCaseidView transientInstance) {
		log.debug("persisting VariantChecklistCaseidView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(VariantChecklistCaseidView instance) {
		log.debug("attaching dirty VariantChecklistCaseidView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(VariantChecklistCaseidView instance) {
		log.debug("attaching clean VariantChecklistCaseidView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(VariantChecklistCaseidView persistentInstance) {
		log.debug("deleting VariantChecklistCaseidView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public VariantChecklistCaseidView merge(
			VariantChecklistCaseidView detachedInstance) {
		log.debug("merging VariantChecklistCaseidView instance");
		try {
			VariantChecklistCaseidView result = (VariantChecklistCaseidView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public VariantChecklistCaseidView findById(
			com.cardiodx.db.waban.view.VariantChecklistCaseidViewId id) {
		log.debug("getting VariantChecklistCaseidView instance with id: " + id);
		try {
			VariantChecklistCaseidView instance = (VariantChecklistCaseidView) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.view.VariantChecklistCaseidView",
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

	public List<VariantChecklistCaseidView> findByExample(
			VariantChecklistCaseidView instance) {
		log.debug("finding VariantChecklistCaseidView instance by example");
		try {
			List<VariantChecklistCaseidView> results = (List<VariantChecklistCaseidView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.VariantChecklistCaseidView")
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
