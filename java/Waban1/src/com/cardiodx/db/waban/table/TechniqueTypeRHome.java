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
 * Home object for domain model class TechniqueTypeR.
 * @see com.cardiodx.db.waban.table.TechniqueTypeR
 * @author Hibernate Tools
 */
public class TechniqueTypeRHome {

	private static final Log log = LogFactory.getLog(TechniqueTypeRHome.class);

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

	public void persist(TechniqueTypeR transientInstance) {
		log.debug("persisting TechniqueTypeR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(TechniqueTypeR instance) {
		log.debug("attaching dirty TechniqueTypeR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TechniqueTypeR instance) {
		log.debug("attaching clean TechniqueTypeR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(TechniqueTypeR persistentInstance) {
		log.debug("deleting TechniqueTypeR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TechniqueTypeR merge(TechniqueTypeR detachedInstance) {
		log.debug("merging TechniqueTypeR instance");
		try {
			TechniqueTypeR result = (TechniqueTypeR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TechniqueTypeR findById(
			com.cardiodx.db.waban.table.TechniqueTypeRId id) {
		log.debug("getting TechniqueTypeR instance with id: " + id);
		try {
			TechniqueTypeR instance = (TechniqueTypeR) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.TechniqueTypeR", id);
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

	public List<TechniqueTypeR> findByExample(TechniqueTypeR instance) {
		log.debug("finding TechniqueTypeR instance by example");
		try {
			List<TechniqueTypeR> results = (List<TechniqueTypeR>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.TechniqueTypeR")
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
