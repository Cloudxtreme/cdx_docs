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
 * Home object for domain model class AssayGenotypeView.
 * @see com.cardiodx.db.waban.view.AssayGenotypeView
 * @author Hibernate Tools
 */
public class AssayGenotypeViewHome {

	private static final Log log = LogFactory
			.getLog(AssayGenotypeViewHome.class);

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

	public void persist(AssayGenotypeView transientInstance) {
		log.debug("persisting AssayGenotypeView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AssayGenotypeView instance) {
		log.debug("attaching dirty AssayGenotypeView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AssayGenotypeView instance) {
		log.debug("attaching clean AssayGenotypeView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AssayGenotypeView persistentInstance) {
		log.debug("deleting AssayGenotypeView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AssayGenotypeView merge(AssayGenotypeView detachedInstance) {
		log.debug("merging AssayGenotypeView instance");
		try {
			AssayGenotypeView result = (AssayGenotypeView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AssayGenotypeView findById(
			com.cardiodx.db.waban.view.AssayGenotypeViewId id) {
		log.debug("getting AssayGenotypeView instance with id: " + id);
		try {
			AssayGenotypeView instance = (AssayGenotypeView) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.AssayGenotypeView", id);
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

	public List<AssayGenotypeView> findByExample(AssayGenotypeView instance) {
		log.debug("finding AssayGenotypeView instance by example");
		try {
			List<AssayGenotypeView> results = (List<AssayGenotypeView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.AssayGenotypeView")
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
