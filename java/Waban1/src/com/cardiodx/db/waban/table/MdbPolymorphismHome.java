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
 * Home object for domain model class MdbPolymorphism.
 * @see com.cardiodx.db.waban.table.MdbPolymorphism
 * @author Hibernate Tools
 */
public class MdbPolymorphismHome {

	private static final Log log = LogFactory.getLog(MdbPolymorphismHome.class);

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

	public void persist(MdbPolymorphism transientInstance) {
		log.debug("persisting MdbPolymorphism instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(MdbPolymorphism instance) {
		log.debug("attaching dirty MdbPolymorphism instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MdbPolymorphism instance) {
		log.debug("attaching clean MdbPolymorphism instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(MdbPolymorphism persistentInstance) {
		log.debug("deleting MdbPolymorphism instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MdbPolymorphism merge(MdbPolymorphism detachedInstance) {
		log.debug("merging MdbPolymorphism instance");
		try {
			MdbPolymorphism result = (MdbPolymorphism) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public MdbPolymorphism findById(java.math.BigDecimal id) {
		log.debug("getting MdbPolymorphism instance with id: " + id);
		try {
			MdbPolymorphism instance = (MdbPolymorphism) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.MdbPolymorphism", id);
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

	public List<MdbPolymorphism> findByExample(MdbPolymorphism instance) {
		log.debug("finding MdbPolymorphism instance by example");
		try {
			List<MdbPolymorphism> results = (List<MdbPolymorphism>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.MdbPolymorphism")
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
