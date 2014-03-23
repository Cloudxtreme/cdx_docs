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
 * Home object for domain model class OcxLoadR.
 * @see com.cardiodx.db.waban.table.OcxLoadR
 * @author Hibernate Tools
 */
public class OcxLoadRHome {

	private static final Log log = LogFactory.getLog(OcxLoadRHome.class);

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

	public void persist(OcxLoadR transientInstance) {
		log.debug("persisting OcxLoadR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(OcxLoadR instance) {
		log.debug("attaching dirty OcxLoadR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(OcxLoadR instance) {
		log.debug("attaching clean OcxLoadR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(OcxLoadR persistentInstance) {
		log.debug("deleting OcxLoadR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public OcxLoadR merge(OcxLoadR detachedInstance) {
		log.debug("merging OcxLoadR instance");
		try {
			OcxLoadR result = (OcxLoadR) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public OcxLoadR findById(com.cardiodx.db.waban.table.OcxLoadRId id) {
		log.debug("getting OcxLoadR instance with id: " + id);
		try {
			OcxLoadR instance = (OcxLoadR) sessionFactory.getCurrentSession()
					.get("com.cardiodx.db.waban.table.OcxLoadR", id);
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

	public List<OcxLoadR> findByExample(OcxLoadR instance) {
		log.debug("finding OcxLoadR instance by example");
		try {
			List<OcxLoadR> results = (List<OcxLoadR>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.table.OcxLoadR")
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
