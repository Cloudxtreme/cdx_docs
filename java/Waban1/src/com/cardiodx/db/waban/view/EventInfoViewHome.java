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
 * Home object for domain model class EventInfoView.
 * @see com.cardiodx.db.waban.view.EventInfoView
 * @author Hibernate Tools
 */
public class EventInfoViewHome {

	private static final Log log = LogFactory.getLog(EventInfoViewHome.class);

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

	public void persist(EventInfoView transientInstance) {
		log.debug("persisting EventInfoView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(EventInfoView instance) {
		log.debug("attaching dirty EventInfoView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(EventInfoView instance) {
		log.debug("attaching clean EventInfoView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(EventInfoView persistentInstance) {
		log.debug("deleting EventInfoView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public EventInfoView merge(EventInfoView detachedInstance) {
		log.debug("merging EventInfoView instance");
		try {
			EventInfoView result = (EventInfoView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public EventInfoView findById(com.cardiodx.db.waban.view.EventInfoViewId id) {
		log.debug("getting EventInfoView instance with id: " + id);
		try {
			EventInfoView instance = (EventInfoView) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.EventInfoView", id);
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

	public List<EventInfoView> findByExample(EventInfoView instance) {
		log.debug("finding EventInfoView instance by example");
		try {
			List<EventInfoView> results = (List<EventInfoView>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.view.EventInfoView")
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
