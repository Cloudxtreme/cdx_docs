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
 * Home object for domain model class CpRunR.
 * @see com.cardiodx.db.waban.table.CpRunR
 * @author Hibernate Tools
 */
public class CpRunRHome {

	private static final Log log = LogFactory.getLog(CpRunRHome.class);

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

	public void persist(CpRunR transientInstance) {
		log.debug("persisting CpRunR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(CpRunR instance) {
		log.debug("attaching dirty CpRunR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CpRunR instance) {
		log.debug("attaching clean CpRunR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(CpRunR persistentInstance) {
		log.debug("deleting CpRunR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CpRunR merge(CpRunR detachedInstance) {
		log.debug("merging CpRunR instance");
		try {
			CpRunR result = (CpRunR) sessionFactory.getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public CpRunR findById(com.cardiodx.db.waban.table.CpRunRId id) {
		log.debug("getting CpRunR instance with id: " + id);
		try {
			CpRunR instance = (CpRunR) sessionFactory.getCurrentSession().get(
					"com.cardiodx.db.waban.table.CpRunR", id);
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

	public List<CpRunR> findByExample(CpRunR instance) {
		log.debug("finding CpRunR instance by example");
		try {
			List<CpRunR> results = (List<CpRunR>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.table.CpRunR")
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
