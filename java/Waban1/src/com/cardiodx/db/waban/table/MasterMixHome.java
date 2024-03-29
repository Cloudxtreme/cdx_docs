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
 * Home object for domain model class MasterMix.
 * @see com.cardiodx.db.waban.table.MasterMix
 * @author Hibernate Tools
 */
public class MasterMixHome {

	private static final Log log = LogFactory.getLog(MasterMixHome.class);

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

	public void persist(MasterMix transientInstance) {
		log.debug("persisting MasterMix instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(MasterMix instance) {
		log.debug("attaching dirty MasterMix instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MasterMix instance) {
		log.debug("attaching clean MasterMix instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(MasterMix persistentInstance) {
		log.debug("deleting MasterMix instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MasterMix merge(MasterMix detachedInstance) {
		log.debug("merging MasterMix instance");
		try {
			MasterMix result = (MasterMix) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public MasterMix findById(java.math.BigDecimal id) {
		log.debug("getting MasterMix instance with id: " + id);
		try {
			MasterMix instance = (MasterMix) sessionFactory.getCurrentSession()
					.get("com.cardiodx.db.waban.table.MasterMix", id);
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

	public List<MasterMix> findByExample(MasterMix instance) {
		log.debug("finding MasterMix instance by example");
		try {
			List<MasterMix> results = (List<MasterMix>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.table.MasterMix")
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
