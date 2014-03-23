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
 * Home object for domain model class ReportTemplateParam.
 * @see com.cardiodx.db.waban.table.ReportTemplateParam
 * @author Hibernate Tools
 */
public class ReportTemplateParamHome {

	private static final Log log = LogFactory
			.getLog(ReportTemplateParamHome.class);

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

	public void persist(ReportTemplateParam transientInstance) {
		log.debug("persisting ReportTemplateParam instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ReportTemplateParam instance) {
		log.debug("attaching dirty ReportTemplateParam instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ReportTemplateParam instance) {
		log.debug("attaching clean ReportTemplateParam instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ReportTemplateParam persistentInstance) {
		log.debug("deleting ReportTemplateParam instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ReportTemplateParam merge(ReportTemplateParam detachedInstance) {
		log.debug("merging ReportTemplateParam instance");
		try {
			ReportTemplateParam result = (ReportTemplateParam) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ReportTemplateParam findById(java.math.BigDecimal id) {
		log.debug("getting ReportTemplateParam instance with id: " + id);
		try {
			ReportTemplateParam instance = (ReportTemplateParam) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.ReportTemplateParam",
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

	public List<ReportTemplateParam> findByExample(ReportTemplateParam instance) {
		log.debug("finding ReportTemplateParam instance by example");
		try {
			List<ReportTemplateParam> results = (List<ReportTemplateParam>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.ReportTemplateParam")
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
