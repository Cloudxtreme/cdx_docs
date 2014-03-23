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
 * Home object for domain model class MasterMixItem.
 * @see com.cardiodx.db.waban.table.MasterMixItem
 * @author Hibernate Tools
 */
public class MasterMixItemHome {

	private static final Log log = LogFactory.getLog(MasterMixItemHome.class);

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

	public void persist(MasterMixItem transientInstance) {
		log.debug("persisting MasterMixItem instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(MasterMixItem instance) {
		log.debug("attaching dirty MasterMixItem instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MasterMixItem instance) {
		log.debug("attaching clean MasterMixItem instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(MasterMixItem persistentInstance) {
		log.debug("deleting MasterMixItem instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MasterMixItem merge(MasterMixItem detachedInstance) {
		log.debug("merging MasterMixItem instance");
		try {
			MasterMixItem result = (MasterMixItem) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public MasterMixItem findById(java.math.BigDecimal id) {
		log.debug("getting MasterMixItem instance with id: " + id);
		try {
			MasterMixItem instance = (MasterMixItem) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.MasterMixItem", id);
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

	public List<MasterMixItem> findByExample(MasterMixItem instance) {
		log.debug("finding MasterMixItem instance by example");
		try {
			List<MasterMixItem> results = (List<MasterMixItem>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.table.MasterMixItem")
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
