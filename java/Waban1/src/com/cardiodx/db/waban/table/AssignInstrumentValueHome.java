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
 * Home object for domain model class AssignInstrumentValue.
 * @see com.cardiodx.db.waban.table.AssignInstrumentValue
 * @author Hibernate Tools
 */
public class AssignInstrumentValueHome {

	private static final Log log = LogFactory
			.getLog(AssignInstrumentValueHome.class);

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

	public void persist(AssignInstrumentValue transientInstance) {
		log.debug("persisting AssignInstrumentValue instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AssignInstrumentValue instance) {
		log.debug("attaching dirty AssignInstrumentValue instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AssignInstrumentValue instance) {
		log.debug("attaching clean AssignInstrumentValue instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AssignInstrumentValue persistentInstance) {
		log.debug("deleting AssignInstrumentValue instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AssignInstrumentValue merge(AssignInstrumentValue detachedInstance) {
		log.debug("merging AssignInstrumentValue instance");
		try {
			AssignInstrumentValue result = (AssignInstrumentValue) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AssignInstrumentValue findById(java.math.BigDecimal id) {
		log.debug("getting AssignInstrumentValue instance with id: " + id);
		try {
			AssignInstrumentValue instance = (AssignInstrumentValue) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.table.AssignInstrumentValue",
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

	public List<AssignInstrumentValue> findByExample(
			AssignInstrumentValue instance) {
		log.debug("finding AssignInstrumentValue instance by example");
		try {
			List<AssignInstrumentValue> results = (List<AssignInstrumentValue>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.AssignInstrumentValue")
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
