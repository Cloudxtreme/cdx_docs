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
 * Home object for domain model class SampleIdentificationKey.
 * @see com.cardiodx.db.waban.table.SampleIdentificationKey
 * @author Hibernate Tools
 */
public class SampleIdentificationKeyHome {

	private static final Log log = LogFactory
			.getLog(SampleIdentificationKeyHome.class);

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

	public void persist(SampleIdentificationKey transientInstance) {
		log.debug("persisting SampleIdentificationKey instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(SampleIdentificationKey instance) {
		log.debug("attaching dirty SampleIdentificationKey instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SampleIdentificationKey instance) {
		log.debug("attaching clean SampleIdentificationKey instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(SampleIdentificationKey persistentInstance) {
		log.debug("deleting SampleIdentificationKey instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SampleIdentificationKey merge(
			SampleIdentificationKey detachedInstance) {
		log.debug("merging SampleIdentificationKey instance");
		try {
			SampleIdentificationKey result = (SampleIdentificationKey) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public SampleIdentificationKey findById(
			com.cardiodx.db.waban.table.SampleIdentificationKeyId id) {
		log.debug("getting SampleIdentificationKey instance with id: " + id);
		try {
			SampleIdentificationKey instance = (SampleIdentificationKey) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.table.SampleIdentificationKey",
							id);
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

	public List<SampleIdentificationKey> findByExample(
			SampleIdentificationKey instance) {
		log.debug("finding SampleIdentificationKey instance by example");
		try {
			List<SampleIdentificationKey> results = (List<SampleIdentificationKey>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.SampleIdentificationKey")
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
