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
 * Home object for domain model class TrgeLiterature.
 * @see com.cardiodx.db.waban.view.TrgeLiterature
 * @author Hibernate Tools
 */
public class TrgeLiteratureHome {

	private static final Log log = LogFactory.getLog(TrgeLiteratureHome.class);

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

	public void persist(TrgeLiterature transientInstance) {
		log.debug("persisting TrgeLiterature instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(TrgeLiterature instance) {
		log.debug("attaching dirty TrgeLiterature instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TrgeLiterature instance) {
		log.debug("attaching clean TrgeLiterature instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(TrgeLiterature persistentInstance) {
		log.debug("deleting TrgeLiterature instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TrgeLiterature merge(TrgeLiterature detachedInstance) {
		log.debug("merging TrgeLiterature instance");
		try {
			TrgeLiterature result = (TrgeLiterature) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TrgeLiterature findById(
			com.cardiodx.db.waban.view.TrgeLiteratureId id) {
		log.debug("getting TrgeLiterature instance with id: " + id);
		try {
			TrgeLiterature instance = (TrgeLiterature) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.view.TrgeLiterature", id);
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

	public List<TrgeLiterature> findByExample(TrgeLiterature instance) {
		log.debug("finding TrgeLiterature instance by example");
		try {
			List<TrgeLiterature> results = (List<TrgeLiterature>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.view.TrgeLiterature")
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
