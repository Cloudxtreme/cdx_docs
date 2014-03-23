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
 * Home object for domain model class MastermixView.
 * @see com.cardiodx.db.waban.view.MastermixView
 * @author Hibernate Tools
 */
public class MastermixViewHome {

	private static final Log log = LogFactory.getLog(MastermixViewHome.class);

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

	public void persist(MastermixView transientInstance) {
		log.debug("persisting MastermixView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(MastermixView instance) {
		log.debug("attaching dirty MastermixView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MastermixView instance) {
		log.debug("attaching clean MastermixView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(MastermixView persistentInstance) {
		log.debug("deleting MastermixView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MastermixView merge(MastermixView detachedInstance) {
		log.debug("merging MastermixView instance");
		try {
			MastermixView result = (MastermixView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public MastermixView findById(com.cardiodx.db.waban.view.MastermixViewId id) {
		log.debug("getting MastermixView instance with id: " + id);
		try {
			MastermixView instance = (MastermixView) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.MastermixView", id);
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

	public List<MastermixView> findByExample(MastermixView instance) {
		log.debug("finding MastermixView instance by example");
		try {
			List<MastermixView> results = (List<MastermixView>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.view.MastermixView")
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
