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
 * Home object for domain model class FwGelView.
 * @see com.cardiodx.db.waban.view.FwGelView
 * @author Hibernate Tools
 */
public class FwGelViewHome {

	private static final Log log = LogFactory.getLog(FwGelViewHome.class);

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

	public void persist(FwGelView transientInstance) {
		log.debug("persisting FwGelView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(FwGelView instance) {
		log.debug("attaching dirty FwGelView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(FwGelView instance) {
		log.debug("attaching clean FwGelView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(FwGelView persistentInstance) {
		log.debug("deleting FwGelView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public FwGelView merge(FwGelView detachedInstance) {
		log.debug("merging FwGelView instance");
		try {
			FwGelView result = (FwGelView) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public FwGelView findById(com.cardiodx.db.waban.view.FwGelViewId id) {
		log.debug("getting FwGelView instance with id: " + id);
		try {
			FwGelView instance = (FwGelView) sessionFactory.getCurrentSession()
					.get("com.cardiodx.db.waban.view.FwGelView", id);
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

	public List<FwGelView> findByExample(FwGelView instance) {
		log.debug("finding FwGelView instance by example");
		try {
			List<FwGelView> results = (List<FwGelView>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.view.FwGelView")
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
