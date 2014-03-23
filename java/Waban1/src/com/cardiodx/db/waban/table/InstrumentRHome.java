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
 * Home object for domain model class InstrumentR.
 * @see com.cardiodx.db.waban.table.InstrumentR
 * @author Hibernate Tools
 */
public class InstrumentRHome {

	private static final Log log = LogFactory.getLog(InstrumentRHome.class);

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

	public void persist(InstrumentR transientInstance) {
		log.debug("persisting InstrumentR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(InstrumentR instance) {
		log.debug("attaching dirty InstrumentR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(InstrumentR instance) {
		log.debug("attaching clean InstrumentR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(InstrumentR persistentInstance) {
		log.debug("deleting InstrumentR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public InstrumentR merge(InstrumentR detachedInstance) {
		log.debug("merging InstrumentR instance");
		try {
			InstrumentR result = (InstrumentR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public InstrumentR findById(com.cardiodx.db.waban.table.InstrumentRId id) {
		log.debug("getting InstrumentR instance with id: " + id);
		try {
			InstrumentR instance = (InstrumentR) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.InstrumentR", id);
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

	public List<InstrumentR> findByExample(InstrumentR instance) {
		log.debug("finding InstrumentR instance by example");
		try {
			List<InstrumentR> results = (List<InstrumentR>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.table.InstrumentR")
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
