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
 * Home object for domain model class MakePlateView.
 * @see com.cardiodx.db.waban.view.MakePlateView
 * @author Hibernate Tools
 */
public class MakePlateViewHome {

	private static final Log log = LogFactory.getLog(MakePlateViewHome.class);

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

	public void persist(MakePlateView transientInstance) {
		log.debug("persisting MakePlateView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(MakePlateView instance) {
		log.debug("attaching dirty MakePlateView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MakePlateView instance) {
		log.debug("attaching clean MakePlateView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(MakePlateView persistentInstance) {
		log.debug("deleting MakePlateView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MakePlateView merge(MakePlateView detachedInstance) {
		log.debug("merging MakePlateView instance");
		try {
			MakePlateView result = (MakePlateView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public MakePlateView findById(com.cardiodx.db.waban.view.MakePlateViewId id) {
		log.debug("getting MakePlateView instance with id: " + id);
		try {
			MakePlateView instance = (MakePlateView) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.MakePlateView", id);
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

	public List<MakePlateView> findByExample(MakePlateView instance) {
		log.debug("finding MakePlateView instance by example");
		try {
			List<MakePlateView> results = (List<MakePlateView>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.view.MakePlateView")
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
