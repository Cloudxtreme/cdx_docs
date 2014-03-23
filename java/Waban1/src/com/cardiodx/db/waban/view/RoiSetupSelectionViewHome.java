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
 * Home object for domain model class RoiSetupSelectionView.
 * @see com.cardiodx.db.waban.view.RoiSetupSelectionView
 * @author Hibernate Tools
 */
public class RoiSetupSelectionViewHome {

	private static final Log log = LogFactory
			.getLog(RoiSetupSelectionViewHome.class);

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

	public void persist(RoiSetupSelectionView transientInstance) {
		log.debug("persisting RoiSetupSelectionView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(RoiSetupSelectionView instance) {
		log.debug("attaching dirty RoiSetupSelectionView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RoiSetupSelectionView instance) {
		log.debug("attaching clean RoiSetupSelectionView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(RoiSetupSelectionView persistentInstance) {
		log.debug("deleting RoiSetupSelectionView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public RoiSetupSelectionView merge(RoiSetupSelectionView detachedInstance) {
		log.debug("merging RoiSetupSelectionView instance");
		try {
			RoiSetupSelectionView result = (RoiSetupSelectionView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public RoiSetupSelectionView findById(
			com.cardiodx.db.waban.view.RoiSetupSelectionViewId id) {
		log.debug("getting RoiSetupSelectionView instance with id: " + id);
		try {
			RoiSetupSelectionView instance = (RoiSetupSelectionView) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.RoiSetupSelectionView",
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

	public List<RoiSetupSelectionView> findByExample(
			RoiSetupSelectionView instance) {
		log.debug("finding RoiSetupSelectionView instance by example");
		try {
			List<RoiSetupSelectionView> results = (List<RoiSetupSelectionView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.RoiSetupSelectionView")
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
