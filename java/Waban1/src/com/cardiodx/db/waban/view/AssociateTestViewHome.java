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
 * Home object for domain model class AssociateTestView.
 * @see com.cardiodx.db.waban.view.AssociateTestView
 * @author Hibernate Tools
 */
public class AssociateTestViewHome {

	private static final Log log = LogFactory
			.getLog(AssociateTestViewHome.class);

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

	public void persist(AssociateTestView transientInstance) {
		log.debug("persisting AssociateTestView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AssociateTestView instance) {
		log.debug("attaching dirty AssociateTestView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AssociateTestView instance) {
		log.debug("attaching clean AssociateTestView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AssociateTestView persistentInstance) {
		log.debug("deleting AssociateTestView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AssociateTestView merge(AssociateTestView detachedInstance) {
		log.debug("merging AssociateTestView instance");
		try {
			AssociateTestView result = (AssociateTestView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AssociateTestView findById(
			com.cardiodx.db.waban.view.AssociateTestViewId id) {
		log.debug("getting AssociateTestView instance with id: " + id);
		try {
			AssociateTestView instance = (AssociateTestView) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.AssociateTestView", id);
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

	public List<AssociateTestView> findByExample(AssociateTestView instance) {
		log.debug("finding AssociateTestView instance by example");
		try {
			List<AssociateTestView> results = (List<AssociateTestView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.AssociateTestView")
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