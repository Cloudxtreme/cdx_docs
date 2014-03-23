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
 * Home object for domain model class MSampleReceptionView.
 * @see com.cardiodx.db.waban.view.MSampleReceptionView
 * @author Hibernate Tools
 */
public class MSampleReceptionViewHome {

	private static final Log log = LogFactory
			.getLog(MSampleReceptionViewHome.class);

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

	public void persist(MSampleReceptionView transientInstance) {
		log.debug("persisting MSampleReceptionView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(MSampleReceptionView instance) {
		log.debug("attaching dirty MSampleReceptionView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MSampleReceptionView instance) {
		log.debug("attaching clean MSampleReceptionView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(MSampleReceptionView persistentInstance) {
		log.debug("deleting MSampleReceptionView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MSampleReceptionView merge(MSampleReceptionView detachedInstance) {
		log.debug("merging MSampleReceptionView instance");
		try {
			MSampleReceptionView result = (MSampleReceptionView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public MSampleReceptionView findById(
			com.cardiodx.db.waban.view.MSampleReceptionViewId id) {
		log.debug("getting MSampleReceptionView instance with id: " + id);
		try {
			MSampleReceptionView instance = (MSampleReceptionView) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.MSampleReceptionView",
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

	public List<MSampleReceptionView> findByExample(
			MSampleReceptionView instance) {
		log.debug("finding MSampleReceptionView instance by example");
		try {
			List<MSampleReceptionView> results = (List<MSampleReceptionView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.MSampleReceptionView")
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
