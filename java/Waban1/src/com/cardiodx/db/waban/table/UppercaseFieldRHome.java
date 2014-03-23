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
 * Home object for domain model class UppercaseFieldR.
 * @see com.cardiodx.db.waban.table.UppercaseFieldR
 * @author Hibernate Tools
 */
public class UppercaseFieldRHome {

	private static final Log log = LogFactory.getLog(UppercaseFieldRHome.class);

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

	public void persist(UppercaseFieldR transientInstance) {
		log.debug("persisting UppercaseFieldR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(UppercaseFieldR instance) {
		log.debug("attaching dirty UppercaseFieldR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(UppercaseFieldR instance) {
		log.debug("attaching clean UppercaseFieldR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(UppercaseFieldR persistentInstance) {
		log.debug("deleting UppercaseFieldR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public UppercaseFieldR merge(UppercaseFieldR detachedInstance) {
		log.debug("merging UppercaseFieldR instance");
		try {
			UppercaseFieldR result = (UppercaseFieldR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public UppercaseFieldR findById(
			com.cardiodx.db.waban.table.UppercaseFieldRId id) {
		log.debug("getting UppercaseFieldR instance with id: " + id);
		try {
			UppercaseFieldR instance = (UppercaseFieldR) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.UppercaseFieldR", id);
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

	public List<UppercaseFieldR> findByExample(UppercaseFieldR instance) {
		log.debug("finding UppercaseFieldR instance by example");
		try {
			List<UppercaseFieldR> results = (List<UppercaseFieldR>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.UppercaseFieldR")
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
