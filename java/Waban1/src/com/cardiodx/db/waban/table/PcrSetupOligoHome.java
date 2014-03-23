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
 * Home object for domain model class PcrSetupOligo.
 * @see com.cardiodx.db.waban.table.PcrSetupOligo
 * @author Hibernate Tools
 */
public class PcrSetupOligoHome {

	private static final Log log = LogFactory.getLog(PcrSetupOligoHome.class);

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

	public void persist(PcrSetupOligo transientInstance) {
		log.debug("persisting PcrSetupOligo instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(PcrSetupOligo instance) {
		log.debug("attaching dirty PcrSetupOligo instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PcrSetupOligo instance) {
		log.debug("attaching clean PcrSetupOligo instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(PcrSetupOligo persistentInstance) {
		log.debug("deleting PcrSetupOligo instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PcrSetupOligo merge(PcrSetupOligo detachedInstance) {
		log.debug("merging PcrSetupOligo instance");
		try {
			PcrSetupOligo result = (PcrSetupOligo) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public PcrSetupOligo findById(java.math.BigDecimal id) {
		log.debug("getting PcrSetupOligo instance with id: " + id);
		try {
			PcrSetupOligo instance = (PcrSetupOligo) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.PcrSetupOligo", id);
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

	public List<PcrSetupOligo> findByExample(PcrSetupOligo instance) {
		log.debug("finding PcrSetupOligo instance by example");
		try {
			List<PcrSetupOligo> results = (List<PcrSetupOligo>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.table.PcrSetupOligo")
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
