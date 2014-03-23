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
 * Home object for domain model class StudyDisplayView.
 * @see com.cardiodx.db.waban.view.StudyDisplayView
 * @author Hibernate Tools
 */
public class StudyDisplayViewHome {

	private static final Log log = LogFactory
			.getLog(StudyDisplayViewHome.class);

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

	public void persist(StudyDisplayView transientInstance) {
		log.debug("persisting StudyDisplayView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(StudyDisplayView instance) {
		log.debug("attaching dirty StudyDisplayView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(StudyDisplayView instance) {
		log.debug("attaching clean StudyDisplayView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(StudyDisplayView persistentInstance) {
		log.debug("deleting StudyDisplayView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public StudyDisplayView merge(StudyDisplayView detachedInstance) {
		log.debug("merging StudyDisplayView instance");
		try {
			StudyDisplayView result = (StudyDisplayView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public StudyDisplayView findById(
			com.cardiodx.db.waban.view.StudyDisplayViewId id) {
		log.debug("getting StudyDisplayView instance with id: " + id);
		try {
			StudyDisplayView instance = (StudyDisplayView) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.StudyDisplayView", id);
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

	public List<StudyDisplayView> findByExample(StudyDisplayView instance) {
		log.debug("finding StudyDisplayView instance by example");
		try {
			List<StudyDisplayView> results = (List<StudyDisplayView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.StudyDisplayView")
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
