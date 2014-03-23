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
 * Home object for domain model class ProtocolGeneValueView.
 * @see com.cardiodx.db.waban.view.ProtocolGeneValueView
 * @author Hibernate Tools
 */
public class ProtocolGeneValueViewHome {

	private static final Log log = LogFactory
			.getLog(ProtocolGeneValueViewHome.class);

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

	public void persist(ProtocolGeneValueView transientInstance) {
		log.debug("persisting ProtocolGeneValueView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ProtocolGeneValueView instance) {
		log.debug("attaching dirty ProtocolGeneValueView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ProtocolGeneValueView instance) {
		log.debug("attaching clean ProtocolGeneValueView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ProtocolGeneValueView persistentInstance) {
		log.debug("deleting ProtocolGeneValueView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ProtocolGeneValueView merge(ProtocolGeneValueView detachedInstance) {
		log.debug("merging ProtocolGeneValueView instance");
		try {
			ProtocolGeneValueView result = (ProtocolGeneValueView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ProtocolGeneValueView findById(
			com.cardiodx.db.waban.view.ProtocolGeneValueViewId id) {
		log.debug("getting ProtocolGeneValueView instance with id: " + id);
		try {
			ProtocolGeneValueView instance = (ProtocolGeneValueView) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.ProtocolGeneValueView",
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

	public List<ProtocolGeneValueView> findByExample(
			ProtocolGeneValueView instance) {
		log.debug("finding ProtocolGeneValueView instance by example");
		try {
			List<ProtocolGeneValueView> results = (List<ProtocolGeneValueView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.ProtocolGeneValueView")
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
