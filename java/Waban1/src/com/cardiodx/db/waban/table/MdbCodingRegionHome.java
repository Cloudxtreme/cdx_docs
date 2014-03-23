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
 * Home object for domain model class MdbCodingRegion.
 * @see com.cardiodx.db.waban.table.MdbCodingRegion
 * @author Hibernate Tools
 */
public class MdbCodingRegionHome {

	private static final Log log = LogFactory.getLog(MdbCodingRegionHome.class);

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

	public void persist(MdbCodingRegion transientInstance) {
		log.debug("persisting MdbCodingRegion instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(MdbCodingRegion instance) {
		log.debug("attaching dirty MdbCodingRegion instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MdbCodingRegion instance) {
		log.debug("attaching clean MdbCodingRegion instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(MdbCodingRegion persistentInstance) {
		log.debug("deleting MdbCodingRegion instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MdbCodingRegion merge(MdbCodingRegion detachedInstance) {
		log.debug("merging MdbCodingRegion instance");
		try {
			MdbCodingRegion result = (MdbCodingRegion) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public MdbCodingRegion findById(java.math.BigDecimal id) {
		log.debug("getting MdbCodingRegion instance with id: " + id);
		try {
			MdbCodingRegion instance = (MdbCodingRegion) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.MdbCodingRegion", id);
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

	public List<MdbCodingRegion> findByExample(MdbCodingRegion instance) {
		log.debug("finding MdbCodingRegion instance by example");
		try {
			List<MdbCodingRegion> results = (List<MdbCodingRegion>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.MdbCodingRegion")
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
