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
 * Home object for domain model class MdbPopulationFreq.
 * @see com.cardiodx.db.waban.table.MdbPopulationFreq
 * @author Hibernate Tools
 */
public class MdbPopulationFreqHome {

	private static final Log log = LogFactory
			.getLog(MdbPopulationFreqHome.class);

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

	public void persist(MdbPopulationFreq transientInstance) {
		log.debug("persisting MdbPopulationFreq instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(MdbPopulationFreq instance) {
		log.debug("attaching dirty MdbPopulationFreq instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MdbPopulationFreq instance) {
		log.debug("attaching clean MdbPopulationFreq instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(MdbPopulationFreq persistentInstance) {
		log.debug("deleting MdbPopulationFreq instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MdbPopulationFreq merge(MdbPopulationFreq detachedInstance) {
		log.debug("merging MdbPopulationFreq instance");
		try {
			MdbPopulationFreq result = (MdbPopulationFreq) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public MdbPopulationFreq findById(java.math.BigDecimal id) {
		log.debug("getting MdbPopulationFreq instance with id: " + id);
		try {
			MdbPopulationFreq instance = (MdbPopulationFreq) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.table.MdbPopulationFreq", id);
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

	public List<MdbPopulationFreq> findByExample(MdbPopulationFreq instance) {
		log.debug("finding MdbPopulationFreq instance by example");
		try {
			List<MdbPopulationFreq> results = (List<MdbPopulationFreq>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.MdbPopulationFreq")
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
