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
 * Home object for domain model class SpecimenShipmentPackage.
 * @see com.cardiodx.db.waban.table.SpecimenShipmentPackage
 * @author Hibernate Tools
 */
public class SpecimenShipmentPackageHome {

	private static final Log log = LogFactory
			.getLog(SpecimenShipmentPackageHome.class);

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

	public void persist(SpecimenShipmentPackage transientInstance) {
		log.debug("persisting SpecimenShipmentPackage instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(SpecimenShipmentPackage instance) {
		log.debug("attaching dirty SpecimenShipmentPackage instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SpecimenShipmentPackage instance) {
		log.debug("attaching clean SpecimenShipmentPackage instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(SpecimenShipmentPackage persistentInstance) {
		log.debug("deleting SpecimenShipmentPackage instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SpecimenShipmentPackage merge(
			SpecimenShipmentPackage detachedInstance) {
		log.debug("merging SpecimenShipmentPackage instance");
		try {
			SpecimenShipmentPackage result = (SpecimenShipmentPackage) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public SpecimenShipmentPackage findById(java.math.BigDecimal id) {
		log.debug("getting SpecimenShipmentPackage instance with id: " + id);
		try {
			SpecimenShipmentPackage instance = (SpecimenShipmentPackage) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.table.SpecimenShipmentPackage",
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

	public List<SpecimenShipmentPackage> findByExample(
			SpecimenShipmentPackage instance) {
		log.debug("finding SpecimenShipmentPackage instance by example");
		try {
			List<SpecimenShipmentPackage> results = (List<SpecimenShipmentPackage>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.SpecimenShipmentPackage")
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
