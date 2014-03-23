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
 * Home object for domain model class OutboundAssay.
 * @see com.cardiodx.db.waban.table.OutboundAssay
 * @author Hibernate Tools
 */
public class OutboundAssayHome {

	private static final Log log = LogFactory.getLog(OutboundAssayHome.class);

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

	public void persist(OutboundAssay transientInstance) {
		log.debug("persisting OutboundAssay instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(OutboundAssay instance) {
		log.debug("attaching dirty OutboundAssay instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(OutboundAssay instance) {
		log.debug("attaching clean OutboundAssay instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(OutboundAssay persistentInstance) {
		log.debug("deleting OutboundAssay instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public OutboundAssay merge(OutboundAssay detachedInstance) {
		log.debug("merging OutboundAssay instance");
		try {
			OutboundAssay result = (OutboundAssay) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public OutboundAssay findById(java.math.BigDecimal id) {
		log.debug("getting OutboundAssay instance with id: " + id);
		try {
			OutboundAssay instance = (OutboundAssay) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.OutboundAssay", id);
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

	public List<OutboundAssay> findByExample(OutboundAssay instance) {
		log.debug("finding OutboundAssay instance by example");
		try {
			List<OutboundAssay> results = (List<OutboundAssay>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.table.OutboundAssay")
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
