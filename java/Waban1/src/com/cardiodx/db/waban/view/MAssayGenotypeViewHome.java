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
 * Home object for domain model class MAssayGenotypeView.
 * @see com.cardiodx.db.waban.view.MAssayGenotypeView
 * @author Hibernate Tools
 */
public class MAssayGenotypeViewHome {

	private static final Log log = LogFactory
			.getLog(MAssayGenotypeViewHome.class);

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

	public void persist(MAssayGenotypeView transientInstance) {
		log.debug("persisting MAssayGenotypeView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(MAssayGenotypeView instance) {
		log.debug("attaching dirty MAssayGenotypeView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MAssayGenotypeView instance) {
		log.debug("attaching clean MAssayGenotypeView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(MAssayGenotypeView persistentInstance) {
		log.debug("deleting MAssayGenotypeView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MAssayGenotypeView merge(MAssayGenotypeView detachedInstance) {
		log.debug("merging MAssayGenotypeView instance");
		try {
			MAssayGenotypeView result = (MAssayGenotypeView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public MAssayGenotypeView findById(
			com.cardiodx.db.waban.view.MAssayGenotypeViewId id) {
		log.debug("getting MAssayGenotypeView instance with id: " + id);
		try {
			MAssayGenotypeView instance = (MAssayGenotypeView) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.view.MAssayGenotypeView", id);
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

	public List<MAssayGenotypeView> findByExample(MAssayGenotypeView instance) {
		log.debug("finding MAssayGenotypeView instance by example");
		try {
			List<MAssayGenotypeView> results = (List<MAssayGenotypeView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.MAssayGenotypeView")
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
