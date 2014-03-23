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
 * Home object for domain model class SeqSetupQcView.
 * @see com.cardiodx.db.waban.view.SeqSetupQcView
 * @author Hibernate Tools
 */
public class SeqSetupQcViewHome {

	private static final Log log = LogFactory.getLog(SeqSetupQcViewHome.class);

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

	public void persist(SeqSetupQcView transientInstance) {
		log.debug("persisting SeqSetupQcView instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(SeqSetupQcView instance) {
		log.debug("attaching dirty SeqSetupQcView instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SeqSetupQcView instance) {
		log.debug("attaching clean SeqSetupQcView instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(SeqSetupQcView persistentInstance) {
		log.debug("deleting SeqSetupQcView instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SeqSetupQcView merge(SeqSetupQcView detachedInstance) {
		log.debug("merging SeqSetupQcView instance");
		try {
			SeqSetupQcView result = (SeqSetupQcView) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public SeqSetupQcView findById(
			com.cardiodx.db.waban.view.SeqSetupQcViewId id) {
		log.debug("getting SeqSetupQcView instance with id: " + id);
		try {
			SeqSetupQcView instance = (SeqSetupQcView) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.SeqSetupQcView", id);
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

	public List<SeqSetupQcView> findByExample(SeqSetupQcView instance) {
		log.debug("finding SeqSetupQcView instance by example");
		try {
			List<SeqSetupQcView> results = (List<SeqSetupQcView>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.view.SeqSetupQcView")
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
