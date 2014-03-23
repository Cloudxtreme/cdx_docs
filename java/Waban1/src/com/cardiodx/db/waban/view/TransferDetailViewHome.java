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
 * Home object for domain model class TransferDetailView.
 * @see com.cardiodx.db.waban.view.TransferDetailView
 * @author Hibernate Tools
 */
public class TransferDetailViewHome {

	private static final Log log = LogFactory
			.getLog(TransferDetailViewHome.class);

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

	public void persist(TransferDetailView transientInstance) {
		log.debug("persisting TransferDetailView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(TransferDetailView instance) {
		log.debug("attaching dirty TransferDetailView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TransferDetailView instance) {
		log.debug("attaching clean TransferDetailView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(TransferDetailView persistentInstance) {
		log.debug("deleting TransferDetailView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TransferDetailView merge(TransferDetailView detachedInstance) {
		log.debug("merging TransferDetailView instance");
		try {
			TransferDetailView result = (TransferDetailView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TransferDetailView findById(
			com.cardiodx.db.waban.view.TransferDetailViewId id) {
		log.debug("getting TransferDetailView instance with id: " + id);
		try {
			TransferDetailView instance = (TransferDetailView) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.view.TransferDetailView", id);
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

	public List<TransferDetailView> findByExample(TransferDetailView instance) {
		log.debug("finding TransferDetailView instance by example");
		try {
			List<TransferDetailView> results = (List<TransferDetailView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.TransferDetailView")
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
