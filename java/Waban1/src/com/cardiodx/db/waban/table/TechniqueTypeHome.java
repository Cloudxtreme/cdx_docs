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
 * Home object for domain model class TechniqueType.
 * @see com.cardiodx.db.waban.table.TechniqueType
 * @author Hibernate Tools
 */
public class TechniqueTypeHome {

	private static final Log log = LogFactory.getLog(TechniqueTypeHome.class);

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

	public void persist(TechniqueType transientInstance) {
		log.debug("persisting TechniqueType instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(TechniqueType instance) {
		log.debug("attaching dirty TechniqueType instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TechniqueType instance) {
		log.debug("attaching clean TechniqueType instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(TechniqueType persistentInstance) {
		log.debug("deleting TechniqueType instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TechniqueType merge(TechniqueType detachedInstance) {
		log.debug("merging TechniqueType instance");
		try {
			TechniqueType result = (TechniqueType) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TechniqueType findById(java.math.BigDecimal id) {
		log.debug("getting TechniqueType instance with id: " + id);
		try {
			TechniqueType instance = (TechniqueType) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.TechniqueType", id);
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

	public List<TechniqueType> findByExample(TechniqueType instance) {
		log.debug("finding TechniqueType instance by example");
		try {
			List<TechniqueType> results = (List<TechniqueType>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.table.TechniqueType")
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
