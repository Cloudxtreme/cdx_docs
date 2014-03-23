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
 * Home object for domain model class ParameterTransferView.
 * @see com.cardiodx.db.waban.view.ParameterTransferView
 * @author Hibernate Tools
 */
public class ParameterTransferViewHome {

	private static final Log log = LogFactory
			.getLog(ParameterTransferViewHome.class);

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

	public void persist(ParameterTransferView transientInstance) {
		log.debug("persisting ParameterTransferView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ParameterTransferView instance) {
		log.debug("attaching dirty ParameterTransferView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ParameterTransferView instance) {
		log.debug("attaching clean ParameterTransferView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ParameterTransferView persistentInstance) {
		log.debug("deleting ParameterTransferView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ParameterTransferView merge(ParameterTransferView detachedInstance) {
		log.debug("merging ParameterTransferView instance");
		try {
			ParameterTransferView result = (ParameterTransferView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ParameterTransferView findById(
			com.cardiodx.db.waban.view.ParameterTransferViewId id) {
		log.debug("getting ParameterTransferView instance with id: " + id);
		try {
			ParameterTransferView instance = (ParameterTransferView) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.ParameterTransferView",
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

	public List<ParameterTransferView> findByExample(
			ParameterTransferView instance) {
		log.debug("finding ParameterTransferView instance by example");
		try {
			List<ParameterTransferView> results = (List<ParameterTransferView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.ParameterTransferView")
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
