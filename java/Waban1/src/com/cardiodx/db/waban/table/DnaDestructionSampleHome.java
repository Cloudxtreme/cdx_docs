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
 * Home object for domain model class DnaDestructionSample.
 * @see com.cardiodx.db.waban.table.DnaDestructionSample
 * @author Hibernate Tools
 */
public class DnaDestructionSampleHome {

	private static final Log log = LogFactory
			.getLog(DnaDestructionSampleHome.class);

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

	public void persist(DnaDestructionSample transientInstance) {
		log.debug("persisting DnaDestructionSample instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(DnaDestructionSample instance) {
		log.debug("attaching dirty DnaDestructionSample instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(DnaDestructionSample instance) {
		log.debug("attaching clean DnaDestructionSample instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(DnaDestructionSample persistentInstance) {
		log.debug("deleting DnaDestructionSample instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public DnaDestructionSample merge(DnaDestructionSample detachedInstance) {
		log.debug("merging DnaDestructionSample instance");
		try {
			DnaDestructionSample result = (DnaDestructionSample) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public DnaDestructionSample findById(java.math.BigDecimal id) {
		log.debug("getting DnaDestructionSample instance with id: " + id);
		try {
			DnaDestructionSample instance = (DnaDestructionSample) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.DnaDestructionSample",
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

	public List<DnaDestructionSample> findByExample(
			DnaDestructionSample instance) {
		log.debug("finding DnaDestructionSample instance by example");
		try {
			List<DnaDestructionSample> results = (List<DnaDestructionSample>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.DnaDestructionSample")
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
