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
 * Home object for domain model class StudyProtocolView.
 * @see com.cardiodx.db.waban.view.StudyProtocolView
 * @author Hibernate Tools
 */
public class StudyProtocolViewHome {

	private static final Log log = LogFactory
			.getLog(StudyProtocolViewHome.class);

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

	public void persist(StudyProtocolView transientInstance) {
		log.debug("persisting StudyProtocolView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(StudyProtocolView instance) {
		log.debug("attaching dirty StudyProtocolView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(StudyProtocolView instance) {
		log.debug("attaching clean StudyProtocolView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(StudyProtocolView persistentInstance) {
		log.debug("deleting StudyProtocolView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public StudyProtocolView merge(StudyProtocolView detachedInstance) {
		log.debug("merging StudyProtocolView instance");
		try {
			StudyProtocolView result = (StudyProtocolView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public StudyProtocolView findById(
			com.cardiodx.db.waban.view.StudyProtocolViewId id) {
		log.debug("getting StudyProtocolView instance with id: " + id);
		try {
			StudyProtocolView instance = (StudyProtocolView) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.StudyProtocolView", id);
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

	public List<StudyProtocolView> findByExample(StudyProtocolView instance) {
		log.debug("finding StudyProtocolView instance by example");
		try {
			List<StudyProtocolView> results = (List<StudyProtocolView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.StudyProtocolView")
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
