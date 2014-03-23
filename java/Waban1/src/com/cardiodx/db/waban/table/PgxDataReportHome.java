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
 * Home object for domain model class PgxDataReport.
 * @see com.cardiodx.db.waban.table.PgxDataReport
 * @author Hibernate Tools
 */
public class PgxDataReportHome {

	private static final Log log = LogFactory.getLog(PgxDataReportHome.class);

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

	public void persist(PgxDataReport transientInstance) {
		log.debug("persisting PgxDataReport instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(PgxDataReport instance) {
		log.debug("attaching dirty PgxDataReport instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PgxDataReport instance) {
		log.debug("attaching clean PgxDataReport instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(PgxDataReport persistentInstance) {
		log.debug("deleting PgxDataReport instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PgxDataReport merge(PgxDataReport detachedInstance) {
		log.debug("merging PgxDataReport instance");
		try {
			PgxDataReport result = (PgxDataReport) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public PgxDataReport findById(java.math.BigDecimal id) {
		log.debug("getting PgxDataReport instance with id: " + id);
		try {
			PgxDataReport instance = (PgxDataReport) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.PgxDataReport", id);
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

	public List<PgxDataReport> findByExample(PgxDataReport instance) {
		log.debug("finding PgxDataReport instance by example");
		try {
			List<PgxDataReport> results = (List<PgxDataReport>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.table.PgxDataReport")
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
