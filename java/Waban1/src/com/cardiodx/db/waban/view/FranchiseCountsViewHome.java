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
 * Home object for domain model class FranchiseCountsView.
 * @see com.cardiodx.db.waban.view.FranchiseCountsView
 * @author Hibernate Tools
 */
public class FranchiseCountsViewHome {

	private static final Log log = LogFactory
			.getLog(FranchiseCountsViewHome.class);

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

	public void persist(FranchiseCountsView transientInstance) {
		log.debug("persisting FranchiseCountsView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(FranchiseCountsView instance) {
		log.debug("attaching dirty FranchiseCountsView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(FranchiseCountsView instance) {
		log.debug("attaching clean FranchiseCountsView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(FranchiseCountsView persistentInstance) {
		log.debug("deleting FranchiseCountsView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public FranchiseCountsView merge(FranchiseCountsView detachedInstance) {
		log.debug("merging FranchiseCountsView instance");
		try {
			FranchiseCountsView result = (FranchiseCountsView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public FranchiseCountsView findById(
			com.cardiodx.db.waban.view.FranchiseCountsViewId id) {
		log.debug("getting FranchiseCountsView instance with id: " + id);
		try {
			FranchiseCountsView instance = (FranchiseCountsView) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.FranchiseCountsView",
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

	public List<FranchiseCountsView> findByExample(FranchiseCountsView instance) {
		log.debug("finding FranchiseCountsView instance by example");
		try {
			List<FranchiseCountsView> results = (List<FranchiseCountsView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.FranchiseCountsView")
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
