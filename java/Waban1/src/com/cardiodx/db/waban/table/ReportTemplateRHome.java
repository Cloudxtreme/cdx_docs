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
 * Home object for domain model class ReportTemplateR.
 * @see com.cardiodx.db.waban.table.ReportTemplateR
 * @author Hibernate Tools
 */
public class ReportTemplateRHome {

	private static final Log log = LogFactory.getLog(ReportTemplateRHome.class);

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

	public void persist(ReportTemplateR transientInstance) {
		log.debug("persisting ReportTemplateR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ReportTemplateR instance) {
		log.debug("attaching dirty ReportTemplateR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ReportTemplateR instance) {
		log.debug("attaching clean ReportTemplateR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ReportTemplateR persistentInstance) {
		log.debug("deleting ReportTemplateR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ReportTemplateR merge(ReportTemplateR detachedInstance) {
		log.debug("merging ReportTemplateR instance");
		try {
			ReportTemplateR result = (ReportTemplateR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ReportTemplateR findById(
			com.cardiodx.db.waban.table.ReportTemplateRId id) {
		log.debug("getting ReportTemplateR instance with id: " + id);
		try {
			ReportTemplateR instance = (ReportTemplateR) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.ReportTemplateR", id);
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

	public List<ReportTemplateR> findByExample(ReportTemplateR instance) {
		log.debug("finding ReportTemplateR instance by example");
		try {
			List<ReportTemplateR> results = (List<ReportTemplateR>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.ReportTemplateR")
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
