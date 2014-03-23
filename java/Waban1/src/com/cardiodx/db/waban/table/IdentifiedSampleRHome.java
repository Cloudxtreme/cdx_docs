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
 * Home object for domain model class IdentifiedSampleR.
 * @see com.cardiodx.db.waban.table.IdentifiedSampleR
 * @author Hibernate Tools
 */
public class IdentifiedSampleRHome {

	private static final Log log = LogFactory
			.getLog(IdentifiedSampleRHome.class);

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

	public void persist(IdentifiedSampleR transientInstance) {
		log.debug("persisting IdentifiedSampleR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(IdentifiedSampleR instance) {
		log.debug("attaching dirty IdentifiedSampleR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(IdentifiedSampleR instance) {
		log.debug("attaching clean IdentifiedSampleR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(IdentifiedSampleR persistentInstance) {
		log.debug("deleting IdentifiedSampleR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public IdentifiedSampleR merge(IdentifiedSampleR detachedInstance) {
		log.debug("merging IdentifiedSampleR instance");
		try {
			IdentifiedSampleR result = (IdentifiedSampleR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public IdentifiedSampleR findById(
			com.cardiodx.db.waban.table.IdentifiedSampleRId id) {
		log.debug("getting IdentifiedSampleR instance with id: " + id);
		try {
			IdentifiedSampleR instance = (IdentifiedSampleR) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.table.IdentifiedSampleR", id);
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

	public List<IdentifiedSampleR> findByExample(IdentifiedSampleR instance) {
		log.debug("finding IdentifiedSampleR instance by example");
		try {
			List<IdentifiedSampleR> results = (List<IdentifiedSampleR>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.IdentifiedSampleR")
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
