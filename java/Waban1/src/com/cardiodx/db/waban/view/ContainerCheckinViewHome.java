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
 * Home object for domain model class ContainerCheckinView.
 * @see com.cardiodx.db.waban.view.ContainerCheckinView
 * @author Hibernate Tools
 */
public class ContainerCheckinViewHome {

	private static final Log log = LogFactory
			.getLog(ContainerCheckinViewHome.class);

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

	public void persist(ContainerCheckinView transientInstance) {
		log.debug("persisting ContainerCheckinView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ContainerCheckinView instance) {
		log.debug("attaching dirty ContainerCheckinView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ContainerCheckinView instance) {
		log.debug("attaching clean ContainerCheckinView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ContainerCheckinView persistentInstance) {
		log.debug("deleting ContainerCheckinView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ContainerCheckinView merge(ContainerCheckinView detachedInstance) {
		log.debug("merging ContainerCheckinView instance");
		try {
			ContainerCheckinView result = (ContainerCheckinView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ContainerCheckinView findById(
			com.cardiodx.db.waban.view.ContainerCheckinViewId id) {
		log.debug("getting ContainerCheckinView instance with id: " + id);
		try {
			ContainerCheckinView instance = (ContainerCheckinView) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.ContainerCheckinView",
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

	public List<ContainerCheckinView> findByExample(
			ContainerCheckinView instance) {
		log.debug("finding ContainerCheckinView instance by example");
		try {
			List<ContainerCheckinView> results = (List<ContainerCheckinView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.ContainerCheckinView")
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
