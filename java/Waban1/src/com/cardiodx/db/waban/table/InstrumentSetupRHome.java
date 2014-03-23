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
 * Home object for domain model class InstrumentSetupR.
 * @see com.cardiodx.db.waban.table.InstrumentSetupR
 * @author Hibernate Tools
 */
public class InstrumentSetupRHome {

	private static final Log log = LogFactory
			.getLog(InstrumentSetupRHome.class);

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

	public void persist(InstrumentSetupR transientInstance) {
		log.debug("persisting InstrumentSetupR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(InstrumentSetupR instance) {
		log.debug("attaching dirty InstrumentSetupR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(InstrumentSetupR instance) {
		log.debug("attaching clean InstrumentSetupR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(InstrumentSetupR persistentInstance) {
		log.debug("deleting InstrumentSetupR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public InstrumentSetupR merge(InstrumentSetupR detachedInstance) {
		log.debug("merging InstrumentSetupR instance");
		try {
			InstrumentSetupR result = (InstrumentSetupR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public InstrumentSetupR findById(
			com.cardiodx.db.waban.table.InstrumentSetupRId id) {
		log.debug("getting InstrumentSetupR instance with id: " + id);
		try {
			InstrumentSetupR instance = (InstrumentSetupR) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.InstrumentSetupR", id);
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

	public List<InstrumentSetupR> findByExample(InstrumentSetupR instance) {
		log.debug("finding InstrumentSetupR instance by example");
		try {
			List<InstrumentSetupR> results = (List<InstrumentSetupR>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.InstrumentSetupR")
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
