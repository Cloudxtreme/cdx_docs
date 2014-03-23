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
 * Home object for domain model class ChecklistInstrumentR.
 * @see com.cardiodx.db.waban.table.ChecklistInstrumentR
 * @author Hibernate Tools
 */
public class ChecklistInstrumentRHome {

	private static final Log log = LogFactory
			.getLog(ChecklistInstrumentRHome.class);

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

	public void persist(ChecklistInstrumentR transientInstance) {
		log.debug("persisting ChecklistInstrumentR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ChecklistInstrumentR instance) {
		log.debug("attaching dirty ChecklistInstrumentR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ChecklistInstrumentR instance) {
		log.debug("attaching clean ChecklistInstrumentR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ChecklistInstrumentR persistentInstance) {
		log.debug("deleting ChecklistInstrumentR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ChecklistInstrumentR merge(ChecklistInstrumentR detachedInstance) {
		log.debug("merging ChecklistInstrumentR instance");
		try {
			ChecklistInstrumentR result = (ChecklistInstrumentR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ChecklistInstrumentR findById(
			com.cardiodx.db.waban.table.ChecklistInstrumentRId id) {
		log.debug("getting ChecklistInstrumentR instance with id: " + id);
		try {
			ChecklistInstrumentR instance = (ChecklistInstrumentR) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.ChecklistInstrumentR",
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

	public List<ChecklistInstrumentR> findByExample(
			ChecklistInstrumentR instance) {
		log.debug("finding ChecklistInstrumentR instance by example");
		try {
			List<ChecklistInstrumentR> results = (List<ChecklistInstrumentR>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.ChecklistInstrumentR")
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
