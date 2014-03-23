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
 * Home object for domain model class AssayAlleleResultView.
 * @see com.cardiodx.db.waban.view.AssayAlleleResultView
 * @author Hibernate Tools
 */
public class AssayAlleleResultViewHome {

	private static final Log log = LogFactory
			.getLog(AssayAlleleResultViewHome.class);

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

	public void persist(AssayAlleleResultView transientInstance) {
		log.debug("persisting AssayAlleleResultView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AssayAlleleResultView instance) {
		log.debug("attaching dirty AssayAlleleResultView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AssayAlleleResultView instance) {
		log.debug("attaching clean AssayAlleleResultView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AssayAlleleResultView persistentInstance) {
		log.debug("deleting AssayAlleleResultView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AssayAlleleResultView merge(AssayAlleleResultView detachedInstance) {
		log.debug("merging AssayAlleleResultView instance");
		try {
			AssayAlleleResultView result = (AssayAlleleResultView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AssayAlleleResultView findById(
			com.cardiodx.db.waban.view.AssayAlleleResultViewId id) {
		log.debug("getting AssayAlleleResultView instance with id: " + id);
		try {
			AssayAlleleResultView instance = (AssayAlleleResultView) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.AssayAlleleResultView",
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

	public List<AssayAlleleResultView> findByExample(
			AssayAlleleResultView instance) {
		log.debug("finding AssayAlleleResultView instance by example");
		try {
			List<AssayAlleleResultView> results = (List<AssayAlleleResultView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.AssayAlleleResultView")
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
