package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:46 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class GenotypeAutocallRuleR.
 * @see com.cardiodx.db.waban.table.GenotypeAutocallRuleR
 * @author Hibernate Tools
 */
public class GenotypeAutocallRuleRHome {

	private static final Log log = LogFactory
			.getLog(GenotypeAutocallRuleRHome.class);

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

	public void persist(GenotypeAutocallRuleR transientInstance) {
		log.debug("persisting GenotypeAutocallRuleR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(GenotypeAutocallRuleR instance) {
		log.debug("attaching dirty GenotypeAutocallRuleR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(GenotypeAutocallRuleR instance) {
		log.debug("attaching clean GenotypeAutocallRuleR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(GenotypeAutocallRuleR persistentInstance) {
		log.debug("deleting GenotypeAutocallRuleR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public GenotypeAutocallRuleR merge(GenotypeAutocallRuleR detachedInstance) {
		log.debug("merging GenotypeAutocallRuleR instance");
		try {
			GenotypeAutocallRuleR result = (GenotypeAutocallRuleR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public GenotypeAutocallRuleR findById(
			com.cardiodx.db.waban.table.GenotypeAutocallRuleRId id) {
		log.debug("getting GenotypeAutocallRuleR instance with id: " + id);
		try {
			GenotypeAutocallRuleR instance = (GenotypeAutocallRuleR) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.table.GenotypeAutocallRuleR",
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

	public List<GenotypeAutocallRuleR> findByExample(
			GenotypeAutocallRuleR instance) {
		log.debug("finding GenotypeAutocallRuleR instance by example");
		try {
			List<GenotypeAutocallRuleR> results = (List<GenotypeAutocallRuleR>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.GenotypeAutocallRuleR")
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
