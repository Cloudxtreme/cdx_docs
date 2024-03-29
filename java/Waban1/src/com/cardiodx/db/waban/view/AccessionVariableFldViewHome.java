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
 * Home object for domain model class AccessionVariableFldView.
 * @see com.cardiodx.db.waban.view.AccessionVariableFldView
 * @author Hibernate Tools
 */
public class AccessionVariableFldViewHome {

	private static final Log log = LogFactory
			.getLog(AccessionVariableFldViewHome.class);

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

	public void persist(AccessionVariableFldView transientInstance) {
		log.debug("persisting AccessionVariableFldView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AccessionVariableFldView instance) {
		log.debug("attaching dirty AccessionVariableFldView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AccessionVariableFldView instance) {
		log.debug("attaching clean AccessionVariableFldView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AccessionVariableFldView persistentInstance) {
		log.debug("deleting AccessionVariableFldView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AccessionVariableFldView merge(
			AccessionVariableFldView detachedInstance) {
		log.debug("merging AccessionVariableFldView instance");
		try {
			AccessionVariableFldView result = (AccessionVariableFldView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AccessionVariableFldView findById(
			com.cardiodx.db.waban.view.AccessionVariableFldViewId id) {
		log.debug("getting AccessionVariableFldView instance with id: " + id);
		try {
			AccessionVariableFldView instance = (AccessionVariableFldView) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.view.AccessionVariableFldView",
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

	public List<AccessionVariableFldView> findByExample(
			AccessionVariableFldView instance) {
		log.debug("finding AccessionVariableFldView instance by example");
		try {
			List<AccessionVariableFldView> results = (List<AccessionVariableFldView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.AccessionVariableFldView")
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
