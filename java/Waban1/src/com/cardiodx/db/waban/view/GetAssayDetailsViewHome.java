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
 * Home object for domain model class GetAssayDetailsView.
 * @see com.cardiodx.db.waban.view.GetAssayDetailsView
 * @author Hibernate Tools
 */
public class GetAssayDetailsViewHome {

	private static final Log log = LogFactory
			.getLog(GetAssayDetailsViewHome.class);

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

	public void persist(GetAssayDetailsView transientInstance) {
		log.debug("persisting GetAssayDetailsView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(GetAssayDetailsView instance) {
		log.debug("attaching dirty GetAssayDetailsView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(GetAssayDetailsView instance) {
		log.debug("attaching clean GetAssayDetailsView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(GetAssayDetailsView persistentInstance) {
		log.debug("deleting GetAssayDetailsView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public GetAssayDetailsView merge(GetAssayDetailsView detachedInstance) {
		log.debug("merging GetAssayDetailsView instance");
		try {
			GetAssayDetailsView result = (GetAssayDetailsView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public GetAssayDetailsView findById(
			com.cardiodx.db.waban.view.GetAssayDetailsViewId id) {
		log.debug("getting GetAssayDetailsView instance with id: " + id);
		try {
			GetAssayDetailsView instance = (GetAssayDetailsView) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.GetAssayDetailsView",
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

	public List<GetAssayDetailsView> findByExample(GetAssayDetailsView instance) {
		log.debug("finding GetAssayDetailsView instance by example");
		try {
			List<GetAssayDetailsView> results = (List<GetAssayDetailsView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.GetAssayDetailsView")
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
