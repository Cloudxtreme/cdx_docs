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
 * Home object for domain model class StudyVariableView.
 * @see com.cardiodx.db.waban.view.StudyVariableView
 * @author Hibernate Tools
 */
public class StudyVariableViewHome {

	private static final Log log = LogFactory
			.getLog(StudyVariableViewHome.class);

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

	public void persist(StudyVariableView transientInstance) {
		log.debug("persisting StudyVariableView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(StudyVariableView instance) {
		log.debug("attaching dirty StudyVariableView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(StudyVariableView instance) {
		log.debug("attaching clean StudyVariableView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(StudyVariableView persistentInstance) {
		log.debug("deleting StudyVariableView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public StudyVariableView merge(StudyVariableView detachedInstance) {
		log.debug("merging StudyVariableView instance");
		try {
			StudyVariableView result = (StudyVariableView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public StudyVariableView findById(
			com.cardiodx.db.waban.view.StudyVariableViewId id) {
		log.debug("getting StudyVariableView instance with id: " + id);
		try {
			StudyVariableView instance = (StudyVariableView) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.StudyVariableView", id);
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

	public List<StudyVariableView> findByExample(StudyVariableView instance) {
		log.debug("finding StudyVariableView instance by example");
		try {
			List<StudyVariableView> results = (List<StudyVariableView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.StudyVariableView")
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
