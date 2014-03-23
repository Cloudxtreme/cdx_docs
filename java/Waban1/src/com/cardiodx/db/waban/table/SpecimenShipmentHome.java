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
 * Home object for domain model class SpecimenShipment.
 * @see com.cardiodx.db.waban.table.SpecimenShipment
 * @author Hibernate Tools
 */
public class SpecimenShipmentHome {

	private static final Log log = LogFactory
			.getLog(SpecimenShipmentHome.class);

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

	public void persist(SpecimenShipment transientInstance) {
		log.debug("persisting SpecimenShipment instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(SpecimenShipment instance) {
		log.debug("attaching dirty SpecimenShipment instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SpecimenShipment instance) {
		log.debug("attaching clean SpecimenShipment instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(SpecimenShipment persistentInstance) {
		log.debug("deleting SpecimenShipment instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SpecimenShipment merge(SpecimenShipment detachedInstance) {
		log.debug("merging SpecimenShipment instance");
		try {
			SpecimenShipment result = (SpecimenShipment) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public SpecimenShipment findById(java.math.BigDecimal id) {
		log.debug("getting SpecimenShipment instance with id: " + id);
		try {
			SpecimenShipment instance = (SpecimenShipment) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.SpecimenShipment", id);
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

	public List<SpecimenShipment> findByExample(SpecimenShipment instance) {
		log.debug("finding SpecimenShipment instance by example");
		try {
			List<SpecimenShipment> results = (List<SpecimenShipment>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.SpecimenShipment")
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
