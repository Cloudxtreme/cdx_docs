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
 * Home object for domain model class SpecimenShipmentPackageR.
 * @see com.cardiodx.db.waban.table.SpecimenShipmentPackageR
 * @author Hibernate Tools
 */
public class SpecimenShipmentPackageRHome {

	private static final Log log = LogFactory
			.getLog(SpecimenShipmentPackageRHome.class);

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

	public void persist(SpecimenShipmentPackageR transientInstance) {
		log.debug("persisting SpecimenShipmentPackageR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(SpecimenShipmentPackageR instance) {
		log.debug("attaching dirty SpecimenShipmentPackageR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SpecimenShipmentPackageR instance) {
		log.debug("attaching clean SpecimenShipmentPackageR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(SpecimenShipmentPackageR persistentInstance) {
		log.debug("deleting SpecimenShipmentPackageR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SpecimenShipmentPackageR merge(
			SpecimenShipmentPackageR detachedInstance) {
		log.debug("merging SpecimenShipmentPackageR instance");
		try {
			SpecimenShipmentPackageR result = (SpecimenShipmentPackageR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public SpecimenShipmentPackageR findById(
			com.cardiodx.db.waban.table.SpecimenShipmentPackageRId id) {
		log.debug("getting SpecimenShipmentPackageR instance with id: " + id);
		try {
			SpecimenShipmentPackageR instance = (SpecimenShipmentPackageR) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.table.SpecimenShipmentPackageR",
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

	public List<SpecimenShipmentPackageR> findByExample(
			SpecimenShipmentPackageR instance) {
		log.debug("finding SpecimenShipmentPackageR instance by example");
		try {
			List<SpecimenShipmentPackageR> results = (List<SpecimenShipmentPackageR>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.SpecimenShipmentPackageR")
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
