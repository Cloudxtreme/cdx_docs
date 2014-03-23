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
 * Home object for domain model class AssignInstrumentR.
 * @see com.cardiodx.db.waban.table.AssignInstrumentR
 * @author Hibernate Tools
 */
public class AssignInstrumentRHome {

	private static final Log log = LogFactory
			.getLog(AssignInstrumentRHome.class);

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

	public void persist(AssignInstrumentR transientInstance) {
		log.debug("persisting AssignInstrumentR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AssignInstrumentR instance) {
		log.debug("attaching dirty AssignInstrumentR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AssignInstrumentR instance) {
		log.debug("attaching clean AssignInstrumentR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AssignInstrumentR persistentInstance) {
		log.debug("deleting AssignInstrumentR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AssignInstrumentR merge(AssignInstrumentR detachedInstance) {
		log.debug("merging AssignInstrumentR instance");
		try {
			AssignInstrumentR result = (AssignInstrumentR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AssignInstrumentR findById(
			com.cardiodx.db.waban.table.AssignInstrumentRId id) {
		log.debug("getting AssignInstrumentR instance with id: " + id);
		try {
			AssignInstrumentR instance = (AssignInstrumentR) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.table.AssignInstrumentR", id);
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

	public List<AssignInstrumentR> findByExample(AssignInstrumentR instance) {
		log.debug("finding AssignInstrumentR instance by example");
		try {
			List<AssignInstrumentR> results = (List<AssignInstrumentR>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.AssignInstrumentR")
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
