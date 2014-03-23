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
 * Home object for domain model class MdbGenotype.
 * @see com.cardiodx.db.waban.table.MdbGenotype
 * @author Hibernate Tools
 */
public class MdbGenotypeHome {

	private static final Log log = LogFactory.getLog(MdbGenotypeHome.class);

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

	public void persist(MdbGenotype transientInstance) {
		log.debug("persisting MdbGenotype instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(MdbGenotype instance) {
		log.debug("attaching dirty MdbGenotype instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MdbGenotype instance) {
		log.debug("attaching clean MdbGenotype instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(MdbGenotype persistentInstance) {
		log.debug("deleting MdbGenotype instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MdbGenotype merge(MdbGenotype detachedInstance) {
		log.debug("merging MdbGenotype instance");
		try {
			MdbGenotype result = (MdbGenotype) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public MdbGenotype findById(java.math.BigDecimal id) {
		log.debug("getting MdbGenotype instance with id: " + id);
		try {
			MdbGenotype instance = (MdbGenotype) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.MdbGenotype", id);
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

	public List<MdbGenotype> findByExample(MdbGenotype instance) {
		log.debug("finding MdbGenotype instance by example");
		try {
			List<MdbGenotype> results = (List<MdbGenotype>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.table.MdbGenotype")
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
