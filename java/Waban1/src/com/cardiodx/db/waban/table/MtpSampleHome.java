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
 * Home object for domain model class MtpSample.
 * @see com.cardiodx.db.waban.table.MtpSample
 * @author Hibernate Tools
 */
public class MtpSampleHome {

	private static final Log log = LogFactory.getLog(MtpSampleHome.class);

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

	public void persist(MtpSample transientInstance) {
		log.debug("persisting MtpSample instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(MtpSample instance) {
		log.debug("attaching dirty MtpSample instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MtpSample instance) {
		log.debug("attaching clean MtpSample instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(MtpSample persistentInstance) {
		log.debug("deleting MtpSample instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MtpSample merge(MtpSample detachedInstance) {
		log.debug("merging MtpSample instance");
		try {
			MtpSample result = (MtpSample) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public MtpSample findById(com.cardiodx.db.waban.table.MtpSampleId id) {
		log.debug("getting MtpSample instance with id: " + id);
		try {
			MtpSample instance = (MtpSample) sessionFactory.getCurrentSession()
					.get("com.cardiodx.db.waban.table.MtpSample", id);
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

	public List<MtpSample> findByExample(MtpSample instance) {
		log.debug("finding MtpSample instance by example");
		try {
			List<MtpSample> results = (List<MtpSample>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.table.MtpSample")
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
