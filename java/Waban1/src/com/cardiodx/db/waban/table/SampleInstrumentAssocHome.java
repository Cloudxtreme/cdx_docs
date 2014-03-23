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
 * Home object for domain model class SampleInstrumentAssoc.
 * @see com.cardiodx.db.waban.table.SampleInstrumentAssoc
 * @author Hibernate Tools
 */
public class SampleInstrumentAssocHome {

	private static final Log log = LogFactory
			.getLog(SampleInstrumentAssocHome.class);

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

	public void persist(SampleInstrumentAssoc transientInstance) {
		log.debug("persisting SampleInstrumentAssoc instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(SampleInstrumentAssoc instance) {
		log.debug("attaching dirty SampleInstrumentAssoc instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SampleInstrumentAssoc instance) {
		log.debug("attaching clean SampleInstrumentAssoc instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(SampleInstrumentAssoc persistentInstance) {
		log.debug("deleting SampleInstrumentAssoc instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SampleInstrumentAssoc merge(SampleInstrumentAssoc detachedInstance) {
		log.debug("merging SampleInstrumentAssoc instance");
		try {
			SampleInstrumentAssoc result = (SampleInstrumentAssoc) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public SampleInstrumentAssoc findById(
			com.cardiodx.db.waban.table.SampleInstrumentAssocId id) {
		log.debug("getting SampleInstrumentAssoc instance with id: " + id);
		try {
			SampleInstrumentAssoc instance = (SampleInstrumentAssoc) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.table.SampleInstrumentAssoc",
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

	public List<SampleInstrumentAssoc> findByExample(
			SampleInstrumentAssoc instance) {
		log.debug("finding SampleInstrumentAssoc instance by example");
		try {
			List<SampleInstrumentAssoc> results = (List<SampleInstrumentAssoc>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.SampleInstrumentAssoc")
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
