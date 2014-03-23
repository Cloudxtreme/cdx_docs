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
 * Home object for domain model class PatientVariableView.
 * @see com.cardiodx.db.waban.view.PatientVariableView
 * @author Hibernate Tools
 */
public class PatientVariableViewHome {

	private static final Log log = LogFactory
			.getLog(PatientVariableViewHome.class);

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

	public void persist(PatientVariableView transientInstance) {
		log.debug("persisting PatientVariableView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(PatientVariableView instance) {
		log.debug("attaching dirty PatientVariableView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PatientVariableView instance) {
		log.debug("attaching clean PatientVariableView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(PatientVariableView persistentInstance) {
		log.debug("deleting PatientVariableView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PatientVariableView merge(PatientVariableView detachedInstance) {
		log.debug("merging PatientVariableView instance");
		try {
			PatientVariableView result = (PatientVariableView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public PatientVariableView findById(
			com.cardiodx.db.waban.view.PatientVariableViewId id) {
		log.debug("getting PatientVariableView instance with id: " + id);
		try {
			PatientVariableView instance = (PatientVariableView) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.PatientVariableView",
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

	public List<PatientVariableView> findByExample(PatientVariableView instance) {
		log.debug("finding PatientVariableView instance by example");
		try {
			List<PatientVariableView> results = (List<PatientVariableView>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.view.PatientVariableView")
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
