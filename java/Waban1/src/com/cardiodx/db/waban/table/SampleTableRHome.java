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
 * Home object for domain model class SampleTableR.
 * @see com.cardiodx.db.waban.table.SampleTableR
 * @author Hibernate Tools
 */
public class SampleTableRHome {

	private static final Log log = LogFactory.getLog(SampleTableRHome.class);

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

	public void persist(SampleTableR transientInstance) {
		log.debug("persisting SampleTableR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(SampleTableR instance) {
		log.debug("attaching dirty SampleTableR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SampleTableR instance) {
		log.debug("attaching clean SampleTableR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(SampleTableR persistentInstance) {
		log.debug("deleting SampleTableR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SampleTableR merge(SampleTableR detachedInstance) {
		log.debug("merging SampleTableR instance");
		try {
			SampleTableR result = (SampleTableR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public SampleTableR findById(com.cardiodx.db.waban.table.SampleTableRId id) {
		log.debug("getting SampleTableR instance with id: " + id);
		try {
			SampleTableR instance = (SampleTableR) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.SampleTableR", id);
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

	public List<SampleTableR> findByExample(SampleTableR instance) {
		log.debug("finding SampleTableR instance by example");
		try {
			List<SampleTableR> results = (List<SampleTableR>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.table.SampleTableR")
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
