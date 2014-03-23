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
 * Home object for domain model class PgxDataReportR.
 * @see com.cardiodx.db.waban.table.PgxDataReportR
 * @author Hibernate Tools
 */
public class PgxDataReportRHome {

	private static final Log log = LogFactory.getLog(PgxDataReportRHome.class);

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

	public void persist(PgxDataReportR transientInstance) {
		log.debug("persisting PgxDataReportR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(PgxDataReportR instance) {
		log.debug("attaching dirty PgxDataReportR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PgxDataReportR instance) {
		log.debug("attaching clean PgxDataReportR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(PgxDataReportR persistentInstance) {
		log.debug("deleting PgxDataReportR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PgxDataReportR merge(PgxDataReportR detachedInstance) {
		log.debug("merging PgxDataReportR instance");
		try {
			PgxDataReportR result = (PgxDataReportR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public PgxDataReportR findById(
			com.cardiodx.db.waban.table.PgxDataReportRId id) {
		log.debug("getting PgxDataReportR instance with id: " + id);
		try {
			PgxDataReportR instance = (PgxDataReportR) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.PgxDataReportR", id);
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

	public List<PgxDataReportR> findByExample(PgxDataReportR instance) {
		log.debug("finding PgxDataReportR instance by example");
		try {
			List<PgxDataReportR> results = (List<PgxDataReportR>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.PgxDataReportR")
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
