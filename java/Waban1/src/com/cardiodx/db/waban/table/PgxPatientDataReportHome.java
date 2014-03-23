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
 * Home object for domain model class PgxPatientDataReport.
 * @see com.cardiodx.db.waban.table.PgxPatientDataReport
 * @author Hibernate Tools
 */
public class PgxPatientDataReportHome {

	private static final Log log = LogFactory
			.getLog(PgxPatientDataReportHome.class);

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

	public void persist(PgxPatientDataReport transientInstance) {
		log.debug("persisting PgxPatientDataReport instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(PgxPatientDataReport instance) {
		log.debug("attaching dirty PgxPatientDataReport instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PgxPatientDataReport instance) {
		log.debug("attaching clean PgxPatientDataReport instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(PgxPatientDataReport persistentInstance) {
		log.debug("deleting PgxPatientDataReport instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PgxPatientDataReport merge(PgxPatientDataReport detachedInstance) {
		log.debug("merging PgxPatientDataReport instance");
		try {
			PgxPatientDataReport result = (PgxPatientDataReport) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public PgxPatientDataReport findById(java.math.BigDecimal id) {
		log.debug("getting PgxPatientDataReport instance with id: " + id);
		try {
			PgxPatientDataReport instance = (PgxPatientDataReport) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.PgxPatientDataReport",
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

	public List<PgxPatientDataReport> findByExample(
			PgxPatientDataReport instance) {
		log.debug("finding PgxPatientDataReport instance by example");
		try {
			List<PgxPatientDataReport> results = (List<PgxPatientDataReport>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.PgxPatientDataReport")
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
