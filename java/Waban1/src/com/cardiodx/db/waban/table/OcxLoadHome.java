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
 * Home object for domain model class OcxLoad.
 * @see com.cardiodx.db.waban.table.OcxLoad
 * @author Hibernate Tools
 */
public class OcxLoadHome {

	private static final Log log = LogFactory.getLog(OcxLoadHome.class);

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

	public void persist(OcxLoad transientInstance) {
		log.debug("persisting OcxLoad instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(OcxLoad instance) {
		log.debug("attaching dirty OcxLoad instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(OcxLoad instance) {
		log.debug("attaching clean OcxLoad instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(OcxLoad persistentInstance) {
		log.debug("deleting OcxLoad instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public OcxLoad merge(OcxLoad detachedInstance) {
		log.debug("merging OcxLoad instance");
		try {
			OcxLoad result = (OcxLoad) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public OcxLoad findById(java.math.BigDecimal id) {
		log.debug("getting OcxLoad instance with id: " + id);
		try {
			OcxLoad instance = (OcxLoad) sessionFactory.getCurrentSession()
					.get("com.cardiodx.db.waban.table.OcxLoad", id);
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

	public List<OcxLoad> findByExample(OcxLoad instance) {
		log.debug("finding OcxLoad instance by example");
		try {
			List<OcxLoad> results = (List<OcxLoad>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.table.OcxLoad")
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
