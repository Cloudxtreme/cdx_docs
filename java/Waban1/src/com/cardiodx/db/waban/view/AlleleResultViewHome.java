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
 * Home object for domain model class AlleleResultView.
 * @see com.cardiodx.db.waban.view.AlleleResultView
 * @author Hibernate Tools
 */
public class AlleleResultViewHome {

	private static final Log log = LogFactory
			.getLog(AlleleResultViewHome.class);

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

	public void persist(AlleleResultView transientInstance) {
		log.debug("persisting AlleleResultView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AlleleResultView instance) {
		log.debug("attaching dirty AlleleResultView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AlleleResultView instance) {
		log.debug("attaching clean AlleleResultView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AlleleResultView persistentInstance) {
		log.debug("deleting AlleleResultView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AlleleResultView merge(AlleleResultView detachedInstance) {
		log.debug("merging AlleleResultView instance");
		try {
			AlleleResultView result = (AlleleResultView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AlleleResultView findById(
			com.cardiodx.db.waban.view.AlleleResultViewId id) {
		log.debug("getting AlleleResultView instance with id: " + id);
		try {
			AlleleResultView instance = (AlleleResultView) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.AlleleResultView", id);
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

	public List<AlleleResultView> findByExample(AlleleResultView instance) {
		log.debug("finding AlleleResultView instance by example");
		try {
			List<AlleleResultView> results = (List<AlleleResultView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.AlleleResultView")
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
