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
 * Home object for domain model class AliquotInfoView.
 * @see com.cardiodx.db.waban.view.AliquotInfoView
 * @author Hibernate Tools
 */
public class AliquotInfoViewHome {

	private static final Log log = LogFactory.getLog(AliquotInfoViewHome.class);

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

	public void persist(AliquotInfoView transientInstance) {
		log.debug("persisting AliquotInfoView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AliquotInfoView instance) {
		log.debug("attaching dirty AliquotInfoView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AliquotInfoView instance) {
		log.debug("attaching clean AliquotInfoView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AliquotInfoView persistentInstance) {
		log.debug("deleting AliquotInfoView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AliquotInfoView merge(AliquotInfoView detachedInstance) {
		log.debug("merging AliquotInfoView instance");
		try {
			AliquotInfoView result = (AliquotInfoView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AliquotInfoView findById(
			com.cardiodx.db.waban.view.AliquotInfoViewId id) {
		log.debug("getting AliquotInfoView instance with id: " + id);
		try {
			AliquotInfoView instance = (AliquotInfoView) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.AliquotInfoView", id);
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

	public List<AliquotInfoView> findByExample(AliquotInfoView instance) {
		log.debug("finding AliquotInfoView instance by example");
		try {
			List<AliquotInfoView> results = (List<AliquotInfoView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.AliquotInfoView")
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
