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
 * Home object for domain model class TrgeGenotype.
 * @see com.cardiodx.db.waban.view.TrgeGenotype
 * @author Hibernate Tools
 */
public class TrgeGenotypeHome {

	private static final Log log = LogFactory.getLog(TrgeGenotypeHome.class);

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

	public void persist(TrgeGenotype transientInstance) {
		log.debug("persisting TrgeGenotype instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(TrgeGenotype instance) {
		log.debug("attaching dirty TrgeGenotype instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TrgeGenotype instance) {
		log.debug("attaching clean TrgeGenotype instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(TrgeGenotype persistentInstance) {
		log.debug("deleting TrgeGenotype instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TrgeGenotype merge(TrgeGenotype detachedInstance) {
		log.debug("merging TrgeGenotype instance");
		try {
			TrgeGenotype result = (TrgeGenotype) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TrgeGenotype findById(com.cardiodx.db.waban.view.TrgeGenotypeId id) {
		log.debug("getting TrgeGenotype instance with id: " + id);
		try {
			TrgeGenotype instance = (TrgeGenotype) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.TrgeGenotype", id);
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

	public List<TrgeGenotype> findByExample(TrgeGenotype instance) {
		log.debug("finding TrgeGenotype instance by example");
		try {
			List<TrgeGenotype> results = (List<TrgeGenotype>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.view.TrgeGenotype")
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
