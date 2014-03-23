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
 * Home object for domain model class GenotypeVariantEntry.
 * @see com.cardiodx.db.waban.table.GenotypeVariantEntry
 * @author Hibernate Tools
 */
public class GenotypeVariantEntryHome {

	private static final Log log = LogFactory
			.getLog(GenotypeVariantEntryHome.class);

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

	public void persist(GenotypeVariantEntry transientInstance) {
		log.debug("persisting GenotypeVariantEntry instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(GenotypeVariantEntry instance) {
		log.debug("attaching dirty GenotypeVariantEntry instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(GenotypeVariantEntry instance) {
		log.debug("attaching clean GenotypeVariantEntry instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(GenotypeVariantEntry persistentInstance) {
		log.debug("deleting GenotypeVariantEntry instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public GenotypeVariantEntry merge(GenotypeVariantEntry detachedInstance) {
		log.debug("merging GenotypeVariantEntry instance");
		try {
			GenotypeVariantEntry result = (GenotypeVariantEntry) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public GenotypeVariantEntry findById(java.math.BigDecimal id) {
		log.debug("getting GenotypeVariantEntry instance with id: " + id);
		try {
			GenotypeVariantEntry instance = (GenotypeVariantEntry) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.GenotypeVariantEntry",
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

	public List<GenotypeVariantEntry> findByExample(
			GenotypeVariantEntry instance) {
		log.debug("finding GenotypeVariantEntry instance by example");
		try {
			List<GenotypeVariantEntry> results = (List<GenotypeVariantEntry>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.GenotypeVariantEntry")
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
