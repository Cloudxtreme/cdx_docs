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
 * Home object for domain model class VariantEntryView.
 * @see com.cardiodx.db.waban.view.VariantEntryView
 * @author Hibernate Tools
 */
public class VariantEntryViewHome {

	private static final Log log = LogFactory
			.getLog(VariantEntryViewHome.class);

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

	public void persist(VariantEntryView transientInstance) {
		log.debug("persisting VariantEntryView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(VariantEntryView instance) {
		log.debug("attaching dirty VariantEntryView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(VariantEntryView instance) {
		log.debug("attaching clean VariantEntryView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(VariantEntryView persistentInstance) {
		log.debug("deleting VariantEntryView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public VariantEntryView merge(VariantEntryView detachedInstance) {
		log.debug("merging VariantEntryView instance");
		try {
			VariantEntryView result = (VariantEntryView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public VariantEntryView findById(
			com.cardiodx.db.waban.view.VariantEntryViewId id) {
		log.debug("getting VariantEntryView instance with id: " + id);
		try {
			VariantEntryView instance = (VariantEntryView) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.VariantEntryView", id);
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

	public List<VariantEntryView> findByExample(VariantEntryView instance) {
		log.debug("finding VariantEntryView instance by example");
		try {
			List<VariantEntryView> results = (List<VariantEntryView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.VariantEntryView")
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
