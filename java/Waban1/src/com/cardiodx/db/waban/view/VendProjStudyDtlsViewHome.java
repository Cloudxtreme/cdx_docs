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
 * Home object for domain model class VendProjStudyDtlsView.
 * @see com.cardiodx.db.waban.view.VendProjStudyDtlsView
 * @author Hibernate Tools
 */
public class VendProjStudyDtlsViewHome {

	private static final Log log = LogFactory
			.getLog(VendProjStudyDtlsViewHome.class);

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

	public void persist(VendProjStudyDtlsView transientInstance) {
		log.debug("persisting VendProjStudyDtlsView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(VendProjStudyDtlsView instance) {
		log.debug("attaching dirty VendProjStudyDtlsView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(VendProjStudyDtlsView instance) {
		log.debug("attaching clean VendProjStudyDtlsView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(VendProjStudyDtlsView persistentInstance) {
		log.debug("deleting VendProjStudyDtlsView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public VendProjStudyDtlsView merge(VendProjStudyDtlsView detachedInstance) {
		log.debug("merging VendProjStudyDtlsView instance");
		try {
			VendProjStudyDtlsView result = (VendProjStudyDtlsView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public VendProjStudyDtlsView findById(
			com.cardiodx.db.waban.view.VendProjStudyDtlsViewId id) {
		log.debug("getting VendProjStudyDtlsView instance with id: " + id);
		try {
			VendProjStudyDtlsView instance = (VendProjStudyDtlsView) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.VendProjStudyDtlsView",
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

	public List<VendProjStudyDtlsView> findByExample(
			VendProjStudyDtlsView instance) {
		log.debug("finding VendProjStudyDtlsView instance by example");
		try {
			List<VendProjStudyDtlsView> results = (List<VendProjStudyDtlsView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.VendProjStudyDtlsView")
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
