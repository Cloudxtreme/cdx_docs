package com.cardiodx.db.waban.audit;

// Generated Jul 14, 2011 1:33:02 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class AudGenotypingVendorProject.
 * @see com.cardiodx.db.waban.audit.AudGenotypingVendorProject
 * @author Hibernate Tools
 */
public class AudGenotypingVendorProjectHome {

	private static final Log log = LogFactory
			.getLog(AudGenotypingVendorProjectHome.class);

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

	public void persist(AudGenotypingVendorProject transientInstance) {
		log.debug("persisting AudGenotypingVendorProject instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AudGenotypingVendorProject instance) {
		log.debug("attaching dirty AudGenotypingVendorProject instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AudGenotypingVendorProject instance) {
		log.debug("attaching clean AudGenotypingVendorProject instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AudGenotypingVendorProject persistentInstance) {
		log.debug("deleting AudGenotypingVendorProject instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AudGenotypingVendorProject merge(
			AudGenotypingVendorProject detachedInstance) {
		log.debug("merging AudGenotypingVendorProject instance");
		try {
			AudGenotypingVendorProject result = (AudGenotypingVendorProject) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AudGenotypingVendorProject findById(java.math.BigDecimal id) {
		log.debug("getting AudGenotypingVendorProject instance with id: " + id);
		try {
			AudGenotypingVendorProject instance = (AudGenotypingVendorProject) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.audit.AudGenotypingVendorProject",
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

	public List<AudGenotypingVendorProject> findByExample(
			AudGenotypingVendorProject instance) {
		log.debug("finding AudGenotypingVendorProject instance by example");
		try {
			List<AudGenotypingVendorProject> results = (List<AudGenotypingVendorProject>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.audit.AudGenotypingVendorProject")
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
