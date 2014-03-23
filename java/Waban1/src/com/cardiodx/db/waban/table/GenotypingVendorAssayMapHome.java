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
 * Home object for domain model class GenotypingVendorAssayMap.
 * @see com.cardiodx.db.waban.table.GenotypingVendorAssayMap
 * @author Hibernate Tools
 */
public class GenotypingVendorAssayMapHome {

	private static final Log log = LogFactory
			.getLog(GenotypingVendorAssayMapHome.class);

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

	public void persist(GenotypingVendorAssayMap transientInstance) {
		log.debug("persisting GenotypingVendorAssayMap instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(GenotypingVendorAssayMap instance) {
		log.debug("attaching dirty GenotypingVendorAssayMap instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(GenotypingVendorAssayMap instance) {
		log.debug("attaching clean GenotypingVendorAssayMap instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(GenotypingVendorAssayMap persistentInstance) {
		log.debug("deleting GenotypingVendorAssayMap instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public GenotypingVendorAssayMap merge(
			GenotypingVendorAssayMap detachedInstance) {
		log.debug("merging GenotypingVendorAssayMap instance");
		try {
			GenotypingVendorAssayMap result = (GenotypingVendorAssayMap) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public GenotypingVendorAssayMap findById(java.math.BigDecimal id) {
		log.debug("getting GenotypingVendorAssayMap instance with id: " + id);
		try {
			GenotypingVendorAssayMap instance = (GenotypingVendorAssayMap) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.table.GenotypingVendorAssayMap",
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

	public List<GenotypingVendorAssayMap> findByExample(
			GenotypingVendorAssayMap instance) {
		log.debug("finding GenotypingVendorAssayMap instance by example");
		try {
			List<GenotypingVendorAssayMap> results = (List<GenotypingVendorAssayMap>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.GenotypingVendorAssayMap")
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
