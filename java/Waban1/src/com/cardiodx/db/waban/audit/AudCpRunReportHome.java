package com.cardiodx.db.waban.audit;

// Generated Jul 14, 2011 1:33:02 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class AudCpRunReport.
 * @see com.cardiodx.db.waban.audit.AudCpRunReport
 * @author Hibernate Tools
 */
public class AudCpRunReportHome {

	private static final Log log = LogFactory.getLog(AudCpRunReportHome.class);

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

	public void persist(AudCpRunReport transientInstance) {
		log.debug("persisting AudCpRunReport instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AudCpRunReport instance) {
		log.debug("attaching dirty AudCpRunReport instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AudCpRunReport instance) {
		log.debug("attaching clean AudCpRunReport instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AudCpRunReport persistentInstance) {
		log.debug("deleting AudCpRunReport instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AudCpRunReport merge(AudCpRunReport detachedInstance) {
		log.debug("merging AudCpRunReport instance");
		try {
			AudCpRunReport result = (AudCpRunReport) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AudCpRunReport findById(java.math.BigDecimal id) {
		log.debug("getting AudCpRunReport instance with id: " + id);
		try {
			AudCpRunReport instance = (AudCpRunReport) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.audit.AudCpRunReport", id);
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

	public List<AudCpRunReport> findByExample(AudCpRunReport instance) {
		log.debug("finding AudCpRunReport instance by example");
		try {
			List<AudCpRunReport> results = (List<AudCpRunReport>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.audit.AudCpRunReport")
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
