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
 * Home object for domain model class IdentifiedAccVarView.
 * @see com.cardiodx.db.waban.view.IdentifiedAccVarView
 * @author Hibernate Tools
 */
public class IdentifiedAccVarViewHome {

	private static final Log log = LogFactory
			.getLog(IdentifiedAccVarViewHome.class);

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

	public void persist(IdentifiedAccVarView transientInstance) {
		log.debug("persisting IdentifiedAccVarView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(IdentifiedAccVarView instance) {
		log.debug("attaching dirty IdentifiedAccVarView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(IdentifiedAccVarView instance) {
		log.debug("attaching clean IdentifiedAccVarView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(IdentifiedAccVarView persistentInstance) {
		log.debug("deleting IdentifiedAccVarView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public IdentifiedAccVarView merge(IdentifiedAccVarView detachedInstance) {
		log.debug("merging IdentifiedAccVarView instance");
		try {
			IdentifiedAccVarView result = (IdentifiedAccVarView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public IdentifiedAccVarView findById(
			com.cardiodx.db.waban.view.IdentifiedAccVarViewId id) {
		log.debug("getting IdentifiedAccVarView instance with id: " + id);
		try {
			IdentifiedAccVarView instance = (IdentifiedAccVarView) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.IdentifiedAccVarView",
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

	public List<IdentifiedAccVarView> findByExample(
			IdentifiedAccVarView instance) {
		log.debug("finding IdentifiedAccVarView instance by example");
		try {
			List<IdentifiedAccVarView> results = (List<IdentifiedAccVarView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.IdentifiedAccVarView")
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
