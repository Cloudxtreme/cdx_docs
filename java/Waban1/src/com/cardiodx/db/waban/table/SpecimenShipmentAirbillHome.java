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
 * Home object for domain model class SpecimenShipmentAirbill.
 * @see com.cardiodx.db.waban.table.SpecimenShipmentAirbill
 * @author Hibernate Tools
 */
public class SpecimenShipmentAirbillHome {

	private static final Log log = LogFactory
			.getLog(SpecimenShipmentAirbillHome.class);

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

	public void persist(SpecimenShipmentAirbill transientInstance) {
		log.debug("persisting SpecimenShipmentAirbill instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(SpecimenShipmentAirbill instance) {
		log.debug("attaching dirty SpecimenShipmentAirbill instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SpecimenShipmentAirbill instance) {
		log.debug("attaching clean SpecimenShipmentAirbill instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(SpecimenShipmentAirbill persistentInstance) {
		log.debug("deleting SpecimenShipmentAirbill instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SpecimenShipmentAirbill merge(
			SpecimenShipmentAirbill detachedInstance) {
		log.debug("merging SpecimenShipmentAirbill instance");
		try {
			SpecimenShipmentAirbill result = (SpecimenShipmentAirbill) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public SpecimenShipmentAirbill findById(java.math.BigDecimal id) {
		log.debug("getting SpecimenShipmentAirbill instance with id: " + id);
		try {
			SpecimenShipmentAirbill instance = (SpecimenShipmentAirbill) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.table.SpecimenShipmentAirbill",
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

	public List<SpecimenShipmentAirbill> findByExample(
			SpecimenShipmentAirbill instance) {
		log.debug("finding SpecimenShipmentAirbill instance by example");
		try {
			List<SpecimenShipmentAirbill> results = (List<SpecimenShipmentAirbill>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.SpecimenShipmentAirbill")
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
