package com.cardiodx.db.waban.view;

// Generated Jul 14, 2011 1:33:57 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class SampleVariableFld.
 * @see com.cardiodx.db.waban.view.SampleVariableFld
 * @author Hibernate Tools
 */
public class SampleVariableFldHome {

	private static final Log log = LogFactory
			.getLog(SampleVariableFldHome.class);

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

	public void persist(SampleVariableFld transientInstance) {
		log.debug("persisting SampleVariableFld instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(SampleVariableFld instance) {
		log.debug("attaching dirty SampleVariableFld instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SampleVariableFld instance) {
		log.debug("attaching clean SampleVariableFld instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(SampleVariableFld persistentInstance) {
		log.debug("deleting SampleVariableFld instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SampleVariableFld merge(SampleVariableFld detachedInstance) {
		log.debug("merging SampleVariableFld instance");
		try {
			SampleVariableFld result = (SampleVariableFld) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public SampleVariableFld findById(
			com.cardiodx.db.waban.view.SampleVariableFldId id) {
		log.debug("getting SampleVariableFld instance with id: " + id);
		try {
			SampleVariableFld instance = (SampleVariableFld) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.SampleVariableFld", id);
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

	public List<SampleVariableFld> findByExample(SampleVariableFld instance) {
		log.debug("finding SampleVariableFld instance by example");
		try {
			List<SampleVariableFld> results = (List<SampleVariableFld>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.SampleVariableFld")
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
