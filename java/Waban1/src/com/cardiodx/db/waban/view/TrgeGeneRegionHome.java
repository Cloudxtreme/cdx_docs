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
 * Home object for domain model class TrgeGeneRegion.
 * @see com.cardiodx.db.waban.view.TrgeGeneRegion
 * @author Hibernate Tools
 */
public class TrgeGeneRegionHome {

	private static final Log log = LogFactory.getLog(TrgeGeneRegionHome.class);

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

	public void persist(TrgeGeneRegion transientInstance) {
		log.debug("persisting TrgeGeneRegion instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(TrgeGeneRegion instance) {
		log.debug("attaching dirty TrgeGeneRegion instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TrgeGeneRegion instance) {
		log.debug("attaching clean TrgeGeneRegion instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(TrgeGeneRegion persistentInstance) {
		log.debug("deleting TrgeGeneRegion instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TrgeGeneRegion merge(TrgeGeneRegion detachedInstance) {
		log.debug("merging TrgeGeneRegion instance");
		try {
			TrgeGeneRegion result = (TrgeGeneRegion) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TrgeGeneRegion findById(
			com.cardiodx.db.waban.view.TrgeGeneRegionId id) {
		log.debug("getting TrgeGeneRegion instance with id: " + id);
		try {
			TrgeGeneRegion instance = (TrgeGeneRegion) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.TrgeGeneRegion", id);
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

	public List<TrgeGeneRegion> findByExample(TrgeGeneRegion instance) {
		log.debug("finding TrgeGeneRegion instance by example");
		try {
			List<TrgeGeneRegion> results = (List<TrgeGeneRegion>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.view.TrgeGeneRegion")
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
