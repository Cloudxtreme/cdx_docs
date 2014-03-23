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
 * Home object for domain model class GenotypeVariantEntryR.
 * @see com.cardiodx.db.waban.table.GenotypeVariantEntryR
 * @author Hibernate Tools
 */
public class GenotypeVariantEntryRHome {

	private static final Log log = LogFactory
			.getLog(GenotypeVariantEntryRHome.class);

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

	public void persist(GenotypeVariantEntryR transientInstance) {
		log.debug("persisting GenotypeVariantEntryR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(GenotypeVariantEntryR instance) {
		log.debug("attaching dirty GenotypeVariantEntryR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(GenotypeVariantEntryR instance) {
		log.debug("attaching clean GenotypeVariantEntryR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(GenotypeVariantEntryR persistentInstance) {
		log.debug("deleting GenotypeVariantEntryR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public GenotypeVariantEntryR merge(GenotypeVariantEntryR detachedInstance) {
		log.debug("merging GenotypeVariantEntryR instance");
		try {
			GenotypeVariantEntryR result = (GenotypeVariantEntryR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public GenotypeVariantEntryR findById(
			com.cardiodx.db.waban.table.GenotypeVariantEntryRId id) {
		log.debug("getting GenotypeVariantEntryR instance with id: " + id);
		try {
			GenotypeVariantEntryR instance = (GenotypeVariantEntryR) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.table.GenotypeVariantEntryR",
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

	public List<GenotypeVariantEntryR> findByExample(
			GenotypeVariantEntryR instance) {
		log.debug("finding GenotypeVariantEntryR instance by example");
		try {
			List<GenotypeVariantEntryR> results = (List<GenotypeVariantEntryR>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.GenotypeVariantEntryR")
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