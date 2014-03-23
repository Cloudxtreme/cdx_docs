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
 * Home object for domain model class ShipmentReceipt.
 * @see com.cardiodx.db.waban.table.ShipmentReceipt
 * @author Hibernate Tools
 */
public class ShipmentReceiptHome {

	private static final Log log = LogFactory.getLog(ShipmentReceiptHome.class);

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

	public void persist(ShipmentReceipt transientInstance) {
		log.debug("persisting ShipmentReceipt instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ShipmentReceipt instance) {
		log.debug("attaching dirty ShipmentReceipt instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ShipmentReceipt instance) {
		log.debug("attaching clean ShipmentReceipt instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ShipmentReceipt persistentInstance) {
		log.debug("deleting ShipmentReceipt instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ShipmentReceipt merge(ShipmentReceipt detachedInstance) {
		log.debug("merging ShipmentReceipt instance");
		try {
			ShipmentReceipt result = (ShipmentReceipt) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ShipmentReceipt findById(java.math.BigDecimal id) {
		log.debug("getting ShipmentReceipt instance with id: " + id);
		try {
			ShipmentReceipt instance = (ShipmentReceipt) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.ShipmentReceipt", id);
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

	public List<ShipmentReceipt> findByExample(ShipmentReceipt instance) {
		log.debug("finding ShipmentReceipt instance by example");
		try {
			List<ShipmentReceipt> results = (List<ShipmentReceipt>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.ShipmentReceipt")
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
