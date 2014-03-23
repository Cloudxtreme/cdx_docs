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
 * Home object for domain model class DnaDestructionVendor.
 * @see com.cardiodx.db.waban.table.DnaDestructionVendor
 * @author Hibernate Tools
 */
public class DnaDestructionVendorHome {

	private static final Log log = LogFactory
			.getLog(DnaDestructionVendorHome.class);

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

	public void persist(DnaDestructionVendor transientInstance) {
		log.debug("persisting DnaDestructionVendor instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(DnaDestructionVendor instance) {
		log.debug("attaching dirty DnaDestructionVendor instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(DnaDestructionVendor instance) {
		log.debug("attaching clean DnaDestructionVendor instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(DnaDestructionVendor persistentInstance) {
		log.debug("deleting DnaDestructionVendor instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public DnaDestructionVendor merge(DnaDestructionVendor detachedInstance) {
		log.debug("merging DnaDestructionVendor instance");
		try {
			DnaDestructionVendor result = (DnaDestructionVendor) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public DnaDestructionVendor findById(java.math.BigDecimal id) {
		log.debug("getting DnaDestructionVendor instance with id: " + id);
		try {
			DnaDestructionVendor instance = (DnaDestructionVendor) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.DnaDestructionVendor",
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

	public List<DnaDestructionVendor> findByExample(
			DnaDestructionVendor instance) {
		log.debug("finding DnaDestructionVendor instance by example");
		try {
			List<DnaDestructionVendor> results = (List<DnaDestructionVendor>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.DnaDestructionVendor")
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
