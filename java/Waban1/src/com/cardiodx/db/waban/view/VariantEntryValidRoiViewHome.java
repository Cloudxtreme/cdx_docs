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
 * Home object for domain model class VariantEntryValidRoiView.
 * @see com.cardiodx.db.waban.view.VariantEntryValidRoiView
 * @author Hibernate Tools
 */
public class VariantEntryValidRoiViewHome {

	private static final Log log = LogFactory
			.getLog(VariantEntryValidRoiViewHome.class);

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

	public void persist(VariantEntryValidRoiView transientInstance) {
		log.debug("persisting VariantEntryValidRoiView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(VariantEntryValidRoiView instance) {
		log.debug("attaching dirty VariantEntryValidRoiView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(VariantEntryValidRoiView instance) {
		log.debug("attaching clean VariantEntryValidRoiView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(VariantEntryValidRoiView persistentInstance) {
		log.debug("deleting VariantEntryValidRoiView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public VariantEntryValidRoiView merge(
			VariantEntryValidRoiView detachedInstance) {
		log.debug("merging VariantEntryValidRoiView instance");
		try {
			VariantEntryValidRoiView result = (VariantEntryValidRoiView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public VariantEntryValidRoiView findById(
			com.cardiodx.db.waban.view.VariantEntryValidRoiViewId id) {
		log.debug("getting VariantEntryValidRoiView instance with id: " + id);
		try {
			VariantEntryValidRoiView instance = (VariantEntryValidRoiView) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.view.VariantEntryValidRoiView",
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

	public List<VariantEntryValidRoiView> findByExample(
			VariantEntryValidRoiView instance) {
		log.debug("finding VariantEntryValidRoiView instance by example");
		try {
			List<VariantEntryValidRoiView> results = (List<VariantEntryValidRoiView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.VariantEntryValidRoiView")
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
