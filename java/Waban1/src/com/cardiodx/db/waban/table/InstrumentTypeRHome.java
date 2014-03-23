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
 * Home object for domain model class InstrumentTypeR.
 * @see com.cardiodx.db.waban.table.InstrumentTypeR
 * @author Hibernate Tools
 */
public class InstrumentTypeRHome {

	private static final Log log = LogFactory.getLog(InstrumentTypeRHome.class);

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

	public void persist(InstrumentTypeR transientInstance) {
		log.debug("persisting InstrumentTypeR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(InstrumentTypeR instance) {
		log.debug("attaching dirty InstrumentTypeR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(InstrumentTypeR instance) {
		log.debug("attaching clean InstrumentTypeR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(InstrumentTypeR persistentInstance) {
		log.debug("deleting InstrumentTypeR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public InstrumentTypeR merge(InstrumentTypeR detachedInstance) {
		log.debug("merging InstrumentTypeR instance");
		try {
			InstrumentTypeR result = (InstrumentTypeR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public InstrumentTypeR findById(
			com.cardiodx.db.waban.table.InstrumentTypeRId id) {
		log.debug("getting InstrumentTypeR instance with id: " + id);
		try {
			InstrumentTypeR instance = (InstrumentTypeR) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.InstrumentTypeR", id);
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

	public List<InstrumentTypeR> findByExample(InstrumentTypeR instance) {
		log.debug("finding InstrumentTypeR instance by example");
		try {
			List<InstrumentTypeR> results = (List<InstrumentTypeR>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.InstrumentTypeR")
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
