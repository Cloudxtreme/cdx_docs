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
 * Home object for domain model class DnaFluor.
 * @see com.cardiodx.db.waban.table.DnaFluor
 * @author Hibernate Tools
 */
public class DnaFluorHome {

	private static final Log log = LogFactory.getLog(DnaFluorHome.class);

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

	public void persist(DnaFluor transientInstance) {
		log.debug("persisting DnaFluor instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(DnaFluor instance) {
		log.debug("attaching dirty DnaFluor instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(DnaFluor instance) {
		log.debug("attaching clean DnaFluor instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(DnaFluor persistentInstance) {
		log.debug("deleting DnaFluor instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public DnaFluor merge(DnaFluor detachedInstance) {
		log.debug("merging DnaFluor instance");
		try {
			DnaFluor result = (DnaFluor) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public DnaFluor findById(java.math.BigDecimal id) {
		log.debug("getting DnaFluor instance with id: " + id);
		try {
			DnaFluor instance = (DnaFluor) sessionFactory.getCurrentSession()
					.get("com.cardiodx.db.waban.table.DnaFluor", id);
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

	public List<DnaFluor> findByExample(DnaFluor instance) {
		log.debug("finding DnaFluor instance by example");
		try {
			List<DnaFluor> results = (List<DnaFluor>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.table.DnaFluor")
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
