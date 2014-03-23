package com.cardiodx.db.waban.view;

// Generated Jul 14, 2011 1:33:57 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class CdxCurrentReportView2.
 * @see com.cardiodx.db.waban.view.CdxCurrentReportView2
 * @author Hibernate Tools
 */
public class CdxCurrentReportView2Home {

	private static final Log log = LogFactory
			.getLog(CdxCurrentReportView2Home.class);

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

	public void persist(CdxCurrentReportView2 transientInstance) {
		log.debug("persisting CdxCurrentReportView2 instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(CdxCurrentReportView2 instance) {
		log.debug("attaching dirty CdxCurrentReportView2 instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CdxCurrentReportView2 instance) {
		log.debug("attaching clean CdxCurrentReportView2 instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(CdxCurrentReportView2 persistentInstance) {
		log.debug("deleting CdxCurrentReportView2 instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CdxCurrentReportView2 merge(CdxCurrentReportView2 detachedInstance) {
		log.debug("merging CdxCurrentReportView2 instance");
		try {
			CdxCurrentReportView2 result = (CdxCurrentReportView2) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public CdxCurrentReportView2 findById(
			com.cardiodx.db.waban.view.CdxCurrentReportView2Id id) {
		log.debug("getting CdxCurrentReportView2 instance with id: " + id);
		try {
			CdxCurrentReportView2 instance = (CdxCurrentReportView2) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.CdxCurrentReportView2",
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

	public List<CdxCurrentReportView2> findByExample(
			CdxCurrentReportView2 instance) {
		log.debug("finding CdxCurrentReportView2 instance by example");
		try {
			List<CdxCurrentReportView2> results = (List<CdxCurrentReportView2>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.CdxCurrentReportView2")
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
