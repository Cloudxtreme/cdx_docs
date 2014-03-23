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
 * Home object for domain model class GenotypingVendorAssayMR.
 * @see com.cardiodx.db.waban.table.GenotypingVendorAssayMR
 * @author Hibernate Tools
 */
public class GenotypingVendorAssayMRHome {

	private static final Log log = LogFactory
			.getLog(GenotypingVendorAssayMRHome.class);

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

	public void persist(GenotypingVendorAssayMR transientInstance) {
		log.debug("persisting GenotypingVendorAssayMR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(GenotypingVendorAssayMR instance) {
		log.debug("attaching dirty GenotypingVendorAssayMR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(GenotypingVendorAssayMR instance) {
		log.debug("attaching clean GenotypingVendorAssayMR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(GenotypingVendorAssayMR persistentInstance) {
		log.debug("deleting GenotypingVendorAssayMR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public GenotypingVendorAssayMR merge(
			GenotypingVendorAssayMR detachedInstance) {
		log.debug("merging GenotypingVendorAssayMR instance");
		try {
			GenotypingVendorAssayMR result = (GenotypingVendorAssayMR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public GenotypingVendorAssayMR findById(
			com.cardiodx.db.waban.table.GenotypingVendorAssayMRId id) {
		log.debug("getting GenotypingVendorAssayMR instance with id: " + id);
		try {
			GenotypingVendorAssayMR instance = (GenotypingVendorAssayMR) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.table.GenotypingVendorAssayMR",
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

	public List<GenotypingVendorAssayMR> findByExample(
			GenotypingVendorAssayMR instance) {
		log.debug("finding GenotypingVendorAssayMR instance by example");
		try {
			List<GenotypingVendorAssayMR> results = (List<GenotypingVendorAssayMR>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.GenotypingVendorAssayMR")
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
