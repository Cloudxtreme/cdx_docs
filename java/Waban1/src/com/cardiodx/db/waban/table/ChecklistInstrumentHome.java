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
 * Home object for domain model class ChecklistInstrument.
 * @see com.cardiodx.db.waban.table.ChecklistInstrument
 * @author Hibernate Tools
 */
public class ChecklistInstrumentHome {

	private static final Log log = LogFactory
			.getLog(ChecklistInstrumentHome.class);

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

	public void persist(ChecklistInstrument transientInstance) {
		log.debug("persisting ChecklistInstrument instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ChecklistInstrument instance) {
		log.debug("attaching dirty ChecklistInstrument instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ChecklistInstrument instance) {
		log.debug("attaching clean ChecklistInstrument instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ChecklistInstrument persistentInstance) {
		log.debug("deleting ChecklistInstrument instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ChecklistInstrument merge(ChecklistInstrument detachedInstance) {
		log.debug("merging ChecklistInstrument instance");
		try {
			ChecklistInstrument result = (ChecklistInstrument) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ChecklistInstrument findById(
			com.cardiodx.db.waban.table.ChecklistInstrumentId id) {
		log.debug("getting ChecklistInstrument instance with id: " + id);
		try {
			ChecklistInstrument instance = (ChecklistInstrument) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.ChecklistInstrument",
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

	public List<ChecklistInstrument> findByExample(ChecklistInstrument instance) {
		log.debug("finding ChecklistInstrument instance by example");
		try {
			List<ChecklistInstrument> results = (List<ChecklistInstrument>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.ChecklistInstrument")
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
