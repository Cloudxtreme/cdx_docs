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
 * Home object for domain model class InstrumentParam.
 * @see com.cardiodx.db.waban.table.InstrumentParam
 * @author Hibernate Tools
 */
public class InstrumentParamHome {

	private static final Log log = LogFactory.getLog(InstrumentParamHome.class);

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

	public void persist(InstrumentParam transientInstance) {
		log.debug("persisting InstrumentParam instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(InstrumentParam instance) {
		log.debug("attaching dirty InstrumentParam instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(InstrumentParam instance) {
		log.debug("attaching clean InstrumentParam instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(InstrumentParam persistentInstance) {
		log.debug("deleting InstrumentParam instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public InstrumentParam merge(InstrumentParam detachedInstance) {
		log.debug("merging InstrumentParam instance");
		try {
			InstrumentParam result = (InstrumentParam) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public InstrumentParam findById(java.math.BigDecimal id) {
		log.debug("getting InstrumentParam instance with id: " + id);
		try {
			InstrumentParam instance = (InstrumentParam) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.InstrumentParam", id);
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

	public List<InstrumentParam> findByExample(InstrumentParam instance) {
		log.debug("finding InstrumentParam instance by example");
		try {
			List<InstrumentParam> results = (List<InstrumentParam>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.InstrumentParam")
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
