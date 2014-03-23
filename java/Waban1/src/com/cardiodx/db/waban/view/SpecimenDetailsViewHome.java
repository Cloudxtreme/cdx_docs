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
 * Home object for domain model class SpecimenDetailsView.
 * @see com.cardiodx.db.waban.view.SpecimenDetailsView
 * @author Hibernate Tools
 */
public class SpecimenDetailsViewHome {

	private static final Log log = LogFactory
			.getLog(SpecimenDetailsViewHome.class);

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

	public void persist(SpecimenDetailsView transientInstance) {
		log.debug("persisting SpecimenDetailsView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(SpecimenDetailsView instance) {
		log.debug("attaching dirty SpecimenDetailsView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SpecimenDetailsView instance) {
		log.debug("attaching clean SpecimenDetailsView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(SpecimenDetailsView persistentInstance) {
		log.debug("deleting SpecimenDetailsView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SpecimenDetailsView merge(SpecimenDetailsView detachedInstance) {
		log.debug("merging SpecimenDetailsView instance");
		try {
			SpecimenDetailsView result = (SpecimenDetailsView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public SpecimenDetailsView findById(
			com.cardiodx.db.waban.view.SpecimenDetailsViewId id) {
		log.debug("getting SpecimenDetailsView instance with id: " + id);
		try {
			SpecimenDetailsView instance = (SpecimenDetailsView) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.SpecimenDetailsView",
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

	public List<SpecimenDetailsView> findByExample(SpecimenDetailsView instance) {
		log.debug("finding SpecimenDetailsView instance by example");
		try {
			List<SpecimenDetailsView> results = (List<SpecimenDetailsView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.SpecimenDetailsView")
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
