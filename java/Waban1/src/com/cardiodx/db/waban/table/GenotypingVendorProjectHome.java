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
 * Home object for domain model class GenotypingVendorProject.
 * @see com.cardiodx.db.waban.table.GenotypingVendorProject
 * @author Hibernate Tools
 */
public class GenotypingVendorProjectHome {

	private static final Log log = LogFactory
			.getLog(GenotypingVendorProjectHome.class);

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

	public void persist(GenotypingVendorProject transientInstance) {
		log.debug("persisting GenotypingVendorProject instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(GenotypingVendorProject instance) {
		log.debug("attaching dirty GenotypingVendorProject instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(GenotypingVendorProject instance) {
		log.debug("attaching clean GenotypingVendorProject instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(GenotypingVendorProject persistentInstance) {
		log.debug("deleting GenotypingVendorProject instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public GenotypingVendorProject merge(
			GenotypingVendorProject detachedInstance) {
		log.debug("merging GenotypingVendorProject instance");
		try {
			GenotypingVendorProject result = (GenotypingVendorProject) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public GenotypingVendorProject findById(java.math.BigDecimal id) {
		log.debug("getting GenotypingVendorProject instance with id: " + id);
		try {
			GenotypingVendorProject instance = (GenotypingVendorProject) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.table.GenotypingVendorProject",
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

	public List<GenotypingVendorProject> findByExample(
			GenotypingVendorProject instance) {
		log.debug("finding GenotypingVendorProject instance by example");
		try {
			List<GenotypingVendorProject> results = (List<GenotypingVendorProject>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.GenotypingVendorProject")
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
