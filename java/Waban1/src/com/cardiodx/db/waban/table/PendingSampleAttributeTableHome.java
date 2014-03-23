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
 * Home object for domain model class PendingSampleAttributeTable.
 * @see com.cardiodx.db.waban.table.PendingSampleAttributeTable
 * @author Hibernate Tools
 */
public class PendingSampleAttributeTableHome {

	private static final Log log = LogFactory
			.getLog(PendingSampleAttributeTableHome.class);

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

	public void persist(PendingSampleAttributeTable transientInstance) {
		log.debug("persisting PendingSampleAttributeTable instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(PendingSampleAttributeTable instance) {
		log.debug("attaching dirty PendingSampleAttributeTable instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PendingSampleAttributeTable instance) {
		log.debug("attaching clean PendingSampleAttributeTable instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(PendingSampleAttributeTable persistentInstance) {
		log.debug("deleting PendingSampleAttributeTable instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PendingSampleAttributeTable merge(
			PendingSampleAttributeTable detachedInstance) {
		log.debug("merging PendingSampleAttributeTable instance");
		try {
			PendingSampleAttributeTable result = (PendingSampleAttributeTable) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public PendingSampleAttributeTable findById(java.math.BigDecimal id) {
		log.debug("getting PendingSampleAttributeTable instance with id: " + id);
		try {
			PendingSampleAttributeTable instance = (PendingSampleAttributeTable) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.table.PendingSampleAttributeTable",
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

	public List<PendingSampleAttributeTable> findByExample(
			PendingSampleAttributeTable instance) {
		log.debug("finding PendingSampleAttributeTable instance by example");
		try {
			List<PendingSampleAttributeTable> results = (List<PendingSampleAttributeTable>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.PendingSampleAttributeTable")
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
